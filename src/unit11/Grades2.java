package unit11;

import java.util.Scanner;

public class Grades2
{
	private Grade[] gradeList ;
	
	public Grades2()
	{
		setGrades("");
	}
	
	public Grades2(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String values)
	{
		Scanner keyboard = new Scanner(values);
		int num = keyboard.nextInt();
		System.out.print(num+"\n");
		gradeList = new Grade[num];
		int i =0;
		while (i<num){
			if (keyboard.hasNextDouble()){
				Grade test = new Grade(keyboard.nextDouble());
				System.out.println(test);
				gradeList[i]=test;
			}
			else{
				keyboard.next();
				i=i-1;
			}
			i++;
		}
		
	}
	
	public void setGrade(int spot, double grade)
	{
		gradeList[spot]=new Grade(grade);

	}
	
	public double getSum()
	{
		double sum=0.0;
		for (int i=0; i<gradeList.length; i++){
			sum=sum+(gradeList[i]).getNumericGrade();	
		}



		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		for (int i=0; i<gradeList.length; i++){
			if (low>gradeList[i].getNumericGrade()){
				low=gradeList[i].getNumericGrade();
			}
		}

		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		for (int i=0; i<gradeList.length; i++){
			if (high<gradeList[i].getNumericGrade()){
				high=gradeList[i].getNumericGrade();
			}
		}


		return high;
	}
	
	public int getNumGrades()
	{
		return gradeList.length;
	}
	
	public String toString()
	{
		String output="";
		for (int i=0; i<gradeList.length; i++){
			output=output+gradeList[i].getNumericGrade()+" ";
		}

		return output;
	}	
}
