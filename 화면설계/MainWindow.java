package ateamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainWindow extends JFrame {
	
	//GridLayout으로 달력 구현?
	JFrame frame = new JFrame("BorderLayout demo");
	
	public MainWindow() {
		super("JLabel 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setLayout(new BorderLayout());
		frame.add(new SidePanel(), BorderLayout.WEST);
		/*
		Container bg = getContentPane();
		bg.setLayout(new FlowLayout());
		
		JLabel tLabel = new JLabel("이콩이");
		JLabel Label = new JLabel("이콩이콩이");
		
		bg.add(tLabel);
		bg.add(Label);
		*/


		
		
		frame.setSize(800, 600);
		frame.setVisible(true);
		
	}
	
	class SidePanel extends Panel{
		
		SidePanel(){
			setBackground(Color.BLUE);
			setLayout(new BorderLayout());
			
			ToDoList td = new ToDoList();
			DDay dd = new DDay();
			CurrTime ct = new CurrTime();
			
			add(ct, BorderLayout.NORTH);
			add(dd, BorderLayout.CENTER);
			add(td, BorderLayout.SOUTH);
			
			
			setVisible(true);
			
		}
	}
	
	
	class CurrTime extends Panel{
		
		JLabel cdate;
		JLabel ctime;
		
		CurrTime(){
			setLayout(new BorderLayout());
			
			cdate = new JLabel("2022/03/16");
			ctime = new JLabel("am/10/48");
			
			cdate.setForeground(Color.WHITE);
			ctime.setForeground(Color.WHITE);
			
			add(cdate, BorderLayout.NORTH);
			add(ctime, BorderLayout.SOUTH);

		}
	}
	
	class DDay extends Panel{
		JLabel ddlbl;
		
		DDay(){
			setLayout(new BorderLayout());
			ddlbl = new JLabel("D-Day here");
			ddlbl.setForeground(Color.WHITE);
			add(ddlbl, BorderLayout.CENTER);
			
		}
	}
	
	class ToDoList extends Panel{
		
		JLabel tdlbl;
		JTextArea ta;
		
		ToDoList(){
			setLayout(new BorderLayout());
			tdlbl= new JLabel("ToDo List");
			ta = new JTextArea(7, 20);
			add(tdlbl, BorderLayout.NORTH);
			add(new JScrollPane(ta), BorderLayout.SOUTH);
			
			setBackground(Color.BLACK);
			tdlbl.setForeground(Color.WHITE);
			ta.setBackground(Color.WHITE);
			
		}
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}

}
