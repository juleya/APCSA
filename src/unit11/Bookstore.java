package unit11;

public class Bookstore {
	private String storeName;
	private Author[] authors;
	
	public Bookstore() {
		storeName = "store";
		authors = new Author[0];
	}
	
	public Bookstore(String lib, int numAuthors) {
		storeName = lib;
		authors = new Author[numAuthors];
		
	}
	
	public void addAuthor(int index, Author a) {
		authors[index] = a;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public double getAuthorAverage(int index) {
		return authors[index].getAverageCost();
	}
	
	public double getAuthorAverage(String name) {
		for (Author author : authors) {
			if (author.getAuthor().equals(name)) {
				return author.getAverageCost();
			}
		}
		
		return 0;
	}
	
	public String getAuthor(int index) {
		return authors[index].getAuthor();
	}
	
	public String getExpensiveAuthor() {
		double exp = Double.MIN_VALUE;
		String name = "";
		for (Author author : authors) {
			if (author.getAverageCost() > exp) {
				name = author.getAuthor();
				exp = author.getAverageCost();
			}
		}
		
		return name;
	}
	
	public String getCheapestAuthor() {
		double cheap = Double.MIN_VALUE;
		String name = "";
		for (Author author : authors) {
			if (author.getAverageCost() < cheap) {
				name = author.getAuthor();
				cheap = author.getAverageCost();
			}
		}
		
		return name;
	}
	
	public String toString() {
		String output = getStoreName() + "\n";
		for (Author author : authors) {
			output += author.toString() + "\n";
		}
		
		return output;
	}

}
