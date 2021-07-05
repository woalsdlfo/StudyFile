package ex4.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CarDAOImpl  implements CarDAO{
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	
	private Connection con; 
    private	Statement stmt;
    private ResultSet rs;
    
	public void regCarInfo(CarVo vo) throws Exception{
		String carNumber;
		String carName;
		String carColor;
		int    carSize;
		String carMaker;
		
    	carNumber=vo.getCarNumber();
    	carName=vo.getCarName();
    	carColor=vo.getCarColor();
    	carSize=vo.getCarSize();
    	carMaker=vo.getCarMaker();
    	
    		connDB();  //DB와 연결하는 메서드 
			String query = "INSERT INTO Rent_Car(carNumber,carName,carColor,carSize,carMaker) "
					        + "VALUES ('"+carNumber+"','"+
					                      carName+"','"+
					                      carColor+"'," +
					                      carSize+",'" +
					                      carColor+"')";
			System.out.println( query) ;	   
			stmt.executeUpdate( query );
    		
	}
	
	public ArrayList<CarVo> listCarInfo(CarVo vo) throws Exception{
		ArrayList<CarVo> carList=new ArrayList<CarVo>();
				connDB();  //DB와 연결하는 메서드 
				String query = "select * from Rent_Car ";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery( query);	//쿼리를 실행한 후 리턴되는 레코드 셋을 rs에 저장한다.		 

				 while( rs.next() ){				        //rs의 레코드셋을 변수에 할당한다.
					 String carNumber=rs.getString("carNumber");						 
					 String carName = rs.getString("carName");
					 String carColor = rs.getString("carColor");					 
					 int carSize = rs.getInt("carSize");
					 String carMaker=rs.getString("carMaker");

					 CarVo carData= new CarVo();    
					 carData.setCarNumber(carNumber);
					 carData.setCarName(carName);                
					 carData.setCarColor(carColor);					
					 carData.setCarSize(carSize);
					 carData.setCarMaker(carMaker);
					
					 carList.add(carData);					
				}  
				rs.close();
				stmt.close();
				con.close();
		return carList;
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
	
