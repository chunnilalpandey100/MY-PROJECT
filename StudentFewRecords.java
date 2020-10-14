import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StudentFewRecords extends JFrame implements ActionListener 
{
	JLabel studentname,fathersname;
	JTextArea Records;
	JScrollPane pane;
    JButton ok;
    public void ShowFewDetails()
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
 	    ResultSet rs=stmt.executeQuery("select name,fathers_name,fee from studinfo where  fee >=8000");
 	    while(rs.next())
 		 {
 	    	 Records.append(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\n=================================================================================================================\n");   
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
			
		
	}

}
