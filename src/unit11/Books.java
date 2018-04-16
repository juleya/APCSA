package unit11;

import java.util.Scanner;
public class Books {
	private Book[] books;
	
	public Books() {
		setBooks("");
	}
	
	public Books(String bookList) {
		setBooks(bookList);
	}
	
	public void setBooks(String bookList) {
		Scanner chopper = new Scanner(bookList);
		books = new Book[chopper.nextInt()];
		
		for (int i = 0; i < books.length; i++) {
			if (chopper.hasNextLine()) {
				String title = chopper.nextLine();
				double p = chopper.nextDouble();
				chopper.nextLine();
				Book next = new Book(title, p);
				books[i] = next;
			} 
		
		}
	}
	
	public void setBook(int index, String title, double price) {
		books[index] = new Book(title, price);
	}
	
	public String getCheapest() {
		int index = 0;
		double cheap = books[0].getPrice();
		for (int i = 0; i < books.length; i++) {
			if (books[i].getPrice() < cheap) {
				cheap = books[i].getPrice();
				index = i;
			}
		}
		
		return books[index].toString();
	}
	
	public String getExpensive() {
		int index = 0;
		double exp = books[0].getPrice();
		for (int i = 0; i < books.length; i++) {
			if (books[i].getPrice() > exp) {
				exp = books[i].getPrice();
				index = i;
			}
		}
		
		return books[index].toString();
	}
	
	public int getNumBooks() {
		return books.length;
	}
	
	public double getPriceSum() {
		double sum = 0;
		for (Book book : books) {
			sum += book.getPrice();
		}
		return sum;
	}
	
	public String toString() {
		String output = "";
		for (Book book : books) {
			output += book.toString() + "\n";
		}
		
		return output;
	}
}
