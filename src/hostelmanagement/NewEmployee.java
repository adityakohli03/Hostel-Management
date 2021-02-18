
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class NewEmployee extends JFrame implements ActionListener{
	JPanel f;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JLabel mobile,name,fname,mname,mail,address,aadhar,designation; 
	JComboBox cmb;
	JButton b1,b2,b3;
	
	NewEmployee(){
		
		//---------frame---------
                setBounds(600,200,600,600);
                setTitle("New Employee");
                 setUndecorated(true);
		  f= new JPanel(); 
                  f.setBackground(Color.CYAN);
		  f.setSize(500,500);
	      f.setLayout(null);
	      f.setVisible(true);
		 //------------close------
                  
        ImageIcon i1=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Close all jframe.png");
        Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        b3=new JButton();
       b3.setIcon(new ImageIcon(i2));
        b3.setBounds(550,5,30,30);
        b3.addActionListener(this);
        f.add(b3);
	    //----------mobile---------- 
		 mobile=new JLabel("Mobile Number");  
		 mobile.setBounds(40,50,100,30); 
		 f.add(mobile);
		 
		 tf1=new JTextField();
		 tf1.setBounds(180,50,370,30);
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
		 address=new JLabel("Address");  
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
		 designation=new JLabel("Designation");  
		 designation.setBounds(40,400,100,30); 
		 f.add(designation);
		 
		 String Designation[]= {"-Select-","Maintenance","Quality Control","Accounting & Budgeting","Cook","Housekeeping","Purchasing & Inventory Control","Security"};
	     cmb=new JComboBox(Designation);
		 cmb.setBounds(180,400,370,30);
		 f.add(cmb);
		 
		 
		 //--------Buttons--------
		 b1=new JButton("Save");
		 b1.setBounds(180,470,100,30);
                  ImageIcon i3=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\save.png");
                 Image img=i3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic1=new ImageIcon(img);
                 b1.setIcon(ic1);
		 f.add(b1);
		 
		 b2=new JButton("Clear");
		 b2.setBounds(320,470,100,30);
                  ImageIcon i4=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\clear.png");
                 Image img1=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic2=new ImageIcon(img1);
                 b2.setIcon(ic2);
		 f.add(b2);
		 
		 //---------Action Listener---------
		  b1.addActionListener(this);
	      b2.addActionListener(this);
              add(f);
		 
	}

	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	new NewEmployee().setVisible(true);

}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	//------Save Button------
	if(e.getSource()==b1) {
		String mobile = tf1.getText();
		String name=tf2.getText();
		String fname=tf3.getText();
		String mname=tf4.getText();
		String email=tf5.getText();
		String address=tf6.getText();
		String aadhar=tf7.getText();
		String designation = (String)cmb.getItemAt(cmb.getSelectedIndex());  
		String status="Working";
		int salary=0;
		if(designation=="Maintenance")
		{
			salary=15000;
		}
		else if(designation=="Quality Control")
		{
			salary=18000;
		}
		else if(designation=="Housekeeping")
		{
			salary=15000;
		}
		else if(designation=="Purchasing & Inventory Control")
		{
			salary=30000;
		}
		else if(designation=="Cook")
		{
			salary=20000;
		}
		else if(designation=="Accounting & Budgeting")
		{
			salary=60000;
		}
		else if(designation=="Security") {
			salary=13000;
		}
		try {
			
			   conn con = new conn();
		
			   String q = " insert into employee(Name,Father_Name,Mother_Name,Mobile_Number,Email,Address,Aadhar,Designation,Status,Salary) values ('"+name+"','"+fname+"','"+mname+"','"+mobile+"','"+email+"','"+address+"','"+aadhar+"','"+designation+"','"+status+"','"+salary+"')";
			   
			  con.s.executeUpdate(q);
			
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			cmb.setSelectedIndex(0);
			JOptionPane.showMessageDialog(null,"Successfully added");

		  }
		  catch (Exception e1) {
			  System.out.println(e1);
		  }
		  
	}
	//--------Clear Button-------
	else if(e.getSource()==b2) {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		tf7.setText("");
		cmb.setSelectedIndex(0);
	}
        //---------close-------
        else if(e.getSource()==b3)
        {
            this.setVisible(false);
        }
	
}

}