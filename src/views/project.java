package views;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class project extends JFrame
{
	public project()
	{
		super();
		setSize(600,350);
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.gray);
        setLocationRelativeTo(null);
        setVisible(true);
		JTabbedPane j = new JTabbedPane();
                sem1 s1 = new sem1();
                s1.setVisible(true);
		j.addTab("SEM:1", s1);
                j.addTab("SEM:2", new sem2());
		j.addTab("SEM:3", new sem3());
		j.addTab("SEM:4", new sem4());
		j.addTab("SEM:5", new sem5());
		j.addTab("SEM:6", new sem6());
		j.addTab("SEM:7", new sem7());
		j.addTab("SEM:8", new sem8());
                j.addTab("Batch",new batch());
		add(j);
		
	}
	public static void main(String[]args)
		{
		   project p = new project();
                   p.setVisible(true);
      		}
}
