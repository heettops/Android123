package a216;

class P
{
	void a()
	{
		System.out.println("Hello");
	}
}

class Q extends P
{
	void b ()
	{
		System.out.println("Bye");
	}
}

interface R
{
	void c();
}

class S extends Q implements R
{
	void d()
	{
		System.out.println("How are you");
	}
	
	@Override
	public void c()
	{
		System.out.println("good");
	}
}
public class Hybrid {
	public static void main(String[] args) {
		
		S s=new S();
		s.a();
		s.b();
		s.c();
		s.d();
	}

}
