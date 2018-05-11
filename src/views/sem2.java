package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class sem2 extends JPanel
{
    	public sem2()
	{	
		JButton b2 = new JButton("FIND");
		JButton b3 = new JButton("REVIEW");
                JButton b5 = new JButton("LISTING");
                JButton b4 = new JButton("Transfer");
                JCheckBox c = new JCheckBox("send");
                JLabel l1 = new JLabel("End of Semester");
                JLabel l = new JLabel("(To transfer data to next sem, click transfer)");
                l1.setFont(new Font("Serif",Font.BOLD,30));
                l.setFont(new Font("Serif",Font.BOLD,20));
                setLayout(null);
                b2.setBounds(100,40,100,40);
                b5.setBounds(300,40,100,40);
                l1.setBounds(100,120,300,40);
                b3.setBounds(100,180,100,40);
                c.setBounds(220,180,60,30);
                b4.setBounds(270,180,100,30);
                l.setBounds(60,220,460,40);
                
		 add(b2); add(b5); add(b5); add(l1); add(b3); add(c); add(b4); add(l);
		        
                b2.addActionListener(new ActionListener()
                   {
                          public void actionPerformed(ActionEvent ae)
                          {
                              new find();
                          }
                    } );   
                  b3.addActionListener(new ActionListener()
                  {
                      public void actionPerformed(ActionEvent ae)
                      {
                       new review1();
                      }
                  }
                  );
                  b5.addActionListener(new ActionListener()
                  {
                      public void actionPerformed(ActionEvent ae)
                      {
                       new list();
                      }
                  }
                  );
                b4.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        if(c.isSelected())
                        {
                            try {
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject","root","");
                                Statement st = conn.createStatement();
                                String sql = "insert into sem3(roll,name,address,batch,tu_roll,contact,photo,status) select roll,name,address,batch,tu_roll,contact,photo,status from sem2";
                                st.executeUpdate(sql);
                                String sql1 ="delete from sem2";
                                st.executeUpdate(sql1);
//                                 String sql2 = "insert into status(tu_roll,name,s1) select tu_roll,name,status from sem1";
//                                st.executeUpdate(sql2);
                                  JOptionPane.showMessageDialog(null, "Transferred...");
                            } catch (SQLException ex) {
                                Logger.getLogger(sem1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                    }
                }
                );
                
		
	}

}


 
    

 


