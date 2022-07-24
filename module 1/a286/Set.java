package a286;

import java.util.HashSet;
import java.util.Iterator;

public class Set 
{
public static void main(String[] args) {
	
	HashSet set=new HashSet<>();
	set.add("a");
	set.add("b");
	set.add("a");
	
	
	
	Iterator i=set.iterator();
	while(i.hasNext())
	{
		System.out.println(i.next());
	}
	
	
}
}
