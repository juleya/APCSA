package unit12;

import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	public Monster() {
		myWeight = 0;
		myHeight = 0;
		myAge = 0;
	}


	public Monster(int ht) {
		myWeight = 0;
		myHeight = ht;
		myAge = 0;
	}
	
	public Monster(int ht, int wt) {
		myWeight = wt;
		myHeight = ht;
		myAge = 0;
	}

	public Monster(int ht, int wt, int age) {
		myWeight = wt;
		myHeight = ht;
		myAge = age;
	}

	public void setHeight(int ht) {
		myHeight = ht;
	}

	public void setWeight(int wt) {
		myWeight = wt;
	}

	public void setAge(int age) {
		myAge = age;
	}
	
	public int getHeight() {
		return myHeight;
	}
	
	public int getWeight() {
		return myWeight;
	}
	
	public int getAge() {
		return myAge;
	}
	
	//creates a new copy of this Object
	public Object clone()
	{
		
		return new Monster(myHeight, myWeight, myAge);
	}

	public boolean equals( Object obj )
	{
		Monster m = (Monster)obj;
		if (this.getWeight() == m.getWeight() && this.getHeight() == m.getHeight() && this.getAge() == m.getAge()) {
			return true;
		}
		return false;
	}

	public int compareTo( Object obj )
	{
		Monster rhs = (Monster)obj;
		if (this.getHeight() == rhs.getHeight() && this.getWeight() != rhs.getWeight()) {
			if (this.getWeight() >rhs.getWeight())
				return 1;
			else return -1;
		} else if (this.getHeight() == rhs.getHeight() && this.getWeight() == rhs.getWeight() && this.getAge() != rhs.getAge()) {
			if (this.getAge() >rhs.getAge())
				return 1;
			else return -1;
		} else if (equals(obj)) {
			return 0;
		} else if (this.getHeight() > rhs.getHeight()) {
			return 1;
		} else return -1;
	}

	public String toString() {
		return getHeight() + " " + getWeight() + " " + getAge();
	}
	
	
}