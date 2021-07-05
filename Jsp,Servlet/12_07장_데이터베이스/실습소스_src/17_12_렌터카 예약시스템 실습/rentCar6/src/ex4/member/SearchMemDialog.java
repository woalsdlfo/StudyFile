package ex4.member;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ex4.common.RentTableModel;

public class SearchMemDialog  extends JDialog{
	JPanel panelSearch,panelBtn;
	JLabel lCarName;
	JTextField tf ;
    JButton btnSearch ;
    JButton btnModify ;
    JButton btnDelete ;
    
    String[][] carItems ;
    JTable rentTable;
    RentTableModel model;
    String[] columnNames={"아이디","비밀번호","이름","주소","전화번호"  };
    
    public SearchMemDialog(String str){
    	setTitle(str);
    	init();
    	
    }
    
    private void init(){
    	rentTable=new JTable();
    	panelSearch=new JPanel();
    	panelBtn=new JPanel();
        
    	lCarName = new JLabel("회원명");
    	tf=new JTextField("회원명을 입력하세요");
    	btnSearch=new JButton("조회하기");
    	 
    	btnSearch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
    	});
    	
    	panelSearch.add(lCarName);
    	panelSearch.add(tf);
    	panelSearch.add(btnSearch);
    	
    	btnModify=new JButton("수정하기");
    	btnDelete=new JButton("삭제하기");
    	panelBtn.add(btnModify);
    	panelBtn.add(btnDelete);
    	
    	add(panelSearch,BorderLayout.NORTH);
    	add(panelBtn,BorderLayout.SOUTH);
    	
    	carItems = new String[0][5];
        model=new RentTableModel(carItems,columnNames);
    	rentTable.setModel(model);
        add(new JScrollPane(rentTable),BorderLayout.CENTER);
        
        setLocation(300,100);//다이얼로그 출력 위치를 정한다.
        setSize(600,600);
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
    }
    
    private void loadTableData(ArrayList carList){
    	
    }
}
