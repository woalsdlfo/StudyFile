package ch17.ex5;

public class CarVo {
	private String CarNum;
	private String CarName;
	private int CarSize;
	private int prodYear;
	private String company;
	
	public CarVo(){
		
	}
	
	public CarVo(String carNum, String carName, int carSize, int prodYear,
			String company) {
		CarNum = carNum;
		CarName = carName;
		CarSize = carSize;
		this.prodYear = prodYear;
		this.company = company;
	}
	public String getCarNum() {
		return CarNum;
	}
	public void setCarNum(String carNum) {
		CarNum = carNum;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String carName) {
		CarName = carName;
	}
	public int getCarSize() {
		return CarSize;
	}
	public void setCarSize(int carSize) {
		CarSize = carSize;
	}
	public int getProdYear() {
		return prodYear;
	}
	public void setProdYear(int prodYear) {
		this.prodYear = prodYear;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
}
