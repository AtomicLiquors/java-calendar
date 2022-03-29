package ateamproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Ppop extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel dateLabel;
	
	String popY = ""+2020;
	String popM = ""+3;
	String popD = ""+5;

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

	/**
	 * Create the frame.
	 */
	public Ppop() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dateLabel = new JLabel(popY+"-"+popM+"-"+popD);
		dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateLabel.setBounds(26, 0, 57, 15);
		contentPane.add(dateLabel);
		
		JLabel lblNewLabel = new JLabel("일정내용");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("일정제목");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(26, 28, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("일정내용");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(26, 71, 57, 36);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("더보기");
		btnNewButton.setBounds(17, 117, 86, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ppop2 pop2 = new Ppop2();
				pop2.setVisible(true);
				pop2.setDate(popY, popM, popD);
				
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
		
		
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(115, 25, 276, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea scContent = new JTextArea();
		scContent.setBounds(115, 62, 276, 57);
		contentPane.add(scContent);
		
		JButton delBtn = new JButton("삭제");
		delBtn.setBounds(347, 129, 75, 23);
		contentPane.add(delBtn);
	}
	
	public void setDate(String y, String m, String d) {
		popY = y;
		popM = m;
		popD = d;
		dateLabel.setText(y + "-" + m + "-" + d);
	}
}

