import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Treacherpreview extends JFrame  implements ActionListener
{
	JLabel Tid,Name,address,gender,subject,mobile,salary,section,background;
    JTextField  tTid,tName,tsubject,tmobile,tsalary,tgender;
    JTextArea taddress;
    JScrollPane pane;
    JButton ok;
	public void Teachers()
	{
		super.setBounds(300, 250, 600, 500);
    	super.setTitle("TEACHER PANEL");
    	super.setResizable(false);
    	
    	section=new JLabel(" WELCOME TO TEACHER PORTAL");
    	section.setBounds(120, 30, 500, 10);
    	super.add(section);
    	
    	Tid=new JLabel("Teacher id");
    	Tid.setBounds(40, 50, 80, 25);
    	super.add(Tid);
    	tTid=new JTextField();
    	tTid.setBounds(130, 50, 220, 25);
    	super.add(tTid);
    	
    	Name=new JLabel("Teacher name");
    	Name.setBounds(40, 85, 80, 25);
    	super.add(Name);
        tName=new JTextField();
        tName.setBounds(130, 85, 220, 25);
        super.add(tName);
        
        address=new JLabel("Address");
        address.setBounds(45,120, 80, 40);
        super.add(address);
        taddress=new JTextArea();
        pane=new JScrollPane(taddress);
        pane.setBounds(130, 120, 120, 60);
        super.add(pane);
        
        gender=new JLabel("Gender");
        gender.setBounds(45, 190, 80, 25);
        super.add(gender);
        tgender=new JTextField();
        tgender.setBounds(130, 190, 80, 25);
        super.add(tgender);
        
        subject=new JLabel("Subject");
        subject.setBounds(45, 235, 80, 25);
        super.add(subject);
        tsubject=new JTextField();
        tsubject.setBounds(130, 235, 150, 25);
        super.add(tsubject);
        
        mobile=new JLabel("Mobile");
        mobile.setBounds(45, 280, 80, 25);
        super.add(mobile);
        tmobile=new JTextField();
        tmobile.setBounds(130, 280, 200, 25);
        super.add(tmobile);
        
        salary=new JLabel("Salary");
        salary.setBounds(45, 320, 80, 25);
        super.add(salary);
        tsalary=new JTextField();
        tsalary.setBounds(130, 320, 200, 25);
        super.add(tsalary);
        
        ok=new JButton("OK");
        ok.setBounds(120, 350, 70, 30);
        ok.setBackground(Color.cyan);
        super.add(ok);
        ok.addActionListener(this);
        
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
        try 
        {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherproject","root", "Rohit");
			 Statement stmt=con.createStatement();
			 
			 ResultSet rs=stmt.executeQuery("select * from teachinfo where Tid ='"+Teacher.Tid_no+"'");
			 if(rs.next())
			 {
				 tTid.setText(rs.getString(1));      tTid.setEditable(false);
				 tName.setText(rs.getString(2));     tName.setEditable(false);
				 taddress.setText(rs.getString(3));  taddress.setEditable(false);
				 tgender.setText(rs.getString(4));   tgender.setEditable(false);
				 tsubject.setText(rs.getString(5));  tsubject.setEditable(false);
				 tmobile.setText(rs.getString(6));   tmobile.setEditable(false);
				 tsalary.setText(rs.getString(7));   tsalary.setEditable(false);
			 }
		} 
              catch (ClassNotFoundException e)
              {
			  e.printStackTrace();
		      } 
        catch (SQLException e) 
        {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == ok)
		   {
			   super.dispose();
			   Dashboard d=new Dashboard();
			   d.home();
		   }
		
	}
  
}
