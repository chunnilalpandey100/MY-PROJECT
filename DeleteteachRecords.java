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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteteachRecords extends JFrame  implements ActionListener
{
	JButton Delete,Back;
	JLabel Tid,section,background;
	JTextField tTid;
	
	public void Delete()
	{
	super.setBounds(300, 250, 500, 450);
	super.setTitle("Teacher Delete Record form");
	super.setResizable(false);
	
	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\deleterecords.jpg"));
	background.setBounds(60, 50, 550,250);
	super.add(background);
	
	section=new JLabel(" DELETE RECORD OF A TEACHER");
	section.setBounds(120, 30, 500, 10);
	super.add(section);
	
	Tid= new JLabel(" Enter Id");
	Tid.setBounds(40, 50, 100, 25);
	super.add(Tid);
	tTid=new JTextField();
	tTid.setBounds(130, 50, 220, 25);
	super.add(tTid);	
	
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
			  Teacher t=new Teacher();
			  t.Teacher();
		  }
		  else if(e.getSource()==Delete)
		  {
			  if(tTid.getText().isEmpty())
			  {
				  JOptionPane.showMessageDialog(null, "Please Fill the Id Field to Delete the record of a teacher ");
			  }
			  else
			  {
				  try
				  {
					  Class.forName("com.mysql.jdbc.Driver");
					  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherproject","root", "Rohit");
					  Statement stmt = con.createStatement();
					  
					  ResultSet rs=stmt.executeQuery("select * from teachinfo where Tid= '"+tTid.getText()+"'");
					  if(rs.next())
					  {
					  stmt.executeUpdate("delete from teachinfo where Tid= '"+tTid.getText()+"'");
					  JOptionPane.showMessageDialog(null, "One record has been deleted");
					  super.dispose();
					  Teacher t=new Teacher();
					  t.Teacher();
					  }
					  else
					  {
						  JOptionPane.showMessageDialog(null, "Invalid record or Record not found in table");
						  super.dispose();
						  Teacher t=new Teacher();
						  t.Teacher();
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
