package ateamproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ateamproject.Data.CalMemberMgr;
import ateamproject.MainWindow.MainWindow;
import ateamproject.mbform.Accountcreate;
import ateamproject.mbform.Accountseek;

public class LoginScreen {

	public JFrame frame;
	private JTextField ID;
	private JPasswordField Password;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
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
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 320);
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JPanel Loginpanel = new JPanel();
		Loginpanel.setBounds(0, 0, 545, 280);
		Loginpanel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(Loginpanel);
		Loginpanel.setLayout(null);

		JButton joinBtn = new JButton("회원가입");
		joinBtn.setIcon(new ImageIcon(
				"ateamproject/img/signup.png"));
		joinBtn.setBounds(101, 215, 119, 35);
		joinBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Accountcreate window = new Accountcreate();
				window.frame.setVisible(true);
			}
		});
		
		Loginpanel.add(joinBtn);
		

		JButton seekBtn = new JButton("ID찾기");
		seekBtn.setIcon(new ImageIcon(
				"ateamproject/img/lookup.png"));
		seekBtn.setBounds(273, 215, 119, 35);
		seekBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		seekBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Accountseek window = new Accountseek();
				window.frame.setVisible(true);
			}
		});
		Loginpanel.add(seekBtn);

		JButton loginBtn = new JButton("로그인");
		loginBtn.setIcon(new ImageIcon(
				"ateamproject/img/login.png"));
		loginBtn.setBounds(410, 68, 113, 119);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CalMemberMgr mgr;
				mgr = new CalMemberMgr();
				String id = ID.getText();
				String pwd = new String(Password.getPassword());
				
				if (mgr.loginChk(id, pwd)) {
					frame.dispose();
					MainWindow mw = new MainWindow();
					mw.setLoginInfo(id); 
					mw.frame.setVisible(true);
					mw.frame.addWindowListener(new WindowAdapter() {
						public void windowActivated(WindowEvent e) {
							mw.setLbl();
							mw.cPanel.cGrid.clearCalGrid();
							mw.cPanel.cGrid.setCalGrid(mw.yearIdx, mw.monthIdx);
						}
					});
					
				} else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다");
				}

			}

		});
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		

		JLabel titleLbl = new JLabel("자바 SW A조 사무용 캘린더");
		titleLbl.setBounds(134, 15, 236, 28);
		titleLbl.setForeground(Color.WHITE);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		

		ID = new JTextField();
		ID.setBounds(101, 68, 291, 42);
		ID.setColumns(10);
		

		Password = new JPasswordField();
		Password.setBounds(101, 145, 291, 42);
		Password.setColumns(10);
		
		
		Loginpanel.add(ID);
		Loginpanel.add(Password);
		Loginpanel.add(titleLbl);
		Loginpanel.add(loginBtn);

		JLabel idLbl = new JLabel("ID");
		idLbl.setBounds(36, 86, 52, 15);
		idLbl.setForeground(Color.WHITE);
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		Loginpanel.add(idLbl);

		JLabel pwdLbl = new JLabel("PW");
		pwdLbl.setBounds(36, 160, 52, 15);
		pwdLbl.setForeground(Color.WHITE);
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		Loginpanel.add(pwdLbl);
		
		JPanel Mainpanel = new JPanel();
		Mainpanel.setBounds(0, 0, 1100, 500);
		frame.getContentPane().add(Mainpanel);
	}
}