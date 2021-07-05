package ex2;


import java.sql.*;
public class PMemberTest
{
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url  = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";

	public static void main(String []args)
	{
		Connection conn;
		ResultSet  rs;
		Statement stmt;
		try{
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO  member VALUES ( ?,?,?,?,? )");
			System.out.println("PreparedStatement 생성 성공");
			pstmt.setString(1,"0004");
        	pstmt.setString(2,"박지성");
        	pstmt.setInt(3,178);
	        pstmt.setInt(4, 67);
            pstmt.setInt(5, 23 );
			pstmt.executeUpdate();

			pstmt.setString(1,"0005");
        	pstmt.setString(2,"임꺽정");
        	pstmt.setInt(3,167);
        	pstmt.setInt(4,45);
        	pstmt.setInt(5,18);
 			pstmt.executeUpdate();
 			
			
			String query = "SELECT * FROM Member where name= ?" ;
		//	String query = "SELECT * FROM member" ;
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,"홍길동");
			System.out.println(query) ;
			rs = pstmt.executeQuery();
			
				while(rs.next()){
						System.out.print( "이름은>>" +  rs.getString( "id" ) );
						System.out.print( "이름은>>" +  rs.getString( "name" ) );
						System.out.print( " 키는>>" +  rs.getInt( "height" ) );
						System.out.print( " 체중은>>" +  rs.getInt( "weight" ) );
						System.out.print( " 나이는>>" +  rs.getInt( "age" ) );
						System.out.println();
					   }
                rs.close();
                pstmt.close();
				conn.close();
              }catch(ClassNotFoundException e){
					e.printStackTrace();
		     }catch(SQLException e){
					e.printStackTrace();
				}
           }
}
