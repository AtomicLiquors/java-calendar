package ateamproject;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarPanel extends Panel {
	
	Calendar cal = Calendar.getInstance();
	//버튼을 누르면 다음을 실행한다.
	//달력의 세팅값은 달력 위쪽에 표시되는 날짜와 일치한다.

	
	public CalendarPanel() {
//		
//		cal.add(Calendar.MONTH, 1);
		
		setBackground(Color.WHITE);

		JPanel cPanel = new JPanel();
		cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
		cPanel.setBackground(Color.PINK);

		JLabel tLabel = new JLabel("CalendarPanel Class 영역입니다.");

		cPanel.add(tLabel);

		cPanel.add(new IconBar());
		cPanel.add(new CalendarGrid());
		cPanel.setSize(getPreferredSize());

		add(cPanel);

		setVisible(true);
	}
	
	

	class IconBar extends Panel {
		
		IconBar() {
			
			int month = (cal.get(Calendar.MONTH));
			String year = "" + cal.get(Calendar.YEAR);

			setBackground(Color.PINK);
			setLayout(new FlowLayout());

			ImageIcon homeIcon = new ImageIcon("ateamproject/img/home.png");
			ImageIcon alarmIcon = new ImageIcon("ateamproject/img/alarm.png");
			ImageIcon settingIcon = new ImageIcon("ateamproject/img/setting.png");

			JButton homeBtn = new JButton(homeIcon);
			JButton alarmBtn = new JButton(alarmIcon);
			JButton settingBtn = new JButton(settingIcon);

			// btn.setPressedIcon(var_name);
			// btn.setRolloverIcon(var_name);

			add(homeBtn);
			add(new JLabel(String.format("%02d", month + 1)));
			add(new JLabel(cal.getDisplayName(month, Calendar.LONG, Locale.ENGLISH)));
			add(new JLabel(year));
			add(alarmBtn);
			add(settingBtn);

			setVisible(true);
		}
	}
	
	
	
	
	class CalendarGrid extends Panel {
	
		CalendarGrid() {
			setCalGrid();
		}
		
		public void refCal() {
			cal.set(Calendar.MONTH, 0);
			setCalGrid();
		}
		

		public void setCalGrid() {
			ArrayList<Integer> calArr = new ArrayList<>();
			ArrayList<Integer> prevArr = new ArrayList<>();
			ArrayList<Integer> nextArr = new ArrayList<>();
					
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int date = cal.get(Calendar.DATE);
			int lastDay = cal.getActualMaximum(Calendar.DATE);

			/** 이번 달 날짜를 배열에 추가 **/
			for (int i = 0; i < lastDay; i++) {
				calArr.add(i + 1);
			}
			
			/** 지난 달 날짜를 배열에 추가 **/
			cal.set(Calendar.DATE, 1);
			int weekday = cal.get(Calendar.DAY_OF_WEEK);
			int numOfPreMonth = weekday - 1;
			cal.add(Calendar.MONTH, -1);
			lastDay = cal.getActualMaximum(Calendar.DATE);
			for (int i = 0; i < numOfPreMonth; i++) {
				calArr.add(0, lastDay);
				prevArr.add(0);
				lastDay--;
			}

			/** 다음 달 날짜를 배열에 추가 **/
			cal.add(Calendar.MONTH, 1);
			lastDay = cal.getActualMaximum(Calendar.DATE);
			cal.set(Calendar.DATE, lastDay);
			weekday = cal.get(Calendar.DAY_OF_WEEK);

			int numOfNextMonth = 7 - weekday;
			for (int i = 0; i < numOfNextMonth; i++) {
				calArr.add(i + 1);
				nextArr.add(0);
			}

			/** 프레임으로 구현 **/
			GridLayout gridLayout = new GridLayout( (calArr.size() / 7) + 1, 7);
			setLayout(gridLayout);
			
			String[] weekName = { "SUN", "MON", "TUE", "WEN", "THU", "FRI", "SUN" };		
			
			for(int i = 0; i < 7; i++) {
				JLabel weekLbl = new JLabel(weekName[i]);
				weekLbl.setOpaque(true);
				weekLbl.setBackground(Color.WHITE);
				weekLbl.setHorizontalAlignment(JLabel.CENTER);
				add(weekLbl);
			}
			

			for (int i = 0; i < calArr.size(); i++) {
				Button tempBtn = new Button(calArr.get(i) + "");
				if (i % 7 == 0) {
					tempBtn.setForeground(Color.RED);
				} else if (i % 7 == 6) {
					tempBtn.setForeground(Color.BLUE);
				}
				
				if (i < prevArr.size() || i >= calArr.size() - nextArr.size() )
					tempBtn.setEnabled(false);
				
				add(tempBtn);
			}
		}

	}

}
