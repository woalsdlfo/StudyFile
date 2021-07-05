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
			System.out.println("Oracle 드라이버 로딩 성공");
		// 커넥션 풀 생성 ***************************************************************************************
			cp = new ConnectionPool(url, user, pwd, initialCons, maxCons, block, timeout);
		//**********************************************************************************************************
			System.out.println("ConnectionPool 생성...");
		// 커넥션 풀로부터 하나의 커넥션 가져옴********************************************************************
					conn = cp.getConnection();
		//*************************************************************************************************************

			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			String query = "INSERT INTO member VALUES ( '0003','유관순' , 165, 45,17)";
			System.out.println( query) ;
			stmt.executeUpdate( query );
			String query2 = "SELECT * FROM member" ;
			System.out.println( query2) ;
			rs = stmt.executeQuery( query2);
					while(rs.next()){
						System.out.print( "아이디는>>" +  rs.getString( "id" ) );
						System.out.print( "이름은>>" +  rs.getString( "name" ) );
						System.out.print( " 키는>>" +  rs.getInt( "height" ) );
						System.out.print( " 체중은>>" +  rs.getInt( "weight" ) );
						System.out.print( " 나이는>>" +  rs.getInt( "age" ) );						
					   }
                rs.close();
				stmt.close();
			//Connection을 닫으면 안된다.
			//conn.close();
			// 커넥션 풀에게 사용한 커넥션을 돌려줌
			cp.releaseConnection(conn);
              }catch(ClassNotFoundException e){
					e.printStackTrace();
		     }catch(SQLException e){
					e.printStackTrace();
				}
           }
}
