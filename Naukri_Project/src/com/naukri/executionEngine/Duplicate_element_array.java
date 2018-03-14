package com.naukri.executionEngine;

public class Duplicate_element_array {

	/**
	 * @param args
	 */
	public void String_duplicate()
	{
	String[] s1={"Balaji","Supriya","Saanvi","Balaji","Komal","Saanvi"};
	int len=s1.length;
	String s2="";
	for(int i=0;i<=len-1;i++)
			{
		      for(int j=i+1;j<=len-1;j++)
		      {
		    	  if(s1[i].equals(s1[j]))
		    	  {
		    		  System.out.println("Duplicate String:"+s1[i]);
		    	  }
		    	 
		      }
		      
			}
	}

	public void int_duplicate()
	{
	  int arr[]= new int[]{10,20,30,10,40,50};
	  
	  int leng=arr.length;
	  System.out.println(leng);
	  for(int i=0;i<=leng-1;i++)
	  {
		 for(int j=i+1;j<=leng-1;j++) 
		 {
			 if(arr[i]==arr[j])
			 {
				 System.out.println("duplicate number:"+arr[i]);
			 }
		 }
	  }
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Duplicate_element_array d1=new Duplicate_element_array();
		d1.String_duplicate();
		d1.int_duplicate();

	}

}
