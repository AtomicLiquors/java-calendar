package ateamproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class Accountcreate {

	private JFrame frame;
	private JTextField textField_7;
	private JLabel lblNewLabel_2;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accountcreate window = new Accountcreate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Accountcreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 493, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 486, 543);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton »Æ¿Œ = new JButton("»Æ¿Œ");
		»Æ¿Œ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		»Æ¿Œ.setBounds(130, 482, 106, 38);
		panel.add(»Æ¿Œ);
		
		JButton √Îº“ = new JButton("√Îº“");
		√Îº“.setBounds(248, 482, 106, 38);
		panel.add(√Îº“);
		
		textField_7 = new JTextField();
		textField_7.setBounds(54, 427, 300, 32);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		lblNewLabel.setBounds(212, 10, 64, 65);
		panel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(54, 395, 87, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_2_1.setForeground(SystemColor.text);
		lblNewLabel_2_1.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(54, 329, 87, 32);
		panel.add(lblNewLabel_2_1);
		
		JPasswordField textField_6 = new JPasswordField();
		textField_6.setColumns(10);
		textField_6.setBounds(54, 361, 300, 32);
		panel.add(textField_6); 
		
		
		JLabel lblNewLabel_2_2 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_2_2.setForeground(SystemColor.text);
		lblNewLabel_2_2.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(54, 266, 87, 32);
		panel.add(lblNewLabel_2_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(54, 298, 300, 32);
		panel.add(textField_5);
		
		JLabel lblNewLabel_2_3 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_2_3.setForeground(SystemColor.text);
		lblNewLabel_2_3.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(54, 203, 87, 32);
		panel.add(lblNewLabel_2_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(54, 237, 300, 32);
		panel.add(textField_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_2_4.setForeground(SystemColor.text);
		lblNewLabel_2_4.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(54, 139, 87, 32);
		panel.add(lblNewLabel_2_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(54, 171, 99, 32);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_5 = new JLabel("\uC774\uB984");
		lblNewLabel_2_5.setForeground(SystemColor.text);
		lblNewLabel_2_5.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(54, 74, 87, 32);
		panel.add(lblNewLabel_2_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(54, 106, 300, 32);
		panel.add(textField);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("\uB144");
		lblNewLabel_2_5_1.setForeground(SystemColor.text);
		lblNewLabel_2_5_1.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2_5_1.setBounds(159, 170, 19, 32);
		panel.add(lblNewLabel_2_5_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(190, 171, 50, 32);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_5_1_1 = new JLabel("\uC6D4");
		lblNewLabel_2_5_1_1.setForeground(SystemColor.text);
		lblNewLabel_2_5_1_1.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2_5_1_1.setBounds(247, 169, 19, 32);
		panel.add(lblNewLabel_2_5_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(278, 171, 50, 32);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_5_1_1_1 = new JLabel("\uC77C");
		lblNewLabel_2_5_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_2_5_1_1_1.setBackground(SystemColor.text);
		lblNewLabel_2_5_1_1_1.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		lblNewLabel_2_5_1_1_1.setBounds(335, 169, 19, 32);
		panel.add(lblNewLabel_2_5_1_1_1);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		btnNewButton.setBounds(366, 299, 87, 28);
		panel.add(btnNewButton);
	}
}
