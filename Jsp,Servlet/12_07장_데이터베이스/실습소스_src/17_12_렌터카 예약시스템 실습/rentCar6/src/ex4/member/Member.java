package ex4.member;

import java.io.IOException;

import ex4.common.exception.RentException;

public interface Member {
	public void regMember(MemberVo vo) throws RentException, IOException; //ȸ�� ��� �޼���
	public String listMember(MemberVo vo) throws MemberException,IOException; //ȸ�� ���� ��ȸ �޼���
	public void modMember(MemberVo vo) throws MemberException;//���� ȸ�� ������ �����ϴ� �޼���
	public void delMember(MemberVo vo) throws MemberException;//���� ȸ�� ������ �����ϴ� �޼���

}
