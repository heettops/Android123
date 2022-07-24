package a236;

public class StringBuilder 
{
public static void main(String[] args) {
	
	String s1="Heet";
	String s2="Nanda";
	String s3=s1+s2;
	
	System.out.println(s3);
	
	
	String s4=s1.concat(s2);
	System.out.println(s4);
	
	
	String s5="HEET";

	String s6="Heet";

	String s7="kaushal";

	String s8="KAUSHAL";
	
	System.out.println(s5.equals(s6));
	System.out.println(s5.equals(s7));
	System.out.println(s5.equals(s8));
	System.out.println(s5.equalsIgnoreCase(s6));
	System.out.println(s5.compareTo(s6));
	
	
	String s9="heet";
	String s10=new String("heet"); 
	
	
	System.out.println(s9.compareTo(s10));   //gives value
	
	System.out.println(s9==s10);            // gives type
	
	
	String s11="heet";
	String s12="HEET";
	
	System.out.println(s11.toUpperCase());

	System.out.println(s12.toLowerCase());
	
	
	String s13="hello how are you";
	String ans=s13.replace("hello","hiii");

			System.out.println(ans);
			
			
			System.out.println(s11.charAt(1));
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
