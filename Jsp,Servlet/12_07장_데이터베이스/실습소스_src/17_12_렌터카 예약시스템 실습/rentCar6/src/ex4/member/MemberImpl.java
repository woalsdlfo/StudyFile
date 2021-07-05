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
	
	//새로운 회원 등록 하는 메서드
	public void regMember(MemberVo vo) throws RentException, IOException{
	}

	
	//기존 회원 정보 조회하는 메서드
	public String listMember(MemberVo vo) throws MemberException, IOException{
		
		return null;
	}
	
	//기존 회원 정보를 수정하는 메서드
	public void modMember(MemberVo vo) throws MemberException{
	}
	
	//기존 회원 정보를 삭제하는 메서드
	public void delMember(MemberVo vo) throws MemberException{
	}
}
