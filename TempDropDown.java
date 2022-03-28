package ateamproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class TempDropDown {
	
	/*
	 * public Date getSQLDate(String year, String month, String day) { 
	 * 
	 * return d; }
	 */
    public static void main(String[] args) {

    	//sqlDate ��ȯ ���� :-> https://all-record.tistory.com/112

		//create a array for months and year
		String year[]=new String[31];
		String date[]=new String[31];
		
		//String array to store weekdays
		String month[]= { "January", "February", "March",
		"April", "May", "June", "July", "August",
		"September", "October", "November", "December"};
		
		
		//add month number and year to list
		for(int i=0;i<31;i++)
		{
			date[i]=""+(int)(i+1);
			year[i]=""+(int)(2022-i);
		}

        JFrame jFrame = new JFrame();

        
        JComboBox<String> cmbYear = new JComboBox<>(year);
        cmbYear.setBounds(10, 10, 140, 20);
        
        JComboBox<String> cmbMonth = new JComboBox<>(month);
        cmbMonth.setBounds(60, 30, 140, 20);
        
        JComboBox<String> cmbDate = new JComboBox<>(date);
        cmbDate.setBounds(110, 50, 140, 20);

        

        JButton jButton = new JButton("Done");
        jButton.setBounds(100, 100, 90, 20);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);

        jFrame.add(jButton);
        jFrame.add(cmbYear);
        jFrame.add(cmbMonth);
        jFrame.add(cmbDate);
        jFrame.add(jLabel);
        
        jFrame.setLayout(null);
        jFrame.setSize(350, 250);
        jFrame.setVisible(true);

        jButton.addActionListener(new ActionListener() {//Test Button
            @Override
            public void actionPerformed(ActionEvent e) {
            	String yValue = cmbYear.getItemAt(cmbYear.getSelectedIndex());
            	int mValue = cmbMonth.getSelectedIndex()+1;
            	String dValue = cmbDate.getItemAt(cmbDate.getSelectedIndex());
            	
            	System.out.println("You selected "); 
                System.out.println(yValue);
                System.out.println(mValue);
                System.out.println(dValue);
                
                
                
                System.out.println("SQL�� �´� ��¥ �������� ��ȯ�� �ּ���.");
                
                String fDate = yValue + "-" + mValue + "-" + dValue;
                Date sqlDate = Date.valueOf(fDate);
                System.out.println(fDate);

                
                //System.out.println(sqlDate);
            }
        });
        
        

    }
}


