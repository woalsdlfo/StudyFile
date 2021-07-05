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
		
	private Connection con;  //DB���ῡ ���Ǵ� ��ü��  �����Ѵ�.
    private	Statement stmt;
    private ResultSet rs;
    
	ArrayList<CarVo> search(CarVo vo) throws Exception{
		ArrayList<CarVo> list =  new ArrayList<CarVo>();
		  try{			
				connDB();  //DB�� �����ϴ� �޼��� 
				String query = "select * from rent_car ";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery( query);	//������ ������ �� ���ϵǴ� ���ڵ� ���� rs�� �����Ѵ�.		 

				 while( rs.next() ){				        //rs�� ���ڵ���� ������ �Ҵ��Ѵ�.
					 String carNum=rs.getString("carNum");						 
					 String carName =rs.getString("carName");
					 int carSize = Integer.parseInt(rs.getString("carSize"));					 
					 int carYear = Integer.parseInt(rs.getString("prodYear"));
					 String company = rs.getString("company");
					 

					CarVo carData= new CarVo(carNum,carName,carSize,carYear,company);     //Vo��ü�� �����Ѵ�.
					
					list.add( carData);					//list�� Vo��ü�� �߰��Ѵ�.
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
    	
		connDB();  //DB�� �����ϴ� �޼��� 
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
    	
		connDB();  //DB�� �����ϴ� �޼��� 
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
		connDB();  //DB�� �����ϴ� �޼��� 
		String query = "delete from rent_car "+
					 " where carNum='"+carNum+"'";
		System.out.println( query) ;	   
		stmt.executeUpdate( query );
		
	}
	public void connDB(){
		try{
			Class.forName(driver);  
			System.out.println("Oracle ����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");

			stmt = con.createStatement();
			System.out.println("Statement ���� ����");		
		}catch(Exception e){
		e.printStackTrace();	
		}
	}	

}
