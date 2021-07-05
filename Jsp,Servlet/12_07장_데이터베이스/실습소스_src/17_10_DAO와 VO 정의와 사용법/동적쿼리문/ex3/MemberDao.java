package ch17.ex6;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user="scott";
	private static final String pwd="tiger";
	
	
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	/*
	public  static final String driver = "org.gjt.mm.mysql.Driver";
	public static final String url  = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=euckr";
	public static final String user = "dev1";
	public static final String pwd = "dev123";	
	*/

	public ArrayList<MemberVo> list(MemberVo vo){
		String _name=null;
		int _age=0;
		
		ArrayList<MemberVo> list=new ArrayList<MemberVo>();
		_name=vo.getName();
		_age=vo.getAge();
		
		try{
			connDB();
			String query="select * from Member";
			if(_name!=null && _age!=0 ){ //���ڷ� �Ѿ�� ���� ������ where ���ǹ��� �߰��Ѵ�.
				query+=" where name='"+_name+"' and age="+_age;
			}else if(_name !=null && _age==0){
				query+=" where name='"+_name+"'";
			}else if(_name ==null && _age!=0){
				query+=" where age="+_age;
			}
			
			System.out.println(query);
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next()){
				String id=rs.getString("id");
				String name=rs.getString("name");
				int height=rs.getInt("height");
				int weight=rs.getInt("weight");
				int age=rs.getInt("age");
				
				MemberVo data=new MemberVo();
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
	
	public void modMember(MemberVo vo){
		String _name=null;
		int _age=0;
		
		_name=vo.getName();
		_age=vo.getAge();
		
		try{
			connDB();
			String query="update Member ";
			query+= " set age="+_age;
			query+=" where name='"+_name+"'";
			
			System.out.println(query);
			stmt.executeUpdate(query);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
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
