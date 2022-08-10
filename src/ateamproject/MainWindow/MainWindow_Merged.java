package ateamproject.MainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ateamproject.LoginScreen;
import ateamproject.Data.CalMemberBean;
import ateamproject.Data.CalMemberMgr;
import ateamproject.Data.CalSchedBean;
import ateamproject.Data.CalSchedMgr;
import ateamproject.SchPopup.Ppop;

public class MainWindow_Merged implements ActionListener, Runnable{
	
	String[] data = { "aaaaaaaa", "bbbbbbbbb", "ccccccccc", "dddddddd", "eeeeeeeee", "fffffffff", "gggggggggg" };

    
	
    
	Calendar cal = Calendar.getInstance();
	Dday dd = new Dday();
	public CalendarPanel_Merged cPanel = new CalendarPanel_Merged();
	CalMemberMgr mbMgr = new CalMemberMgr();
	CalSchedMgr scMgr = new CalSchedMgr();
	CalSchedBean dBean;

	
	public int yearIdx = cal.get(Calendar.YEAR);
	public int monthIdx = cal.get(Calendar.MONTH);
	String[] engMonths = new DateFormatSymbols(Locale.US).getMonths();
	
	String loginId;
	int ddayId;
	
	private Thread thread;
	private SimpleDateFormat sfDate;
	private SimpleDateFormat sfTime;
	
	DefaultTableModel dm = new DefaultTableModel();
	

	public JFrame frame;
	
	JLabel monthLbl;
	JLabel yearLbl;
	JLabel engLbl; 
	
	JLabel currDateLbl;
	JLabel currTimeLbl;
	
	JLabel ddayTenLbl;
	JLabel ddayOneLbl;
	JLabel memberLbl;
	
	JPanel todoPanel;
	
	JButton ddayTitleBtn;
	
	JButton alarmBtn;
	JButton homeBtn;
	JButton settingBtn;
	JButton prevBtn;
	JButton nextBtn;

	private Vector strArray2Vector(String[] str) {
        Vector vector = new Vector();
        for (int i = 0; i < str.length; i++) {
          Vector v = new Vector();
          v.addElement(str[i]);
          vector.addElement(v);
        }
        return vector;
      }
	
	/**
	 * Create the application.
	 */
	public MainWindow_Merged() {
		initialize();
		cPanel.cGrid.setCalGrid(yearIdx, monthIdx);
		setLbl();

		
	    Vector dummyHeader = new Vector();
	    dummyHeader.addElement("");
	    dm.setDataVector(strArray2Vector(data), dummyHeader);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void setLbl(){

		//달력 Label 설정
		monthLbl.setText(String.format("%02d", monthIdx + 1));
		engLbl.setText(engMonths[monthIdx]);
		yearLbl.setText("" + yearIdx);
		cPanel.setDate(yearIdx, monthIdx);
		
		ddayId = scMgr.getDdaySched();
		

		if(ddayId != 0) {
			dBean = scMgr.getSched(ddayId);
			Date dDate = dBean.getSc_startdate();
			ddayTitleBtn.setText(dBean.getSc_title());
			
			
			SimpleDateFormat ysdf = new SimpleDateFormat(
				    "yyyy");
			SimpleDateFormat msdf = new SimpleDateFormat(
					"M");
			SimpleDateFormat dsdf = new SimpleDateFormat(
					"d");
			
			int y = Integer.parseInt(ysdf.format(dDate));
			int m = Integer.parseInt(msdf.format(dDate));
			int d = Integer.parseInt(dsdf.format(dDate));
			
			long [] sd = dd.countDday(y, m, d);
			ddayTenLbl.setText("" + sd[0]);
			ddayOneLbl.setText("" + sd[1]);
		}else{
			ddayTenLbl.setText("" + 0);
			ddayOneLbl.setText("" + 0);
			ddayTitleBtn.setText("");
		}
	}
	
	


	
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setLocation(-82, -107);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 950, 630);
		frame.getContentPane().setLayout(null);
		
		JPanel calPanel = new JPanel();
		calPanel.setBounds(237, 176, 665, 385);
		frame.getContentPane().add(calPanel);
				
		calPanel.add(cPanel);
		
		
		JLabel lblNewLabel = new JLabel("일");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(237, 139, 93, 37);
		lblNewLabel.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("월");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(331, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("화");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setBounds(425, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("수");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setBounds(519, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("목");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setBounds(610, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("금");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setBounds(705, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("토");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setForeground(Color.BLUE);
		lblNewLabel_1_5.setBounds(799, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 195, 613);
		panel_1.setLayout(null);
		frame.getContentPane().add(panel_1);
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 51, 204));
		panel_2.setBounds(32, 234, 133, 42);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel tdLbl = new JLabel("To-Do list");
		tdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		tdLbl.setBounds(0, 0, 133, 42);
		tdLbl.setForeground(Color.WHITE);
		tdLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel_2.add(tdLbl);
		
		JTable table;
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1. 홍길동"},
				{"2."},
				{"3."},
				{"4."},
				{"5."},
				{"6."},
				{"7."},
				{"8."},
				{"9."},
				{"10."},
				{"11."},
			},
			new String[] {
				"TO-DO list"
			}
		));
		table.setBounds(32, 275, 133, 287);
		panel_1.add(table);
		 table.setRowHeight(26);
	


//		
//		JTable table = new JTable(dm);
//	    table.setShowGrid(false);
//	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//	    JScrollPane scrollTable = new JScrollPane(table);
//	    scrollTable.setColumnHeader(null);
////	    scrollTable.setBounds(0,0,30,230);
//	    scrollTable.setVisible(true);
//	    todoPanel.add(scrollTable);
	    
	    
	    
	    
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setForeground(new Color(0, 0, 204));
		panel_4_1.setBackground(new Color(0, 51, 153));
		panel_4_1.setBounds(123, 120, 38, 50);
		panel_1.add(panel_4_1);
		panel_4_1.setLayout(null);
		
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setForeground(new Color(0, 0, 204));
		panel_4_1_1.setBackground(new Color(0, 51, 153));
		panel_4_1_1.setBounds(32, 120, 38, 50);
		panel_1.add(panel_4_1_1);
		panel_4_1_1.setLayout(null);
				
		
		
		//아래는 D-Day 항목들, 단 소속 패널이 다 따로따로 되어있는데 개선바람.		
		JPanel panel_4_1_2 = new JPanel();
		panel_4_1_2.setBackground(new Color(0, 51, 153));
		panel_4_1_2.setBounds(82, 120, 38, 50);
		panel_1.add(panel_4_1_2);
		panel_4_1_2.setLayout(null);
		
		
		JLabel ddayDLbl = new JLabel("D");
		ddayDLbl.setFont(new Font("굴림", Font.BOLD, 15));
		ddayDLbl.setForeground(new Color(255, 255, 255));
		ddayDLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ddayDLbl.setBounds(0, 0, 38, 50);
		panel_4_1_1.add(ddayDLbl); 
		
		ddayTenLbl = new JLabel("0");
		ddayTenLbl.setFont(new Font("굴림", Font.BOLD, 15));
		ddayTenLbl.setForeground(new Color(255, 255, 255));
		ddayTenLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ddayTenLbl.setBounds(0, 0, 38, 50);
		panel_4_1_2.add(ddayTenLbl);
		
		ddayOneLbl = new JLabel("0");
		ddayOneLbl.setFont(new Font("굴림", Font.BOLD, 15));
		ddayOneLbl.setForeground(new Color(255, 255, 255));
		ddayOneLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ddayOneLbl.setBounds(0, 0, 38, 50);
		panel_4_1.add(ddayOneLbl);
		
		JPanel ddayTitlePanel = new JPanel();
		ddayTitlePanel.setOpaque(false);
		ddayTitlePanel.setBorder(null);
		ddayTitlePanel.setBounds(32, 180, 150, 50);
		panel_1.add(ddayTitlePanel);
		ddayTitlePanel.setLayout(null);
		
		ddayTitleBtn = new JButton("");
		ddayTitleBtn.setFont(new Font("굴림", Font.BOLD, 15));
		ddayTitleBtn.setForeground(new Color(255, 255, 255));
		ddayTitleBtn.setHorizontalAlignment(SwingConstants.LEFT);
		ddayTitleBtn.setFocusable(false);
		ddayTitleBtn.setOpaque(false);
		ddayTitleBtn.setBounds(0, 0, 150, 35);
		ddayTitleBtn.setContentAreaFilled(false);
		ddayTitleBtn.setBorder(null);
		ddayTitleBtn.setBorderPainted(false);
		ddayTitlePanel.add(ddayTitleBtn); 
		
		ddayTitleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(ddayId > 0) {
					Ppop p = new Ppop(ddayId);
					p.setVisible(true);
					p.passLoginInfo(loginId);
					//ppop을 띄워줄 것이다.
				}else {
					System.out.println("dday가 존재하지 않습니다.");
				}
				
				
			}
			
		});		
		
		sfDate = new SimpleDateFormat("yyyy-MM-dd a");
		sfTime = new SimpleDateFormat("hh:mm:ss");
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
		
		currDateLbl = new JLabel("2022-03-15");
		currDateLbl.setForeground(new Color(255, 255, 255));
		currDateLbl.setFont(new Font("굴림", Font.BOLD, 19));
		currDateLbl.setHorizontalAlignment(SwingConstants.LEFT);
		currDateLbl.setBounds(20, 36, 200, 42);
		panel_1.add(currDateLbl);
		
		currTimeLbl = new JLabel("PM 03:42");
		currTimeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		currTimeLbl.setForeground(Color.WHITE);
		currTimeLbl.setFont(new Font("굴림", Font.BOLD, 19));
		currTimeLbl.setBounds(20, 64, 88, 42);
		panel_1.add(currTimeLbl);
		
		alarmBtn = new JButton("");
		alarmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		alarmBtn.setIcon(new ImageIcon("ateamproject/img/alarm.png"));
		alarmBtn.setBounds(799, 44, 41, 37);
		alarmBtn.setContentAreaFilled(false);
		alarmBtn.setBorder(null);
		alarmBtn.setBorderPainted(false);
		frame.getContentPane().add(alarmBtn);
				
		
		homeBtn = new JButton("");
		homeBtn.setIcon(new ImageIcon("ateamproject/img/home.png"));
		homeBtn.setBounds(237, 44, 41, 37);
		homeBtn.setContentAreaFilled(false);
		homeBtn.setBorder(null);
		homeBtn.setBorderPainted(false);		
		frame.getContentPane().add(homeBtn);
		
		settingBtn = new JButton("");
		settingBtn.setIcon(new ImageIcon("ateamproject/img/setting.png"));
		settingBtn.setContentAreaFilled(false);
		settingBtn.setBorder(null);
		settingBtn.setBorderPainted(false);
		
		

		settingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		settingBtn.setBounds(851, 44, 41, 37);
		frame.getContentPane().add(settingBtn);
		
		prevBtn = new JButton("◀");
		prevBtn.setFont(new Font("굴림", Font.BOLD, 10));
		prevBtn.setBounds(439, 80, 50, 50);
		frame.getContentPane().add(prevBtn);
		prevBtn.addActionListener(this);
		
		nextBtn = new JButton("▶");
		nextBtn.setFont(new Font("굴림", Font.BOLD, 10));
		nextBtn.setBounds(710, 80, 50, 50);
		frame.getContentPane().add(nextBtn);
		nextBtn.addActionListener(this);
		
		monthLbl = new JLabel();
		monthLbl.setFont(new Font("굴림", Font.BOLD, 63));
		monthLbl.setBounds(519, 65, 93, 89);
		frame.getContentPane().add(monthLbl);
		
		yearLbl = new JLabel();
		yearLbl.setFont(new Font("굴림", Font.BOLD, 20));
		yearLbl.setBounds(610, 77, 48, 35);
		frame.getContentPane().add(yearLbl);
		
		engLbl = new JLabel();
		engLbl.setFont(new Font("굴림", Font.BOLD, 18));
		engLbl.setBounds(610, 104, 93, 35);
		frame.getContentPane().add(engLbl);
		
		memberLbl = new JLabel();
		memberLbl.setBounds(600, 11, 200, 23);
		memberLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(memberLbl);
		
		
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("굴림", Font.PLAIN, 10));
		logoutBtn.setBounds(816, 11, 78, 23);
		frame.getContentPane().add(logoutBtn);
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen lscreen = new LoginScreen();
				lscreen.frame.setVisible(true);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj.equals(prevBtn)) {
			//왼쪽 화살표를 클릭하면 날짜가 바뀐다.

			if(monthIdx == 0) {
				monthIdx = 11;
				yearIdx--;
			}else {
				monthIdx--;
			}
			
			setLbl();
			cPanel.cGrid.clearCalGrid();
			cPanel.cGrid.setCalGrid(yearIdx, monthIdx);
			
		}else if(obj==nextBtn) {
			//오른쪽 화살표를 클릭하면 날짜가 바뀐다.;
			
			if(monthIdx == 11) {
				monthIdx = 0;
				yearIdx++;
			}else {
				monthIdx++;
			}
			
			setLbl();
			cPanel.cGrid.clearCalGrid();
			cPanel.cGrid.setCalGrid(yearIdx, monthIdx);
		}
	}
	
	public void setLoginInfo(String mb_id) {
		CalMemberBean bean = mbMgr.getMemberInfo(mb_id);
		
		loginId = mb_id;
		cPanel.loginId = mb_id;
		
		memberLbl.setText( bean.getMb_realname() + "님 환영합니다."); 
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow_Merged window = new MainWindow_Merged();
					window.frame.setVisible(true);
					
//					window.frame.addMouseListener(new MouseAdapter() {
//						public void mouseEntered(MouseEvent e) {
//							System.out.println("예콩이");
//						}
//					});
					
					window.frame.addWindowListener(new WindowAdapter() {
						public void windowActivated(WindowEvent e) {
							window.setLbl();
							window.cPanel.cGrid.clearCalGrid();
							window.cPanel.cGrid.setCalGrid(window.yearIdx, window.monthIdx);
						}
					});
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	@Override
	public void run() {
        while (true) {
        	currDateLbl.setText(sfDate.format(new Date()));
        	currTimeLbl.setText(sfTime.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){}
        }
    }

}

