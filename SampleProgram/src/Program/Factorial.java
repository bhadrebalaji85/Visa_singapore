package Program;

public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//4! = 1 * 2 * 3 * 4
		
		int sum=1;
		for(int i=1; i<=4;i++)
		{
			sum*=i;
			
		}
          System.out.println("Factorial number is:" +sum);
	}

}
