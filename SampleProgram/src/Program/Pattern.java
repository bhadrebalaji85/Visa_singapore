package Program;

public class Pattern {
	
	
	/*
	 1
	 1 2 1
	 1 2 3 1 2
	 
	 */
	int i,j,k;
	public Pattern()
	{
		for(i=1;i<5;i++)
			
			//System.out.print(" ");
		{
		  for(j=1;j<=5-i;j++)
		  {
			  System.out.print(" ");
		  }
		  for(k=1;k<=(2*i-1);k++)
		  {
			  System.out.print(k);  
			  if(k==i && k>i)
			  {
				  for(int q=1;q<i;q++)
				  {
					  System.out.print(q);
				  }
			  }
			 
				    
		  }
	
		 // System.out.println(j);
		  System.out.println();
		
		}
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p1= new Pattern();

	}

}
