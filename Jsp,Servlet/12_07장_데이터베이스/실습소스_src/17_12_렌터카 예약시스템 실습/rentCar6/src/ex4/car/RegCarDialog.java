package ex4.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegCarDialog  extends JDialog{
	JPanel jPanel;
	JLabel lCarNum,lCarName,lSize,lColor,lMaker;
	JTextField tfCarNum,tfCarName,tfSize,tfColor,tfMaker ;
    JButton btnReg;
    
    Car carController;
    
    public RegCarDialog(String str){
    	setTitle(str);
    	init();
    }
    
    private void init(){
    	 carController=new CarImpl();
    	lCarNum = new JLabel("������ȣ");
    	lCarName = new JLabel("������");
    	lSize = new JLabel("��ⷮ");
    	lColor = new JLabel("������");
    	lMaker = new JLabel("��������");
    	
    	
    	tfCarNum=new JTextField(20);
    	tfCarName=new JTextField(20);
    	tfSize=new JTextField(20);
    	tfColor=new JTextField(20);
    	tfMaker=new JTextField(20);
    	
    	btnReg=new JButton("����ϱ�");
    	
   	 	btnReg.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String carNum=tfCarNum.getText().trim();
				String carName=tfCarName.getText().trim();
				int carSize=Integer.parseInt(tfSize.getText().trim());
				String carColor=tfColor.getText().trim();
				String carMaker=tfMaker.getText().trim();
				
				CarVo vo=new CarVo(carNum,carName,carColor,carSize,carMaker);
				try {
					carController.regCarInfo(vo);
					showMessage("������  ����߽��ϴ�.");
					tfCarNum.setText("");
					tfCarName.setText("");
					tfSize.setText("");
					tfColor.setText("");
					tfMaker.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("������ �߻��߽��ϴ�.\n�ٽ� ����� �ּ���.");
				}
				
				
				
				//dispose();
				
			}
        });
    	
    	
    	jPanel=new JPanel(new GridLayout(0,2));
    	jPanel.add(lCarNum);
    	jPanel.add(tfCarNum);
    	
    	jPanel.add(lCarName);
    	jPanel.add(tfCarName);
    	
    	jPanel.add(lSize);
    	jPanel.add(tfSize);
    	
    	jPanel.add(lColor);
    	jPanel.add(tfColor);
    	
    	jPanel.add(lMaker);
    	jPanel.add(tfMaker);
    	
    	add(jPanel,BorderLayout.NORTH);
    	add(btnReg,BorderLayout.SOUTH);
    	
        setLocation(400, 200);
        setSize(400,400);
        setModal(true); //�׻� �θ�â ���� ���̰� �Ѵ�.
        setVisible(true);
    }
    
    private void showMessage(String msg){
    	JOptionPane.showMessageDialog(this,
    			msg, 
    			"������ �ڽ�",
               JOptionPane.INFORMATION_MESSAGE);
    }
}
