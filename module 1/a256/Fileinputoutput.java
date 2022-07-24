package a256;

import java.io.FileOutputStream;

public class Fileinputoutput 
{
public static void main(String[] args) {
	
	try
	{
		String s="hello brother";
		FileOutputStream fout=new FileOutputStream("D://Heet.txt");
		fout.write(s.getBytes());
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
