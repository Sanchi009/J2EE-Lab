package prg2;
import java.util.*;
class book{
	String title, author, publisher;
	double price;
	book(String title, String author, String publisher, double price)
	{
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	void display()
	{
		System.out.println("title: " + title + " author: " + author + " publisher: " + publisher + " price: " + String.valueOf(price));
	}
}
class bookcompare implements Comparator<book>{
	public int compare(book b1, book b2)
	{
		return (int)(b1.price - b2.price);
	}
}
public class bookdb {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<book> list = new ArrayList<>();
		book b1 = new book("t1", "a1", "p1", 850);
		book b2 = new book("t2", "a2", "p2", 1850);
		book b3 = new book("t3", "a2", "p3", 350);
		book b4 = new book("t4 title", "a4", "p4", 750);
		list.add(b1); list.add(b2);list.add(b3); list.add(b4);

		System.out.println("***book details***");
		for(book b : list)
			b.display();
		
		System.out.println("**details of booking after sorting according to price ");
		Collections.sort(list, new bookcompare());
		for(book b : list)
			b.display();
		
		System.out.println("assigning unique id to books ");
		HashMap<Integer, book> hm = new HashMap<>();
		int i = 1;
		for(book b : list)
			hm.put(i++, b);
		for(Map.Entry<Integer, book> temp : hm.entrySet())
		{
			System.out.println("book id: " + temp.getKey());
			System.out.println("other details: ");
			temp.getValue().display();
		}
		
		System.out.println("**books with same author name**");
		System.out.println("enter the author name ");
		String name = sc.next();
		for(book b : list)
			if(name.equals(b.author))
				b.display();
		
		System.out.println("books with price greater than x");
		double p = sc.nextDouble();
		LinkedList<book> newlist = new LinkedList<>();
		for(book b : list)
			if(b.price > p)
				newlist.add(b);
		for(book b : newlist)
			b.display();
		
		
		System.out.println("search book using title");
		System.out.println("enter whole or part of book title ");
		String t = sc.next();
		for(book b : list)
			if(b.title.contains(t))
				b.display();
		
		System.out.println("check and update publisher ");
		System.out.println("enter the publisher name ");
		String pub = sc.next();
		for(book b : list)
			if(b.publisher.equals(pub))
				b.display();
		System.out.println("enter the book title and new publisher ");
		String title = sc.next();
		String publisher = sc.next();
		for(book b : list)
			if(b.title.equals(title))
				b.publisher = publisher;
		System.out.println("book collection after modification ");
		for(book b : list)
			b.display();
	}

}
