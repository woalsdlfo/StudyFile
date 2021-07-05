package ex4.car;

import java.util.ArrayList;

public interface CarDAO {
	public void regCarInfo(CarVo vo) throws Exception;
	public ArrayList<CarVo> listCarInfo(CarVo vo) throws Exception;
}
