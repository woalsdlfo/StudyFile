package ex4.base;

import java.util.Calendar;

public class Base{
	
	//���� Ŭ�������� ��ȸ�� ������ ����ϴ� �޼���
	public void displayData(String data){
		System.out.println("��ȸ�� ������>>"+data+"�Դϴ�.");
	}
	
	//�޼��� ȣ�� �� ȣ��� �ð� ������ ����ϴ� �޼���
	public String showTime(){
		String date=null;
		String time=null;
		
		Calendar cal=Calendar.getInstance();
		
		int hour=cal.get(Calendar.HOUR);
		int min=cal.get(Calendar.MINUTE);
		int sec=cal.get(Calendar.SECOND);
		
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		int day=cal.get(Calendar.DATE);
		
		date=year+"-"+month+"-"+day;
		time=hour+":"+min+":"+sec;
		return date+" "+time;
		
	}

}
