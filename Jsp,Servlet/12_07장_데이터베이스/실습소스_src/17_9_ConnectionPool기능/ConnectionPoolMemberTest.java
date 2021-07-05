package ch17.ex2;

import java.sql.*;
public class ConnectionPoolMemberTest{
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url  = "jdbc:oracle:thin:@192.168.0.4:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private static final int initialCons = 5;
	private static final int maxCons = 20;
	private static final boolean block = true;
	private static final long timeout = 10000;

	public static void main(String []args)
	{
		Connection conn;
		Statement stmt;
		ResultSet  rs;
	   ConnectionPool cp;

		try{
			Class.forName(driver);
			System.out.println("Oracle ����̹� �ε� ����");
		// Ŀ�ؼ� Ǯ ���� ***************************************************************************************
			cp = new ConnectionPool(url, user, pwd, initialCons, maxCons, block, timeout);
		//**********************************************************************************************************
			System.out.println("ConnectionPool ����...");
		// Ŀ�ؼ� Ǯ�κ��� �ϳ��� Ŀ�ؼ� ������********************************************************************
					conn = cp.getConnection();
		//*************************************************************************************************************

			stmt = conn.createStatement();
			System.out.println("Statement ���� ����");
			String query = "INSERT INTO member VALUES ( '0003','������' , 165, 45,17)";
			System.out.println( query) ;
			stmt.executeUpdate( query );
			String query2 = "SELECT * FROM member" ;
			System.out.println( query2) ;
			rs = stmt.executeQuery( query2);
					while(rs.next()){
						System.out.print( "���̵��>>" +  rs.getString( "id" ) );
						System.out.print( "�̸���>>" +  rs.getString( "name" ) );
						System.out.print( " Ű��>>" +  rs.getInt( "height" ) );
						System.out.print( " ü����>>" +  rs.getInt( "weight" ) );
						System.out.print( " ���̴�>>" +  rs.getInt( "age" ) );						
					   }
                rs.close();
				stmt.close();
			//Connection�� ������ �ȵȴ�.
			//conn.close();
			// Ŀ�ؼ� Ǯ���� ����� Ŀ�ؼ��� ������
			cp.releaseConnection(conn);
              }catch(ClassNotFoundException e){
					e.printStackTrace();
		     }catch(SQLException e){
					e.printStackTrace();
				}
           }
}
