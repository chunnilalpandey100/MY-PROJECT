import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class TimeTable extends JFrame  implements ActionListener
{
	JButton Delete,Back;
	JLabel studentname,section,background;
	JTextField tstudent;
	
	public void Time()
	{
		super.setBounds(300, 250, 500, 450);
    	super.setTitle("Class Student Delete Record form");
    	super.setResizable(false);
    	
    	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\deleterecords.jpg"));
    	background.setBounds(100, 50, 550,250);
    	super.add(background);
    	
    	section=new JLabel(" Delete record of a student");
    	section.setBounds(120, 30, 500, 10);
    	super.add(section);
    	
    	studentname= new JLabel(" Student Name");
    	studentname.setBounds(40, 50, 100, 25);
    	super.add(studentname);
    	tstudent=new JTextField();
    	tstudent.setBounds(130, 50, 220, 25);
    	super.add(tstudent);	
    	
    	Back = new JButton("Back");
		Back.setBounds(205, 380, 80, 25);
		Back.setBackground(Color.cyan);
		super.add(Back);
		Back.addActionListener(this);
		
		Delete =new JButton("Delete");
		Delete.setBounds(300, 380, 80, 25);
		Delete.setBackground(Color.cyan);
    	super.add(Delete);
    	Delete.addActionListener(this);
    	
    	super.setLayout(null);
 	    super.setVisible(true);
 	    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
	  if(e.getSource()==Back)
	  {
		  super.dispose();
		  Student s=new Student();
		  s.Student();
	  }
	  else if(e.getSource()==Delete)
	  {
		  if(tstudent.getText().isEmpty())
		  {
			  JOptionPane.showMessageDialog(null, "Please Fill the required Field to Delete the records of a student  ");
		  }
		  else
		  {
			  try
			  {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproject","root", "Rohit");
				  Statement stmt = con.createStatement();
				  
				  ResultSet rs=stmt.executeQuery("select * from studinfo where name= '"+tstudent.getText()+"'");
				  if(rs.next())
				  {
				  stmt.executeUpdate("delete from studinfo where name= '"+tstudent.getText()+"'");
				  JOptionPane.showMessageDialog(null, "One record has been deleted");
				  super.dispose();
				  TimeTable tb=new TimeTable();
				  tb.Time();
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(null, "Invalid record or Record not found in table");
					  super.dispose();
					  TimeTable tb=new TimeTable();
					  tb.Time();
				  }
			   
			  }
		  
			  catch(ClassNotFoundException e1)
			  {
				  e1.printStackTrace();
			  }
			  catch(SQLException e1)
			  {
				  e1.printStackTrace();
			  }
		  }
		  
	  }
	  
	}

 
}
