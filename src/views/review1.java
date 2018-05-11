package views;

import controllers.DatabaseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Student;

class review1 extends JFrame {

    JLabel  l22,l1;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JComboBox jcb,jcb1;
JLabel r_name, r_address, r_batch, r_roll, r_contact, r_photo,r_attendance;
        
    JButton btn1;
//    String photo;
    String name,address,batch,roll,contact,attendance;
    review1() {

        setVisible(true);

        setSize(650, 500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

//        setTitle("Data Entry Form ");
        jcb = new JComboBox();
        jcb.addItem("sem1");
        jcb.addItem("sem2");
        jcb.addItem("sem3");
        jcb.addItem("sem4");
        jcb.addItem("sem5");
        jcb.addItem("sem6");
        jcb.addItem("sem7");
        jcb.addItem("sem8");
        
        
        jcb1 = new JComboBox();
        l22 = new JLabel("Change with name:");
        
        l1 = new JLabel("Confirm Semester:");
//        l8 = new JLabel("Confirm Semester:");    
        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));
        tf1 = new JTextField();
        tf1.setFont(new Font("Serif", Font.BOLD, 20));
        tf2 = new JTextField();
        tf2.setFont(new Font("Serif", Font.BOLD, 20));
        btn1 = new JButton("Submit");
        btn1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setBounds(70, 30, 400, 30);
        tf1.setBounds(300, 70, 200, 30);
         jcb.setBounds(270, 35, 200, 30);
        jcb1.setBounds(270, 100, 100, 25);
                            
        btn1.setBounds(500, 35, 100, 30);

        add(l1);
        add(jcb);
         add(jcb1);
                           
       add(tf2); 
        add(btn1);
                            l22.setBounds(70,100,200,20);
                            add(l22);
                             l22.setFont(new Font("Serif", Font.BOLD, 20));
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    try {

                        DatabaseHandler dh = new DatabaseHandler();
                        String sem = (String) jcb.getSelectedItem();
                        List<Student> list = dh.listing(sem);
                        int si = list.size();
                         String []arr = new String[si];
                           
                        for (int i = 0; i < list.size(); i++) {
                             Student s = list.get(i);
                             name = s.getName();
                             address = s.getAddress();
                             batch = s.getBatch();
                             roll = s.getTURoll();
                             contact = s.getContact();
                             attendance = s.getAttendance();
                            arr[i] = name; 
                            }
                           for(int j =0;j<si;j++)
                           {
                               jcb1.addItem(arr[j]);
                           
                           }
                            jcb1.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                   String  sname = (String) jcb1.getSelectedItem();
                                   String sem = (String) jcb.getSelectedItem();
                                    
                                        
                                    List<Student> list = dh.finding(sem,sname);
                        String turol="";
                        String sta = "";
                        for (int i = 0; i < list.size(); i++) {
                             Student s = list.get(i);
                             turol = s.getTURoll();
                             
                        }
                                    
                                    
                                    
                                    JLabel l2 = new JLabel("Enter TU Roll No:");
                                        JTextField tf1 = new JTextField(10);
                                        tf1.setText(turol);
                                        JLabel l3 = new JLabel("Update Attendance Status:");
                                        JComboBox jcb2 = new JComboBox();
                                        JButton submit = new JButton("Submit");
                                        JButton clear = new JButton("Clear");
                                        jcb2.addItem("Present");
                                        jcb2.addItem("Absent");
                                        add(l2); add(tf1);
                                        add(l3); add(jcb2);
                                        add(submit); add(clear);
                                        l2.setBounds(80,150,300,30);
                                        tf1.setBounds(280,150,100,30);
                                        l3.setBounds(80,200,200,30);
                                        jcb2.setBounds(280,200,100,30);
                                        submit.setBounds(80,245,100,30);
                                        clear.setBounds(200,245,100,30);
                                        l2.setFont(new Font("Serif", Font.BOLD, 15));
                                        l3.setFont(new Font("Serif", Font.BOLD, 15));
                                        tf1.setFont(new Font("Serif", Font.BOLD, 15));
                                        jcb2.setFont(new Font("Serif", Font.BOLD, 15));
                                        submit.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent aee)
                                         
                                            {
                                                String str1  = (String) jcb1.getSelectedItem(); // name
                                                String str2  = (String) jcb.getSelectedItem(); // sem
                                                String rol = tf1.getText();
                                                String att = (String) jcb2.getSelectedItem(); // status
                                                

                                                if(name!=null)
                                                {
                                                    List<Student> list = dh.updating(str2,str1,att,rol);
                                                    JOptionPane.showMessageDialog(null, "Updated Successfully!");
                                                }
                                                else
                                                {
                                                JOptionPane.showMessageDialog(null, "Unable to Update!");
                                                }
                                                
                                            }
                                            
                                        }
                                        );
                                    }
                                  
                            }
                                   
                            );
                        

                    } catch (Exception ee) {

                    }

                }

//            }



        });
    }
}
