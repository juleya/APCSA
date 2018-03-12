package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class
{
	private String name;
	private Student[] studentList;
	
	public Class()
	{
		name="";
		studentList=new Student[0];
	}
	
	public Class(String name, int stuCount)
	{
		this.name = name;
		studentList = new Student[stuCount];
	
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList[stuNum] = s;
	}
	
	public String getClassName()
	{
	   return name;	
	}
	
	public double getClassAverage()
	{
		double classAverage = 0;
		double sum = 0;
		
		for (Student student : studentList) {
			sum += student.getAverage();
		}

		classAverage = sum / studentList.length;

		return classAverage;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		for (Student student: studentList) {
			if (student.getName().equals(stuName)) {
				return student.getAverage();
			}
		}
		
		return 0;
		
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hName ="";
		for (Student student : studentList) {
			if (student.getAverage() > high) {
				hName = student.getName();
				high = student.getAverage();
			}
		}

		return hName;
	}

	public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String hName ="";		
		for (Student student : studentList) {
			if (student.getAverage() < low) {
				hName = student.getName();
				low = student.getAverage();
			}
		}

		return hName;
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";
		for (Student student: studentList) {
			if (student.getAverage() < failingGrade) {
				output += student.getName() + " ";
			}
		}

		return output;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";
		for (Student student: studentList) {
			output += student.toString() + "\t" +  student.getAverage() + "\n";
		}

		return output;
	}  	
}