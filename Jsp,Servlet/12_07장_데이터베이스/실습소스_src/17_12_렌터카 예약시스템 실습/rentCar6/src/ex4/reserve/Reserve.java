package ex4.reserve;

public interface Reserve {
	public String reserveCar(ResVo vo);   //���� �����ϴ� �޼���
	public void modReserveInfo(ResVo vo);   //�� ���������� �����ϴ� �޼���
	public void cancelReserveInfo(ResVo vo);  //�� ���� ������ ����ϴ� �޼���
}
