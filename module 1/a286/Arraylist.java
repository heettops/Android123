package a286;

import java.util.ArrayList;
import java.util.Iterator;

public class Arraylist
{
public static void main(String[] args) {
	
	ArrayList<String>arraylist=new ArrayList<>();
	
	arraylist.add("Heeet");
	arraylist.add("kaushal");
	arraylist.add("dhrumil");
	
	ArrayList<String>arraylist2=new ArrayList<>();
	
	

	arraylist2.add("android");
	arraylist2.add("software");
	arraylist2.add("mbbs");
	
	arraylist.addAll(arraylist2);
	
	Iterator i=arraylist.iterator();
	
	while(i.hasNext())
	{
		System.out.println(i.next());
	}
	
	
	
	
}
}
