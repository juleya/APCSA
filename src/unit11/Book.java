package unit11;

public class Book {
	
	private String title;
	private double price;

	public Book() {
		title = "Untitled";
		price = 10.99;
	}
	
	public Book(String name, double cost) {
		setTitle(name);
		price = cost;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public void setPrice(double num) {
		price = num;
	}

	public String getTitle() {
		return title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return getTitle() + "- $" + getPrice();
	}
}
