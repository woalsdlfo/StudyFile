package ex4.reserve;

public interface Reserve {
	public String reserveCar(ResVo vo);   //차를 예약하는 메서드
	public void modReserveInfo(ResVo vo);   //차 예약정보를 수정하는 메서드
	public void cancelReserveInfo(ResVo vo);  //차 예약 정보를 취소하는 메서드
}
