package ateamproject;

import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JLabel;

public class CalendarPanel extends Panel{

	
	CalendarPanel(){
		
		setLayout(new FlowLayout());

		JLabel tLabel = new JLabel("CalendarPanel Class 영역입니다.");
		
		add(tLabel);
		
		add(new CalendarGrid());
	}
	
	
	
}
