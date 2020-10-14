import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BankLogin extends JFrame implements ActionListener
{
    JButton hsignup,hlogin,signup,login;
    public void home()
    {
    	super.setBounds(100, 100, 400, 250);
    	super.setTitle("HOME PAGE");
    	super.setResizable(false);
    	
    	hsignup=new JButton("SIGN-UP");
    	hsignup.setBounds(130, 50, 100, 30);
    	super.add(hsignup);
    	hsignup.addActionListener(this);
    	
    	hlogin=new JButton("LOG-IN");
    	hlogin.setBounds(130, 110, 100, 30);
    	super.add(hlogin);
    	hlogin.addActionListener(this);
    	
    	super.setLayout(null);
    	super.setVisible(true);
    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    }
	
	public void actionPerformed(ActionEvent e)
	{
	      if(e.getSource()==hlogin)
	      {
	    	  dispose();
	    	  Login l= new Login();
	    	  l.login();
	      }
	      if(e.getSource()==hsignup)
	      {
	    	  dispose();
	    	  Signup s= new Signup();
	    	  s.signup();
	      }
	 	
	}
       public static void main(String[] args) 
	   {
    	   BankLogin b1=new BankLogin();
    	   b1.home();
	   }
}
