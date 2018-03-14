package Program;

public class Pyramid_pattern {

	/**https://www.youtube.com/watch?v=r5TMt0WrZY
	 * @param args
	 */
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i,j,k;
		for(i=1;i<=5;i++)
		{
		 for(j=1;j<=5-i;j++)
		 {
			 System.out.print(" ");
		 }
		 for(k=1;k<=(2*i-1);k++)
				 {
			 System.out.print(k);
				 }
		 System.out.println();
		}
		
	}

}
