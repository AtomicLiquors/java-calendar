package ateamproject.SchPopup;

import java.awt.BorderLayout;
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

import javax.swing.*;

public class Ppop2 extends JFrame {
	
	CalSchedMgr mgr = new CalSchedMgr();
	Vector<CalSchedBean> vlist = mgr.listSched();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel dateLabel; 
	
	String popY = ""+2020;
	String popM = ""+3;
	String popD = ""+5;




	/**
	 * Create the frame.
	 */
	public Ppop2() {
		
		CalSchedBean sbean = mgr.getSched("2022-3-25");
		System.out.println("결과값 : " + 
		sbean.getSc_id() +"\t" +
		sbean.getSc_startdate() +"\t" +
		sbean.getSc_content());
		
		
		setBounds(100, 100, 452, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dateLabel = new JLabel("");
		dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateLabel.setBounds(26, 0, 57, 15);
		contentPane.add(dateLabel);

		JLabel lblNewLabel = new JLabel("일정내용 더보기");
		lblNewLabel.setBounds(0, 0, 434, 15);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("일정제목");
		lblNewLabel_1.setBounds(26, 28, 57, 15);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("일정내용");
		lblNewLabel_2.setBounds(26, 71, 57, 36);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("저장");
		btnNewButton_1.setBounds(116, 157, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("취소");
		btnNewButton_2.setBounds(241, 157, 97, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		textField = new JTextField();
		textField.setBounds(115, 25, 283, 20);
		textField.setToolTipText("제목을 쓰세요");
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_3 = new JButton("삭제");
		btnNewButton_3.setBounds(347, 129, 75, 23);
		contentPane.add(btnNewButton_3);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(116, 55, 282, 53);
		contentPane.add(textArea);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 230, 424, 127);
		contentPane.add(contentPane_1);

		JLabel lblNewLabel_1_1 = new JLabel("admin");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(26, 3, 57, 15);
		contentPane_1.add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setToolTipText("제목을 쓰세요");
		textField_1.setColumns(10);
		textField_1.setBounds(105, 0, 283, 20);
		contentPane_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setToolTipText("제목을 쓰세요");
		textField_2.setColumns(10);
		textField_2.setBounds(105, 30, 283, 20);
		contentPane_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setToolTipText("제목을 쓰세요");
		textField_3.setColumns(10);
		textField_3.setBounds(105, 60, 283, 20);
		contentPane_1.add(textField_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("admin");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(26, 33, 57, 15);
		contentPane_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("admin");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(26, 63, 57, 15);
		contentPane_1.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_3 = new JLabel("Comments");
		lblNewLabel_3.setBounds(0, 205, 434, 15);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	
	public void setDate(String y, String m, String d) {
		dateLabel.setText(y + "-" + m + "-" + d);
		popY = y;
		popM = m;
		popD = d;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ppop2 frame = new Ppop2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
