package prg3;

public class Student {
	String usn; 
	String name;
	String age;
	String cat;
	String address;
	double cgpa;
	Student(String usn, String name, String age, String cat,String address, double cgpa)
	{
		this.usn = usn;
		this.name = name;
		this.age = age;
		this.cat = cat;
		this.address = address;
		this.cgpa = cgpa;
	}
	
	String tostring()
	{
		return " usn : " + usn + " name : " + name + " age : " + age + " cat : " + cat + " address : " + address + " cgpa : " + String.valueOf(cgpa);
	}
}
