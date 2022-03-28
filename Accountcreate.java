package ateamproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JTextField tfName;
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
	
	public Boolean formCheck() {
		//확인 버튼을 눌렀을 때, 입력이 맞게 되었는지, Id중복확인이 되었는지 판단한다.

		
		
		boolean emptyId = tfId.getText().trim().length() == 0;
		boolean emptyName = tfName.getText().trim().length() == 0;
		boolean emptyEmail = tfEmail.getText().trim().length() == 0;
		
		if(emptyId) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.");
			return false;
		}
		
		if (!isIdChecked) {
			//Id 중복확인을 통과하지 않았다면 다음을 실행한다.
			JOptionPane.showMessageDialog(null, "아이디 중복확인이 필요합니다.");
			return false;
		}
		
		if(emptyName) {
			JOptionPane.showMessageDialog(null, "이름(실명)을 입력해주세요.");
			return false;
		}
		
		if(emptyEmail) {
			JOptionPane.showMessageDialog(null, "이메일 주소를 입력해주세요.");
			return false;
		}
		

		if(!emptyId && !emptyName && !emptyEmail && isIdChecked && pwdCheck())
			return true;
		else
			return false;
		
		
		//반영 안 된 것 : id, pwd, 이메일 제약조건.
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
		
		if(pwd1.length == 0) {
			JOptionPane.showMessageDialog(null, "패스워드를 올바르게 입력하세요.");
			return false;
		}
		
		if(pwd2.length == 0) {
			JOptionPane.showMessageDialog(null, "패스워드 확인란을 올바르게 입력하세요.");
			return false;
		}
		
		flag = Arrays.equals(pwd1, pwd2);
		//배열을 비교한 결과를 flag에 대입 
		
		if(!flag)
			JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다.");
		
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
		
		
		//생년월일 드롭다운

		String yList[]=new String[31];
		String dList[]=new String[31];
		String mList[]=new String[12];
			
		
		for(int i=0;i<31;i++)
		{
			dList[i]=""+(int)(i+1);
			yList[i]=""+(int)(2022-i);
		}//월을 선택하면 유동적으로 바뀌도록.
		
		
		for(int i=0; i<12; i++) {
			mList[i] = "" + (int)(i+1);
		}
		

		JLabel lblNewLabel_2_4 = new JLabel("생년월일");
		lblNewLabel_2_4.setForeground(SystemColor.text);
		lblNewLabel_2_4.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(54, 139, 87, 32);
		panel.add(lblNewLabel_2_4);

		JComboBox<String> cmbYear = new JComboBox<>(yList);
		cmbYear.setBounds(54, 171, 99, 32);
		panel.add(cmbYear);

		JLabel lblNewLabel_2_5_1 = new JLabel("년");
		lblNewLabel_2_5_1.setForeground(SystemColor.text);
		lblNewLabel_2_5_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_5_1.setBounds(159, 170, 19, 32);
		panel.add(lblNewLabel_2_5_1);
		
        
        JComboBox<String> cmbMonth = new JComboBox<>(mList);
        cmbMonth.setBounds(190, 171, 50, 32);
		panel.add(cmbMonth);

		JLabel lblNewLabel_2_5_1_1 = new JLabel("월");
		lblNewLabel_2_5_1_1.setForeground(SystemColor.text);
		lblNewLabel_2_5_1_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_5_1_1.setBounds(247, 169, 19, 32);
		panel.add(lblNewLabel_2_5_1_1);


        JComboBox<String> cmbDate = new JComboBox<>(dList);
        cmbDate.setBounds(278, 171, 50, 32);
		panel.add(cmbDate);

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
				
				String targetId = tfId.getText().trim();
				
				if(targetId.equals("")) {
					setIdChecked(false);
					JOptionPane.showMessageDialog(null, "먼저 아이디를 입력하세요.");
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
		
		
		JButton okBtn = new JButton("확인");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!formCheck()) {
					//formCheck메소드를 실행하고, false일 경우 종료한다.
					return;
				}
				
				String yValue = cmbYear.getItemAt(cmbYear.getSelectedIndex());
            	int mValue = cmbMonth.getSelectedIndex()+1;
            	String dValue = cmbDate.getItemAt(cmbDate.getSelectedIndex());
            	

				String id = tfId.getText().trim();
				char[] pwd = tfPassword.getPassword();
				String name = tfName.getText().trim();
				String bDate = yValue + "-" + mValue + "-" + dValue;
				String email = tfEmail.getText().trim();
				

				
				mgr.signUp(id, pwd, name, bDate, email);
			}
		});
		okBtn.setBounds(130, 482, 106, 38);
		panel.add(okBtn);
		
		
		
		checkIdButton.setFont(new Font("굴림", Font.PLAIN, 13));
		checkIdButton.setBounds(366, 299, 87, 28);
		panel.add(checkIdButton);
	}
}
