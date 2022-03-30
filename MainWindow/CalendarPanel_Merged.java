package ateamproject.MainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ateamproject.Data.CalSchedBean;
import ateamproject.Data.CalSchedMgr;
import ateamproject.SchPopup.Ppop;



public class CalendarPanel_Merged extends Panel{
	
	Calendar cal = Calendar.getInstance();
	CalendarGrid cGrid = new CalendarGrid();
	
	CalSchedMgr mgr = new CalSchedMgr(); 

	String[] engMonths = new DateFormatSymbols(Locale.US).getMonths();
	
	
	
	JButton calBtn;
	
	int panelY = cal.get(Calendar.YEAR);;
	int panelM = cal.get(Calendar.MONTH);


	public void setDate(int y, int m) {
		panelY = y;
		panelM = m;
	}
	
	public CalendarPanel_Merged() {		
		
		JPanel cPanel = new JPanel();
		cPanel.setOpaque(false);
		cPanel.add(cGrid);

		add(cPanel);

		setVisible(true);
	}
	
	
	public class CalendarGrid extends Panel implements ActionListener {
		
		//최초 실행 시 생성자에서 날짜를 입력하고, SetCalGrid를 실행한다. 
		//setCalGrid를 실행했을 때는 날짜만 지우고, 날짜만 다시 쓴다.
		
		ArrayList<Integer> calArr = new ArrayList<>();
		ArrayList<Integer> prevArr = new ArrayList<>();
		ArrayList<Integer> nextArr = new ArrayList<>();
				

		int lastDay; 
		
		GridLayout gridLayout = new GridLayout(7, 7);
		//달력을 넣기 위한 7 * 7 짜리 그리드를 만들어준다.
		//단, 행 수인 7은 임시로 넣은 값이고 나중에 setCalGrid()에 의해 수시로 변한다.
	
		CalendarGrid() {	
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
			//System.out.println("달력 지우기 완료");
		}

		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String btnTxt = "";
			
			Object obj = e.getSource();
			if (obj instanceof JButton) {
				JButton tempBtn = (JButton)obj;
		        btnTxt = tempBtn.getText();
			}
			//System.out.println(btnTxt+" clicked");
			Ppop pop = new Ppop("" + panelY, "" + (panelM + 1), btnTxt);

			pop.setVisible(true);
			
			
		}



		public void setCalGrid(int y, int m) {

			Calendar locCal = Calendar.getInstance();
			//System.out.println("locCal 설정 시작 : yearidx, monthidx = " + y +", " + m);
			
			locCal.set(y, m, 1);
			lastDay = locCal.getActualMaximum(Calendar.DATE);

			
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
				
				
				Boolean isOuttaBound = (i < prevArr.size() || i >= calArr.size() - nextArr.size() );
				
				if (isOuttaBound)
					calBtn.setEnabled(false);
				
				calBtn.setPreferredSize(new Dimension(95, 385 / (calArr.size()/7) ));
				calBtn.setHorizontalAlignment(SwingConstants.LEFT);
				calBtn.setVerticalAlignment(SwingConstants.TOP);
				calBtn.addActionListener(this);
				
				
				String btnDate = panelY + "-" + (panelM + 1) + "-" + calArr.get(i);;
				

				if(i < prevArr.size()) {
					if(panelM==0) {
						panelY = panelY - 1;
						panelM = 12;
					}
					btnDate = panelY + "-" + (panelM) + "-" + calArr.get(i);
				}else if(i >= calArr.size() - nextArr.size()) {
					if(panelM==11) {
						panelY = panelY + 1;
						panelM = 1;
					}
					btnDate = panelY + "-" + (panelM + 2) + "-" + calArr.get(i);
				}
					
//				System.out.println(panelY);
//				System.out.println(panelM);
//				System.out.println(calArr.get(i));
				

				CalSchedBean sbean = mgr.getSched(btnDate);
				Boolean isSchedFound = (sbean.getSc_id()!=0);
				
				if(isSchedFound) {
					if (isOuttaBound)
						calBtn.setBackground(Color.GRAY);
					else
						calBtn.setBackground(Color.decode("#0078D7"));
				}
				add(calBtn);
				
				//if( DB를 조회해서 panelY, panelM, i와 일치하는 날짜에 데이터가 있을 경우)
				//일정 표기할 객체.setVisible(true);
			}
			
			
			calArr.removeAll(calArr);
			prevArr.removeAll(prevArr);
			nextArr.removeAll(nextArr);
			//System.out.println("달력 세팅 완료\n");
						
			validate();
			repaint();
		}
		
	}

	

}
