import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class delete1 extends JFrame {
    public delete1()
    {
           setLayout(new FlowLayout());
           setSize(200,200);
           setVisible(true);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           JTabbedPane j = new JTabbedPane();
            j.addTab("D",new abc());
            j.addTab("E",new abc());
            j.addTab("F",new abc());
            add(j);
           int in = j.getSelectedIndex();
//           in = j.getTabCount()-1;
//           j.setSelectedIndex(in);
        if(in == 0)
        System.out.println("D");
        else if(in == 1)
            System.out.println("E");
        else
            System.out.println("F");
    }
    public static void main(String[]args)
    {
        new delete1();
    }

    private static class abc extends Component {

        public abc() {
        }
    }
}

