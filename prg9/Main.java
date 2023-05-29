package prg9;
import java.util.*;
class thread1 extends Thread
{
	String[] dig = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	public void run()
	{
		try {
			Scanner sc = new Scanner(System.in);
			//System.out.println("enter 4 digit number");
			int n = sc.nextInt();
			String num = String.valueOf(n);
			if(num.length() < 4)
				throw new Exception();
			else
			{
				while(n != 0)
				{
					int i = n % 10;
					System.out.println(dig[i]);
					n = n / 10;
				}
			}
		}
		catch(Exception err)
		{
			System.out.println("wrong input......enter 4 digit number");
		}
		
	}
	
	
}
class thread2 extends Thread
{
	Scanner sc = new Scanner(System.in);
	public void run()
	{
		//System.out.println("enter word");
		String word = sc.next();
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		for(char ch : word.toCharArray())
		{
			switch(ch)
			{
			case 'a': a++; break;
			case 'e': e++; break;
			case 'i': i++; break;
			case 'o': o++; break;
			case 'u': u++; break;
			}
		}
		if(a>0) System.out.println("a : " + a);
		if(e>0) System.out.println("e : " + e);
		if(i>0) System.out.println("i : " + i);
		if(o>0) System.out.println("o : " + o);
		if(u>0) System.out.println("u : " + u);
	}
}

public class Main {

	public static void main(String[] args) {
		
		thread1 obj1 = new thread1();
		thread2 obj2 = new thread2();
		obj1.start();
		obj2.start();

	}

}
