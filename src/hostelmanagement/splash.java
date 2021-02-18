import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class splash {
    public static void main(String[] args){
        fframe f1 = new fframe();
        f1.setVisible(true);
        f1.setLocation(600,300);
        f1.setSize(730,550);
        }
        
    }
class fframe extends JFrame implements Runnable{
    Thread t1;
    fframe(){
        setUndecorated(true);
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());
        ImageIcon ic1=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\culogo.png");
    Image ig1=ic1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
    ImageIcon i1=new ImageIcon(ig1);
        
        
        JLabel l1 = new JLabel(i1);
        add(l1);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(4000);
            this.setVisible(false);
            
            login l = new login();
            l.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}