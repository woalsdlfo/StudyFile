package ex6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class ProcedureTest1 {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";

	public static void main(String args[]) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		CallableStatement cstmt = null;
		try {
			Class.forName(driver);
			System.out.println(" Oracle ����̹� �ε� ����");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");

			cstmt = conn.prepareCall("{call p_list_member( ?, ?, ? )}"); 
			cstmt.setString(1, "0002");
			cstmt.registerOutParameter(2, Types.CHAR);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			System.out.print("�̸� : " + cstmt.getString(2)+"\t");
			System.out.print("���� : " + cstmt.getInt(3));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}