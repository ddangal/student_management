package views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import com.mysql.jdbc.Driver;

import controllers.DatabaseHandler;
import models.Student;

import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
class batch extends JPanel {

   JComboBox jcb;
   JLabel l;
    public batch() {
        
        jcb = new JComboBox();
        l = new JLabel("Select the Batch: ");
        jcb.addItem("2014");
        jcb.addItem("2013");
        jcb.addItem("2012");
        jcb.addItem("2011");
        add(l);
        add(jcb);
        jcb.addActionListener(new ActionListener()
        		{

					@Override
					public void actionPerformed(ActionEvent ae) {
					String s = (String) jcb.getSelectedItem();
					
                    DatabaseHandler dh = new DatabaseHandler();
                    String sem = (String) jcb.getSelectedItem();
                    List<Student> list = dh.listing_batch(s);
                    
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
                        Student s1 = list.get(i);
                        String r_name = s1.getName();
                        String r_address = s1.getAddress();
                        String r_batch = s1.getBatch();
                        String r_roll = s1.getTURoll();
                        String r_contact = s1.getContact();
                      
                      model.addRow(new Object[]{r_name, r_address, r_batch, r_roll,r_contact});

                    }

					
					}
        	
        		});
        try {
            setLayout(new FlowLayout());
        	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject", "root", "");
            DatabaseMetaData dmd = con.getMetaData();
            ResultSet rs = dmd.getTables(null, null, "%",null);
            String str ="";
            String str1 ="";
            while(rs.next())
            {
           
//                 System.out.println(rs.getString(3));
//                jcb.addItem(rs.getString(3));
                str = rs.getString(3);
                //str1  = str.substring(0,5);
                 //               System.out.println(str1);

//                if(str1.equals("batch"))
//                {
//                  jcb.addItem(rs.getString(3));
//            
//                }
                
            }
           
      
        } catch (SQLException ex) {
            Logger.getLogger(batch.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
}
