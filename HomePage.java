import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HomePage extends JFrame implements ActionListener
{
    JButton hsignup,hlogin,signup,login;
    JLabel school,background;
    public void home()
    {
    	school=new JLabel(" WELCOME TO SHREE ADARSH VIDHYA NIKETAN SR.SEC SCHOOL, BHILWARA");
    	school.setBounds(120, 20, 500, 10);
    	super.add(school);
    	
    	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\mschool.jpg"));
    	background.setBounds(90, 50, 550,250);
    	super.add(background);
    	
      	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\logo.png"));
    	background.setBounds(15, 20, 150,250);
    	super.add(background);
    	
    	super.setBounds(100, 50, 750,450);
    	super.setTitle("HOME PAGE");
    	super.setResizable(false);
    	
    	hsignup=new JButton("SIGN-UP");
    	hsignup.setBounds(620, 60, 100, 30);
    	hsignup.setBackground(Color.CYAN);
    	super.add(hsignup);
    	hsignup.addActionListener(this);
    	
    	hlogin=new JButton("LOG-IN");
    	hlogin.setBounds(620, 110, 100, 30);
    	hlogin.setBackground(Color.CYAN);
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
    	   HomePage b1=new HomePage();
    	   b1.home();
	   }
}
