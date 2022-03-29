package ateamproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.*;



public class CalendarPanel_Merged extends Panel {
	
	Calendar cal = Calendar.getInstance();
	CalendarGrid cGrid = new CalendarGrid();
	
	int yearIdx;
	int monthIdx;
	String[] engMonths = new DateFormatSymbols(Locale.US).getMonths();

	
	
	JButton calBtn;

	
	public CalendarPanel_Merged() {		

		JPanel cPanel = new JPanel();
		cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
		cPanel.add(cGrid);
		cPanel.setSize(getPreferredSize());

		add(cPanel);

		setVisible(true);
	}
	
	


	
	public void decMonth(int m, int y) {
		//상위 클래스에서 m, y값을 변경한다.
		//하위 클래스에서 m, y값을 받아와 함수를 실행한다. 
		
		//
	}

	
	public class CalendarGrid extends Panel implements ActionListener {
		
		//GridLayout의 특정 항목을 지우는 방법이 필요하다. 
		
		//최초 실행 시 생성자에서 날짜를 입력하고, SetCalGrid를 실행한다. 
		//setCalGrid를 실행했을 때는 날짜만 지우고, 날짜만 다시 쓴다.
		
		//Grid의 행 열 수를 새롭게 지정할 수 있나?
		
		ArrayList<Integer> calArr = new ArrayList<>();
		ArrayList<Integer> prevArr = new ArrayList<>();
		ArrayList<Integer> nextArr = new ArrayList<>();
				

		int lastDay; 
		
		String[] weekName = { "SUN", "MON", "TUE", "WEN", "THU", "FRI", "SUN" };		
		GridLayout gridLayout = new GridLayout(7, 7);
		//달력을 넣기 위한 7 * 7 짜리 그리드를 만들어준다.
		//단, 행 수인 7은 임시로 넣은 값이고 나중에 setCalGrid()에 의해 수시로 변한다.
	
		CalendarGrid() {
			//달력의 크기를 설정해 준다.	
			setLayout(gridLayout);		
		}
		

		public void clearCalGrid() {
			//기존 달력을 지워야 한다.
			int count = cGrid.getComponentCount();
			for (int i = 0; i < count; i++) {
				remove(0);
			}
			validate();
			repaint();
			System.out.println("달력 지우기 완료");
		}
		


		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(e.getActionCommand()+" clicked");
			//tempBtn.getText
		}



		public void setCalGrid(int y, int m) {

			System.out.println("달력 세팅 시작");
			
			Calendar locCal = Calendar.getInstance();
			System.out.println("locCal 설정 시작 : yearidx, monthidx = " + y +", " + m);
			
			locCal.set(y, m, 1);
			lastDay = locCal.getActualMaximum(Calendar.DATE);
			//System.out.println("lastDay = " + lastDay);
	

			
			/** 이번 달 날짜를 배열에 추가 **/
			for (int i = 0; i < lastDay; i++) {
				calArr.add(i + 1);
			}
			
			/** 지난 달 날짜를 배열에 추가 **/
			locCal.set(Calendar.DATE, 1);
			int weekday = locCal.get(Calendar.DAY_OF_WEEK);
			int numOfPreMonth = weekday - 1;
			//System.out.println("numOfPreMonth = "+numOfPreMonth);
			
			locCal.add(Calendar.MONTH, -1);
			lastDay = locCal.getActualMaximum(Calendar.DATE);
			
			for (int i = 0; i < numOfPreMonth; i++) {
				calArr.add(0, lastDay);
				prevArr.add(0);
				lastDay--;
			}
			

			/** 다음 달 날짜를 배열에 추가 **/
			locCal.add(Calendar.MONTH, 1);
			lastDay = locCal.getActualMaximum(Calendar.DATE);
			locCal.set(Calendar.DATE, lastDay);
			weekday = locCal.get(Calendar.DAY_OF_WEEK);

			int numOfNextMonth = 7 - weekday;
			for (int i = 0; i < numOfNextMonth; i++) {
				calArr.add(i + 1);
				nextArr.add(0);
			}
			

			/** 프레임으로 구현 **/
			
			gridLayout.setRows( ( calArr.size() / 7 ) );
			//배열의 크기만큼 gridLayout의 행 수를 조절한다.
			
			
//			System.out.println("이전 달 크기: " + prevArr.size());
//			System.out.println("전체 달 크기: " + calArr.size());
//			System.out.println("다음 달 크기: " + nextArr.size());
//			

			for (int i = 0; i < calArr.size(); i++) {
				calBtn = new JButton(calArr.get(i) + "");
				if (i % 7 == 0) {
					calBtn.setForeground(Color.RED);
				} else if (i % 7 == 6) {
					calBtn.setForeground(Color.BLUE);
				}
				
				if (i < prevArr.size() || i >= calArr.size() - nextArr.size() )
					calBtn.setEnabled(false);
				calBtn.setPreferredSize(new Dimension(95, 75));
				calBtn.setActionCommand(""+ (i-1));
				calBtn.addActionListener(this);
				add(calBtn);
			}
			
			
			calArr.removeAll(calArr);
			prevArr.removeAll(prevArr);
			nextArr.removeAll(nextArr);
//			System.out.println("달력 세팅 완료\n");
						
			validate();
			repaint();
		}

		
	}




	

}
