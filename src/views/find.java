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
import javax.swing.JTextField;
import models.Student;

class find extends JFrame {
    String name,address,batch,roll,contact,attendance;
    String filename;
    JLabel l1, l2, l3, l4, l5, l6, l7,l8;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JComboBox jcb,jcb1;

    JButton btn1, btn2;
    String photo;
    find() {

        setVisible(true);

        setSize(650, 500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setTitle("Data Entry Form ");
        jcb = new JComboBox();
        jcb1 = new JComboBox();
        jcb.addItem("sem1");
        jcb.addItem("sem2");
        jcb.addItem("sem3");
        jcb.addItem("sem4");
        jcb.addItem("sem5");
        jcb.addItem("sem6");
        jcb.addItem("sem7");
        jcb.addItem("sem8");
        
        
        l1 = new JLabel("Find Data:");
        l8 = new JLabel("Select Name :");    
        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l8.setFont(new Font("Serif", Font.BOLD, 20));
        
        l2 = new JLabel("Confirm Semester:");
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l3 = new JLabel("Enter TU Roll:");
        l3.setFont(new Font("Serif", Font.BOLD, 20));
        tf1 = new JTextField();
        tf1.setFont(new Font("Serif", Font.BOLD, 20));
        tf2 = new JTextField();
        tf2.setFont(new Font("Serif", Font.BOLD, 20));
        btn1 = new JButton("Submit");
        btn1.setFont(new Font("Serif", Font.BOLD, 20));
        btn2 = new JButton("Clear");
        btn2.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setBounds(100, 30, 400, 30);

        l2.setBounds(80, 70, 200, 30);

        l8.setBounds(80, 110, 200, 30);
        jcb.setBounds(300, 70, 200, 30);
        jcb1.setBounds(300, 110, 200, 30);
        
        btn1.setBounds(80, 160, 100, 30);

        btn2.setBounds(210, 160, 100, 30);

        add(l1);
        add(l2);
        add(tf1);
        add(l8);
        add(jcb);
        add(jcb1);
      add(btn1);
//        add(btn2);
      
        JLabel r_name, r_address, r_batch, r_roll, r_contact, r_photo;
        
        r_name = new JLabel("");
        r_name.setFont(new Font("Serif", Font.BOLD, 20));
        r_address = new JLabel("");
        r_address.setFont(new Font("Serif", Font.BOLD, 20));
        r_batch = new JLabel("");
        r_batch.setFont(new Font("Serif", Font.BOLD, 20));
        r_roll = new JLabel("");
        r_roll.setFont(new Font("Serif", Font.BOLD, 20));
        r_contact = new JLabel("");
        r_contact.setFont(new Font("Serif", Font.BOLD, 20));
        add(r_name);
        add(r_address);
        add(r_batch);
        add(r_roll);
        add(r_contact);
        r_name.setBounds(80, 200, 300, 30);
        r_name.setForeground(new Color(20, 20, 250));
        r_address.setForeground(new Color(20, 20, 250));
        r_batch.setForeground(new Color(20, 20, 250));
        r_roll.setForeground(new Color(20, 20, 250));
        r_contact.setForeground(new Color(20, 20, 250));
        r_address.setBounds(80, 250, 300, 30);
        r_batch.setBounds(80, 300, 300, 30);
        r_roll.setBounds(80, 350, 300, 30);
        r_contact.setBounds(80, 400, 300, 30);
        //r_image.setBounds(300,300,200,200);
        
        
        
        
        jcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                        DatabaseHandler dh = new DatabaseHandler();
                        String sem = (String) jcb.getSelectedItem();
                        List<Student> list = dh.listing(sem);
                        int si = list.size();
                         String []arr = new String[si];
                           
                        for (int i = 0; i < list.size(); i++) {
                            // TODO USE TABLE VIEW TO DISPLAY MULTIPLE DATA AND DISPLAY IMAGE
                            //FIRST MOVE SELECTED IMAGE TO RESOURCES FOLDER WHILE INSERTING DATA INTO DATABASEE
                            Student s = list.get(i);
                             name = s.getName();
                             arr[i] = name; 
                            }
                           for(int j =0;j<si;j++)
                           {
                               jcb1.addItem(arr[j]);
                           
                           }
                            
                            btn1.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                	
                                	
                                     DatabaseHandler dh = new DatabaseHandler();

                         String sem = (String) jcb.getSelectedItem();
                        String name = (String) jcb1.getSelectedItem();
                        
                        List<Student> list = dh.finding(sem,name);
                        
                        for (int i = 0; i < list.size(); i++) {
                            // TODO USE TABLE VIEW TO DISPLAY MULTIPLE DATA AND DISPLAY IMAGE
                            //FIRST MOVE SELECTED IMAGE TO RESOURCES FOLDER WHILE INSERTING DATA INTO DATABASEE
                            Student s = list.get(i);
                            r_name.setText("Name: " + s.getName());
                            r_address.setText("Address:  " + s.getAddress());
                            r_batch.setText("Batch:  " + s.getBatch());
                            r_roll.setText("Roll:  " + s.getTURoll());;
                            r_contact.setText("Contact:  " + s.getContact());
                            filename = s.getName();
                            ImageIcon ii = loadImage(filename);
                          
                            JLabel r_image = new JLabel(ii);
                            r_image.setBounds(330,180,300,250);
                            add(r_image);
                            
                            
                         
                            //    photo = s.getPhoto();
//                             tf1.setText(photo);
//                              ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource("../../resources/"+photo)); 
//                            JLabel llll = new JLabel(ico);
//                            llll.setBounds(400, 400, 400, 400);

                        }
                                    
                                }
                            }
                            );
                        
                    }catch(Exception ex)
                    {
                        
                        
                    }  }
        });
       }
    public ImageIcon loadImage(String file) {
          
 
        ImageIcon ii = new ImageIcon("src/images/"+file+".png");
        return ii;
    }

}