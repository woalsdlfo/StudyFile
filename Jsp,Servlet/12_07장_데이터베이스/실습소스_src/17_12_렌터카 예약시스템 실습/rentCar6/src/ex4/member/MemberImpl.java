package ex4.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ex4.base.Base;
import ex4.common.DataUtil;
import ex4.common.exception.RentException;

public class MemberImpl extends Base implements Member{
	
	//���ο� ȸ�� ��� �ϴ� �޼���
	public void regMember(MemberVo vo) throws RentException, IOException{
	}

	
	//���� ȸ�� ���� ��ȸ�ϴ� �޼���
	public String listMember(MemberVo vo) throws MemberException, IOException{
		
		return null;
	}
	
	//���� ȸ�� ������ �����ϴ� �޼���
	public void modMember(MemberVo vo) throws MemberException{
	}
	
	//���� ȸ�� ������ �����ϴ� �޼���
	public void delMember(MemberVo vo) throws MemberException{
	}
}
