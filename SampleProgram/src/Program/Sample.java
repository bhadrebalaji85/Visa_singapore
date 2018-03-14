package Program;

public class Sample {
     
	  static int count=100;
	  public void increment()
	  {
		  count++;
	  }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sample  b1=new Sample();
		b1.increment();
		Sample b2=new Sample();
		System.out.println(b2.count);
		int a ,b;

	}

}
