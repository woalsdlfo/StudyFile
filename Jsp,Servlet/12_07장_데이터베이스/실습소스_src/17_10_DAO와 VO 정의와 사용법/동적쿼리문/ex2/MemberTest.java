package ch17.ex5;

import java.util.ArrayList;

public class MemberTest {
	public static void main(String[] args){
		MemberDao dao=new MemberDao();
		String _name="이순신";
		int _age=25;

		MemberVo vo=new MemberVo(_name,_age);
		
		ArrayList<MemberVo> list=dao.list(vo);  //인자로 조건값을 넘긴다.
		
		for(int i=0; i<list.size();i++){
			MemberVo data=(MemberVo) list.get(i);
			String id=data.getId();
			String name=data.getName();
			int height=data.getHeight();
			int weight=data.getWeight();
			int age=data.getAge();
			
			System.out.println("아이디는>>"+id+
								" ,이름은>>"+name+
								" ,키는>>"+height+
								" ,체중은>>"+weight+
								" ,나이는>>"+age);
			
		}
	}

}
