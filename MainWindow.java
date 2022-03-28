package ateamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainWindow extends JFrame {

	CalSchedMgr mgr = new CalSchedMgr();
	Vector<CalSchedBean> vlist = mgr.listSched();
	
	JFrame frame = new JFrame("Calendar demo");
	
	public MainWindow() {
		super("Calendar demo_super");
		
		System.out.println("=======MainWindow 클래스 실행=======");
//		System.out.println(vlist);
//		CalSchedBean bean = new CalSchedBean();
//		System.out.println(bean.getSc_id());
//		System.out.println(bean.getSc_startdate());
//		System.out.println(bean.getSc_title());
//		System.out.println(bean.getSc_enddate());
//		System.out.println(bean.getSc_content());
//		System.out.println(bean.getSc_isdone());
//		//왜 아무 값도 뜨지 않을까? 뭘 놓친 거지?
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setLayout(new BorderLayout());
		frame.add(new SidePanel(), BorderLayout.WEST);
		frame.add(new CalendarPanel(), BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setVisible(true);

	}
	
	class SidePanel extends Panel{
		SidePanel(){
			
			setBackground(Color.BLUE);

			ToDoList td = new ToDoList();
			DDay dd = new DDay();
			CurrTime ct = new CurrTime();
						
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			panel.setBackground(Color.BLUE);
			panel.add(Box.createRigidArea(new Dimension(0,50)));
			panel.add(ct);
			panel.add(Box.createRigidArea(new Dimension(0,100)));
			panel.add(dd);
			panel.add(Box.createRigidArea(new Dimension(0,100)));
			panel.add(Box.createVerticalGlue());
			panel.add(td);
			panel.add(Box.createRigidArea(new Dimension(0,50)));
			
			add(panel);
			setVisible(true);
		}
	}
	
	
	class CurrTime extends Panel{
		
		JLabel cDate;
		JLabel cTime;
		
		CurrTime(){
			setLayout(new GridLayout(2, 1));
			
			setBackground(Color.PINK);
			
			cDate = new JLabel("2022/03/16");
			cTime = new JLabel("am/10/48");
			
			cDate.setForeground(Color.WHITE);
			cDate.setHorizontalAlignment(JLabel.CENTER);
			
			cTime.setForeground(Color.WHITE);
			cTime.setHorizontalAlignment(JLabel.CENTER);
			
			add(cDate);
			add(cTime);
		}
	}
	
	class DDay extends Panel{
		JLabel ddLbl;
		
		DDay(){
			setLayout(new BorderLayout());
			setBackground(Color.PINK);
			ddLbl = new JLabel("D-Day here");
			ddLbl.setForeground(Color.WHITE);
			ddLbl.setHorizontalAlignment(JLabel.CENTER);
			add(ddLbl, BorderLayout.CENTER);
		}
	}
	
	class ToDoList extends Panel{
		
		JLabel tdLbl;
		JTextArea ta;
		
		ToDoList(){
			setLayout(new BorderLayout());
			tdLbl= new JLabel("ToDo List");
			ta = new JTextArea(7, 20);
			add(tdLbl, BorderLayout.NORTH);
			add(new JScrollPane(ta), BorderLayout.SOUTH);
			
			setBackground(Color.BLACK);
			tdLbl.setForeground(Color.WHITE);
			tdLbl.setHorizontalAlignment(JLabel.CENTER);
			ta.setBackground(Color.WHITE);
		}
	}
	
	public static void main(String[] args) {
		
		


		
		new MainWindow();
		CalMemberBean bean = new CalMemberBean();
		
		Scanner sc = new Scanner(System.in);
		
		
		bean.setMb_id(sc.next());
		bean.setMb_pwd(sc.next());
		bean.setMb_realname(sc.next());
		bean.setMb_joindate(null);
		bean.setMb_email(sc.next());
		bean.setMb_birthdate(null);
	
		System.out.println(bean);
		System.out.println(bean.getMb_id());
		System.out.println(bean.getMb_pwd());
		System.out.println(bean.getMb_realname());
		System.out.println(bean.getMb_email());

	}

}
