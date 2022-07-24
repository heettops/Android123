package a236;

class A
{
	String color="Black";
}

class B extends A
{
	String color="Pink";
	
	void display()
	{
		System.out.println(color);
		System.out.println(super.color);
	}
}

public class Super {
	public static void main(String[] args) {
		
		B b=new B();
		b.display();
	}

}
