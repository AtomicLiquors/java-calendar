package ateamproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarPanel extends Panel {


	public CalendarPanel() {
		setBackground(Color.WHITE);
		
		JPanel cPanel = new JPanel();
		cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
		cPanel.setBackground(Color.PINK);
		
		JLabel tLabel = new JLabel("CalendarPanel Class 영역입니다.");

		cPanel.add(tLabel);
		
		cPanel.add(new IconBar());
		cPanel.add(new WeekdayBar());
		cPanel.add(new CalendarGrid());
		cPanel.setSize(getPreferredSize());
		
		add(cPanel);
		
		setVisible(true);
	}
	

	class IconBar extends Panel {
		
		IconBar() {
			setBackground(Color.PINK);
			setLayout(new FlowLayout());
			
			ImageIcon homeIcon = 
					new ImageIcon("ateamproject/img/home.png");
			ImageIcon alarmIcon = 
					new ImageIcon("ateamproject/img/alarm.png");
			ImageIcon settingIcon = 
					new ImageIcon("ateamproject/img/setting.png");

			JButton homeBtn = new JButton(homeIcon);
			JButton alarmBtn = new JButton(alarmIcon);
			JButton settingBtn = new JButton(settingIcon);
			
			
			//btn.setPressedIcon(var_name);
			//btn.setRolloverIcon(var_name);
			
			add(homeBtn);
			add(new JLabel("08"));
			add(alarmBtn);
			add(settingBtn);
			
			setVisible(true);
			
			
			

		}
	}
	
	class WeekdayBar extends Panel {

		WeekdayBar() {
			setBackground(Color.WHITE);
			setLayout(new GridLayout(1, 7));
			JLabel sun = new JLabel("SUN");
			JLabel sat = new JLabel("SAT");
			
			sun.setForeground(Color.RED);
			sat.setForeground(Color.BLUE);
			
			add(sun);
			add(new JLabel("MON"));
			add(new JLabel("TUE"));
			add(new JLabel("WEN"));
			add(new JLabel("THU"));
			add(new JLabel("FRI"));
			add(sat);
		}

	}

}
