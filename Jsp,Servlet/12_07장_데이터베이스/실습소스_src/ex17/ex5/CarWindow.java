package ch17.ex5;

import java.awt.*;
import java.awt.event.*;
import java.util.*;



//�� �Է� ��Ҹ� ���� ���� �ǳڿ� �ø� �Ŀ� �ٽ� ū �ǳ����� �ø���.
public class CarWindow {
	 private Frame frame;
	 private Button btnAdd,btnSearch,btnMod,btnDel;
	  private Panel btnPanel;
	  private Panel carPanel,numPanel,namePanel,sizePanel,yearPanel,comPanel;
	  private Panel listPanel;
	  private java.awt.List  carList;
	  
	  private Label lNum,lName,lSize,lYear,lCompany;
	  private TextField tNum,tName,tSize,tYear,tCompany;

	  CarVo carVo=null;
	  ArrayList<CarVo> cList;
	
	  private CarDao carDao;
	  public CarWindow() {
		  
	    frame = new Frame("�������� ���");  //ȭ�� ��ü�� �����Ѵ�.
	    carPanel = new Panel();
	    carPanel.setBackground(Color.GREEN);
	    carPanel.setLayout(new GridLayout(0,1));

	    numPanel=new Panel();
	    namePanel=new Panel();
	    sizePanel=new Panel();
	    yearPanel=new Panel();
	    comPanel=new Panel();
	    btnPanel=new Panel();
	    
	    lNum=new Label("����ȣ");
	    tNum=new TextField("",30); 
	    numPanel.add(lNum);
	    numPanel.add(tNum);
	    
	    lName=new Label("����  ");
	    tName=new TextField("",30);
	    namePanel.add(lName);
	    namePanel.add(tName);
	    
	    lSize=new Label("��ⷮ");
	    tSize=new TextField("",30);
	    sizePanel.add(lSize);
	    sizePanel.add(tSize);
	    
	    lYear=new Label("����  ");
	    tYear=new TextField("",30);
	    yearPanel.add(lYear);
	    yearPanel.add(tYear);
	    
	    lCompany=new Label("������");
	    tCompany=new TextField("",30);
	    comPanel.add(lCompany);
	    comPanel.add(tCompany);
	    
	    carList =new java.awt.List();
	    carList.setName("carList");
	    carList.setBackground(Color.ORANGE);
	    carList.add("����ȣ        ����        ��ⷮ        ����      ������");

	    carList.addItemListener(new ItemHandler());
	    
	    listPanel=new Panel();
	    listPanel.setLayout(new GridLayout(0,1));
	    listPanel.add(carList);

	    
	    btnAdd=new Button("���");
	    btnSearch=new Button("��ȸ");
	    btnMod=new Button("����");
	    btnDel=new Button("����");
	    
	    btnAdd.addActionListener(new ActionHandler());
	    btnSearch.addActionListener(new ActionHandler());
	    btnMod.addActionListener(new ActionHandler());
	    btnDel.addActionListener(new ActionHandler());
	    
	    btnPanel.add(btnAdd);
	    btnPanel.add(btnSearch);
	    btnPanel.add(btnMod);
	    btnPanel.add(btnDel);
	    
	    cList=new ArrayList<CarVo>();
	    
	    carDao=new CarDao();
	    carVo=new CarVo();
	  }
	  
	  private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e)  {
			try{
				if(e.getSource()==btnAdd){
					String carNum=tNum.getText();
					String carName=tName.getText();
					int carSize=Integer.parseInt(tSize.getText());
					int carYear=Integer.parseInt(tYear.getText());
					String company=tCompany.getText();
					carVo =new CarVo(carNum,carName,carSize,carYear,company);
					carDao.AddCar(carVo);
					
					initList();
					
				}else if(e.getSource()==btnSearch){
					initList();
					
					
				}else if(e.getSource()==btnMod){
					String carNum=tNum.getText();
					String carName=tName.getText();
					int carSize=Integer.parseInt(tSize.getText());
					int carYear=Integer.parseInt(tYear.getText());
					String company=tCompany.getText();
					carVo =new CarVo(carNum,carName,carSize,carYear,company);
					carDao.modifyCar(carVo);
					initList();
				}else if(e.getSource()==btnDel){
					String carNum=carVo.getCarNum();
					carDao.deleteCar(carNum);
					initList();
					
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
	  }
	  
	  private class ItemHandler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			 
			if(e.getStateChange()==ItemEvent.SELECTED){
				System.out.println(e.getItem());
				int index=(Integer)e.getItem();
				carVo=cList.get(index);
				
				tNum.setText(carVo.getCarNum());
				tName.setText(carVo.getCarName());
				tSize.setText(Integer.toString(carVo.getCarSize()));
				tYear.setText(Integer.toString(carVo.getProdYear()));
				tCompany.setText(carVo.getCompany());
			}
			
			
		}
		  
	  }
	  
	  private void initList() throws Exception{
		  cList=(ArrayList<CarVo>)carDao.search(carVo);
		  carList.removeAll();
			for( int i = 0 ; i < cList.size(); i++ ){
				carVo=cList.get(i);
				String carNum=carVo.getCarNum();
				String carName=carVo.getCarName();
				int carSize=carVo.getCarSize();
				int carYear=carVo.getProdYear();
				String company=carVo.getCompany();
				
				carList.add(carNum+"       "+carName+"       "+carSize+"       "+
							carYear+"       "+company);	
			}
	  }
	  
	  public void launchFrame() {
		  carPanel.add(numPanel);
		  carPanel.add(namePanel);
		  carPanel.add(sizePanel);
		  carPanel.add(yearPanel);
		  carPanel.add(comPanel);
		
		frame.add(carPanel,BorderLayout.NORTH);
		frame.add(listPanel,BorderLayout.CENTER);
		frame.add(btnPanel,BorderLayout.SOUTH);
		
		frame.setSize(500,500);  
		frame.setVisible(true); 
	  }
	  
	  public static void main(String args[]) {
			CarWindow  border = new CarWindow();
		    border.launchFrame();
	  }	  
}
