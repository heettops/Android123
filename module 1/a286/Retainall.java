package a286;

import java.util.ArrayList;
import java.util.Iterator;

public class Retainall
{
public static void main(String[] args) {
	
	ArrayList<String>arraylist=new ArrayList<>();
	
	arraylist.add("hey");
	arraylist.add("hiii");
	arraylist.add("helloo");
	arraylist.add("hmmm");
	
	ArrayList<String>arraylist2=new ArrayList<>();
	
	arraylist2.add("A");
	arraylist2.add("B");
	arraylist2.add("C");
	arraylist2.add("hmmm");
	
	arraylist.retainAll(arraylist2);
	
	Iterator i=arraylist.iterator();
	
	while(i.hasNext())
	{
		System.out.println(i.next());
	}
}
}
