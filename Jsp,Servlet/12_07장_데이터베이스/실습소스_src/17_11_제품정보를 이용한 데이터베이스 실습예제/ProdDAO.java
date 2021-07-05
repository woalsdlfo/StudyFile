package ch17.ex4;

import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class ProdDAO {



		private static final String driver="oracle.jdbc.driver.OracleDriver";  //����� DB���� ���� �����͸� �����Ѵ�.
		private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
		private static final String user = "scott";
		private static final String pwd="tiger";
		
		private Connection con;  //DB���ῡ ���Ǵ� ��ü��  �����Ѵ�.
	    private	Statement stmt;
	    private ResultSet rs;
	    
	    //��ǰ ������ ���̺� �߰��ϴ� �޼ҵ�
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
	    		connDB();  //DB�� �����ϴ� �޼��� 
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
				connDB();  //DB�� �����ϴ� �޼��� 
				String query = "select * from Product ";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery( query);	//������ ������ �� ���ϵǴ� ���ڵ� ���� rs�� �����Ѵ�.		 

				 while( rs.next() ){				        //rs�� ���ڵ���� ������ �Ҵ��Ѵ�.
					 String code=rs.getString("prodCode");						 
					 String name = rs.getString("prodName");
					 String color = rs.getString("prodColor");					 
					 int qty = rs.getInt("prodQty");

					ProdVO prodData= new ProdTO();     //TO��ü�� �����Ѵ�.
					prodData.setProdCode(code);
					prodData.setProdName( name);                //�������� TO��ü�� ��������� �����Ѵ�.
					prodData.setProdColor(color);					
					prodData.setProdQty(qty);
					
					list.add( prodData);					//list�� TO��ü�� �߰��Ѵ�.
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
				System.out.println("Oracle ����̹� �ε� ����");
				con = DriverManager.getConnection(url, user, pwd);
				System.out.println("Connection ���� ����");

				stmt = con.createStatement();
				System.out.println("Statement ���� ����");		
			}catch(Exception e){
			e.printStackTrace();	
			}
		}
	}//end class MemberDAO

