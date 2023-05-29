package prg4;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Market implements ActionListener{
	
	JLabel lno = new JLabel("enter phone number");
	JTextField phno = new JTextField(20);
	JLabel lcid = new JLabel("customer id ");
	JTextField cid = new JTextField(5);
	JButton getid = new JButton("Get id");
	JLabel litems = new JLabel("#1 --> Rs.60/-kg oranges  #2 --> Rs.120/-kg apples");
	JTextField item = new JTextField(5);
	JLabel lqty = new JLabel("enter the required quantity"); 
	JTextField qty = new JTextField(20);
	JRadioButton rdb = new JRadioButton("30% discount");
	JButton bill = new JButton("total bill");
	JTextField amt = new JTextField(20);

	HashMap<String, Integer> hm = new HashMap<>();
	HashMap<Integer, Integer> itemhm = new HashMap<>();
	
	void customer()
	{
		hm.put("9448596125", 120);
		hm.put("9535396125", 121);
		hm.put("9448140409", 122);
	}
	void additem()
	{
		itemhm.put(1, 60);
		itemhm.put(2, 120);
	}
	
	Market()
	{
		JFrame jf = new JFrame("customer billing");
		String uname = JOptionPane.showInputDialog(null, "enter the user name");
		String pswd = JOptionPane.showInputDialog(null, "enter the password");
		customer();
		additem();
		if(uname.equals("sanchi") && pswd.equals("12345"))
		{
			jf.setSize(500, 500);
			jf.setLayout(new FlowLayout());
			jf.add(lno); jf.add(phno);
			jf.add(getid);
			getid.addActionListener(this);
			jf.add(lcid); jf.add(cid);
			jf.add(litems); jf.add(item);
			jf.add(lqty); jf.add(qty);
			jf.add(rdb);
			jf.add(bill);
			bill.addActionListener(this);
			jf.add(amt);
			
			jf.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "invalid login");
		}
	}
	
	public static void main(String[] args) {
		Market m1 = new Market();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == getid)
		{
			String pno = phno.getText();
			if(hm.containsKey(pno))
			{
				JOptionPane.showMessageDialog(null, "customer aldready registered with id " + hm.get(pno));
				cid.setText(Integer.toString(hm.get(pno)));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "customer successfully registered with id " + 123);
				cid.setText(Integer.toString(123));
			}
			
		}
		else if(e.getSource() == bill)
		{
			int amount = 0;
			int q = Integer.parseInt(qty.getText());
			if(item.getText().equals("1"))
				amount = 60 * q ;
			if(item.getText().equals("2"))
				amount = 120 * q ;
			
			if(rdb.isSelected())
				amount -= amount*0.30;
			
			amt.setText("pay : " + amount);
			
		}
		
	}

}
