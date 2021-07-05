package ex6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.jdbc.OracleTypes;

public class FunctionTest2 {
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String  user="scott";
	private static final String pwd="tiger";


	public static void main(String args[]) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String query = "{ ? = call f_list_mem1(?)}";
		try {
			Class.forName(driver);
			System.out.println(" Oracle 드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			
			CallableStatement cstmt = conn.prepareCall(query);
			
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, "임꺽정");
			cstmt.execute();
			ResultSet rset = (ResultSet) cstmt.getObject(1);
			while (rset.next())
				System.out.println(rset.getString(1) + "\t" + rset.getString(2));
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}