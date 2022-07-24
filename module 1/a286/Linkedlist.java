package a286;

import java.util.Iterator;
import java.util.LinkedList;

public class Linkedlist 
{
public static void main(String[] args) {
	
	LinkedList list=new LinkedList<>();
	
	list.add("a");
	list.add("b");
	list.add("b");
	list.add("c");
	
	Iterator i=list.iterator();
	
	while(i.hasNext())
	{
		System.out.println(i.next());
	}
}
}
