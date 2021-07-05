package ex4.car;

import java.util.ArrayList;

import ex4.base.Base;
import ex4.common.DataUtil;

public class CarImpl extends Base implements Car{
	String carData;
	CarDAO carDAO=new CarDAOImpl();
	
	
	//���� ������ ��ȸ�ϴ� �޼���
	public ArrayList<CarVo> listCarInfo(CarVo vo) throws Exception{
		ArrayList<CarVo> carList=null;
		
		try {
			carList=carDAO.listCarInfo(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carList;
	}
	
	//�� ���� ������ ����ϴ� �޼���
	public void regCarInfo(CarVo vo)  throws Exception{
		carDAO.regCarInfo(vo);
	}
	
	// �� ������ �����ϴ� �޼���
	public void modCarInfo(CarVo vo) throws Exception{
		// ������ ������.
	}
	
	//�� ������ �����ϴ� �޼���
	public void delCarInfo(CarVo vo) throws Exception{
		//������ ������.
	}
	

}
