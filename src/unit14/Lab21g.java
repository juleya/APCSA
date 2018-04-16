package unit14;

import static java.lang.System.*;

public class Lab21g
{
	public static void main(String args[])
	{
		AtCounter test = new AtCounter();
		test.countAts(0, 0);
		System.out.println("0 0 has " + test);
		
		AtCounter test2 = new AtCounter();
		test2.countAts(2, 5);
		System.out.println("2 5 has " + test2);
		
		AtCounter test3 = new AtCounter();
		test3.countAts(5, 0);
		System.out.println("5 0 has " + test3);
		
		AtCounter test4 = new AtCounter();
		test4.countAts(9, 9);
		System.out.println("9 9 has " + test4);
		
		AtCounter test5 = new AtCounter();
		test5.countAts(3, 9);
		System.out.println("3 9 has " + test5);
		
	}
}
