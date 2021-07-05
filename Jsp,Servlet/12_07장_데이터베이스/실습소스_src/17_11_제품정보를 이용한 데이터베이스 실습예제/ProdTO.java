package ch17.ex4;

public class ProdVO {
	private String prodCode;  //제품코드번호
	private String prodName;   //제품이름
	private String prodColor;  //제품 색상
	private int prodQty  ;		//제품수량
	
	
	ProdVO(){
		this("x20120001","스마트폰","화이트",100);
	}
	
	ProdVO(String prodCode, String prodName, String prodColor, int prodQty){
		this.prodCode=prodCode;
		this.prodName=prodName;
		this.prodColor=prodColor;
		this.prodQty=prodQty;
	}
	
	
	//setter ,getter
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdColor() {
		return prodColor;
	}
	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}
	public int getProdQty() {
		return prodQty;
	}
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}
	
	



}
