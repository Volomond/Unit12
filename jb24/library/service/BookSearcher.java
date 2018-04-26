package by.epam.jb24.library.service;

import java.util.ArrayList;
import java.util.List;

import by.epam.jb24.library.entity.Book;
import by.epam.jb24.library.entity.PrintedEdition;

public class BookSearcher implements Search{
	private String author;
	
	public BookSearcher (String InAuthor) {
		this.author = InAuthor;
	}

	@Override
	public List<PrintedEdition> search(List<PrintedEdition> unit) {
		ArrayList<PrintedEdition> searchResult = new ArrayList<PrintedEdition>();
		for(PrintedEdition printSearch: unit) {
			if(printSearch instanceof Book) {
				Book searchBook = (Book) printSearch;
				if(searchBook.getAuthor().equals(author)) {
					searchResult.add(printSearch);
				}
			}
		}
		return searchResult;
	}

}
