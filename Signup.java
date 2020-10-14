import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener 
{
    JLabel name,email,mobile,address,password,section,background;
    JTextField tname,temail,tmobile;
    JPasswordField tpassword;
    JTextArea taddress;
    JScrollPane pane;
    JButton signup;
    static String email_id;
    
    public void signup()
    {
       	section=new JLabel(" WELCOME TO SIGNUP SECTION ");
    	section.setBounds(120, 30, 500, 10);
    	super.add(section);
    	
    	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\signup.png"));
    	background.setBounds(90, 50, 550,250);
    	super.add(background);
    	
    	super.setBounds(300, 150, 650, 400);
    	super.setTitle("SIGN-UP");
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
        
        address=new JLabel("Address");
        address.setBounds(45, 155, 80, 25);
        super.add(address);
        taddress=new JTextArea();
        pane=new JScrollPane(taddress);
        taddress.setBackground(Color.cyan);
        pane.setBounds(130, 155, 220, 70);
        super.add(pane);
        
        password=new JLabel("Password");
        password.setBounds(45, 235, 80, 25);
        super.add(password);
        tpassword=new JPasswordField();
        tpassword.setBounds(130, 235, 220, 25);
        tpassword.setBackground(Color.cyan);
        super.add(tpassword);
        
        signup=new JButton("SIGN-UP");
        signup.setBounds(180, 300, 90, 27);
        signup.setBackground(Color.cyan);
        super.add(signup);
        signup.addActionListener(this);
        
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
           
    }
	
	public void actionPerformed(ActionEvent e) 
	{
	   if(e.getSource()==signup)
	   {
		   char[] pass=tpassword.getPassword();
		   String password="";
		   for (int i = 0; i < pass.length; i++) 
		   {
			password+=pass[i];
		}
		 if(tname.getText().isEmpty()||temail.getText().isEmpty()||tmobile.getText().isEmpty()||taddress.getText().isEmpty()||password.isEmpty())
		 {
			 JOptionPane.showMessageDialog(null, "All fields are required to be filled");
		 }
		 else
		 {
			 try
			 {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject", "root", "Rohit");
			 Statement stmt=con.createStatement();
			 email_id=temail.getText();
			 
			 ResultSet rs=stmt.executeQuery("select email from userinfo where email='"+temail.getText()+"'");
			 
			 char[] name = tname.getText().toUpperCase().toCharArray();
				int count1 = 0;
				for(char ch : name)
				{
					int a = ch;
					if(!(a == 32) && !(a>=65 && a<=90))
					{
						count1++;
					}
				}
				if(count1 > 0)
				{
					JOptionPane.showMessageDialog(null, "Invalid Name.");
				}
				else
				{
					 String email = temail.getText();
					 int num1=0,num2=0,num3=0;
						for (int i = 0; i < temail.getText().length(); i++)
						{
						  if(temail.getText().charAt(i)==' ')
						  {
							  num1++;
							  break;
						  }
						   if(temail.getText().charAt(i)=='@')
						  {
							  num2++;
						  }
						   if(email.charAt(i) == '.' && email.charAt(i+1) == '.')
							{
								num3++;
							}
						}   
						   if((num1 > 0) || (num2 > 1 || num2 < 1) || (num3 > 0) || (!email.endsWith("@gmail.com") || email.startsWith("@")))
							{
								JOptionPane.showMessageDialog(null, "Invalid Email.");
							}
						   
						  else 
						   {
							  if(rs.next())
								 { 
									 JOptionPane.showMessageDialog(null, "Email is already exists in our database Please try with another email.");
								 }
								 else
								 {
									 rs=stmt.executeQuery("select mobileno from userinfo where mobileno='"+tmobile.getText()+"'");
									 if(rs.next())
									 {
										 JOptionPane.showMessageDialog(null, "Mobile number is already exists in our database try with different number.");
									 }
									 else
									 {
										 if(tmobile.getText().length()==10)
										 {
											 stmt.executeUpdate("Insert into userinfo values('"+tname.getText()+"','"+temail.getText()+"','"+tmobile.getText()+"','"+taddress.getText()+"','"+password+"')");
											 JOptionPane.showMessageDialog(null, "Hello "+tname.getText()+"!You are registered in our database and we are redirecting you to Home Page for login.");
											 super.dispose();
											 Signup_Preview_Panel spp=new Signup_Preview_Panel();
											 spp.OK();	 
										 }
										 else
										 {
											 JOptionPane.showMessageDialog(null, "Invalid mobile no.");
										 }
										 
									 }
								 }
						   }
				}
		 }
			 catch(HeadlessException e1)
			 {
				 e1.printStackTrace();
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
