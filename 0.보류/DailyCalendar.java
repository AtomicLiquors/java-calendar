package ateamproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.Choice;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import java.awt.Label;

public class DailyCalendar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DailyCalendar window = new DailyCalendar();
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
	public DailyCalendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setLocation(-82, -107);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 950, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("To-Do list");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 133, 42);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 25));
		panel_2.add(lblNewLabel_2);
		
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
		
		JButton btnAlarm = new JButton("");
		btnAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlarm.setIcon(new ImageIcon("ateamproject/img/alarm.png"));
		btnAlarm.setBounds(799, 44, 41, 37);
		frame.getContentPane().add(btnAlarm);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("ateamproject/img/home.png"));
		btnNewButton_1_1.setBounds(237, 44, 41, 37);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnAlarm_1 = new JButton("");
		btnAlarm_1.setIcon(new ImageIcon("ateamproject/img/setting.png"));
		btnAlarm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlarm_1.setBounds(851, 44, 41, 37);
		frame.getContentPane().add(btnAlarm_1);
		
		JLabel lblNewLabel_7 = new JLabel("08");
		lblNewLabel_7.setFont(new Font("굴림", Font.BOLD, 63));
		lblNewLabel_7.setBounds(523, 65, 93, 89);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("2021");
		lblNewLabel_7_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_7_1.setBounds(614, 77, 48, 35);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("AUGUST");
		lblNewLabel_7_1_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_7_1_1.setBounds(614, 104, 93, 35);
		frame.getContentPane().add(lblNewLabel_7_1_1);
		
		JButton btnNewButton = new JButton("로그아웃");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton.setBounds(816, 11, 78, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7_2 = new JLabel("mon");
		lblNewLabel_7_2.setFont(new Font("굴림", Font.BOLD, 45));
		lblNewLabel_7_2.setBounds(523, 136, 120, 53);
		frame.getContentPane().add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("28");
		lblNewLabel_7_3.setFont(new Font("굴림", Font.BOLD, 80));
		lblNewLabel_7_3.setBounds(519, 220, 120, 105);
		frame.getContentPane().add(lblNewLabel_7_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(SystemColor.textHighlight);
		panel_3_1.setBounds(422, 325, 308, 234);
		frame.getContentPane().add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("일정제목");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(35, 33, 107, 46);
		panel_3_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("일정세부내용");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(37, 71, 103, 30);
		panel_3_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_8 = new JLabel("[더보기]");
		lblNewLabel_8.setForeground(SystemColor.text);
		lblNewLabel_8.setBounds(32, 145, 52, 15);
		panel_3_1.add(lblNewLabel_8);
		
		JButton btnNewButton_1_2 = new JButton(">");
		btnNewButton_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1_2.setBounds(630, 237, 41, 53);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("<");
		btnNewButton_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1_2_1.setBounds(466, 237, 41, 53);
		frame.getContentPane().add(btnNewButton_1_2_1);
	}
}
