import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Teacher extends JFrame  implements ActionListener
{
    JLabel Tid,Name,address,gender,subject,mobile,salary,section,background;
    JTextField  tTid,tName,tsubject,tmobile,tsalary;
    JTextArea taddress;
    JComboBox<String> list;
    JScrollPane pane;
    JButton Save,Back,click_here_to_delete_record,Records;
    static String Tid_no;
    
    public void Teacher()
    {
    	super.setBounds(300, 250, 600, 500);
    	super.setTitle("TEACHER PANEL");
    	super.setResizable(false);
    	
    	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\Classroom.jpg"));
    	background.setBounds(100, 50, 550,250);
    	super.add(background);
    	
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
        String[] gender= {"Male","Female","Others"};
        list=new JComboBox(gender);
        list.setBounds(130, 190, 80, 25);
        super.add(list);
        
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
        
        Records=new JButton("Records of Staff");
        Records.setBounds(320, 320, 200, 25);
        Records.setBackground(Color.cyan);
        super.add(Records);
        Records.addActionListener(this);
        
        Save=new JButton("Save");
        Save.setBounds(120, 380, 80, 25);
        Save.setBackground(Color.cyan);
        super.add(Save);
        Save.addActionListener(this);
        
        Back = new JButton("Back");
		Back.setBounds(205, 380, 80, 25);
		Back.setBackground(Color.cyan);
		super.add(Back);
		Back.addActionListener(this);
		
		click_here_to_delete_record=new JButton("Delete teacher record");
		click_here_to_delete_record.setBounds(290, 380, 160, 25);
		click_here_to_delete_record.setBackground(Color.cyan);
		super.add(click_here_to_delete_record);
		click_here_to_delete_record.addActionListener(this);
        
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
	public void actionPerformed(ActionEvent e) 
	{
		String gender = String.valueOf(list.getItemAt(list.getSelectedIndex()));
	 	if(e.getSource()==Back)
	 	{
	 		super.dispose();
	 		Dashboard d=new Dashboard();
	 		d.home();
	 	}
	 	else if(e.getSource()==click_here_to_delete_record)
	 	{
	 		super.dispose();
	 		DeleteteachRecords dtr=new DeleteteachRecords();
	 		dtr.Delete();
	 	}
	 	else if(e.getSource()==Records)
	 	{
	 		super.dispose();
	 		Teachers_Records tr=new Teachers_Records();
	 		tr.StaffRecords();
	 	}
	 	else if(e.getSource()==Save)
	 	{
	 	
	      if(tTid.getText().isEmpty()||tName.getText().isEmpty()||tsubject.getText().isEmpty()||tmobile.getText().isEmpty()||tsalary.getText().isEmpty()||taddress.getText().isEmpty())
		 {
			 JOptionPane.showMessageDialog(null, "All fields are required to be filled");
		 }
	 		else
	 		{
	 			try
	 			{
	 			
	 			 Class.forName("com.mysql.jdbc.Driver");
	 			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherproject","root", "Rohit");
	 			 Statement stmt=con.createStatement();
	 			 {
	 			 Tid_no=tTid.getText();
	 			char[] name = tName.getText().toUpperCase().toCharArray();
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
					if(tmobile.getText().length()==10)
					{
						 stmt.executeUpdate("Insert into teachinfo values('"+tTid.getText()+"','"+tName.getText()+"','"+taddress.getText()+"','"+gender+"','"+tsubject.getText()+"','"+tmobile.getText()+"','"+tsalary.getText()+"')");
			 			 
			 			 JOptionPane.showMessageDialog(null, "Hello "+tName.getText()+",You are Register in our school techer database,we are redirecting to our dashboard");
			 			 super.dispose();
			 			 Treacherpreview tp=new Treacherpreview();
			 			 tp.Teachers();	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid mobile no.");
					}	
				}
	 			}
	 			}
	 			catch (HeadlessException e1)
				{
					e1.printStackTrace();
				}
				catch (ClassNotFoundException e1)
				{
					e1.printStackTrace();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
	 		}
	 	}
		
	}

}
