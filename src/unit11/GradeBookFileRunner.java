package unit11;


import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner file = new Scanner(new File("gradebook.dat"));

		out.println("\nWhat is the name of this class?");
		String name = file.nextLine();
		out.println(name);
		out.println("\nHow many students are in this class?");
		int size = file.nextInt();
		out.println(size);
		Class test = new Class(name, size);
		
		for (int i = 0; i < size; i++) {
			out.println("Enter the name of student " + (i + 1) + " : ");
			String student = file.nextLine();
			out.println(student);
			out.println("Enter the grades for " + student);
			
			out.println("Use the format x - grades (2 - 100 100) : ");
			String grades = file.nextLine();
			out.println(grades);
			
			Student s = new Student(student, grades);
			out.println(s);
			test.addStudent(i, s);
		}
		
	
		out.println(test);

		out.println("Failure List = " + test.getFailureList(70));	
		out.println("Highest Average = " + test.getStudentWithHighestAverage());
		out.println("Lowest Average = " + test.getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",test.getClassAverage()));











	}		
}