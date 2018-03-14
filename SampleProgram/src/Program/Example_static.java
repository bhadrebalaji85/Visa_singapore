package Program;

public class Example_static {

	  
	  static int count = 100;
	  public void increment()
	  {
	   
		  count++;
		 
	  }
	  public static void main(String []args)
	  {
		  Example_static b1 = new Example_static();
	     b1.increment();
	 
	     System.out.println(b1.count );
	     Example_static b2 = new Example_static();
	     //static b2.increment();
	     System.out.println(b2.count+ "" +b1.count);  
	     b2.increment();// line 13
	     
	     Example_static b3 = new Example_static();
	     System.out.println(b2.count+ "" +b1.count+ "" +b3.count);
	  }
	}
