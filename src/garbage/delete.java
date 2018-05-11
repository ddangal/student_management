/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author deependra97
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafx.scene.control.Spinner;
public class delete extends JFrame 
{
    
    public delete()
    {
        setLayout(null);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComboBox jcb = new JComboBox();
        jcb.setBounds(100,100,300,40);
        jcb.addItem("Pawan");
        jcb.addItem("Deependra");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        jcb.addItem("Sunit");
        
        
        add(jcb);
        jcb.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                String s = (String) jcb.getSelectedItem();
                System.out.println(s);
            }
        }
        );
        String [] arr = {"Deependra","Pawan","sunit"};
        SpinnerListModel model = new SpinnerListModel(arr);
        JSpinner spin = new JSpinner(model);
        add(spin);
    }
    public static void main(String[]args)
    {
        new delete();
    }
}
