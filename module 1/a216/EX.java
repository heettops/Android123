package a216;

interface Print
{
	void print();
}

interface Show
{
	void show();

}

public class EX implements Print,Show

{
	@Override
	public void show()
	{
		System.out.println("its showing");
	}
	
	@Override
	public void print()
	{
		System.out.println("Its printing");
	}
	
	public static void main(String[] args)
	{
		
		EX a1=new EX();
		EX a2=new EX();
		
		a1.print();
		a2.show();
	}
}


