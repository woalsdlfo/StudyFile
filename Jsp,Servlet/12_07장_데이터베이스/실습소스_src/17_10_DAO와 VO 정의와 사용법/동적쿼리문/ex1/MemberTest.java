package ch17.ex4;

import java.util.ArrayList;

public class MemberTest {
	public static void main(String[] args){
		MemberDao dao=new MemberDao();
		String _name=null;
		
		_name="������";
		ArrayList<MemberVo> list=dao.list(_name);  //���ڷ� ���ǰ��� �ѱ��.
		
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
