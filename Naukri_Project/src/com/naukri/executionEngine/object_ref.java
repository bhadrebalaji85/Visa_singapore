package com.naukri.executionEngine;

class A
{
	public void show()
	{
		 System.out.println("Class A");
	}
	public void show2()
	{
		 System.out.println("Class C");
	}
}

class B extends A
{
	public void show()
	{
		 System.out.println("Class B");
	}
	
}
public class object_ref {
	
  public static void main(String[] args) {
		// TODO Auto-generated method stub
	  
	  A a=new B();
	  a.show();
      a.show2();
	}

}
