package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Student2 implements Comparable
{
	private String myName;
	private Grades myGrades;
	
	public Student2()
	{
		setName("");
		setGrades("");
	}
	
	public Student2(String name, String gradeList)
	{
		setName(name);
		setGrades(gradeList);
		
	
	}
	
	public void setName(String name)
	{
		myName = name;

	}	
	
	public void setGrades(String gradeList)
	{
		myGrades = new Grades(gradeList);
	
	}
	
	public void setGrade(int spot, double grade)
	{
		myGrades.setGrade(spot, grade);
	}

	public String getName()
	{
		return myName;
	}
	
	public int getNumGrades()
	{
		return myGrades.getNumGrades();
	}

	public double getSum()
	{
		return myGrades.getSum();
	}
	
	public double getAverage()
	{
		return getSum() / getNumGrades();
	}

	public double getAverageMinusLow()
	{
		return (getSum() - getLowGrade()) / (getNumGrades() - 1);
	}
	
	public double getHighGrade()
	{
		return myGrades.getHighGrade();
	}
	
	public double getLowGrade()
	{
		return myGrades.getLowGrade();
	}
	
	public String toString()
	{
		return getName() + " = " + myGrades.toString();
	}	
	public boolean equals(Object obj) {
		Student2 st = (Student2)obj;
		if (this.getAverage() == st.getAverage()) 
			return true;
		return false;
	} 
	public int compareTo(Object obj) {
		Student2 st = (Student2)obj;
		return this.getAverage() - st.getAverage();
	}
}