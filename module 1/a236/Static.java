package a236;

public class Static

{
   int id;
   String name;
   static String college="VVP";
   
   public  Static(int id,String name)
   {
	this.id=id;
	this.name=name;
	
	
   }
   
   void display()
   {
	   System.out.println(id+""+name+""+college);
	   
   }
   
   public static void main(String[] args) {
	
	   Static s1=new Static(71,"heet");
	   Static s2=new Static(34,"Kaushal");
	   
	   s1.display();
	   s2.display();
}
}
