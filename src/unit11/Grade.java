package unit11;

public class Grade {
	private double value;
	
	public Grade() {
		value = 92.5;
	}
	
	public Grade(double num) {
		setGrade(num);
	}
	
	public void setGrade(double num) {
		value = num;
	}
	public String getLetterGrade() {
		if (value >= 90) {
			return "A";
		} else if (value >=80) {
			return "B";
		} else if (value >=70) {
			return "C";
		} else if (value >=60) {
			return "D";
		} else return "F";
	}
	public double getNumericGrade() {
		return value;
	}
	
	public String toString() {
		return getNumericGrade() + "\n" + getLetterGrade();
	}
}
