package ch17.ex4;

import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class ProdDAO {



		private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
		private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
		private static final String user = "scott";
		private static final String pwd="tiger";
		
		private Connection con;  //DB연결에 사용되는 객체를  선언한다.
	    private	Statement stmt;
	    private ResultSet rs;
	    
	    //제품 정보를 테이블에 추가하는 메소드
	    public void addProdInfo(ProdVO prodVO){
	    	String code=null;
	    	String name= null;
	    	String color=null;
	    	int 	qty=0;
	    	
	    	 code=prodVO.getProdCode();
	    	 name=prodVO.getProdName();
	    	 color=prodInfo.getProdColor();
	    	 qty=prodInfo.getProdQty();
	    	
	    	try{
	    		connDB();  //DB와 연결하는 메서드 
				String query = "INSERT INTO Product(prodCode,prodName,prodColor,prodQty) VALUES ( '"+
						code+"','"+
						name+"','"+
						color+"'," +
						qty +" )";
				System.out.println( query) ;	   
				stmt.executeUpdate( query );
	    		
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }

		public ArrayList<ProdVO> listProdInfo(){   
		  ArrayList<ProdTO> list =  new ArrayList<ProdTO>();
		  try{			
				connDB();  //DB와 연결하는 메서드 
				String query = "select * from Product ";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery( query);	//쿼리를 실행한 후 리턴되는 레코드 셋을 rs에 저장한다.		 

				 while( rs.next() ){				        //rs의 레코드셋을 변수에 할당한다.
					 String code=rs.getString("prodCode");						 
					 String name = rs.getString("prodName");
					 String color = rs.getString("prodColor");					 
					 int qty = rs.getInt("prodQty");

					ProdVO prodData= new ProdTO();     //TO객체를 생성한다.
					prodData.setProdCode(code);
					prodData.setProdName( name);                //변수값을 TO객체의 멤버변수에 세팅한다.
					prodData.setProdColor(color);					
					prodData.setProdQty(qty);
					
					list.add( prodData);					//list에 TO객체를 추가한다.
				} //end while 
				rs.close();
				stmt.close();
				con.close();
		  }catch(Exception e){
			e.printStackTrace();	
		  }

		  return list;
		} //end list()

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
	}//end class MemberDAO

