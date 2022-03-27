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

public class MainWindow_Designed {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow_Designed window = new MainWindow_Designed();
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
	public MainWindow_Designed() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(237, 176, 655, 390);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btnNewButton_7 = new JButton("1");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("2");
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("3");
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("4");
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("5");
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("6");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_12);
	
		JButton btnNewButton_13 = new JButton("7");
		panel.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("8");
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("9");
		panel.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("10");
		panel.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("11");
		panel.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("12");
		panel.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("13");
		panel.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("14");
		panel.add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("15");
		panel.add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("16");
		panel.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("17");
		panel.add(btnNewButton_23);
		
		JButton btnNewButton_24 = new JButton("18");
		panel.add(btnNewButton_24);
		
		JButton btnNewButton_25 = new JButton("19");
		panel.add(btnNewButton_25);
		
		JButton btnNewButton_26 = new JButton("20");
		panel.add(btnNewButton_26);
		
		JButton btnNewButton_27 = new JButton("21");
		panel.add(btnNewButton_27);
		
		JButton btnNewButton_28 = new JButton("22");
		panel.add(btnNewButton_28);
		
		JButton btnNewButton_29 = new JButton("23");
		panel.add(btnNewButton_29);
		
		JButton btnNewButton_30 = new JButton("24");
		panel.add(btnNewButton_30);
		
		JButton btnNewButton_31 = new JButton("25");
		panel.add(btnNewButton_31);
		
		JButton btnNewButton_32 = new JButton("26");
		panel.add(btnNewButton_32);
		
		JButton btnNewButton_33 = new JButton("27");
		panel.add(btnNewButton_33);
		
		JButton btnNewButton_34 = new JButton("28");
		panel.add(btnNewButton_34);
		
		JButton btnNewButton_35 = new JButton("29");
		panel.add(btnNewButton_35);
		
		JButton btnNewButton_36 = new JButton("30");
		panel.add(btnNewButton_36);
		
		JButton btnNewButton_37 = new JButton("31");
		panel.add(btnNewButton_37);
		
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
		lblNewLabel_7.setBounds(519, 65, 93, 89);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("2021");
		lblNewLabel_7_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_7_1.setBounds(610, 77, 48, 35);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("AUGUST");
		lblNewLabel_7_1_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_7_1_1.setBounds(610, 104, 93, 35);
		frame.getContentPane().add(lblNewLabel_7_1_1);
		
		JButton btnNewButton = new JButton("로그아웃");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton.setBounds(816, 11, 78, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
