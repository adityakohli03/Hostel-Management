
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.sql.Date;  
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Employe_payment extends JFrame implements ActionListener {

	JPanel contentPane;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JLabel mobile,name,email,designation,payment,month;
	JButton b1,b2,b3,b4;
	int x=1;
	 String[][] data=new String[x][3];
     String[] columnNames={"Month", "Amount","Payment Date & Time"};
     int i=0,j=0;
	 JTable table;
	public Employe_payment() {
		
		//---------frame---------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 setUndecorated(true);
		setBounds(600, 200, 650, 600);
		contentPane = new JPanel();
                
		setContentPane(contentPane);
		contentPane.setLayout(null);
                contentPane.setBackground(Color.CYAN);
		 //------------close------
                  
        ImageIcon i1=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Close all jframe.png");
        Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        b4=new JButton();
       b4.setIcon(new ImageIcon(i2));
        b4.setBounds(600,5,30,30);
        b4.addActionListener(this);
        contentPane.add(b4);
		
		 //----------mobile---------- 
		mobile = new JLabel("Mobile Number");
		mobile.setFont(new Font("Tahoma", Font.BOLD, 13));
		mobile.setBounds(40, 50, 100, 30);
		contentPane.add(mobile);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf1.setBounds(180, 50, 220, 30);
		contentPane.add(tf1);
		
		
		//--------name--------
		name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.BOLD, 13));
		name.setBounds(40, 100, 100, 30);
		contentPane.add(name);
		
		 tf2=new JTextField();
		 tf2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 tf2.setBounds(180,100,370,30);
		 contentPane.add(tf2);
		
		 
		 //---------email--------
		
		email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 13));
		email.setBounds(40, 150, 100, 30);
		contentPane.add(email);
		
		 tf3=new JTextField();
		 tf3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 tf3.setBounds(180,150,370,30);
		 contentPane.add(tf3);
		 
		//---------designation---------
		
		designation = new JLabel("Designation");
		designation.setFont(new Font("Tahoma", Font.BOLD, 13));
		designation.setBounds(40, 200, 100, 30);
		contentPane.add(designation);
		

		 tf4=new JTextField();
		 tf4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 tf4.setBounds(180,200,370,30);
		 contentPane.add(tf4);
		
		//----------month---------
		 
		month = new JLabel("Month");
		month.setFont(new Font("Tahoma", Font.BOLD, 13));
		month.setBounds(40, 250, 100, 30);
		contentPane.add(month);
		
		 tf5=new JTextField();
		 tf5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 tf5.setBounds(180,250,370,30);
		 contentPane.add(tf5);
		
		 //-------Payment--------
		payment = new JLabel("Payment");
		payment.setFont(new Font("Tahoma", Font.BOLD, 13));
		payment.setBounds(40, 300, 100, 30);
		contentPane.add(payment);
		
		 tf6=new JTextField();
		 tf6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 tf6.setBounds(180,300,370,30);
		 contentPane.add(tf6);
		
		
		 
		 //--------Buttons---------
		 
		 b1=new JButton("Search");
		 b1.setFont(new Font("Tahoma", Font.BOLD, 13));
		 b1.setBounds(420,50,130,30);
                   ImageIcon i3=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\search.png");
                 Image img=i3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic1=new ImageIcon(img);
                 b1.setIcon(ic1);
		 contentPane.add(b1);
		 
		 b2=new JButton("Pay");
		 b2.setFont(new Font("Tahoma", Font.BOLD, 13));
		 b2.setBounds(240,340,100,30);
                   ImageIcon i4=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Fees.png");
                 Image img2=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic2=new ImageIcon(img2);
                 b2.setIcon(ic2);
		 contentPane.add(b2);
		 
		 b3=new JButton("Clear");
		 b3.setFont(new Font("Tahoma", Font.BOLD, 13));
		 b3.setBounds(380,340,100,30);
                   ImageIcon i5=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\clear.png");
                 Image img3=i5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
                 ImageIcon ic3=new ImageIcon(img3);
                 b3.setIcon(ic3);
		 contentPane.add(b3);
		 
		 
		 tf2.setEnabled(false);
		 tf3.setEnabled(false);
		 tf4.setEnabled(false);
		 tf5.setEnabled(false);
		 tf6.setEnabled(false);
		 //-----------Table-----------
		 
		/* JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(40, 386, 549, 167);
		 contentPane.add(scrollPane);
		 
		 table = new JTable();
		 table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 	},
		 	new String[] {
		 		"Month", "Amount","Payment Date"
		 	}
		 ) {
		 	Class[] columnTypes = new Class[] {
		 		Object.class, Integer.class
		 	};
		 	public Class getColumnClass(int columnIndex) {
		 		return columnTypes[columnIndex];
		 	}
		 });
		 table.getColumnModel().getColumn(0).setPreferredWidth(240);
		 table.getColumnModel().getColumn(1).setPreferredWidth(240);
		 table.getColumnModel().getColumn(2).setPreferredWidth(240);
		 scrollPane.setViewportView(table);
	
		*/
		 
		/* String data[][]={};    
		 String column[]={"Month","Amount","Payment Date"};         
		 table=new JTable(data,column);    
		 table.setBounds(40,390,550,150);   
		 JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setViewportView(table);
		 scrollPane.setBounds(40,390,550,150); 
		 contentPane.add(scrollPane);
		*/
		 
		 
		 //---------Action Listener---------
		  b1.addActionListener(this);
	      b2.addActionListener(this);
		  b3.addActionListener(this);
	     
		
	}
	
	public void clear() {
		tf1.setEditable(true);
		tf4.setEditable(true);
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		 tf2.setEnabled(false);
		 tf3.setEnabled(false);
		 tf4.setEnabled(false);
		 tf5.setEnabled(false);
		 tf6.setEnabled(false);
		b1.setEnabled(true);
		b2.setVisible(true);
		table.setVisible(false);
	}
	public void table_details() {
		
	String mobile=tf1.getText();
	 int i=0, j=0;
	try {
	 conn con=new conn();
	 ResultSet rs=con.s.executeQuery("select * from employee_payment where Mobile_Number='"+mobile+"'");
	while(rs.next()) {
             data[i][j++]=rs.getString(2);
             data[i][j++]=rs.getString(3);
             data[i][j++]=rs.getString(4);
             i++;
             x++;
             j=0;
	}
	table=new JTable(data,columnNames);
	table.setVisible(true);
	}
	catch(Exception e1) {
		System.out.println(e1);
	}
	JScrollPane scrollPane = new JScrollPane(table);
	 scrollPane.setBounds(40, 386, 549, 167);
	 contentPane.add(scrollPane);
	}
	public static void main(String[] args) {
	    new Employe_payment().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String mobile=tf1.getText();
			String status="";
			 String[] monthName = {"January", "February",
		                "March", "April", "May", "June", "July",
		                "August", "September", "October", "November",
		                "December"};

		        Calendar cal = Calendar.getInstance();
		        String month = monthName[cal.get(Calendar.MONTH)];
		        int year = cal.get(Calendar.YEAR);
		        String my=month+"-"+String.valueOf(year);
			try {
			 conn con=new conn();
			 ResultSet rs=con.s.executeQuery("select * from employee where Mobile_Number='"+mobile+"'");
			 if(rs.next())
			 {
				 status=rs.getString(9);
				 if(rs.getString(9).equals("Working")) {
				 tf1.setEditable(false);
				 tf2.setText(rs.getString(1));
				 tf3.setText(rs.getString(5));
				 tf4.setText(rs.getString(8));
				 tf5.setText(month+"-"+String.valueOf(year));
				 tf6.setText(rs.getString(10));
				 tf4.setEditable(false);
				 tf2.setEnabled(true);
				 tf3.setEnabled(true);
				 tf4.setEnabled(true);
				 tf5.setEnabled(true);
				 tf6.setEnabled(true);
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"Employee Leaved The University");
					 clear();
				 }
				
			 }
			 else
			 {
					JOptionPane.showMessageDialog(null,"Employee Doesn't Exists ! ");
					 clear();
			 }
			ResultSet rs2=con.s.executeQuery("select * from employee_payment inner join employee where employee.Status='Working' and employee_payment.Month='"+my+"' and employee_payment.Mobile_Number='"+mobile+"'");
			if(rs2.next()) {
				b1.setEnabled(false);
				b2.setVisible(false);
				table_details();
				JOptionPane.showMessageDialog(null,"Payment for this month is already done ");
			}
			
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
		}
		
		else if(e.getSource()==b2) {
			
			String mobile=tf1.getText();
			String month=tf5.getText();
			String amount=tf6.getText(); 
			try {
				conn con=new conn();
			con.s.executeUpdate("insert into employee_payment(Mobile_Number,Month,Amount) values('"+mobile+"','"+month+"','"+amount+"')");
				table_details();
				JOptionPane.showMessageDialog(null,"Payment Done");
				b2.setVisible(false);
				
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
			
			
		
		}
		else if(e.getSource()==b3) {
			clear();
		}
                else if(e.getSource()==b4) {
			this.setVisible(false);
		}
	}
}
