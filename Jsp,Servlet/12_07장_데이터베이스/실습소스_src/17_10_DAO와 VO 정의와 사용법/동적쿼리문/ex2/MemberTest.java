package ch17.ex5;

import java.util.ArrayList;

public class MemberTest {
	public static void main(String[] args){
		MemberDao dao=new MemberDao();
		String _name="�̼���";
		int _age=25;

		MemberVo vo=new MemberVo(_name,_age);
		
		ArrayList<MemberVo> list=dao.list(vo);  //���ڷ� ���ǰ��� �ѱ��.
		
		for(int i=0; i<list.size();i++){
			MemberVo data=(MemberVo) list.get(i);
			String id=data.getId();
			String name=data.getName();
			int height=data.getHeight();
			int weight=data.getWeight();
			int age=data.getAge();
			
			System.out.println("���̵��>>"+id+
								" ,�̸���>>"+name+
								" ,Ű��>>"+height+
								" ,ü����>>"+weight+
								" ,���̴�>>"+age);
			
		}
	}

}
