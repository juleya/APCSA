package unit11;

import java.io.File;
import java.util.Scanner;

public class BookstoreRunner {
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the Bookstore Archive!");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("store name");
		String store = keyboard.nextLine();
		//System.out.println(store);
		System.out.println("number of authors");
		int numAuthors = keyboard.nextInt();
		
		Bookstore test = new Bookstore(store, numAuthors);
		
		for (int i = 0; i < numAuthors; i++) {
			System.out.println("author " + i + 1);
			String author = keyboard.nextLine();
			System.out.println("number of books");
			keyboard.nextLine();
			int numBooks = keyboard.nextInt();
			String list = "";
			for (int j = 0; j < numBooks; j++) {
				System.out.println("title");
				String title = keyboard.nextLine();
				//System.out.println(title);
				keyboard.nextLine();
				System.out.println("price");
	
				double price = keyboard.nextDouble();
				Book b = new Book(title, price);
				list += b.toString() + "\n";
				
			}
			
			Author a = new Author(author, list);
			test.addAuthor(0, a);
		}
		
		System.out.println(test);
		
		System.out.println("Expensive Author = " + test.getExpensiveAuthor());
		System.out.println("Cheapest Author = " + test.getCheapestAuthor());
	}
}
