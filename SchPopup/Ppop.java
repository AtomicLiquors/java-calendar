package ateamproject.SchPopup;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import ateamproject.Data.CalSchedBean;
import ateamproject.Data.CalSchedMgr;
import member.MemberBean;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Vector;


import ateamproject.Data.CalSchedBean;

public class Ppop extends JFrame {
	
	CalSchedMgr mgr = new CalSchedMgr();
	Vector<CalSchedBean> vlist = mgr.listSched();

	protected JPanel contentPane;
	private JTextField tfTitle;
	private JTextArea taContent; 
	private JLabel dateLabel;
	
	private JButton delBtn;
	private JButton saveBtn;
	
	String popY = "" + 2020;
	String popM = "" + 1;
	String popD = "" + 1;

	String popDate = "";
	
	Boolean isSchedFound = false;
	int schedId;
	
	
	public Ppop() {

		setBounds(100, 100, 450, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dateLabel = new JLabel(popDate);
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
				PpopDetail popDetail = new PpopDetail();
				popDetail.setVisible(true);
				popDetail.setPopDate(popY, popM, popD);
				
				dispose();
			}
		});
		
		
		saveBtn = new JButton("저장");
		saveBtn.setBounds(116, 157, 97, 23);
		contentPane.add(saveBtn);
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?");
				CalSchedBean bean = new CalSchedBean();
				
				Date rDate = Date.valueOf(popDate);
				
				if (input==0) { 
					bean.setSc_content(taContent.getText());
					bean.setSc_startdate(rDate); 
					bean.setSc_enddate(rDate);
					bean.setSc_color(null); 
					bean.setSc_priority(0); 
					bean.setSc_isdone(false); 
					bean.setSc_privacy(null); 
					bean.setSc_title(tfTitle.getText());
					}
				
				if(isSchedFound) {
					bean.setSc_id(schedId);
					mgr.updateSched(bean);
				}
				else
					mgr.addSched(bean);
				
				dispose();
			}
		});
		
		
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(241, 157, 97, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		
		tfTitle = new JTextField();
		//일정 제목
		tfTitle.setBounds(115, 25, 276, 20);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);
		
		taContent = new JTextArea();
		//일정 내용
		taContent.setBounds(115, 62, 276, 57);
		contentPane.add(taContent);
		
		delBtn = new JButton("삭제");
		delBtn.setBounds(347, 129, 75, 23);
		contentPane.add(delBtn);
		delBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?");
				if (input==0) {
					mgr.delSched(schedId);
					JOptionPane.showMessageDialog(null, "일정이 데이터베이스에서 삭제되었습니다.");
					dispose();
				}
			}
		});
	}
	
	public void setPopDate(String y, String m, String d) {
		
		popY = y;
		popM = m;
		popD = d;
		
		popDate = popY + "-" + popM + "-" + popD;
		
		dateLabel.setText(popDate);
		
		CalSchedBean sbean = mgr.getSched(popDate);
		isSchedFound = (sbean.getSc_id() != 0);
		schedId = sbean.getSc_id();
		
//		System.out.println("결과값 : "); 
//		System.out.println("id : " + sbean.getSc_id() ); 
//		System.out.println("시작일 : " + sbean.getSc_startdate()); 
//		System.out.println("종료일 : " + sbean.getSc_enddate() ); 
//		System.out.println("제목 : " + sbean.getSc_title()); 
//		System.out.println("내용 : " + sbean.getSc_content()); 
		
		if(isSchedFound) {
			schedId = sbean.getSc_id();
			tfTitle.setText(sbean.getSc_title());
			taContent.setText(sbean.getSc_content());
		}else {
			tfTitle.setText("새 일정 제목");
			taContent.setText("");
			delBtn.setEnabled(false);	
		}		
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

