
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HomePage extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
   HomePage()
   {
        JPanel p=new JPanel();
        setTitle("Home Page");
         setUndecorated(true);
       setSize(1920,1030);
       p.setSize(1920,1030);
       p.setBackground(Color.CYAN);
       p.setLayout(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel p1=new JPanel();
       ImageIcon i=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Chitkara-University-Patiala-2PB-Campus.jpg");
       Image i1=i.getImage().getScaledInstance(1900, 950, Image.SCALE_DEFAULT);
       ImageIcon ic=new ImageIcon(i1);
       JLabel img=new JLabel(ic);
       p1.add(img);
       p1.setBounds(300,100,1900,950);
         
       ImageIcon i2=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\room.png");
       Image img1=i2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b1=new JButton("Manage Rooms");
       b1.setIcon(new ImageIcon(img1));
       b1.setBounds(25,100,250,50);
       
         ImageIcon i3=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\new student.png");
       Image img2=i3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b2=new JButton("New Student");
       b2.setIcon(new ImageIcon(img2));
       b2.setBounds(25,175,250,50);

         ImageIcon i4=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Update & Delete Student.png");
       Image img3=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b3=new JButton("Update & Delete Student");
       b3.setIcon(new ImageIcon(img3));
       b3.setBounds(25,250,250,50);

         ImageIcon i5=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Fees.png");
       Image img4=i5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b4=new JButton("Student Fee");
       b4.setIcon(new ImageIcon(img4));
       b4.setBounds(25,325,250,50);

         ImageIcon i6=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\all student living.png");
       Image img5=i6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b5=new JButton("All Student Living");
       b5.setIcon(new ImageIcon(img5));
       b5.setBounds(25,400,250,50);

         ImageIcon i7=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Leaved students.png");
       Image img6=i7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b6=new JButton("Leaved Student");
       b6.setIcon(new ImageIcon(img6));
       b6.setBounds(25,475,250,50);

         ImageIcon i8=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\new student.png");
       Image img7=i8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b7=new JButton("New Emolyee");
       b7.setIcon(new ImageIcon(img7));
       b7.setBounds(25,550,250,50);

         ImageIcon i9=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Update & Delete Student.png");
       Image img8=i9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b8=new JButton("Update & Delete Employee");
       b8.setIcon(new ImageIcon(img8));
       b8.setBounds(25,625,250,50);

         ImageIcon i10=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Fees.png");
       Image img9=i10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b9=new JButton("Employee Payment");
       b9.setIcon(new ImageIcon(img9));
       b9.setBounds(25,700,250,50);

         ImageIcon i11=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\all student living.png");
       Image img10=i11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b10=new JButton("All Employee Working");
       b10.setIcon(new ImageIcon(img10));
       b10.setBounds(25,775,250,50);

         ImageIcon i12=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Leaved students.png");
       Image img11=i12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       b11=new JButton("Leaved Employee");
       b11.setIcon(new ImageIcon(img11));
       b11.setBounds(25,850,250,50);
       
         ImageIcon i13=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\logout.png");
       Image img12=i13.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        b12=new JButton("Logout");
       b12.setIcon(new ImageIcon(img12));
       b12.setBounds(1200,30,200,60);
       
         ImageIcon i14=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Close.png");
       Image img13=i14.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        b13=new JButton("EXIT");
       b13.setIcon(new ImageIcon(img13));
       b13.setBounds(1500,30,200,60);
    
       JLabel l=new JLabel("NAVIGATOR BAR");
       l.setFont(new Font("NSimSun",Font.BOLD,30));
       l.setBounds(30,40,500,25);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
       b4.addActionListener(this);
       b5.addActionListener(this);
       b6.addActionListener(this);
       b7.addActionListener(this);
       b8.addActionListener(this);
       b9.addActionListener(this);
       b10.addActionListener(this);
       b11.addActionListener(this);
       b12.addActionListener(this);
       b13.addActionListener(this);
       
       
       p.add(l);
       p.add(p1);
       p.add(b1);
       p.add(b2);
       p.add(b3);
       p.add(b4);
       p.add(b5);
       p.add(b6);
       p.add(b7);
       p.add(b8);
       p.add(b9);
       p.add(b10);
       p.add(b11);
       p.add(b12);
       p.add(b13);
       add(p);
       
   } 
   @Override
      public void actionPerformed(ActionEvent ae)
      {
          if(ae.getSource()==b1)
          {
              new Room().setVisible(true);
          }
          else if(ae.getSource()==b2)
          {
              new NewStudent().setVisible(true);
          }
          else if(ae.getSource()==b3)
          {
              new Update_Delete_Student().setVisible(true);
          }
          else if(ae.getSource()==b4)
          {
          new Student_Fee().setVisible(true);   
          }
          else if(ae.getSource()==b5)
          {
              new Student_Living().setVisible(true);
          }
          else if(ae.getSource()==b6)
          {
              new Student_Leaved().setVisible(true);
          }
          else if(ae.getSource()==b7)
          {
              new NewEmployee().setVisible(true);
          }
          else if(ae.getSource()==b8)
          {
              new Update_Delete_Employee().setVisible(true);
          }
          else if(ae.getSource()==b9)
          {
              new Employe_payment().setVisible(true);
          }
          else if(ae.getSource()==b10)
          {
              new Employee_Working().setVisible(true);
          }
          else if(ae.getSource()==b11)
          {
              new Employee_Leaved().setVisible(true);
          }
          else if(ae.getSource()==b12)
          {
              this.setVisible(false);
              new login().setVisible(true);
          }
          else if(ae.getSource()==b13)
          {
              System.exit(0);
          }
      }
   public static void main(String args[])
   {
       new HomePage().setVisible(true);
   }
}



