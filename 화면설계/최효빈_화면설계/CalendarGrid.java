package ateamproject;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Calendar;

public class CalendarGrid extends Panel {
	
	CalendarGrid(){
		ArrayList<Integer> calArr = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		/** 이번 달 세팅 **/
		for (int i = 0; i < lastDay; i++) {
			calArr.add(i + 1);
		}
		
		/** 지난 달 세팅 완료 **/
		cal.set(Calendar.DATE, 1);
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		int numOfPreMonth = weekday - 1;
		cal.add(Calendar.MONTH, -1);
		lastDay = cal.getActualMaximum(Calendar.DATE);
		for(int i = 0; i < numOfPreMonth; i++) {
			calArr.add(0, lastDay);
			lastDay--;
		}
		
		/**다음 달 세팅**/
		cal.add(Calendar.MONTH, 1);
		lastDay = cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE, lastDay);
		weekday = cal.get(Calendar.DAY_OF_WEEK);
		
		int numOfNextMonth = 7 - weekday;
		for (int i = 0; i < numOfNextMonth; i++) {
			calArr.add(i + 1);
		}
		
		/**프레임으로 구현**/
		GridLayout gridLayout = new GridLayout(calArr.size() / 7, 7);
		setLayout(gridLayout);
		
		for(int i = 0; i < calArr.size(); i++) {
			Button tempBtn = new Button(calArr.get(i) + "");
			if (i % 7 == 0) {
				tempBtn.setForeground(Color.RED);
			} else if(i % 7 == 6) {
				tempBtn.setForeground(Color.BLUE);
			}
			add(tempBtn);
		}
		
	}
	
	
	
}
