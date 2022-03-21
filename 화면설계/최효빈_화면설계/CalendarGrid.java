package ateamproject;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;

public class CalendarGrid extends Panel {
	
	
	Calendar cal = Calendar.getInstance();
	
	//버튼을 누르면 다음을 실행한다.
	//cal.set(Calendar.MONTH, (현재 달 -1) +-1);
	
	
	CalendarGrid() {
		
		System.out.println(cal);
		setCal();
	}

	public void setCal() {
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
