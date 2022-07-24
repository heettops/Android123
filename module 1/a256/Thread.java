package a256;

class A extends Thread
{
	public void run()
	{
		for(int i=1;i<=6;i++)
		{
			System.out.println("Thread A:"+i);
		}
	}


		
	
}

class B extends Thread
{
	public void run()
	{
		for(int i=1;i<=6;i++)
			System.out.println("Thread B:"+i);
			
	}

	
		
	
}

public class Thread {
	public static void main(String[] args) {
		
		A a =new A();
		B b =new B();
		
		a.start();
		b.start();
		
		
		
	}

}
