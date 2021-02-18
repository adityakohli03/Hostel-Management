import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Room extends JFrame implements ActionListener{
    
    JPanel p1;
    JTable table;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2;
    JCheckBox c1,c2;
       //int x=1;
       String[][] data=new String[20][3];
        String[] columnNames={"RoomNumber","Active","RoomStatus"};
        JButton b1,b2,b3,b4,b5;
    int i=0,j=0;
    Room(){
        setSize(700,500);
        setLocation(500,200);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.CYAN);
        p1.setBounds(0,0,700,500);
        
        ImageIcon i1=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Close all jframe.png");
        Image i2=i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        b5=new JButton();
       b5.setIcon(new ImageIcon(i2));
        b5.setBounds(640,10,50,50);
        b5.addActionListener(this);
        p1.add(b5);
        
        l2=new JLabel("ADD NEW ROOM");
        l2.setFont(new Font("ALGERIAN",Font.BOLD,20));
        l2.setBounds(10,10,200,30);
        p1.add(l2);
        
        l3=new JLabel("Room Number");
        l3.setFont(new Font("TAHOMA",Font.BOLD,14));
        l3.setBounds(10,70,105,30);
        p1.add(l3);
        
        t1=new JTextField();
        t1.setBounds(125,70,90,30);
        p1.add(t1);
        
        l4=new JLabel("Activate or Deactivate");
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(250,70,155,30);
        p1.add(l4);
        
         c1=new JCheckBox("Yes");
        c1.setBackground(Color.CYAN);
        c1.setFont(new Font("TAHOMA",Font.BOLD,14));
        c1.setBounds(410,70,50,30);
        p1.add(c1);
        
        b1=new JButton("Save");
        ImageIcon i4=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\save.png");
        Image i5=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        b1.setIcon(i6);
        b1.setFont(new Font("TAHOMA",Font.BOLD,14));
        b1.setBounds(500,70,95,30);
        p1.add(b1);
        
        JSeparator s1=new JSeparator();
        s1.setOrientation(SwingConstants.HORIZONTAL);
        s1.setBounds(0,110,700,1);
        s1.setBackground(Color.BLACK);
        p1.add(s1);
        
        l5=new JLabel("UPDATE OR DELETE ROOM");
        l5.setFont(new Font("ALGERIAN",Font.BOLD,20));
        l5.setBounds(10,115,270,30);
        p1.add(l5);
        
        l6=new JLabel("Room Number");
        l6.setFont(new Font("TAHOMA",Font.BOLD,14));
        l6.setBounds(10,165,105,30);
        p1.add(l6);
        
        t2=new JTextField();
        t2.setBounds(125,165,90,30);
        p1.add(t2);
        
        b2=new JButton("Search");
        ImageIcon i7=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\search.png");
        Image i8=i7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        b2.setIcon(i9);
        b2.setFont(new Font("TAHOMA",Font.BOLD,14));
        b2.setBounds(230,165,105,30);
        p1.add(b2);
        
        l7=new JLabel("Activate or Deactivate");
        l7.setFont(new Font("TAHOMA",Font.BOLD,14));
        l7.setBounds(365,165,160,30);
        p1.add(l7);
        
        c2=new JCheckBox("Yes");
        c2.setBackground(Color.CYAN);
        c2.setFont(new Font("TAHOMA",Font.BOLD,14));
        c2.setBounds(535,165,50,30);
        p1.add(c2);
        
         b3=new JButton("Update");
        ImageIcon i10=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\save.png");
        Image i11=i10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i12=new ImageIcon(i11);
        b3.setIcon(i12);
        b3.setFont(new Font("TAHOMA",Font.BOLD,14));
        b3.setBounds(390,210,110,30);
        p1.add(b3);
        
        b4=new JButton("Delete");
        ImageIcon i13=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\HostelManagement\\src\\icons\\Close all jframe.png");
        Image i14=i13.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i15=new ImageIcon(i14);
        b4.setIcon(i15);
        b4.setFont(new Font("TAHOMA",Font.BOLD,14));
        b4.setBounds(520,210,110,30);
        p1.add(b4);
        
        JSeparator s2=new JSeparator();
        s2.setOrientation(SwingConstants.HORIZONTAL);
        s2.setBounds(0,247,700,1);
        s2.setBackground(Color.BLACK);
        p1.add(s2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);;
        
        l8=new JLabel("ALL ROOMS");
        l8.setFont(new Font("ALGERIAN",Font.BOLD,20));
        l8.setBounds(290,250,200,30);
        p1.add(l8);
        add(p1);
        
        table();
    }
    public void table()
    {
        int i=0, j=0;
	try {
	 conn con=new conn();
	 ResultSet rs=con.s.executeQuery("select * from room");
	while(rs.next()) {
             data[i][j++]=rs.getString(1);
             data[i][j++]=rs.getString(2);
             data[i][j++]=rs.getString(3);
             i++;
             j=0;
          //   x++;
	}
	table=new JTable(data,columnNames);
	table.setVisible(true);
	}
	catch(Exception e1) {
		System.out.println(e1);
	}
	JScrollPane scrollPane = new JScrollPane(table);
	 scrollPane.setBounds(40, 280, 549, 167);
	 p1.add(scrollPane);
    }
    public void clear(){
    t1.setText("");
    t2.setText("");
    c1.setSelected(false);
    c2.setSelected(false);
    t2.setBackground(new JButton().getBackground());
    t2.setForeground(new JButton().getForeground());
    t2.setEditable(true);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
             String RoomNumber=t1.getText();
        String activate;
        String roomStatus="Not Booked";
        if(c1.isSelected())
        {
            activate="Yes";
        }
        else
            activate="No";
        try
        {
         conn con=new conn();
         con.s.executeUpdate("insert into room values('"+RoomNumber+"','"+activate+"','"+roomStatus+"')");
         JOptionPane.showMessageDialog(null,"Sucessfully Updated");
         table();
         clear();
        }
        catch(Exception ae)
        {
            JOptionPane.showMessageDialog(null,ae);
        }
        table();
        }
        else if(e.getSource()==b2)
        {
              String roomnumber=t2.getText();
        int i=0;
        try
        {
             conn con=new conn();
            ResultSet rs=con.s.executeQuery("select *from room where RoomNumber='"+roomnumber+"'");
            while(rs.next())
            {
                i=1;
                if(rs.getString(3).equals("Booked")){
                    JOptionPane.showMessageDialog(null, "This Room is Booked");
                    clear();
                }
                else
                {
                    t2.setEditable(false);
                    t2.setForeground(Color.red);
                    t2.setBackground(Color.pink);
                    if(rs.getString(2).equals("Yes"))
                        c2.setSelected(true);
                    else
                       c2.setSelected(false);
                }
            }
            if(i==0)
            {
                JOptionPane.showMessageDialog(null,"Room Number Does not Exist");
                clear();
            }
        }
        catch(Exception e1)
        {
            JOptionPane.showMessageDialog(null,e1);
        }
         table();
        }
        else if(e.getSource()==b3)
        {
              String roomnumber=t2.getText();
        String activate;
        if(c2.isSelected())
        {
            activate="Yes";
        }
        else
            activate="No";
        try
        {
           conn con=new conn();
            con.s.executeUpdate("update room set Active='"+activate+"' where RoomNumber='"+roomnumber+"'");
            JOptionPane.showMessageDialog(null,"Successfully Updated");
            table();
            clear();
        }
        catch(Exception aae)
        {
            JOptionPane.showMessageDialog(null,aae);
        }
        }
        else if(e.getSource()==b4)
        {
             String roomnumber=t2.getText();
        try
        {
            conn con=new conn();
            con.s.executeUpdate("delete from room where RoomNumber='"+roomnumber+"'");
            JOptionPane.showMessageDialog(null,"Successfully Deleted");
            
            table();
            clear();
        }
        catch(Exception aee)
        {
            JOptionPane.showMessageDialog(null,aee);
        }
        }
        else if(e.getSource()==b5)
        {
            this.setVisible(false);
        }
    }
    
    
    public static void main(String args[]){
        new Room().setVisible(true);
        
    }   
}