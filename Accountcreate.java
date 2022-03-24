package ateamproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Accountcreate {

	CalMemberMgr mgr = new CalMemberMgr();

	boolean isIdChecked = false;
	// 회원가입 중복 체크 여부.
	boolean formComplete = false;
	// 필수 입력항목 입력 여부.
	boolean isPwdCorrect = false;
	//통과여부를 처리하는 함수는 okBtn.addActionListener로.
	
	private JFrame frame;
	private JTextField tfEmail;
	private JTextField tfId;
	private JTextField tfBirthYear;
	private JTextField tfName;
	private JTextField tfBirthMonth;
	private JTextField tfBirthDay;
	private JPasswordField tfPassword;
	private JPasswordField tfChkPassword;

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
	public void setIdChecked(boolean flag) {
		isIdChecked = flag;
	}
	
	

	
	public Boolean pwdCheck() {
		String pwString = ""; 
		Boolean flag = false;
		//tf_pw 필드에서 패스워드를 얻어옴, char[] 배열에 저장 
		
		
		char[] pwd1 = tfPassword.getPassword(); 
		//pwd1 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha 에 한 글자씩 저장 
		
		for(char c : pwd1){ 
			Character.toString(c); 
		//cha 에 저장된 값 string으로 변환 
			pwString += (pwString.equals("")) ? ""+c+"" : ""+c+""; 
		//pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자 
		}
		
		char[] pwd2 = tfChkPassword.getPassword(); 
		//pwd1 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha 에 한 글자씩 저장 
		
		for(char c : pwd2){ 
			Character.toString(c); 
			pwString += (pwString.equals("")) ? ""+c+"" : ""+c+""; 
		}
		
		flag = Arrays.equals(pwd1, pwd2);
		//배열을 비교한 결과를 flag에 대입 
		
		return flag;

	}
	//isPwdCorrect = (tfPassword.getText() == tfChkPassword.getText());

	
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

		JButton okBtn = new JButton("확인");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//양식이 빠짐없이 작성되었는가?
				//아이디 중복확인을 통과했는가?
				//비밀번호 확인이 일치하는가?
				//입력 내용이 형식에 어긋나지 않았나?
				//
				
				if (formComplete) 
					System.out.println("항목이 빠짐없이 작성되었습니다.");
				if (isIdChecked)
					System.out.println("중복확인을 통과했습니다.");
				else
					JOptionPane.showMessageDialog(null, "아이디 중복확인이 필요합니다.");
				
				if (pwdCheck())
					System.out.println("패스워드 일치 확인을 통과했습니다.");
				else
					JOptionPane.showMessageDialog(null, "패스워드가 일치하는지 확인하세요.");
				
				mgr.signUp();
			}
		});
		okBtn.setBounds(130, 482, 106, 38);
		panel.add(okBtn);
		
		
		
		JButton testBtn = new JButton("테스트 버튼");
		testBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		testBtn.setBounds(0, 0, 106, 38);
		panel.add(testBtn);
		

		JButton cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancelBtn.setBounds(248, 482, 106, 38);
		panel.add(cancelBtn);

		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(212, 10, 64, 65);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2_5 = new JLabel("이름");
		lblNewLabel_2_5.setForeground(SystemColor.text);
		lblNewLabel_2_5.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(54, 74, 87, 32);
		panel.add(lblNewLabel_2_5);

		tfName = new JTextField("");
		tfName.setColumns(10);
		tfName.setBounds(54, 106, 300, 32);
		panel.add(tfName);

		JLabel lblNewLabel_2_4 = new JLabel("생년월일");
		lblNewLabel_2_4.setForeground(SystemColor.text);
		lblNewLabel_2_4.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(54, 139, 87, 32);
		panel.add(lblNewLabel_2_4);

		tfBirthYear = new JTextField("");
		tfBirthYear.setColumns(10);
		tfBirthYear.setBounds(54, 171, 99, 32);
		panel.add(tfBirthYear);

		JLabel lblNewLabel_2_5_1 = new JLabel("년");
		lblNewLabel_2_5_1.setForeground(SystemColor.text);
		lblNewLabel_2_5_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_5_1.setBounds(159, 170, 19, 32);
		panel.add(lblNewLabel_2_5_1);

		tfBirthMonth = new JTextField("");
		tfBirthMonth.setColumns(10);
		tfBirthMonth.setBounds(190, 171, 50, 32);
		panel.add(tfBirthMonth);

		JLabel lblNewLabel_2_5_1_1 = new JLabel("월");
		lblNewLabel_2_5_1_1.setForeground(SystemColor.text);
		lblNewLabel_2_5_1_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_5_1_1.setBounds(247, 169, 19, 32);
		panel.add(lblNewLabel_2_5_1_1);

		tfBirthDay = new JTextField("");
		tfBirthDay.setColumns(10);
		tfBirthDay.setBounds(278, 171, 50, 32);
		panel.add(tfBirthDay);

		JLabel lblNewLabel_2_5_1_1_1 = new JLabel("일");
		lblNewLabel_2_5_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_2_5_1_1_1.setBackground(SystemColor.text);
		lblNewLabel_2_5_1_1_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_5_1_1_1.setBounds(335, 169, 19, 32);
		panel.add(lblNewLabel_2_5_1_1_1);

		
		JLabel lblNewLabel_2_2 = new JLabel("이메일");
		lblNewLabel_2_2.setForeground(SystemColor.text);
		lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(54, 203, 87, 32);
		panel.add(lblNewLabel_2_2);
		//===
		tfEmail = new JTextField("");
		tfEmail.setColumns(10);
		tfEmail.setBounds(54, 237, 300, 32);
		panel.add(tfEmail);

		
		JLabel lblNewLabel_2_3 = new JLabel("아이디");
		lblNewLabel_2_3.setForeground(SystemColor.text);
		lblNewLabel_2_3.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(54, 266, 87, 32);
		panel.add(lblNewLabel_2_3);

		
		tfId = new JTextField("");
		tfId.setColumns(10);
		tfId.setBounds(54, 298, 300, 32);
		tfId.getDocument().addDocumentListener(new DocumentListener() {
			//한번 중복체크를 받았어도, 입력한 아이디가 변경되면 다시 중복체크를 하도록 만든다.
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				setIdChecked(false);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				setIdChecked(false);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				//StyledDocument에만 적용되는 메소드.
			}
		});
		panel.add(tfId);
		
		
		JLabel lblNewLabel_2_1 = new JLabel("비밀번호");
		lblNewLabel_2_1.setForeground(SystemColor.text);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(54, 329, 87, 32);
		panel.add(lblNewLabel_2_1);

		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(54, 361, 300, 32);
		panel.add(tfPassword);

		JLabel lblNewLabel_2 = new JLabel("비밀번호 확인");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(54, 395, 87, 32);
		panel.add(lblNewLabel_2);

		tfChkPassword = new JPasswordField("");
		tfChkPassword.setBounds(54, 427, 300, 32);
		panel.add(tfChkPassword);
		tfChkPassword.setColumns(10);
		
		
		JButton checkIdButton = new JButton("중복확인");
		checkIdButton.addActionListener(new ActionListener() {

			// return boolean
			public void actionPerformed(ActionEvent e) {
				System.out.println("===액션을 실행합니다. 입력값 : " + tfId.getText());
				
				String targetId = tfId.getText().trim();
				
				if(targetId.equals("")) {
					setIdChecked(false);
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
					return;
				}
					
				boolean dupID = mgr.dupIdChk(targetId);
				// getText() in select id from member

				if(dupID) {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
					setIdChecked(false);
				}
					
				else {
					JOptionPane.showMessageDialog(null, "사용할 수 있는 아이디입니다!");
					setIdChecked(true);
				}
					
			}
		});
		checkIdButton.setFont(new Font("굴림", Font.PLAIN, 13));
		checkIdButton.setBounds(366, 299, 87, 28);
		panel.add(checkIdButton);
	}
}
