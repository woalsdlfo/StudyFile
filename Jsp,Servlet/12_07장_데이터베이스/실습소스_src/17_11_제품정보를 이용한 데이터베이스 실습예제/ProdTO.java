package ch17.ex4;

public class ProdVO {
	private String prodCode;  //��ǰ�ڵ��ȣ
	private String prodName;   //��ǰ�̸�
	private String prodColor;  //��ǰ ����
	private int prodQty  ;		//��ǰ����
	
	
	ProdVO(){
		this("x20120001","����Ʈ��","ȭ��Ʈ",100);
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
