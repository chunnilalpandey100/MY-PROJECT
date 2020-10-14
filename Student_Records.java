import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.sql.Statement;

public class Student_Records extends JFrame implements ActionListener
{
   JLabel studentname,fathersname;
   JTextArea Records;
   JScrollPane pane;
   JButton ok,seeRecords,TimeTable;
   public void MyRecords()
   {
	   super.setBounds(450, 200, 600, 480);
	   super.setTitle("Student Records Page");
	   super.setResizable(false);
	   
	   Records=new JTextArea();
	   pane=new JScrollPane(Records);
	   pane.setBounds(25, 50, 550, 350);
	   Records.setEditable(false);
	   super.add(pane);
	   
	   try
	   {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproject","root", "Rohit");
		Statement stmt = con.createStatement();	
	    ResultSet rs=stmt.executeQuery("select * from studinfo ");
	    while(rs.next())
		 {
	    	 Records.append(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7)+"\t\t"+rs.getInt(8)+"\t\t"+rs.getInt(9)+"\n=================================================================================================================\n");   
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
	   
	   ok=new JButton("OK");
	   ok.setBounds(108, 20, 60, 25);
	   ok.setBackground(Color.cyan);
	   super.add(ok);
	   ok.addActionListener(this);
	   
	   seeRecords=new JButton("RECORDS");
	   seeRecords.setBounds(180, 20, 95, 25);
	   seeRecords.setBackground(Color.cyan);
	   super.add(seeRecords);
	   seeRecords.addActionListener(this);
	   
	   TimeTable=new JButton("Class Time Table");
	   TimeTable.setBounds(300, 20, 130, 25);
	   TimeTable.setBackground(Color.cyan);
	   super.add(TimeTable);
	   TimeTable.addActionListener(this);
	   
	   super.setLayout(null);
	   super.setVisible(true);
	   super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
      }
	
	  public void actionPerformed(ActionEvent e) 
	   {
		if(e.getSource()==ok)
		{
			super.dispose();
			Student sp=new Student();
			sp.Student();
		}
		else if(e.getSource()==seeRecords)
		{
			super.dispose();
			StudentFewRecords sfr=new StudentFewRecords();
			sfr.ShowFewDetails();
		}
		else if(e.getSource()==TimeTable)
		{
			super.dispose();
			Class_Periods cp= new Class_Periods();
			cp.MyClassTimeTable();
		}
		
	}
  
}
