package ch17.ex1;

import java.sql.*;

public class MemberTest{	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url  = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";

	public static void main(String []args)
	{
		Connection conn;
		Statement stmt;
		ResultSet  rs;
		try{
			Class.forName(driver);
			System.out.println("Oracle ����̹� �ε� ����");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
			stmt = conn.createStatement();
			System.out.println("Statement ���� ����");
			String query = "INSERT INTO Member VALUES ( '0003','������' , 185, 85 , 23 )";
			System.out.println( query) ;
			stmt.executeUpdate( query );
			String query2 = "SELECT * FROM Member" ;
			System.out.println( query2) ;
			rs = stmt.executeQuery( query2);
			while(rs.next()){
			    System.out.print( "���̵��>>" +  rs.getString( "id" ) ); 
				System.out.print( ", �̸���>>" +  rs.getString( "name" ) );
				System.out.print( ", Ű��>>" +  rs.getInt( "height" ) );
				System.out.print( ", ü����>>" +  rs.getInt( "weight" ) );
				System.out.print( ", ���̴�>>" +  rs.getInt( "age" ) );
				System.out.println();
			   }
            rs.close();
			stmt.close();
			conn.close();
      }catch(ClassNotFoundException e){
			e.printStackTrace();
      }catch(SQLException e){
			e.printStackTrace();
	  }
   }
}
