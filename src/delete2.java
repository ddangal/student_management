import java.awt.event.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class delete2 extends JFrame {
    public delete2()
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject", "root", "");
            DatabaseMetaData dmd = con.getMetaData();
            ResultSet rs = dmd.getTables(null, null, "%",null);
            while(rs.next())
            {
                System.out.println(rs.getString(3));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(delete2.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void main(String[]args)
    {
        new delete1();
    }

    
}

