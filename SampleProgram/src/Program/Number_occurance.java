package Program;

public class Number_occurance {
	
	int arr[]= new int[5];
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int num1[]= new int[]{2,21,4,56,12,10,8,2,12};
		
		int num2[]=new int[]{12,8,2,10,56,12,8,8,12};
		
		int count=0;
		
		//System.out.println(num1.length);
		//System.out.println(num2.length);
		try
		{
			for(int i=1;i<(num1.length);i++)
		
		{
			for(int j=1;j<(num2.length);j++)
			{
				if(num1[i]==num2[j])
				{
					count++;
					System.out.println(num1[i]);
					//System.out.println(num1[2]);
				}
				
			}
			//System.out.println(count);


			System.out.println("Count is:" +count+ "Repeated numbers" +num1[i]);
		}
    		
			
		} catch (ArrayIndexOutOfBoundsException exception)
		{
			
		}
		

	}

}
