package ch17.ex5;

import java.sql.*;
import java.util.ArrayList;


public class CarDao {
	/*
	private static final String driver="oracle.jdbc.driver.OracleDriver";  
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	*/
	public  static final String driver = "org.gjt.mm.mysql.Driver";
	public static final String url  = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=euckr";
	public static final String user = "dev1";
	public static final String pwd = "dev123";
		
	private Connection con;  //DB연결에 사용되는 객체를  선언한다.
    private	Statement stmt;
    private ResultSet rs;
    
	ArrayList<CarVo> search(CarVo vo) throws Exception{
		ArrayList<CarVo> list =  new ArrayList<CarVo>();
		  try{			
				connDB();  //DB와 연결하는 메서드 
				String query = "select * from rent_car ";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery( query);	//쿼리를 실행한 후 리턴되는 레코드 셋을 rs에 저장한다.		 

				 while( rs.next() ){				        //rs의 레코드셋을 변수에 할당한다.
					 String carNum=rs.getString("carNum");						 
					 String carName =rs.getString("carName");
					 int carSize = Integer.parseInt(rs.getString("carSize"));					 
					 int carYear = Integer.parseInt(rs.getString("prodYear"));
					 String company = rs.getString("company");
					 

					CarVo carData= new CarVo(carNum,carName,carSize,carYear,company);     //Vo객체를 생성한다.
					
					list.add( carData);					//list에 Vo객체를 추가한다.
				} //end while 
				rs.close();
				stmt.close();
				con.close();
		  }catch(Exception e){
			e.printStackTrace();	
		  }

		  return list;
		} //end list()
	
	void AddCar(CarVo vo) throws Exception{
		String carNum=null;
    	String carName= null;
    	int carYear=0;
    	int carSize=0;
    	String company=null;

    	carNum=vo.getCarNum();
    	carName=vo.getCarName();
    	carYear=vo.getProdYear();
    	carSize=vo.getCarSize();
    	company=vo.getCompany();
    	
		connDB();  //DB와 연결하는 메서드 
		String query = "INSERT INTO rent_car(carNum,carName,carSize,prodYear,company) VALUES ( '"+
				carNum+"','"+
				carName+"',"+
				carSize+"," +
				carYear +",'"+
				company+"')";
		System.out.println( query) ;	   
		stmt.executeUpdate( query );
	}
	
	void modifyCar(CarVo vo) throws Exception{
		String carNum=null;
    	String carName= null;
    	int carYear=0;
    	int carSize=0;
    	String company=null;

    	carNum=vo.getCarNum();
    	carName=vo.getCarName();
    	carYear=vo.getProdYear();
    	carSize=vo.getCarSize();
    	company=vo.getCompany();
    	
		connDB();  //DB와 연결하는 메서드 
		String query = "update rent_car "+
		               " set carName='"+carName+"',"+
				        " carSize="+carSize+","+
		                " prodYear="+carYear+","+
				        " company='"+company+"'"+
					 " where carNum='"+carNum+"'";
		System.out.println( query) ;	   
		stmt.executeUpdate( query );
	}
	
	 void deleteCar(String carNum) throws Exception{
		connDB();  //DB와 연결하는 메서드 
		String query = "delete from rent_car "+
					 " where carNum='"+carNum+"'";
		System.out.println( query) ;	   
		stmt.executeUpdate( query );
		
	}
	public void connDB(){
		try{
			Class.forName(driver);  
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");

			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");		
		}catch(Exception e){
		e.printStackTrace();	
		}
	}	

}
