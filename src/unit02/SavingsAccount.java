package unit02;

public class SavingsAccount {
	
	static int balance;
	static double interestRate; 
	
	public SavingsAccount(int number, double interest) {
		balance = number;
		interestRate = interest;
		
	}
	
	public static void addInterest() {
		balance += balance * interestRate;

	}
	
	public static void SavingsAccountTester() {
		balance = 1000;
		interestRate = .10;
	}

	public static void main(String[] args) {
		SavingsAccountTester();
		addInterest();
		System.out.println(balance);

	}

}
