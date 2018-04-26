package by.epam.jb24.library.entity;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book extends PrintedEdition {
	private String publishDateSt;
	private String title;
	private String author;
	
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	private Date publishDate = null;
	
	public Book(String inTitle, String inAuthor,int inPrintSize, double inPrice, String inPublishDateSt) {
		super(inPrintSize,inPrice);
		this.title = inTitle;
		this.author = inAuthor;
		this.publishDateSt = inPublishDateSt;
		try {
			publishDate = format.parse(inPublishDateSt);
		} catch (ParseException e) {
			System.out.println(inPublishDateSt + "No parse ");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}

	public String getPublishDateSt() {
		return publishDateSt;
	}

	public void setPublishDateSt(String publishDateSt) {
		this.publishDateSt = publishDateSt;
	}

	public void view(int inPrintSize, double inPrice) {
		System.out.println("Book: " + title + " " + author + inPrintSize + inPrice + " "+ publishDateSt);
	}

	@Override
	public String toString() {
		return "Book: title=" + title + ", author=" + author + ", PrintSize =" + getPrintSize() + ", Price ="
				+ getPrice()+ ", Publish date = "+ publishDateSt;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result + ((publishDateSt == null) ? 0 : publishDateSt.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		if (publishDateSt == null) {
			if (other.publishDateSt != null)
				return false;
		} else if (!publishDateSt.equals(other.publishDateSt))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public void printInfo() {
		System.out.println(this.toString());
		
	}
		
	
}
