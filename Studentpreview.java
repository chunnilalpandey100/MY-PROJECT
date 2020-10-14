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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Studentpreview extends JFrame implements ActionListener
{
	
	JLabel studentname,fathersname,mobile,address,dob,admissiondate,section,background,gender,standard,fee;
    JTextField tstudent,tfathers,tmobile,tdob,tadmission,tgender,tstandard,tfee ;
    JTextArea taddress;
    JScrollPane pane;
    JButton ok;
    
   public void Student1()
   {
    super.setBounds(300, 250, 600, 450);
   	super.setTitle("PREVIEW PANEL");
   	super.setResizable(!false);
   
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
    tgender=new JTextField();
    tgender.setBounds(130, 270, 80, 25);
    super.add(tgender);
    
    dob=new JLabel("DOB");
    dob.setBounds(45, 300, 70, 25);
    super.add(dob);
    tdob=new JTextField();
    tdob.setBounds(130, 300, 220, 25);
    super.add(tdob);
    
    standard=new JLabel("Standard");
    standard.setBounds(370, 50, 90, 25);
    super.add(standard);
    tstandard=new JTextField();
    tstandard.setBounds(470, 50, 70, 25);
    super.add(tstandard);
    
    fee=new JLabel("Fee");
    fee.setBounds(370, 80, 90, 25);
    super.add(fee);
    tfee=new JTextField();
    tfee.setBounds(470, 80, 100, 25);
    super.add(tfee);
    
    ok=new JButton("OK");
    ok.setBounds(120, 350, 70, 30);
    ok.setBackground(Color.cyan);
    super.add(ok);
    ok.addActionListener(this);
    
    super.setLayout(null);
    super.setVisible(true);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);  
    
    try 
    {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproject","root", "Rohit");
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from studinfo where mobileno = '"+Student.mobile_no+"'");
		if(rs.next())
		{
			tstudent.setText(rs.getString(1));	tstudent.setEditable(false);
			tfathers.setText(rs.getString(2));  tfathers.setEditable(false);
			tmobile.setText(rs.getString(3));   tmobile.setEditable(false);
			taddress.setText(rs.getString(4));  taddress.setEditable(false);
			tdob.setText(rs.getString(5));       tdob.setEditable(false);
			tadmission.setText(rs.getString(6)); tadmission.setEditable(false);
			tgender.setText(rs.getString(7));    tgender.setEditable(false);
			tstandard.setText(rs.getString(8));  tstandard.setEditable(false);
			tfee.setText(rs.getString(9));       tfee.setEditable(false);
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
	   if(e.getSource() == ok)
	   {
		   JOptionPane.showMessageDialog(null, "Back to Form Panel");
		   super.dispose();
		   Student sp=new Student ();
		   sp.Student();
	   }
	}
}
  

