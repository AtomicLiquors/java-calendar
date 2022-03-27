package ateamproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class LoginDesign {

	private JFrame frame;
	private JTextField ID;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDesign window = new LoginDesign();
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
	public LoginDesign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setResizable(false);
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 320);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel Loginpanel = new JPanel();
		Loginpanel.setBounds(0, 0, 545, 280);
		Loginpanel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(Loginpanel);
		Loginpanel.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(
				"ateamproject/img/signup.png"));
		btnNewButton.setBounds(101, 215, 119, 35);
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Loginpanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(
				"ateamproject/img/lookup.png"));
		btnNewButton_1.setBounds(273, 215, 119, 35);
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Loginpanel.add(btnNewButton_1);

		JButton loginBtn = new JButton("");
		loginBtn.setIcon(new ImageIcon(
				"ateamproject/img/login.png"));
		loginBtn.setBounds(410, 68, 113, 119);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CalMemberMgr mgr;
				mgr = new CalMemberMgr();
				
				//쿼리문을 실행해야 된다. Password.getPassword() equals select pwd from member where id = "ID.getText()"  
				String id = ID.getText();
				String pwd = new String(Password.getPassword());
				
				if (mgr.loginChk(id, pwd)) {
					System.out.println("Account confirm");
					frame.dispose();
					new MainWindow();
				} else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다");
				}

			}

		});
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Loginpanel.add(loginBtn);

		JLabel lblNewLabel = new JLabel("자바 SW A조 사무용 캘린더");
		lblNewLabel.setBounds(134, 15, 236, 28);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Loginpanel.add(lblNewLabel);

		ID = new JTextField();
		ID.setBounds(101, 68, 291, 42);
		ID.setColumns(10);
		Loginpanel.add(ID);

		Password = new JPasswordField();
		Password.setBounds(101, 145, 291, 42);
		Password.setColumns(10);
		Loginpanel.add(Password);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(36, 86, 52, 15);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Loginpanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("PW");
		lblNewLabel_1_1.setBounds(36, 160, 52, 15);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Loginpanel.add(lblNewLabel_1_1);

		JPanel Mainpanel = new JPanel();
		Mainpanel.setBounds(0, 0, 1100, 500);
		frame.getContentPane().add(Mainpanel);
	}
}