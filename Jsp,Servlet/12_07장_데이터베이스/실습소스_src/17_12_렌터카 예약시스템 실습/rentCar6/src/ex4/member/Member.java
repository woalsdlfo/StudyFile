package ex4.member;

import java.io.IOException;

import ex4.common.exception.RentException;

public interface Member {
	public void regMember(MemberVo vo) throws RentException, IOException; //회원 등록 메서드
	public String listMember(MemberVo vo) throws MemberException,IOException; //회원 정보 조회 메서드
	public void modMember(MemberVo vo) throws MemberException;//기존 회원 정보를 수정하는 메서드
	public void delMember(MemberVo vo) throws MemberException;//기존 회원 정보를 삭제하는 메서드

}
