package ateamproject;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormatSymbols;



public class CalendarPanel extends Panel {
	
	Calendar cal = Calendar.getInstance();
	CalendarGrid cGrid = new CalendarGrid();

	
	public CalendarPanel() {
		//버튼을 누르면 다음을 실행한다.
		//달력의 세팅값은 달력 위쪽에 표시되는 날짜와 일치한다.
		
		setBackground(Color.WHITE);

		JPanel cPanel = new JPanel();
		cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
		cPanel.setBackground(Color.PINK);

		JLabel tLabel = new JLabel("CalendarPanel Class 영역입니다.");

		cPanel.add(tLabel);
		
		cPanel.add(new IconBar());
		cPanel.add(cGrid);
		cPanel.setSize(getPreferredSize());

		add(cPanel);

		setVisible(true);
	}
	
	

	public class IconBar extends Panel implements ActionListener {
		
		
		//3개가 전부 캘린터에서 받아오고, 버튼들이 캘린더를 조작해야 한다.
		//또는 3개가 전부 monthIdx에서 받아오고, 버튼들이 monthIdx를 조작해야 한다.
		int monthIdx = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		String[] engMonths = new DateFormatSymbols(Locale.US).getMonths();
		
		ImageIcon homeIcon = new ImageIcon("ateamproject/img/home.png");
		ImageIcon alarmIcon = new ImageIcon("ateamproject/img/alarm.png");
		ImageIcon settingIcon = new ImageIcon("ateamproject/img/setting.png");
		
		JButton prevBtn = new JButton("◀");
		JButton nextBtn = new JButton("▶");
		

		JButton homeBtn = new JButton(homeIcon);
		JButton alarmBtn = new JButton(alarmIcon);
		JButton settingBtn = new JButton(settingIcon);

		// btn.setPressedIcon(var_name);
		// btn.setRolloverIcon(var_name);
		
		JLabel monthLbl = new JLabel(String.format("%02d", monthIdx + 1));
		JLabel engLbl = new JLabel(engMonths[monthIdx]);
		JLabel yearLbl = new JLabel("" + year);
		
		IconBar() {
			
			setBackground(Color.PINK);
			setLayout(new FlowLayout());

			add(homeBtn);
			add(prevBtn);
			add(monthLbl);
			add(engLbl);	
			add(yearLbl);
			add(nextBtn);
			add(alarmBtn);
			add(settingBtn);
			
			prevBtn.addActionListener(this);
			nextBtn.addActionListener(this);

			setVisible(true);
		}
		
		
		public void setLbl(){
			monthLbl.setText(String.format("%02d", monthIdx + 1));
			engLbl.setText(engMonths[monthIdx]);
			yearLbl.setText("" + year);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object obj = e.getSource();
			
			if(obj.equals(prevBtn)) {
				//왼쪽 화살표를 클릭하면 날짜가 바뀐다.
				
				if(monthIdx == 0) {
					monthIdx = 11;
					year--;
				}else {
					monthIdx--;
				}
				
				setLbl();
				cGrid.setCalGrid();
				
			}else if(obj==nextBtn) {
				//오른쪽 화살표를 클릭하면 날짜가 바뀐다.
				
				if(monthIdx == 11) {
					monthIdx = 0;
					year++;
				}else {
					monthIdx++;
				}
				
				setLbl();
			}
			
		}
	}
	
	
	
	
	public class CalendarGrid extends Panel {
		
		//GridLayout의 특정 항목을 지우는 방법이 필요하다. 
		
		//최초 실행 시 생성자에서 날짜를 입력하고, SetCalGrid를 실행한다. 
		//setCalGrid를 실행했을 때는 날짜만 지우고, 날짜만 다시 쓴다.
		
	
		CalendarGrid() {
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
