package a216;

class A
{
	void a()
	{
		System.out.println("heet");
	}
}

class B extends A
{
	void b()
	{
		System.out.println("Kaushal");
	}
}

class C extends B
{
	void c()
	{
		System.out.println("Mayank");
	}
}

class D extends C
{
	void d()
	{
		
	
	System.out.println("Harsh");
	}
}

public class Multilevel 
{
 public static void main(String[] args)
 {
	D d=new D();
	d.a();
	d.b();
	d.c();
	d.d();
	 
}
}
