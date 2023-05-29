package prg5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class custcred extends JFrame implements ActionListener {
	
	static Connection c;
	static Statement s;
	JFrame jf = new JFrame("JDBC");
	JPanel jp = new JPanel();
	JButton jb1 = new JButton("submit");
	JLabel cno = new JLabel("enter customer number");
	JTextField cnum = new JTextField(10);
	JLabel cn = new JLabel("enter customer name");
	JTextField cname = new JTextField(10);
	JLabel cs = new JLabel("enter customer state");
	JTextField cstate = new JTextField(10);
	JLabel cr = new JLabel("enter credit limit");
	JTextField ccredit = new JTextField(10);
	JLabel rep = new JLabel("enter rep no");
	JTextField repno = new JTextField(10);
	custcred()
	{
		jf.setSize(500, 500);
		jf.add(jp);
		jp.add(cno); jp.add(cnum);
		jp.add(cn); jp.add(cname);
		jp.add(cs); jp.add(cstate);
		jp.add(cr); jp.add(ccredit);
		jp.add(rep); jp.add(repno);
		jb1.addActionListener(this);
		jp.add(jb1);
		jf.setVisible(true);		
	}

	public static void main(String[] args) throws Exception {
		
		custcred cd = new custcred();
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "12345");
		//c.toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jb1)
		{
			int cno = Integer.parseInt(cnum.getText());
			String cn = cname.getText();
			String cs = cstate.getText();
			int cr = Integer.parseInt(ccredit.getText());
			int rep = Integer.parseInt(repno.getText());
			
			try
			{
				s = (Statement)c.createStatement();
				String querrytoupdate = String.format("insert into customer (custno, custname, state, creditlimit, repno) values (%d, '%s', '%s', %d, %d)", cno, cn, cs, cr, rep);
				int rs = s.executeUpdate(querrytoupdate);	
				String querry = String.format("select * from customer where creditlimit > 15000");
				ResultSet rs1 = s.executeQuery(querry);
				while(rs1.next())
				{
					System.out.print("customer number: " + rs1.getInt("custno"));  
					System.out.print("customer name: " +  rs1.getString("custname"));
					System.out.print("customer state: " +  rs1.getString("state"));
					System.out.print("customer credit : " + rs1.getInt("creditlimit"));
					System.out.print("customer rep no: " + rs1.getInt("repno"));		
				}
				s.close();
				c.close(); 
			}
			catch(Exception err)
			{
				System.out.println(err);
			}
		}
		
		
		
	}

}
