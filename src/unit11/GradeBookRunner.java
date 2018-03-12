package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
		out.println("Welcome to the Class Stats program!");
		out.println("\nWhat is the name of this class?");
		Scanner keyboard = new Scanner(System.in);
		String name = keyboard.nextLine();
		out.println("\nHow many students are in this class?");
		int size = keyboard.nextInt();
		Class test = new Class(name, size);
		
		for (int i = 0; i < size; i++) {
			Scanner output = new Scanner(System.in);
			out.println("Enter the name of student " + (i + 1) + " : ");
			String student = output.nextLine();
			
			Scanner gradebook = new Scanner(System.in);
			out.println("Enter the grades for " + student);
			out.println("Use the format x - grades ( 2 - 100 100) : ");
			String grades = gradebook.nextLine();
			Student s = new Student(student, grades);
			test.addStudent(i, s);
		}
		
	
		out.println(test);

		out.println("Failure List = " + test.getFailureList(70));	
		out.println("Highest Average = " + test.getStudentWithHighestAverage());
		out.println("Lowest Average = " + test.getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",test.getClassAverage()));	
		
		
		



















	}		
}
