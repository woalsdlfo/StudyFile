package ex4.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CarDAOImpl  implements CarDAO{
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //����� DB���� ���� �����͸� �����Ѵ�.
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
    	
    		connDB();  //DB�� �����ϴ� �޼��� 
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
				connDB();  //DB�� �����ϴ� �޼��� 
				String query = "select * from Rent_Car ";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery( query);	//������ ������ �� ���ϵǴ� ���ڵ� ���� rs�� �����Ѵ�.		 

				 while( rs.next() ){				        //rs�� ���ڵ���� ������ �Ҵ��Ѵ�.
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
	
