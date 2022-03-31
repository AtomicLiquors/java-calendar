package ateamproject.SchPopup;

import java.awt.EventQueue;
import java.util.Vector;

import javax.net.ssl.SSLContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ateamproject.Data.CalReplyBean;
import ateamproject.Data.CalSchedBean;
import ateamproject.Data.CalSchedMgr;


public class PpopDetail extends Ppop {
	
	CalSchedMgr mgr = new CalSchedMgr();
	Vector<CalSchedBean> vlist = mgr.listSched();
	Vector<CalReplyBean> rlist = mgr.getReply(super.schedId);

	
	private JPanel contentPane;
	private JPanel replyPanel;
	private JTextField replyTf;
	private JTextField addReplyTf;

	
	private JLabel replyIdLbl;
	private JLabel replyIdLbl1;
	private JLabel replyIdLbl2;
	
	
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

		replyPanel = new JPanel();
		replyPanel.setLayout(null);
		replyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		replyPanel.setBounds(10, 230, 424, 127);
		super.contentPane.add(replyPanel);
		
		
		setComment();
		
		addReplyTf = new JTextField();
		addReplyTf.setColumns(10);
		addReplyTf.setVisible(true);
		addReplyTf.setFocusable(false);
		addReplyTf.setText("");
		addReplyTf.setToolTipText("코멘트를 입력하세요");
		addReplyTf.setBounds(105, 0, 220, 20);
		replyPanel.add(addReplyTf);
		
		JButton addReplyBtn = new JButton("");
		addReplyBtn.setIcon(new ImageIcon("ateamproject/img/pencil.png"));
		addReplyBtn.setBounds(367, 0, 30, 30);
		addReplyBtn.addActionListener("")
		
		replyPanel.add(addReplyBtn);
		

		/*
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("ateamproject/img/x.png"));
		btnNewButton_1.setBounds(367, 0, 30, 20);
		replyPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("ateamproject/img/x.png"));
		btnNewButton_2.setBounds(367, 30, 30, 20);
		replyPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("ateamproject/img/pencil.png"));
		btnNewButton_3.setBounds(333, 29, 30, 20);
		replyPanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("ateamproject/img/pencil.png"));
		btnNewButton_4.setBounds(333, 59, 30, 20);
		replyPanel.add(btnNewButton_4);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon("ateamproject/img/x.png"));
		btnNewButton_2_1.setBounds(367, 59, 30, 20);
		replyPanel.add(btnNewButton_2_1);
		*/

		JLabel lblNewLabel_3 = new JLabel("Comments");
		lblNewLabel_3.setBounds(0, 205, 434, 15);
		super.contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void setComment() {
		for (int i = 0; i < rlist.size(); i++) {
			try {
				String replyId = rlist.get(i).getMb_id();
				System.out.println(replyId);
				replyIdLbl = new JLabel(replyId);
				replyIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
				replyIdLbl.setBounds(26, 43 + (i*30), 57, 15);
				replyPanel.add(replyIdLbl);
				
				String reply = rlist.get(i).getRp_content();
				
				replyTf = new JTextField();
				replyTf.setColumns(10);
				replyTf.setVisible(true);
				replyTf.setFocusable(false);
				replyTf.setText(reply);
				replyTf.setBounds(105, 40 + (i*30), 220, 20);
				replyPanel.add(replyTf);
				
			} catch (Exception e) {
				System.out.println(i+"번째 조회 결과:");
				System.out.println("등록된 코멘트가 없습니다.");
				//e.printStackTrace();
			}
		}
	}
	
	public void getComment(int sc_id) {
		//코멘트 테이블을 조회한다.
		//표시
	}
	
	public void addComment(int sc_id) {
		//코멘트를 등록한다.
		//표시
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

