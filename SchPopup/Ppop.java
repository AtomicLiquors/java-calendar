package ateamproject.SchPopup;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ateamproject.Data.CalSchedBean;
import ateamproject.Data.CalSchedMgr;

public class Ppop extends JFrame {

	CalSchedMgr mgr = new CalSchedMgr();
	Vector<CalSchedBean> vlist = mgr.listSched();

	protected JPanel contentPane;
	private JTextField tfTitle;
	private JTextArea taContent;
	private JLabel dateLabel;

	private JButton delBtn;
	private JButton saveBtn;
	private JButton ddayBtn;

	String popY = "" + 2020;
	String popM = "" + 1;
	String popD = "" + 1;

	static String popLoginId = "";
	String popDate = "";

	Boolean isSchedFound = false;
	Boolean isOnDday = false;
	int schedId;
	
	CalSchedBean sbean;

	public Ppop(String y, String m, String d) {

		popY = y;
		popM = m;
		popD = d;

		popDate = popY + "-" + popM + "-" + popD;

		sbean = mgr.getSched(popDate);
		isSchedFound = (sbean.getSc_id() != 0);

		if (isSchedFound)
			schedId = sbean.getSc_id();
		
		initialize();
	}
	
	
	public Ppop(int sc_id) {
		schedId = sc_id;
		sbean = mgr.getSched(sc_id);
		isSchedFound = (sbean.getSc_id() != 0);
		
		if (isSchedFound) {
			
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-M-d");
			SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
			SimpleDateFormat sdfMonth = new SimpleDateFormat("M");
			SimpleDateFormat sdfDay = new SimpleDateFormat("d");
			
			popDate = sdfDate.format(sbean.getSc_startdate());
			popY = sdfYear.format(sbean.getSc_startdate());
			popM = sdfMonth.format(sbean.getSc_startdate());
			popD = sdfDay.format(sbean.getSc_startdate());
					
		}
		
		initialize();
	}

	
	public Ppop() {
		
		initialize();
	}
	
	
	
	
	private void initialize() {

		setBounds(100, 100, 450, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dateLabel = new JLabel(popDate);
		dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateLabel.setBounds(26, 0, 57, 15);
		dateLabel.setText(popDate);

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
				PpopDetail popDetail = new PpopDetail(popY, popM, popD);
				popDetail.setVisible(true);

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

				if (input == 0) {
					bean.setSc_content(taContent.getText());
					bean.setSc_startdate(rDate);
					bean.setSc_enddate(rDate);
					bean.setSc_color(null);
					bean.setSc_priority(0);
					bean.setSc_isdone(false);
					bean.setSc_privacy(null);
					bean.setSc_title(tfTitle.getText());
				}

				if (isSchedFound) {
					bean.setSc_id(schedId);
					mgr.updateSched(bean);
				} else
					mgr.addSched(bean);

				dispose();
			}
		});

		ddayBtn = new JButton();
		ddayBtn.setIcon(new ImageIcon("ateamproject/img/dday.png"));
		setBtnIsOnDday();
		ddayBtn.setContentAreaFilled(false);
		ddayBtn.setBorderPainted(false);
		ddayBtn.setToolTipText("일정을 D-Day로 등록합니다.");
		ddayBtn.setBounds(400, 25, 20, 20);
		contentPane.add(ddayBtn);

		if (isSchedFound)
			ddayBtn.setEnabled(true);
		else
			ddayBtn.setEnabled(false);

		ddayBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("D-day 등록을 실행합니다.");

				// if : 이미 일정이 등록되어 있는가? d-day 테이블에서 sc_id를 찾아.

				if (isOnDday) {
					int input = JOptionPane.showConfirmDialog(null, "D-Day 등록을 해제하시겠습니까?");
					
					if (input == 0) {
						mgr.clearDday();
						setBtnIsOnDday();
					}

				} else {
					int input = JOptionPane.showConfirmDialog(null, "D-Day로 등록하시겠습니까?");
					if (input == 0) {
						JOptionPane.showMessageDialog(null, "일정이 D-Day로 등록되었습니다.");
						mgr.clearDday();
						mgr.addDday(schedId);
						setBtnIsOnDday();
					}

				}

			}
		});

		JButton cancelBtn = new JButton("닫기");
		cancelBtn.setBounds(241, 157, 97, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		tfTitle = new JTextField();
		// 일정 제목
		tfTitle.setBounds(115, 25, 276, 20);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);

		taContent = new JTextArea();
		// 일정 내용
		taContent.setBounds(115, 62, 276, 57);
		contentPane.add(taContent);

		delBtn = new JButton("삭제");
		delBtn.setBounds(347, 129, 75, 23);
		contentPane.add(delBtn);
		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?");
				if (input == 0) {
					mgr.delSched(schedId);
					mgr.delDday(schedId);
					JOptionPane.showMessageDialog(null, "일정이 데이터베이스에서 삭제되었습니다.");
					dispose();
				}
			}
		});

		if (isSchedFound) {
			tfTitle.setText(sbean.getSc_title());
			taContent.setText(sbean.getSc_content());
		} else {
			tfTitle.setText("새 일정 제목");
			taContent.setText("");
			delBtn.setEnabled(false);
		}
	}

	public void setBtnIsOnDday() {
		isOnDday = mgr.getIsOnDday(schedId);//데이터를 가져온다.
		if (isOnDday) {
			ddayBtn.setIcon(new ImageIcon("ateamproject/img/ddayOn.png"));
		} else {
			ddayBtn.setIcon(new ImageIcon("ateamproject/img/dday.png"));
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


	public static void passLoginInfo(String loginId) {
		popLoginId = loginId;
	}

}
