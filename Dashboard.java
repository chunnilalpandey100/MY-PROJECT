import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener
{
	 JButton hnewstudentreg,hteacherdetails,student,teacherdetails,hBack,Back;
	 JLabel background,click1,click2,click3;
	 
	    public void home()
	    {
	    	super.setBounds(170, 250, 700, 280);
	    	super.setTitle("DASHBOARD");
	    	super.setResizable(true);
	    	
	    	background=new JLabel(new ImageIcon ("C:\\Users\\lenovo\\Downloads\\homepage.jpg"));
	    	background.setBounds(60, 30, 600,250);
	    	super.add(background);
	    	
	    	hnewstudentreg=new JButton("New student details");
	    	hnewstudentreg.setBounds(130, 50, 180, 30);
	    	hnewstudentreg.setBackground(Color.cyan);
	    	super.add(hnewstudentreg);
	    	hnewstudentreg.addActionListener(this);
	    	
	    	click1=new JLabel("Click above button to register or delete new Records of students");
	    	click1.setBounds(130, 80, 390, 30);
	    	super.add(click1);
	    	
	    	hteacherdetails=new JButton("Teacher details");
	    	hteacherdetails.setBounds(130, 110, 180, 30);
	    	hteacherdetails.setBackground(Color.cyan);
	    	super.add(hteacherdetails);
	    	hteacherdetails.addActionListener(this);
	    	
	    	click2=new JLabel("click above button to add or delete Records of teacher");
	    	click2.setBounds(130, 140, 480, 30);
	    	super.add(click2);
	    	
	    	hBack=new JButton("Log-Out");
	    	hBack.setBounds(130, 170, 180, 30);
	    	hBack.setBackground(Color.cyan);
	    	super.add(hBack);
	    	hBack.addActionListener(this);
	    	
	    	click3=new JLabel("click above button to Permanent logout");
	    	click3.setBounds(130, 200, 400,30);
	    	super.add(click3);
	    	
	    	super.setLayout(null);
	    	super.setVisible(true);
	    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	
	    }
		
public void actionPerformed(ActionEvent e) 
{
	if(e.getSource()==hnewstudentreg)
	{
		dispose();
		Student s=new Student();
		s.Student();
	}
	
	if(e.getSource()==hteacherdetails)
	{
		dispose();
		Teacher t=new Teacher();
		t.Teacher();
	}
	if(e.getSource()==hBack)
	{
		JOptionPane.showMessageDialog(null, "You are successfully log out");
		dispose();
		Login lg=new Login();
		lg.login();
	}
}
public static void main(String[] args) 
{
	HomePage b2=new HomePage();
	b2.home();
}

}
