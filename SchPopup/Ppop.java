package ateamproject.SchPopup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ateamproject.Data.CalSchedBean;
import ateamproject.Data.CalSchedMgr;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Ppop extends JFrame {
	
	CalSchedMgr mgr = new CalSchedMgr();
	Vector<CalSchedBean> vlist = mgr.listSched();

	private JPanel contentPane;
	private JTextField tfTitle;

	private JLabel dateLabel;
	
	String popY = "" + 2020;
	String popM = "" + 1;
	String popD = "" + 1;

	
	
	
	public Ppop() {

		setBounds(100, 100, 450, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dateLabel = new JLabel(popY + "-" + popM + "-" + popD);
		dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateLabel.setBounds(26, 0, 57, 15);
		contentPane.add(dateLabel);
		
		JLabel lblNewLabel = new JLabel("일정내용");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 15);
		contentPane.add(lblNewLabel);
		
		JLabel titleLbl = new JLabel("일정제목");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(26, 28, 57, 15);
		contentPane.add(titleLbl);
		
		JLabel contentLbl = new JLabel("일정내용");
		contentLbl.setHorizontalAlignment(SwingConstants.CENTER);
		contentLbl.setBounds(26, 71, 57, 36);
		contentPane.add(contentLbl);
		
		JButton callPop2Btn = new JButton("더보기");
		callPop2Btn.setBounds(17, 117, 86, 23);
		contentPane.add(callPop2Btn);
		
		callPop2Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ppop2 pop2 = new Ppop2();
				pop2.setVisible(true);
				pop2.setDate(popY, popM, popD);
				
				dispose();
			}
		});
		
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setBounds(116, 157, 97, 23);
		contentPane.add(saveBtn);
		
		JButton cancleBtn = new JButton("취소");
		cancleBtn.setBounds(241, 157, 97, 23);
		contentPane.add(cancleBtn);
		cancleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		tfTitle = new JTextField();
		
		tfTitle.setBounds(115, 25, 276, 20);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);
		
		JTextArea scContent = new JTextArea();
		scContent.setBounds(115, 62, 276, 57);
		contentPane.add(scContent);
		
		JButton delBtn = new JButton("삭제");
		delBtn.setBounds(347, 129, 75, 23);
		contentPane.add(delBtn);
	}
	
	public void setPopDate(String y, String m, String d) {
		System.out.println(popY + "-" + popM + "-" +popD);
		
		popY = y;
		popM = m;
		popD = d;
		dateLabel.setText(y + "-" + m + "-" + d);
		
		
		CalSchedBean sbean = mgr.getSched(popY + "-" + popM + "-" +popD);
		System.out.println("결과값 : "); 
		System.out.println("id : " + sbean.getSc_id() ); 
		System.out.println("시작일 : " + sbean.getSc_startdate()); 
		System.out.println("종료일 : " + sbean.getSc_enddate() ); 
		System.out.println("제목 : " + sbean.getSc_title()); 
		System.out.println("내용 : " + sbean.getSc_content()); 
		
		tfTitle.setText(sbean.getSc_title());
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ppop frame = new Ppop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

