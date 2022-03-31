package ateamproject;

// Example from http://www.crionics.com/products/opensource/faq/swing_ex/SwingExamples.html
/*
 * (swing1.1)
 */

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * @version 1.0 12/24/98
 */
public class Temp extends JFrame {

  public Temp() {

    String[] data = { "a", "b", "c", "d", "e", "f", "g" };

    DefaultTableModel dm = new DefaultTableModel();
    Vector dummyHeader = new Vector();
    dummyHeader.addElement("");
    dm.setDataVector(strArray2Vector(data), dummyHeader);
    
    JTable table = new JTable(dm);
    table.setShowGrid(false);
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollTable = new JScrollPane(table);
    scrollTable.setColumnHeader(null);
    scrollTable.setMinimumSize(new Dimension(100, 80));
    

    Container c = getContentPane();
    c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
    c.add(scrollTable);
    
    c.add(new JSeparator(SwingConstants.VERTICAL));

    setSize(220, 130);
    setVisible(true);
  }

  private Vector strArray2Vector(String[] str) {
    Vector vector = new Vector();
    for (int i = 0; i < str.length; i++) {
      Vector v = new Vector();
      v.addElement(str[i]);
      vector.addElement(v);
    }
    return vector;
  }

  public static void main(String[] args) {
    final Temp frame = new Temp();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
