package a216;

class Bank
{
	void bank()
	{
		System.out.println("Banking");
	}
}

class Current extends Bank
{
	void current()
	{
		System.out.println("Current");
	}
}

class Save extends Bank
{
	void save()
	{
		System.out.println("Saving");
	}
}
public class Hierarchical {
	
	public static void main(String[] args) {
		
		Current c=new Current();
		Save s=new Save();
		
		c.current();
		s.save();
		c.bank();
	}

}
