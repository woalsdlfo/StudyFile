package ch17.ex4;

import java.util.ArrayList;


public class ProductTest {
	public static void main(String []args){
		ProdVO prod1 = new ProdVO();
		
		//ProdTO prod2 =new ProdTO("x20120002","스마트 TV","그레이",200);
		//ProdTO prod3 =new ProdTO("x20120003","노트북","블랙",300);
		
		ProdDAO dao  = new ProdDAO();  //DAO를 호출한다.
		
		dao.addProdInfo(prod1);
		ArrayList<ProdTO> list  = dao.listProdInfo();       //prodDao의 listProdInfo() 메서드를 호출하여 리턴값을  레코드를 담을 arraylist 객체에 담는다.
		

		for( int i = 0 ; i < list.size(); i++ ){    //list에 존재하는 레코드의 개수만큼 루프문을 순환한다.
				 ProdVO prodData = list.get(i);   
				 String prodCode=prodData.getProdCode();       //getter() 메서드를 이용해서 TO에 저장된 data를 변수에 할당한다.
				 String prodName = prodData.getProdName();              
				 String prodColor = prodData.getProdColor();
				 int prodQty = prodData.getProdQty();
				 
				 System.out.println("제품번호는 >>" + prodCode  );
				 System.out.println("제품이름은  >>"+prodName);
				 System.out.println("제품색상은>>"+prodColor);
				 System.out.println("제품입고 수량은>>" +prodQty);
				 System.out.println();
		}//end for
	}		
}

