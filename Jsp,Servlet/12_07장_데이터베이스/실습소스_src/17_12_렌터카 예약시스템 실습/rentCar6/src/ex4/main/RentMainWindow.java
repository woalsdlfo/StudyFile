package ex4.main;

import java.awt.Container;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ex4.car.RegCarDialog;
import ex4.car.SearchCarDialog;
import ex4.member.RegMemDialog;
import ex4.member.SearchMemDialog;


public class RentMainWindow extends JFrame  {
	JFrame f;
	JMenuBar menuBar;
	JMenu carMenu, memberMenu, rentMenu,helpMenu; //���� �޴� �׸�
	//���� �޴� �׸�
		 JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
		 JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
		 JMenuItem helpMenu41;
	JPanel jPanel;
	JLabel lCarName;
	JTextField tf ;
    JButton searchBtn ;
    
   
	public RentMainWindow(){
		  f = new JFrame("��Ʈī ���� �ý���");
		menuBar = new JMenuBar();
		   //���� �޴�  �׸� ��ü ����
		carMenu = new JMenu("���� ����");
		memberMenu = new JMenu("ȸ������");
		helpMenu = new JMenu("����");
	}
	 

	// ����޴� ���� �޼ҵ�
		protected void startFrame() { 
		  f.setJMenuBar(menuBar); //Frame�� �޴��ٸ� �ܴ�.
		  menuBar.add(carMenu); //�޴��ٿ� "����"�׸��� �ܴ�.
		  //���� �޴� ���� ���� �޴� �׸�
		  carMenu.add(carMenu11 = new JMenuItem("í�����"));
		  carMenu.add(carMenu12 = new JMenuItem("������ȸ"));
		  carMenu.addSeparator(); //�и��� �����ϱ�
		  carMenu.add(carMenu13 = new JMenuItem("��������"));
		  carMenu.add(carMenu14 = new JMenuItem("��������"));
		 
		  menuBar.add(memberMenu); //�޴��ٿ� "ȸ������"�׸��� �ܴ�.
		  //ȸ�� ���� �޴� ���� ���� �޴� �׸�
		  memberMenu.add(memMenu21=new JMenuItem("ȸ�����"));
		  memberMenu.add(memMenu22=new JMenuItem("ȸ����ȸ"));
		  memberMenu.add(memMenu23=new JMenuItem("ȸ������"));
		  memberMenu.add(memMenu24=new JMenuItem("ȸ������"));
		 
		  
		  menuBar.add(helpMenu);
		  helpMenu.add(helpMenu41 = new JMenuItem("����"));
		  
		  
		 jPanel=new JPanel();
		 lCarName=new JLabel("������");
		  tf = new JTextField(10);
		  searchBtn = new JButton("���� ��ȸ�ϱ�");
		    
		 jPanel.add(lCarName);
		 jPanel.add(tf);
		 jPanel.add(searchBtn);
		 
		 
		 Container con=f.getContentPane(); //contentPane �� ������ �� �� ����ϴ� �޼ҵ�
		 con.add(jPanel,"North");
		 
		  f.setLocation(200, 100);
		  f.setSize(800, 600);
		  f.setVisible(true);
		  f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		  //�޴� �׸� ���� �̺�Ʈ�� �̺�Ʈ �����ʸ� �����Ѵ�.
		  carMenu11.addActionListener(new CarHandler());
		  carMenu12.addActionListener(new CarHandler());
		  carMenu13.addActionListener(new CarHandler());
		  carMenu14.addActionListener(new CarHandler());
		  
		  memMenu21.addActionListener(new MemberHandler());
		  memMenu22.addActionListener(new MemberHandler());
		  memMenu23.addActionListener(new MemberHandler());
		  memMenu24.addActionListener(new MemberHandler());
		  
		  helpMenu41.addActionListener(new HelpHandler());
	}

	private class CarHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()==carMenu11){
				new RegCarDialog("�������â");
			}else if(e.getSource()==carMenu12){
				new SearchCarDialog("������ȸâ");
			}else if(e.getSource()==carMenu13){
			}
		}
	}
	
	private class MemberHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()==memMenu21){
				new RegMemDialog("ȸ�� ���â");
			}else if(e.getSource()==memMenu22){
				new SearchMemDialog("ȸ�� ��ȸâ");
			}else if(e.getSource()==memMenu23){
			}
		}
	}
	
	private class HelpHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			version();
		}
	}
	
	//���� �޴� Ŭ�� �� �����ϴ� �޼ҵ�
		public void version() { // ��������â ����
		  final JDialog d = new JDialog(this, "��������");
		  JLabel jbver = new JLabel("       ����1.0");
		  JLabel jbdate = new JLabel("       2015.03.11");
		  JLabel jbauthor = new JLabel("       ���� : idea java");
		  
		  d.setLayout(new FlowLayout());
		  d.add(jbver);
		  d.add(jbdate);
		  d.add(jbauthor);
		  
		  d.setLocation(250, 230);
		  d.setSize(200, 100);
		  d.setVisible(true);
		  
		  d.addWindowListener(new WindowAdapter(){ // ��������â ����
			   public void windowClosing(WindowEvent e){
				   d.dispose();
				   d.setVisible(false);
			   }
		  });
		 }	
		
	 
	public static void main(String[] args){
		RentMainWindow test=new RentMainWindow();
		test.startFrame();
	}
}
