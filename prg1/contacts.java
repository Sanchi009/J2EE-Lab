package prg1;
import java.util.*;
class misscall
{
	long number;
	String name;
	misscall(long num, String name)
	{
		this.number = num;
		this.name = name;
	}
	
	public void display()
	{
		System.out.println(" number : " + String.valueOf(number) + " name: "+ name);
	}
}

public class contacts {

	public static void main(String[] args) {
		
		HashMap<Long, String> hm = new HashMap<>();
		ArrayList<misscall> missedlist = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter phone no and name of 3 friends");
		for(int i = 0; i < 3; i++)
		{
			System.out.println("Phone no: ");
			Long n = sc.nextLong();
			System.out.println("Name : ");
			String name = sc.next();
			hm.put(n, name);
		}
		
		System.out.println("Friends in contact list: ");
		System.out.println(hm);
		
	
		for(int i = 0; i < 2; i++)
		{
			System.out.println("enter missed call number");
			long number = sc.nextLong();
			if(hm.containsKey(number))
				missedlist.add(new misscall(number, hm.get(number)));
			else
				missedlist.add(new misscall(number, "private caller"));		
		}
		System.out.println("missed call contact details");
		for(misscall m : missedlist)
		{
			m.display();
		}
		
		System.out.println("enter the number you want delete ");
		long num = sc.nextLong();
		if(hm.containsKey(num))
		{
			System.out.println("list after deletion");
			hm.remove(num);
			System.out.println(hm);
		}
		else
		{
			System.out.println("contact does not exists");
		}
	}

}
