package ateamproject;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
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
	CalendarGrid cGrid = new CalendarGrid();
	
	
	int yearIdx;
	int monthIdx;
	
	String[] engMonths = new DateFormatSymbols(Locale.US).getMonths();
	
	Button calBtn;

	
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
		JLabel yearLbl = new JLabel("" + yearIdx);
		
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
			yearLbl.setText("" + yearIdx);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object obj = e.getSource();
			
			if(obj.equals(prevBtn)) {
				//왼쪽 화살표를 클릭하면 날짜가 바뀐다.
				
				if(monthIdx == 0) {
					monthIdx = 11;
					yearIdx--;
				}else {
					monthIdx--;
				}
				
				setLbl();
				cGrid.clearCalGrid();
				cGrid.setCalGrid();
				
			}else if(obj==nextBtn) {
				//오른쪽 화살표를 클릭하면 날짜가 바뀐다.
				
				if(monthIdx == 11) {
					monthIdx = 0;
					yearIdx++;
				}else {
					monthIdx++;
				}
				
				setLbl();
				cGrid.clearCalGrid();
				cGrid.setCalGrid();
			}
			
		}
	}
	
	
	
	
	public class CalendarGrid extends Panel implements ActionListener {
		
		//GridLayout의 특정 항목을 지우는 방법이 필요하다. 
		
		//최초 실행 시 생성자에서 날짜를 입력하고, SetCalGrid를 실행한다. 
		//setCalGrid를 실행했을 때는 날짜만 지우고, 날짜만 다시 쓴다.
		
		//Grid의 행 열 수를 새롭게 지정할 수 있나?
		
		ArrayList<Integer> calArr = new ArrayList<>();
		ArrayList<Integer> prevArr = new ArrayList<>();
		ArrayList<Integer> nextArr = new ArrayList<>();
				
//		int year = cal.get(Calendar.YEAR);
//		int month = cal.get(Calendar.MONTH);
//		int date = cal.get(Calendar.DATE);
		int lastDay; 
		
		
		
		String[] weekName = { "SUN", "MON", "TUE", "WEN", "THU", "FRI", "SUN" };		
		GridLayout gridLayout = new GridLayout(7, 7);
		//달력을 넣기 위한 7 * 7 짜리 그리드를 만들어준다.
		//단, 행 수인 7은 임시로 넣은 값이고 나중에 setCalGrid()에 의해 수시로 변한다.
	
		CalendarGrid() {
			//달력의 크기를 설정해 준다.	
			setLayout(gridLayout);
			
			yearIdx = cal.get(Calendar.YEAR);
			monthIdx = cal.get(Calendar.MONTH);
			
			setCalGrid();
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
		
		
		
		public void setCalGrid() {
			System.out.println("달력 세팅 시작");
			//배열 초기화를 안 했나? 배열이 수상하니 배열을 들여다봅시다.
			//배열 선언부를 여기로 끌고와야 되나? 아니면 setCalGrid 실행 전에?
			//배열에 들어갈 항목 또한 변수값과 연동되게.
			
			Calendar locCal = Calendar.getInstance();
			//System.out.println("locCal 설정 시작 : yearidx, monthidx = " + yearIdx +", " + monthIdx);
			
			locCal.set(yearIdx, monthIdx, 1);
			lastDay = locCal.getActualMaximum(Calendar.DATE);
			//System.out.println("lastDay = " + lastDay);
	
			
			/** 요일 라벨을 추가 **/
			for(int i = 0; i < 7; i++) {
				JLabel weekLbl = new JLabel(weekName[i]);
				weekLbl.setOpaque(true);
				weekLbl.setBackground(Color.WHITE);
				weekLbl.setHorizontalAlignment(JLabel.CENTER);
				add(weekLbl);
			}
			
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
			
			gridLayout.setRows( ( calArr.size() / 7 ) + 1 );
			//배열의 크기만큼 gridLayout의 행 수를 조절한다.
			
			
//			System.out.println("이전 달 크기: " + prevArr.size());
//			System.out.println("전체 달 크기: " + calArr.size());
//			System.out.println("다음 달 크기: " + nextArr.size());
//			

			for (int i = 0; i < calArr.size(); i++) {
				calBtn = new Button(calArr.get(i) + "");
				if (i % 7 == 0) {
					calBtn.setForeground(Color.RED);
				} else if (i % 7 == 6) {
					calBtn.setForeground(Color.BLUE);
				}
				
				if (i < prevArr.size() || i >= calArr.size() - nextArr.size() )
					calBtn.setEnabled(false);
				calBtn.setActionCommand(""+i);
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



		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(e.getActionCommand()+" clicked");
			
			
				
			//tempBtn.getText
		}

		
	}




	

}
