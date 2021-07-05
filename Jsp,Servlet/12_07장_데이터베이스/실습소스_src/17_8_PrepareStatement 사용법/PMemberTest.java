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
			System.out.println("Oracle ����̹� �ε� ����");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO  member VALUES ( ?,?,?,?,? )");
			System.out.println("PreparedStatement ���� ����");
			pstmt.setString(1,"0004");
        	pstmt.setString(2,"������");
        	pstmt.setInt(3,178);
	        pstmt.setInt(4, 67);
            pstmt.setInt(5, 23 );
			pstmt.executeUpdate();

			pstmt.setString(1,"0005");
        	pstmt.setString(2,"�Ӳ���");
        	pstmt.setInt(3,167);
        	pstmt.setInt(4,45);
        	pstmt.setInt(5,18);
 			pstmt.executeUpdate();
 			
			
			String query = "SELECT * FROM Member where name= ?" ;
		//	String query = "SELECT * FROM member" ;
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,"ȫ�浿");
			System.out.println(query) ;
			rs = pstmt.executeQuery();
			
				while(rs.next()){
						System.out.print( "�̸���>>" +  rs.getString( "id" ) );
						System.out.print( "�̸���>>" +  rs.getString( "name" ) );
						System.out.print( " Ű��>>" +  rs.getInt( "height" ) );
						System.out.print( " ü����>>" +  rs.getInt( "weight" ) );
						System.out.print( " ���̴�>>" +  rs.getInt( "age" ) );
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
