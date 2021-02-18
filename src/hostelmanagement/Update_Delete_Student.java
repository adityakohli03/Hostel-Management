import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Update_Delete_Student extends JFrame implements ActionListener {
	JPanel f;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	JLabel mobile,name,fname,mname,mail,address,aadhar,roomnumber,status; 
	JComboBox<String> cmb;
	JButton b1,b2,b3,b4,b5;
	
	
	Update_Delete_Student(){
		//---------frame---------
                setBounds(600,200,600,650);
                 setUndecorated(true);
		  f= new JPanel(); 
		  f.setSize(600,650);
                  f.setBackground(Color.CYAN);
	      f.setLayout(null);
	      f.setVisible(true);
			 //------------close------
                  
        ImageIcon i1=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Close all jframe.png");
        Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        b5=new JButton();
       b5.setIcon(new ImageIcon(i2));
        b5.setBounds(550,5,30,30);
        b5.addActionListener(this);
        f.add(b5);

	    //----------mobile---------- 
		 mobile=new JLabel("Mobile Number");  
		 mobile.setBounds(40,50,100,30); 
		 f.add(mobile);
		 
		 tf1=new JTextField();
		 tf1.setBounds(180,50,220,30);
		 f.add(tf1);
		 
		 //--------name--------
		 name=new JLabel("Name");  
		 name.setBounds(40,100,100,30); 
		 f.add(name);
		 
		 tf2=new JTextField();
		 tf2.setBounds(180,100,370,30);
		 f.add(tf2);
		 
		 //---------fname--------
		 fname=new JLabel("Father's Name");  
		 fname.setBounds(40,150,100,30); 
		 f.add(fname);
		 
		 tf3=new JTextField();
		 tf3.setBounds(180,150,370,30);
		 f.add(tf3);
		 
		 //---------mname---------
		 mname=new JLabel("Mother's Name");  
		 mname.setBounds(40,200,100,30); 
		 f.add(mname);
		 
		 tf4=new JTextField();
		 tf4.setBounds(180,200,370,30);
		 f.add(tf4);
		 
		 //----------mail---------
		 mail=new JLabel("Email ID");  
		 mail.setBounds(40,250,100,30); 
		 f.add(mail);
		 
		 tf5=new JTextField();
		 tf5.setBounds(180,250,370,30);
		 f.add(tf5);
		 
		 //-------address--------
		 address=new JLabel(" Address");  
		 address.setBounds(40,300,100,30); 
		 f.add(address);
		 
		 tf6=new JTextField();
		 tf6.setBounds(180,300,370,30);
		 f.add(tf6);
		 
		 //------aadhar--------
		 aadhar=new JLabel("Aadhar Number");  
		 aadhar.setBounds(40,350,100,30); 
		 f.add(aadhar);
		 
		 tf7=new JTextField();
		 tf7.setBounds(180,350,370,30);
		 f.add(tf7);
		 
		 //--------designation--------
		 roomnumber=new JLabel("Room Number");  
		 roomnumber.setBounds(40,400,100,30); 
		 f.add(roomnumber);
		 
		 tf8=new JTextField();
		 tf8.setBounds(180,400,370,30);
		 f.add(tf8);
		
		 
		 //---------status--------
		 status=new JLabel("Status");
		 status.setBounds(40,450,100,30); 
		 f.add(status);
		 
		 
		  cmb=new JComboBox<String>();
		  cmb.setBounds(180,450,370,30);
		  f.add(cmb);
			 
		 
		 
		 //--------Buttons---------
		 
		 b1=new JButton("Search");
		 b1.setBounds(420,50,130,30);
                   ImageIcon i3=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\search.png");
                 Image img=i3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic1=new ImageIcon(img);
                 b1.setIcon(ic1);
		 f.add(b1);
		 
		 b2=new JButton("Update");
		 b2.setBounds(180,540,100,30);
                   ImageIcon i4=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Update & Delete Student.png");
                 Image img2=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic2=new ImageIcon(img2);
                 b2.setIcon(ic2);
		 f.add(b2);
		 
		 b3=new JButton("Delete");
		 b3.setBounds(315,540,100,30);
                   ImageIcon i5=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\delete.png");
                 Image img3=i5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic3=new ImageIcon(img3);
                 b3.setIcon(ic3);
		 f.add(b3);
		 
		 b4=new JButton("Clear");
		 b4.setBounds(450,540,100,30);
                   ImageIcon i6=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\clear.png");
                 Image img4=i6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic4=new ImageIcon(img4);
                 b4.setIcon(ic4);
		 f.add(b4);
		 
		 add(f);
		 //---------Action Listener---------
		  b1.addActionListener(this);
	      b2.addActionListener(this);
		  b3.addActionListener(this);
	      b4.addActionListener(this);
		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Update_Delete_Student().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1) {
			String mobile=tf1.getText();
			try {
			 conn con=new conn();
			 ResultSet rs=con.s.executeQuery("select * from student where Mobile_Number='"+mobile+"'");
			 if(rs.next())
			 {
				 tf1.setEditable(false);
				 tf2.setText(rs.getString(1));
				 tf3.setText(rs.getString(2));
				 tf4.setText(rs.getString(3));
				 tf5.setText(rs.getString(5));
				 tf6.setText(rs.getString(6));
				 tf7.setText(rs.getString(7));
				 tf8.setText(rs.getString(8));
				 tf8.setEditable(false);
				 if(rs.getString(9).equals("Living"))
				 {
					 cmb.addItem("Living");
					 cmb.addItem("Leaved");
				 }
				 else 
				 {
					 cmb.addItem("Leaved");
					 cmb.addItem("Living");
				 }
				 
			 }
			 else
			 {
					JOptionPane.showMessageDialog(null,"Student Doesn't Exists ! ");
					 tf1.setText("");
			 }
			
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
		}
		else if(e.getSource()==b2) {
			String mobile = tf1.getText();
			String name=tf2.getText();
			String fname=tf3.getText();
			String mname=tf4.getText();
			String email=tf5.getText();
			String address=tf6.getText();
			String aadhar=tf7.getText();
                        String rnum=tf8.getText();
			String status=(String)(cmb.getSelectedItem());
			
			
			try {
					
				   //2. connection
				   conn con=new conn();
                                   if(status.equals("Living"))
                                   {
                                      con.s.executeUpdate("update room set RoomStatus='Booked' where RoomNumber='"+rnum+"'");
                                   }
                                   else
                                   {
                                    con.s.executeUpdate("update room set RoomStatus='Not Booked' where RoomNumber='"+rnum+"'");   
                                   }
			
   String query = "update student set Name='"+name+"',Father_Name='"+fname+"',Mother_Name='"+mname+"',Email='"+email+"',Address='"+address+"',Aadhar='"+aadhar+"',Status='"+status+"' where Mobile_Number='"+mobile+"'";
				   
				  
				   con.s.executeUpdate(query);
			 
				   JOptionPane.showMessageDialog(null,"Student Data Updated. ");
                                   
		}
			catch(Exception e1) {
				System.out.println(e1);
			}
		}
		else if(e.getSource()==b3) {
                    String rnum=tf8.getText();
			try {
			 conn con=new conn();
			   String query = "delete from student where Mobile_Number='"+tf1.getText()+"'";
			   con.s.execute(query);
	                   con.s.executeUpdate("update room set RoomStatus='Not Booked' where RoomNumber='"+rnum+"'");
                           
			   
			   tf1.setEditable(true);
				tf8.setEditable(true);
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				tf8.setText("");
				cmb.removeItemAt(0);
				cmb.removeItemAt(0);
			   JOptionPane.showMessageDialog(null,"Student Data Deleted Successfully ");
		}
			catch(Exception e1) {
				System.out.println(e1);
			}
		}
		
		else if(e.getSource()==b4)
		{
			tf1.setEditable(true);
			tf8.setEditable(true);
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			tf8.setText("");
			cmb.removeItemAt(0);
			cmb.removeItemAt(0);
		}
                else if(e.getSource()==b5)
                {
                    this.setVisible(false);
                }
		
	}

}
