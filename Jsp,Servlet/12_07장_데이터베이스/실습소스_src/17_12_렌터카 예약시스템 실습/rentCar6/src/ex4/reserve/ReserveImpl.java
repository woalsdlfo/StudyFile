package ex4.reserve;

import ex4.base.Base;
import ex4.common.DataUtil;

public class ReserveImpl extends Base implements Reserve{
	String resData;
	
	//���� �����ϴ� �޼���
	public String reserveCar(ResVo vo){
		resData="���� ����ȣ:"+vo.resCarNumber+","+
	            "���� ����:"+vo.resDate+","+
	            "�̿� ���� ����"+vo.useBeginDate+","+
	            "�� �ݳ� ����:"+vo.returnDate;
		
		DataUtil.encodeData(resData);		
		System.out.println("����ī ����ð�:"+showTime());
		System.out.println("���� �����մϴ�.");
		DataUtil.decodeData(resData);		

		return resData;
	}
	
	//�� ���������� �����ϴ� �޼���
	public void modReserveInfo(ResVo vo){
		resData="���� ����ȣ:"+vo.resCarNumber+","+
	            "���� ����:"+vo.resDate+","+
	            "�̿� ���� ����"+vo.useBeginDate+","+
	            "�� �ݳ� ����:"+vo.returnDate;
		
		DataUtil.encodeData(resData);	
		System.out.println("����ī ���� ���� ���� �ð�:"+showTime());
		System.out.println("���� �����մϴ�.");
	}
	
	//�� ���� ������ ����ϴ� �޼���
	public void cancelReserveInfo(ResVo vo){
		resData="���� ����ȣ:"+vo.resCarNumber+","+
	            "���� ����:"+vo.resDate+","+
	            "�̿� ���� ����"+vo.useBeginDate+","+
	            "�� �ݳ� ����:"+vo.returnDate;
		
		DataUtil.decodeData(resData);		
		System.out.println("����ī ���� ���� ���� �ð�:"+showTime());
		System.out.println("�� ���� ������ �����մϴ�.");
	}
}
