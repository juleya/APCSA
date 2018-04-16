package unit11;

public class Author {
	private String name;
	private Books bookList;
	
	public Author() {
		setName("");
		setBooks("");
	}
	
	public Author(String name, String books) {
		setName(name);
		setBooks(books);
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setBooks(String list) {
		bookList = new Books(list);
	}
	
	public void setBook(int index, String title, double price) {
		bookList.setBook(index, title, price);
	}
	
	public String getAuthor() {
		return name;
	}
	
	public int getNumBooks() {
		return bookList.getNumBooks();
	}
	
	public double getBookPriceSum() {
		return bookList.getPriceSum();
	}
	
	public double getAverageCost() {
		return getBookPriceSum() / getNumBooks();
	}
	
	public String toString() {
		return getAuthor() + ":\n" + bookList.toString();
	}
}
