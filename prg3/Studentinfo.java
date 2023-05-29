package prg3;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Studentinfo implements ActionListener{
	
	static JFrame jf = new JFrame("student info");
	static JTextField usn = new JTextField(20);
	static JTextField name = new JTextField(20);
	static JTextField age = new JTextField(20);
	static JTextField cat = new JTextField(20);
	static JTextField address = new JTextField(20);
	static JTextField sg[] = new JTextField[8];
	//static JTextField cgpa = new JTextField(10);
	static JButton verify = new JButton("verify");
	static JButton submit = new JButton("submit");
	static JButton display = new JButton("display");
	
	static ArrayList<Student> list = new ArrayList<>();
	
	public static void main(String[] args) {
		jf.setSize(800, 600);
		jf.setLayout(new FlowLayout());
		jf.add(new JLabel("student usn: "));
		jf.add(usn);
		jf.add(new JLabel("student name: "));
		jf.add(name);
		jf.add(new JLabel("student age: "));
		jf.add(age);
		jf.add(new JLabel("student cat: "));
		jf.add(cat);
		jf.add(new JLabel("student address: "));
		jf.add(address);
		for(int i = 0; i < sg.length; i++)
		{
			sg[i] = new JTextField(5);
			jf.add(new JLabel("sgpa "+(i+1)));
			jf.add(sg[i]);
		}
		verify.addActionListener(new Studentinfo());
		submit.addActionListener(new Studentinfo());
		display.addActionListener(new Studentinfo());
		jf.add(verify);
		jf.add(submit);
		jf.add(display);
		jf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == verify)
		{
			int a = Integer.parseInt(age.getText());
			if(a > 30 || a < 15)
			{
				System.out.println("invalid age");
				String temp = JOptionPane.showInputDialog(null,"enter age between 15-30");
				age.setText(temp);
			}
			else
			{
				System.out.println("valid age");
			}

			for (int i = 0; i < sg.length; i++) {
				try {
					double gpa = Double.parseDouble(sg[i].getText());
					if(( gpa> 10)) {
						JOptionPane.showMessageDialog(sg[i], "Enter valid SGPA");
						sg[i].requestFocus();
					}
				}catch(Exception exec) {
					JOptionPane.showMessageDialog(sg[i], "Invalid Entry");
					sg[i].requestFocus();
				}
			}
			
			
		}
		else if(e.getSource() == submit)
		{
			double[] sgpa = new double[8];
			for(int i = 0; i < sg.length; i++)
			{
				sgpa[i] = Double.parseDouble(sg[i].getText());
			}
			double cg = Arrays.stream(sgpa).sum()/8.0;
			list.add(new Student(usn.getText(), name.getText(), age.getText(), cat.getText(), address.getText(), cg));
		}
		else if(e.getSource() == display)
		{
				JFrame jf2 = new JFrame("display");
				jf.setVisible(false);
				jf2.setVisible(true);
				JTextArea ta = new JTextArea();
				for(Student s : list)
					ta.append(s.tostring());
				jf2.add(ta);
				jf2.setVisible(true);
		}
	}

}
