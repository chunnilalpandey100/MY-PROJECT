import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student extends JFrame implements ActionListener
{
	    JLabel studentname,fathersname,mobile,address,dob,
	    admissiondate,section,background,gender,standard,fee;
	    JTextField tstudent,tfathers,tmobile,tdob,tadmission ;
	    JTextArea taddress;
	    JComboBox<String> list;
	    JComboBox<Integer> list1,list2;
	    JScrollPane pane;
	    JButton Register,Back,clickhere,Records;
	    static String mobile_no;
	    
	    public void Student()
	    {
	    	super.setBounds(300, 250, 650, 480);
	    	super.setTitle("STUDENT PANEL");
	    	super.setResizable(!false);
	    	 
//	        background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\Classroom.jpg"));
//	    	background.setBounds(100, 50, 550,250);
//	    	super.add(background);
	    	
	    	section=new JLabel(" WELCOME TO STUDENT PORTAL");
	    	section.setBounds(120, 30, 650, 10);
	    	super.add(section);
	    	
	    	studentname= new JLabel(" Student Name");
	    	studentname.setBounds(40, 50, 100, 30);
	    	super.add(studentname);
	    	tstudent=new JTextField();
	    	tstudent.setBounds(130, 50, 220, 25);
	    	super.add(tstudent);
	        
	    	fathersname=new JLabel("Father's name");
	    	fathersname.setBounds(40, 85, 80, 25);
	    	super.add(fathersname);
	        tfathers=new JTextField();
	        tfathers.setBounds(130, 85, 220, 25);
	        super.add(tfathers);
	        
	        mobile=new JLabel("Mobile no.");
	        mobile.setBounds(45, 120, 80, 25);
	        super.add(mobile);
	        tmobile=new JTextField();
	        tmobile.setBounds(130, 120, 220, 25);
	        super.add(tmobile);
	        
	        address=new JLabel("Address");
	        address.setBounds(45, 155, 80, 25);
	        super.add(address);
	        taddress=new JTextArea();
	        pane=new JScrollPane(taddress);
	        pane.setBounds(130, 155, 220, 70);
	        super.add(pane);
	        
	        admissiondate=new JLabel("Date of admi");
	        admissiondate.setBounds(45, 235, 80, 25);
	        super.add(admissiondate);
	        tadmission=new JTextField();
	        tadmission.setBounds(130, 235, 220, 25);
	        super.add(tadmission);
	 
	        gender=new JLabel("Gender");
	        gender.setBounds(45,270, 80, 25);
	        super.add(gender);
	        String[] gender= {"Male","Female","Others"};
	        list=new JComboBox<String>(gender);
	        list.setBounds(130, 270, 80, 25);
	        super.add(list);
	        
	        dob=new JLabel("DOB");
	        dob.setBounds(45, 300, 70, 25);
	        super.add(dob);
	        tdob=new JTextField();
	        tdob.setBounds(130, 300, 220, 25);
	        super.add(tdob);
	        
	        Records=new JButton("click here to see the records of students ");
	        Records.setBounds(350, 300, 280, 25);
	        Records.setBackground(Color.cyan);
	        super.add(Records);
	        Records.addActionListener(this);;
	        
	        standard=new JLabel("Standard");
	        standard.setBounds(370, 50, 90, 25);
	        super.add(standard);
	        Integer[] standard = {0,6,7,8,9,10,11,12};
	        list1=new JComboBox<Integer>(standard);
	        list1.setBounds(470, 50, 70, 25);
	        super.add(list1);
	        
	        fee=new JLabel("Fee");
	        fee.setBounds(370,80 , 90, 25);
	        super.add(fee);
	        Integer[] fee = {0,6000,7000,8000,9000,10000,11000,12000};
	        list2=new JComboBox<Integer>(fee);
	        list2.setBounds(470, 80, 100, 25);
	        super.add(list2);
	        
	        Register=new JButton("Register");
	        Register.setBounds(180, 350, 90, 27);
	        Register.setBackground(Color.cyan);
	        super.add(Register);
	        Register.addActionListener(this);
	        
	        Back=new JButton("Back");
	        Back.setBounds(80, 350, 90, 27);
	        Back.setBackground(Color.cyan);
	        super.add(Back);
	        Back.addActionListener(this);
	        
	        clickhere=new JButton("Click here to delete student records");
	        clickhere.setBounds(300, 350, 250, 27);
	        clickhere.setBackground(Color.cyan);
	        super.add(clickhere);
	        clickhere.addActionListener(this);
	        
	        super.setLayout(null);
	        super.setVisible(true);
	        super.setDefaultCloseOperation(EXIT_ON_CLOSE);           
	    }
		
	    
	public void actionPerformed(ActionEvent e) 
	{
		String gender = String.valueOf(list.getItemAt(list.getSelectedIndex()));
		int standard = list1.getItemAt(list1.getSelectedIndex());
		int fee = list2.getItemAt(list2.getSelectedIndex());
		if(e.getSource()==Back)
		{
			super.dispose();
			Dashboard d=new Dashboard();
			d.home();
		}
		else if(e.getSource()==clickhere)
		{
			super.dispose();
			TimeTable t=new TimeTable();
			t.Time();
		}
		else if(e.getSource()==Records)
		{
			super.dispose();
			Student_Records sr=new Student_Records();
			sr.MyRecords();
		}
		else if(e.getSource()==Register)
		{
			if(tstudent.getText().isEmpty()||tmobile.getText().isEmpty()||tdob.getText().isEmpty()||tadmission.getText().isEmpty()||taddress.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "All fields are required to be filled.");
			}
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproject","root", "Rohit");
			Statement stmt = con.createStatement();	
			{
			mobile_no = tmobile.getText();
			char[] name = tstudent.getText().toUpperCase().toCharArray();
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
				if(list1.getItemAt(list1.getSelectedIndex()).equals(0))
				{
					JOptionPane.showMessageDialog(null, "invalid selected Class");
				}
				else
				{
					if(list2.getItemAt(list2.getSelectedIndex()).equals(0))
					{
						JOptionPane.showMessageDialog(null, "Invalid selected fee ");
					}
					else
					{
						if(tmobile.getText().length()==10)
						{
							stmt.executeUpdate("Insert into studinfo values('"+tstudent.getText()+"','"+tfathers.getText()+"','"+tmobile.getText()+"','"+taddress.getText()+"','"+tdob.getText()+"','"+tadmission.getText()+"','"+gender+"','"+standard+"','"+fee+"')");
							
							JOptionPane.showMessageDialog(null, "Hello "+tstudent.getText()+"! You are registered in our School database and we are redirecting to Preview Page for See your information.");
							super.dispose();
							Studentpreview sp = new Studentpreview();
							sp.Student1();		
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
	