package com.naukri.executionEngine;

interface I1{
	void show();
	void show1();
	void show2();
	
}

interface I2{
	void show();
	void show3();
	void show4();
}

class abc implements I1,I2{
	final static int a=5;
	
	public void  show()
	{
		System.out.println("Interface");
	}
	public void  show1()
	{
		System.out.println("Interface1");
	}
	public void  show2()
	{
		System.out.println("Interface");
	}
	public void  show3()
	{
		System.out.println("Interface3");
	}
	public void  show4()
	{
		System.out.println("Interface4");
	}
	public void  show5()
	{
		System.out.println("Interface5");
	}
}
public class Interface_1 {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		I1 i=new abc();
		i.show();
		i.show1();
		i.show2();
		abc a=new abc();
		a.show5();
	
	}

}
