package a216;

class Father
{
	void a()
	{
		System.out.println("Father's details");
	}
}

class Son extends Father
{
	void b()
	{
		System.out.println("Son's details");
	}
}
public class Single 
{
 public static void main(String[] args) 
 {
	Son s=new Son();
	s.a();
	s.b();
	
}
}
