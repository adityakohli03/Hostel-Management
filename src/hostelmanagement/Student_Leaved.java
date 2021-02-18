
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Student_Leaved extends JFrame implements ActionListener{
	JLabel heading;
	JPanel contentPane;
	 JTable table;
	//int x=2;
         JButton b1;
	 String[][] data=new String[20][8];
     String[] columnNames={"Name","Father Name","Mother Name","Mobile","Email", "Address","Aadhar","Room Number"};
	Student_Leaved(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 700, 600);
		contentPane = new JPanel();
		 setUndecorated(true);
		setBounds(500, 200, 700, 600);
		contentPane = new JPanel();
		   contentPane.setBackground(Color.CYAN);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		    ImageIcon i1=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Close all jframe.png");
        Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        b1=new JButton();
       b1.setIcon(new ImageIcon(i2));
        b1.setBounds(650,5,30,30);
        b1.addActionListener(this);
        contentPane.add(b1);

		
		//------------heading----------
		heading=new JLabel("Student Leaved");
		heading.setFont(new Font("Tahoma", Font.BOLD, 15));
		heading.setBounds(270,10,300,30);
		contentPane.add(heading);
		
		int i=0, j=0;
		try {
		conn con=new conn();
		 ResultSet rs=con.s.executeQuery("select * from student where Status='Leaved'");
		
		 while(rs.next()) {
	             data[i][j++]=rs.getString(1);
	             data[i][j++]=rs.getString(2);
	             data[i][j++]=rs.getString(3);
	             data[i][j++]=rs.getString(4);
	             data[i][j++]=rs.getString(5);
	             data[i][j++]=rs.getString(6);
	             data[i][j++]=rs.getString(7);
	             data[i][j++]=rs.getString(8);
	             i++;
	         //   x++;
	             j=0;
		}
	
		 table=new JTable(data,columnNames);
			table.setVisible(true);
		
		
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setBounds(40,40,610, 500);
		 contentPane.add(scrollPane);
	}
	public static void main(String[] args) {
		new Student_Leaved().setVisible(true);
	}
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b1)
            {
                this.setVisible(false);
            }
        }

}
