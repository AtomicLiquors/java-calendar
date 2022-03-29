package ateamproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ateamproject.CalendarPanel_Merged;

public class MainWindow_Merged implements ActionListener{
	Calendar cal = Calendar.getInstance();
	CalendarPanel_Merged cmg = new CalendarPanel_Merged();
	
	int yearIdx = cal.get(Calendar.YEAR);
	int monthIdx = cal.get(Calendar.MONTH);
	String[] engMonths = new DateFormatSymbols(Locale.US).getMonths();
	
	public JFrame frame;
	
	JLabel monthLbl;
	JLabel yearLbl;
	JLabel engLbl; 
	
	JButton alarmBtn;
	JButton homeBtn;
	JButton settingBtn;
	JButton prevBtn;
	JButton nextBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow_Merged window = new MainWindow_Merged();
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
	public MainWindow_Merged() {
		initialize();
		cmg.cGrid.setCalGrid(yearIdx, monthIdx);
		setLbl();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void setLbl(){
		monthLbl.setText(String.format("%02d", monthIdx + 1));
		engLbl.setText(engMonths[monthIdx]);
		yearLbl.setText("" + yearIdx);
		cmg.setDate(yearIdx, monthIdx);

	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setLocation(-82, -107);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 950, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel calPanel = new JPanel();
		calPanel.setBounds(237, 176, 665, 385);
		frame.getContentPane().add(calPanel);
		
		
		
		calPanel.add(cmg);
		
		JLabel lblNewLabel = new JLabel("일");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(237, 139, 93, 37);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setToolTipText("");
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("월");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(331, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("화");
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setBounds(425, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("수");
		lblNewLabel_1_2.setToolTipText("");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setBounds(519, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("목");
		lblNewLabel_1_3.setToolTipText("");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setBounds(610, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("금");
		lblNewLabel_1_4.setToolTipText("");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setBounds(705, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("토");
		lblNewLabel_1_5.setToolTipText("");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setForeground(Color.BLUE);
		lblNewLabel_1_5.setBounds(799, 139, 93, 37);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
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
		tdLbl.setFont(new Font("굴림", Font.PLAIN, 25));
		panel_2.add(tdLbl);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(32, 276, 133, 287);
		panel_1.add(panel_3);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setForeground(new Color(0, 0, 204));
		panel_4_1.setBackground(new Color(0, 51, 153));
		panel_4_1.setBounds(123, 120, 38, 50);
		panel_1.add(panel_4_1);
		panel_4_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("7");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 38, 50);
		panel_4_1.add(lblNewLabel_3);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setForeground(new Color(0, 0, 204));
		panel_4_1_1.setBackground(new Color(0, 51, 153));
		panel_4_1_1.setBounds(32, 120, 38, 50);
		panel_1.add(panel_4_1_1);
		panel_4_1_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("D");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 38, 50);
		panel_4_1_1.add(lblNewLabel_4);
		
		JPanel panel_4_1_2 = new JPanel();
		panel_4_1_2.setBackground(new Color(0, 51, 153));
		panel_4_1_2.setBounds(82, 120, 38, 50);
		panel_1.add(panel_4_1_2);
		panel_4_1_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("0");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 38, 50);
		panel_4_1_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("2022-03-15");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 19));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(25, 36, 131, 42);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("PM 03:42");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("굴림", Font.BOLD, 19));
		lblNewLabel_6_1.setBounds(33, 64, 88, 42);
		panel_1.add(lblNewLabel_6_1);
		
		alarmBtn = new JButton("");
		alarmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		alarmBtn.setIcon(new ImageIcon("ateamproject/img/alarm.png"));
		alarmBtn.setBounds(799, 44, 41, 37);
		frame.getContentPane().add(alarmBtn);
		
		
		
		
		homeBtn = new JButton("");
		homeBtn.setIcon(new ImageIcon("ateamproject/img/home.png"));
		homeBtn.setBounds(237, 44, 41, 37);
		frame.getContentPane().add(homeBtn);
		
		settingBtn = new JButton("");
		settingBtn.setIcon(new ImageIcon("ateamproject/img/setting.png"));
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
		
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("굴림", Font.PLAIN, 10));
		logoutBtn.setBounds(816, 11, 78, 23);
		frame.getContentPane().add(logoutBtn);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj.equals(prevBtn)) {
			//왼쪽 화살표를 클릭하면 날짜가 바뀐다.
			System.out.println("prevBtn");
			
			if(monthIdx == 0) {
				monthIdx = 11;
				yearIdx--;
			}else {
				monthIdx--;
			}
			
			setLbl();
			cmg.cGrid.clearCalGrid();
			cmg.cGrid.setCalGrid(yearIdx, monthIdx);
			
		}else if(obj==nextBtn) {
			//오른쪽 화살표를 클릭하면 날짜가 바뀐다.
			System.out.println("nextBtn");
			
			if(monthIdx == 11) {
				monthIdx = 0;
				yearIdx++;
			}else {
				monthIdx++;
			}
			
			setLbl();
			cmg.cGrid.clearCalGrid();
			cmg.cGrid.setCalGrid(yearIdx, monthIdx);
		}
		
	}

	
}
