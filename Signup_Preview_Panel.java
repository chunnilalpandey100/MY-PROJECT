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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Signup_Preview_Panel extends JFrame implements ActionListener 
{
	JLabel name,email,mobile,section,background;
    JTextField tname,temail,tmobile;
    JButton OK;
    
    public void OK()
    {
       	section=new JLabel(" SIGNUP SUCCESSFULL!! ");
    	section.setBounds(120, 30, 500, 10);
    	super.add(section);
    	
    	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\signup.png"));
    	background.setBounds(90, 50, 550,250);
    	super.add(background);
    	
    	super.setBounds(300, 150, 650, 400);
    	super.setTitle("PREVIEW");
    	super.setResizable(true);
    	
    	name= new JLabel("Name");
    	name.setBounds(45, 50, 80, 25);
    	super.add(name);
    	tname=new JTextField();
    	tname.setBounds(130, 50, 220, 25);
    	tname.setBackground(Color.cyan);
    	super.add(tname);
    	
    	email=new JLabel("Email");
    	email.setBounds(45, 85, 80, 25);
    	super.add(email);
        temail=new JTextField();
        temail.setBounds(130, 85, 220, 25);
        temail.setBackground(Color.cyan);
        super.add(temail);
        
        mobile=new JLabel("Mobile no.");
        mobile.setBounds(45, 120, 80, 25);
        super.add(mobile);
        tmobile=new JTextField();
        tmobile.setBounds(130, 120, 220, 25);
        tmobile.setBackground(Color.cyan);
        super.add(tmobile);
         
        OK=new JButton("BACK");
        OK.setBounds(180, 300, 90, 27);
        OK.setBackground(Color.cyan);
        super.add(OK);
        OK.addActionListener(this);
        
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        try 
        {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject", "root", "Rohit");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("Select * from userinfo where email='"+Signup.email_id+"'");
			if(rs.next())
			{
				tname.setText(rs.getString(1));          tname.setEditable(false);
				temail.setText(rs.getString(2));         temail.setEditable(false);
				tmobile.setText(rs.getString(3));        tmobile.setEditable(false);
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
      if(e.getSource()==OK)
      {
    	  super.dispose();
    	  HomePage hp=new HomePage();
    	  hp.home();	  
      }
		
	}
  
}
