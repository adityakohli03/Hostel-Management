
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Bg extends JFrame{
    Bg()
    {
        setUndecorated(true);
         ImageIcon ic4=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Chitkara-University-Patiala-2PB-Campus.jpg");
    Image ig4=ic4.getImage().getScaledInstance(1900, 950, Image.SCALE_DEFAULT);
     ImageIcon i4=new ImageIcon(ig4);
     JLabel l1=new JLabel(i4);
      add(l1);
      setSize(1900,950);
    }
    public static void main(String args)
    {
        new Bg().setVisible(true);
    }
}
