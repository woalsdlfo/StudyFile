package ch17.ex6;

public class MemberVo {
	 //�Ӽ�
	private String id; 
	private String name;  
	private int height;
	private int  weight;
	private int age;
	
	public MemberVo(){
		
	}
	
	public MemberVo(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	//getters/setters
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
