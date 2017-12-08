package summative.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int isbn;
	private String title, author;
	private double price;

	private List<VIM> vims;

	public Book() {
		isbn = 0;
		title = null;
		author = null;
		price = 0;
		vims = new ArrayList<VIM>();
	}

	public Book(int isbn, String title, String author, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		vims = new ArrayList<VIM>();
	}

	public void addVIM(VIM v) {
		vims.add(v);
	}

	public String getTitle() {
		return title;
	}

	public VIM getVIMByName(String name) {
		VIM v = null;
		Iterator<VIM> i = vims.iterator();
		while (i.hasNext()) {
			v = i.next();
			if (v.getName().toLowerCase().contentEquals(name.toLowerCase())) {
				return v;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String vimNames = "";
		String vimAmount = "(" + String.valueOf(vims.size()) + ")";

		Iterator<VIM> i = vims.iterator();
		while (i.hasNext()) {
			vimNames += i.next().getName() + ", ";
		}

		return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn
				+ "\nPrice: " + price + ": "
				 + "\n";
	}
	
	public int getIsbn(){
		return isbn;
	}

	public String getAuthor() {
		return author;
	}

	public String getPrice() {
		return String.valueOf(price);
	}

	public String getISBN() {
		return String.valueOf(isbn);
	}

	

}

