package views;

import controllers.DatabaseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Student;

class list extends JFrame {

    JLabel l1;

    JComboBox jcb;

    JButton btn1;
    list() {

        setVisible(true);

        setSize(650, 500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        jcb = new JComboBox();
        jcb.addItem("sem1");
        jcb.addItem("sem2");
        jcb.addItem("sem3");
        jcb.addItem("sem4");
        jcb.addItem("sem5");
        jcb.addItem("sem6");
        jcb.addItem("sem7");
        jcb.addItem("sem8");
        
        
        l1 = new JLabel("Confirm Semester:");
        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));
        btn1 = new JButton("Submit");
        btn1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setBounds(70, 30, 400, 30);
         jcb.setBounds(270, 35, 200, 30);
        
        btn1.setBounds(500, 35, 100, 30);

        add(l1);
        add(jcb);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btn1) {

                    try {

                        DatabaseHandler dh = new DatabaseHandler();
                        String sem = (String) jcb.getSelectedItem();
                        List<Student> list = dh.listing(sem);
                        
                         JTable table = new JTable();   
                          String[] colname = {"Name","address","Batch","Roll","Contact"};
                          
                        DefaultTableModel model = new DefaultTableModel();
                            model.setColumnIdentifiers(colname);

                            table.setModel(model); 
                            table.setBounds(100,150,500,500);
                            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                            table.setFillsViewportHeight(true);
                            JScrollPane scroll = new JScrollPane(table);
                            scroll.setHorizontalScrollBarPolicy(
                            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            scroll.setVerticalScrollBarPolicy(
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
                            scroll.setBounds(100,100,500,500);
                           table.setFont(new Font("Serif", Font.PLAIN, 15));
                           
//        
                            add(scroll);
                          
                            
                        for (int i = 0; i < list.size(); i++) {
                            Student s = list.get(i);
                            String r_name = s.getName();
                            String r_address = s.getAddress();
                            String r_batch = s.getBatch();
                            String r_roll = s.getTURoll();
                            String r_contact = s.getContact();
                          
                          model.addRow(new Object[]{r_name, r_address, r_batch, r_roll,r_contact});

                        }

                    } catch (Exception ee) {

                    }

                }

            }

        });
    }
}
