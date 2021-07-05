package ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //����� DB���� ���� �����͸� �����Ѵ�.
	private static final String url ="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	
	private Connection con;  //DB���ῡ ���Ǵ� ��ü��  �����Ѵ�.
    private	Statement stmt;
    private ResultSet rs;	
    
    
    public ArrayList<MemberVO> list(){
    	ArrayList<MemberVO> list=new ArrayList<MemberVO>();
    	try{
    		connDB();
    		String query="select * from Member order by id ";
    		System.out.println(query);
    		ResultSet rs=stmt.executeQuery(query);
    		
    		while(rs.next()){
    			String id=rs.getString("id");
    			String name=rs.getString("name");
    			int height=rs.getInt("height");
    			int weight=rs.getInt("weight");
    			int age=rs.getInt("age");
    			
    			MemberVO data=new MemberVO();
    			
    			data.setId(id);
    			data.setName(name);
    			data.setHeight(height);
    			data.setWeight(weight);
    			data.setAge(age);
    			
    			list.add(data);
    		}
    		rs.close();
    		stmt.close();
    		con.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return list;
    }
    
    public void connDB(){
    	try{
    		Class.forName(driver);
    		System.out.println("Oracle ����̹� �ε� ����");
    		con=DriverManager.getConnection(url,user,pwd);
    		System.out.println("Connection ���� ����");
    		
    		stmt=con.createStatement();
    		System.out.println("Statement ���� ����");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

}
