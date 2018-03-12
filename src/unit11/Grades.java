package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private Grade[] grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
		
		Scanner chopper = new Scanner(gradeList);
		grades = new Grade[chopper.nextInt()];
		
		
		for (int i = 0; i < grades.length; i++) {
			if (chopper.hasNextDouble()) {
				Grade next = new Grade(chopper.nextDouble());
				grades[i] = next;
			} else {
				do {
					chopper.next();
				} while (!chopper.hasNextDouble());
				
				Grade next = new Grade(chopper.nextDouble());
				grades[i] = next;
				
				
			}
			
		}
	
	}
	
	public void setGrade(int spot, double grade)
	{
		grades[spot] = new Grade(grade);

	}
	
	public double getSum()
	{
		double sum = 0;
		for (Grade grade : grades) {
			sum += grade.getNumericGrade();
		}
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = grades[0].getNumericGrade();
		
		for (Grade grade : grades) {
			if (grade.getNumericGrade() < low) {
				low = grade.getNumericGrade();
			}
		}
		
		return low;
	}
	
	public double getHighGrade()
	{
		double high = grades[0].getNumericGrade();
		
		for (Grade grade : grades) {
			if (grade.getNumericGrade() > high) {
				high = grade.getNumericGrade();
			}
		}
		
		return high;
	}
	
	public int getNumGrades()
	{
		return grades.length;
	}
	
	public String toString()
	{

		String output="";
		for (int i = 0; i < getNumGrades(); i++) {
			output += grades[i].getNumericGrade() + " ";
		}

		return output;
		

	}	
}