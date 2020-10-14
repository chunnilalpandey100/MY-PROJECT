import java.awt.Color;
import java.awt.HeadlessException;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener 
{
    JLabel email,mobile,password,or,section,background;
    JTextField temail,tmobile;
    JPasswordField tpassword;
    JButton login;
    
    public void login()
    {
    	super.setBounds(450, 170, 670, 320);
    	super.setTitle("LOG-IN");
    	super.setResizable(false);
    	
    	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\login.jpg"));
    	background.setBounds(100, 50, 550,250);
    	super.add(background);
    	
    	section=new JLabel(" ALREADY SIGNUP THEN LOGIN HERE FOR NEXT STEP ");
    	section.setBounds(120, 30, 500, 10);
    	super.add(section);
    	
    	email=new JLabel("Email");
    	email.setBounds(30, 50, 80, 25);
    	super.add(email);
    	temail=new JTextField();
    	temail.setBounds(110, 50, 200, 25);
    	super.add(temail);
    	
    	or=new JLabel("OR");
    	or.setBounds(35, 80, 50 ,20);
    	super.add(or);
    	
    	mobile=new JLabel("MOBILE NO.");
    	mobile.setBounds(30, 110, 80, 25);
    	super.add(mobile);
    	tmobile=new JTextField();
    	tmobile.setBounds(110, 110, 200, 25);
    	super.add(tmobile);
    	
    	password=new JLabel("Password");
    	password.setBounds(30, 145, 80, 25);
    	super.add(password);
    	tpassword=new JPasswordField();
    	tpassword.setBounds(110, 145, 200, 25);
    	super.add(tpassword);
    	
    	login=new JButton("LOG-IN");
    	login.setBounds(30, 195, 80, 25);
    	login.setBackground(Color.cyan);
    	super.add(login);
    	login.addActionListener(this);
    	
    	super.setLayout(null);
    	super.setVisible(true);
    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==login)
		{			
			if(!temail.getText().isEmpty()&&!tmobile.getText().isEmpty())
			{
			   JOptionPane.showMessageDialog(null," Only one field is required to filled (either Email or Mobile no.)");	
			}
			else 
			{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject", "root", "Rohit");
					Statement stmt=con.createStatement();
					
					char[] pass=tpassword.getPassword();
					String password="";
					for (int i = 0; i < pass.length; i++) 
					{
					      password+=pass[i];
					}
					ResultSet rs=stmt.executeQuery("select name from userinfo where Email='"+temail.getText()+"'AND password='"+password+"'");
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Hello  " +rs.getString(1)+ "!You have successfully logged in.");
						super.dispose();
						Dashboard d=new Dashboard();
						d.home();
					}
					else
					{
						rs=stmt.executeQuery("select Name from userinfo where mobileno='"+tmobile.getText()+"'AND password='"+password+"'");
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "Hello  "  +rs.getString(1)+ "!You have successfully logged in.");
							super.dispose();
							Dashboard d=new Dashboard();
							d.home();
						}
						else
						{
						  JOptionPane.showMessageDialog(null, " Invalid login credentials"); 
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
