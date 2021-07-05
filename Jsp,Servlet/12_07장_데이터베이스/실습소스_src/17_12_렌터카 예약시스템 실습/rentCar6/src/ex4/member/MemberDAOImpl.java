package ex4.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import ex4.common.exception.RentException;


public class MemberDAOImpl implements Member {
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //����� DB���� ���� �����͸� �����Ѵ�.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	private Connection con; 
    private	Statement stmt;
    private ResultSet rs;
    
	public void regMember(MemberVo vo) throws RentException, IOException {
		
	}

	public String listMember(MemberVo vo) throws MemberException, IOException {

		return null;
	}

	public void modMember(MemberVo vo) throws MemberException {
		
	}

	public void delMember(MemberVo vo) throws MemberException {
		
	}
	
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

}
