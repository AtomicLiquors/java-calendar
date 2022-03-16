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
	
	//GridLayout���� �޷� ����?
	JFrame frame = new JFrame("BorderLayout demo");
	
	public MainWindow() {
		super("JLabel ����");
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
			panel.add(Box.createRigidArea(new Dimension(0,50)));
			panel.add(dd);
			panel.add(Box.createRigidArea(new Dimension(0,50)));
			panel.add(Box.createVerticalGlue());
			panel.add(td);
			panel.add(Box.createRigidArea(new Dimension(0,50)));
			
			add(panel);
			setVisible(true);
			
			
			
		}
	}
	
	
	class CurrTime extends Panel{
		
		JLabel cdate;
		JLabel ctime;
		
		CurrTime(){
			setLayout(new GridLayout(2, 1));
			
			setBackground(Color.PINK);
			
			cdate = new JLabel("2022/03/16");
			ctime = new JLabel("am/10/48");
			
			cdate.setForeground(Color.WHITE);
			cdate.setHorizontalAlignment(JLabel.CENTER);
			
			ctime.setForeground(Color.WHITE);
			ctime.setHorizontalAlignment(JLabel.CENTER);
			
			add(cdate);
			add(ctime);

		}
	}
	
	class DDay extends Panel{
		JLabel ddlbl;
		
		DDay(){
			setLayout(new BorderLayout());
			ddlbl = new JLabel("D-Day here");
			ddlbl.setForeground(Color.WHITE);
			ddlbl.setHorizontalAlignment(JLabel.CENTER);
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
			tdlbl.setHorizontalAlignment(JLabel.CENTER);
			ta.setBackground(Color.WHITE);
			
		}
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}

}
