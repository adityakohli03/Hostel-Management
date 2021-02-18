
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
JLabel l1,l2,l3;
JButton b1,b2;
JTextField t1;
JPasswordField p1;
JPanel p4,p2,p3;
Bg b=new Bg();
    login()
{
    b.setVisible(true);
    setTitle("Login Page");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    l1=new JLabel("Username");
    l2=new JLabel("Password");
    
    t1=new JTextField(15);
    p1=new JPasswordField(15);
    
    ImageIcon ic1=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\pop.png");
    Image ig1=ic1.getImage().getScaledInstance(128, 128,Image.SCALE_DEFAULT);
    ImageIcon i1=new ImageIcon(ig1);
    l3=new JLabel(i1);
    
    ImageIcon ic2=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\login.png");
    Image ig2=ic2.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
    b1=new JButton("Login",new ImageIcon(ig2));
    
    ImageIcon ic3=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\cancel.jpg");
    Image ig3=ic3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
    b2=new JButton("Cancle",new ImageIcon(ig3));
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    
    setLayout(new BorderLayout());
    
    p2=new JPanel();
    p3=new JPanel();
    p4=new JPanel();
    
    p4.add(l3);
    p4.setBackground(Color.WHITE);
    
    p2.add(l1);
    p2.add(t1);
    p2.add(l2);
    p2.add(p1);
     p2.setBackground(Color.WHITE);
    
    p3.add(b1);
    p3.add(b2);
     p3.setBackground(Color.WHITE);
     
    add(p4,BorderLayout.WEST);
    add(p2,BorderLayout.CENTER);
    add(p3,BorderLayout.SOUTH);
    
    setSize(440,250);
        setLocation(600,400);
        setVisible(true);
    
}
@Override
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==b1)
        {
       try
       {
           conn c1=new conn();
           String s1=t1.getText();
           String s2=p1.getText();
           String s3="select * from login where username = '"+s1+"' and password = '"+s2+"'";
             ResultSet rs = c1.s.executeQuery(s3);
            if(rs.next()){
               new HomePage().setVisible(true);
                this.setVisible(false);
                b.setVisible(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
                t1.setText("");
                p1.setText("");
            }
        }
       catch(Exception e)
       {
            e.printStackTrace();
            System.out.println("error: "+e);
        }
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Login Cancled");
           System.exit(0);
       }
    }
    public static void main(String[] args){
        new login().setVisible(true);
    }

}
