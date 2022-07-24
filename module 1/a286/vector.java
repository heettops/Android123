package a286;

import java.util.Vector;

public class vector 
{
	public static void main(String[] args) {
		
		Vector v=new Vector<>(4);
		
		v.addElement("a");
		v.addElement("b");
		v.addElement("c");
		v.addElement("d");
		v.addElement("e");
		
		System.out.println(v.size());
		System.out.println(v.capacity());
		
		if(v.contains("a"))
		{
			System.out.println("right");
		}
		
		else
		{
			System.out.println("wrong");
	}

}
}
