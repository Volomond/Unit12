package by.epam.jb24.library.main;

import java.util.ArrayList;
import java.util.List;

import by.epam.jb24.library.entity.Book;
import by.epam.jb24.library.entity.Directory;
import by.epam.jb24.library.entity.Library;
import by.epam.jb24.library.entity.Magazine;
import by.epam.jb24.library.entity.PrintedEdition;
import by.epam.jb24.library.service.BookSearcher;
import by.epam.jb24.library.service.LibServiceCompare;
import by.epam.jb24.library.service.Libinit;
import by.epam.jb24.library.service.PriceCompare;
import by.epam.jb24.library.service.Search;
import by.epam.jb24.library.service.Searcher;
import by.epam.jb24.library.view.PrintBook;
import by.epam.jb24.library.view.PrintList;
import by.epam.jb24.library.view.Printer;

public class DemoLibrary {

	public static void main(String[] args) {
		Library myLibra = new Library();
		Libinit read = new Libinit();
		List<PrintedEdition> lists = new ArrayList<>();
		List<PrintedEdition> serResultList = new ArrayList<PrintedEdition>();

		try {
			lists = read.BookReader();
		} catch (Exception e) {
			System.out.println("Reading from file fails. Library Generate by default");
			myLibra.add(new Book("Lord of the rings: king's return", "J.Tolkin", 1000000, 23.5, "20.10.1955"));
			myLibra.add(new Book("Lord of the rings: brotherhood of the ring", "J.Tolkin", 1000000, 25.5, "29.07.1954"));
			myLibra.add(new Book("Lord of the rings: two towers", "J.Tolkin", 1000000, 15.5, "11.11.1954"));
			myLibra.add(new Book("Game of thrones", "J.Martin", 100000, 15.5, "06.08.1996"));
			myLibra.add(new Book("Withcher", "A.Sapkovski", 50000, 10, "12.04.2003"));
			myLibra.add(new Magazine("Top Gear", 5000, 5));
			myLibra.add(new Magazine("Salon", 5000, 3));
			myLibra.add(new Directory("Phonebook", 12000, 2.5));
			lists = myLibra.getLibraLst();
		}
		printAsList(new PrintList(), lists);
		/*myLibra.remove(new Book("Lord of the rings: king's return", "J.Tolkin", 1000000, 20.5));
		print(new PrintList(), lists);
		
		Search seeker = new Searcher(new Book("Lord of the rings: brotherhood of the ring", "J.Tolkin", 1000000, 25.5,"29.07.1954"));
		serResultList = seeker.search(lists);
		printAsList(new PrintList(), serResultList);
		
		printBookAsTable(new PrintBook(), serResultList);*/
		
		Search seekerBook = new BookSearcher("J.Tolkin");
		serResultList = seekerBook.search(lists);
		printBookAsTable(new PrintBook(), serResultList);
		
		LibServiceCompare sortingPrice = new LibServiceCompare();
		serResultList = sortingPrice.compare(serResultList,"Price");
		printBookAsTable(new PrintBook(), serResultList);
		
		LibServiceCompare sortingDate = new LibServiceCompare();
		serResultList = sortingDate.compare(serResultList,"Date");
		printBookAsTable(new PrintBook(), serResultList);
	}

	public static void printAsList(Printer toPrintObj, List<PrintedEdition> lists) {
		toPrintObj.print(lists);
	}

	public static void printBookAsTable(PrintBook printBook, List<PrintedEdition> serResultList) {
		printBook.print(serResultList);
	}

}
