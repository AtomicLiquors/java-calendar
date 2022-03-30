package ateamproject.SchPopup;

import java.awt.EventQueue;

import ateamproject.Data.CalSchedBean;
import ateamproject.Data.CalSchedMgr;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class PpopDetail extends Ppop {
	
	CalSchedMgr mgr = new CalSchedMgr();
	Vector<CalSchedBean> vlist = mgr.listSched();

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
//	String popY = "" + 2020;
//	String popM = "" + 1;
//	String popD = "" + 1;
	private final JButton btnNewButton = new JButton("");

	
	public PpopDetail() {
		super();
	}
	
	public PpopDetail(String y, String m, String d) {
		
		super(y, m, d);
		
		setBounds(100, 100, 452, 425);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 230, 424, 127);
		super.contentPane.add(contentPane_1);

		JLabel lblNewLabel_1_1 = new JLabel("admin");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(26, 3, 57, 15);
		contentPane_1.add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setToolTipText("제목을 쓰세요");
		textField_1.setColumns(10);
		textField_1.setBounds(105, 0, 220, 20);
		contentPane_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setToolTipText("제목을 쓰세요");
		textField_2.setColumns(10);
		textField_2.setBounds(105, 30, 220, 20);
		contentPane_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setToolTipText("제목을 쓰세요");
		textField_3.setColumns(10);
		textField_3.setBounds(105, 60, 220, 20);
		contentPane_1.add(textField_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("admin");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(26, 33, 57, 15);
		contentPane_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("admin");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(26, 63, 57, 15);
		contentPane_1.add(lblNewLabel_1_1_2);
		btnNewButton.setIcon(new ImageIcon("ateamproject/img/pencil.png"));
		btnNewButton.setBounds(333, 0, 30, 20);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("ateamproject/img/x.png"));
		btnNewButton_1.setBounds(367, 0, 30, 20);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("ateamproject/img/x.png"));
		btnNewButton_2.setBounds(367, 30, 30, 20);
		contentPane_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("ateamproject/img/pencil.png"));
		btnNewButton_3.setBounds(333, 29, 30, 20);
		contentPane_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("ateamproject/img/pencil.png"));
		btnNewButton_4.setBounds(333, 59, 30, 20);
		contentPane_1.add(btnNewButton_4);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon("ateamproject/img/x.png"));
		btnNewButton_2_1.setBounds(367, 59, 30, 20);
		contentPane_1.add(btnNewButton_2_1);

		JLabel lblNewLabel_3 = new JLabel("Comments");
		lblNewLabel_3.setBounds(0, 205, 434, 15);
		super.contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PpopDetail frame = new PpopDetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
