package ateamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainWindow extends JFrame {
	
	JFrame frame = new JFrame("Calendar demo");
	
	public MainWindow() {
		super("Calendar demo_super");
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
	}

}
