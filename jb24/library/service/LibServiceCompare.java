package by.epam.jb24.library.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.epam.jb24.library.entity.PrintedEdition;
import by.epam.jb24.library.entity.Book;

public class LibServiceCompare {
	public List<PrintedEdition> compare(List<PrintedEdition> units, String compareMethod) {
		String methodPrcie = "Price";
		String methodDate = "Date";
		ArrayList<Book> convertResult = new ArrayList<Book>();
		ArrayList<PrintedEdition> hasResult = new ArrayList<PrintedEdition>();
		for (PrintedEdition collConvertToBook : units) {
			convertResult.add((Book) collConvertToBook);
		}

		if (compareMethod.equals(methodPrcie)) {
			Collections.sort(convertResult, new PriceCompare());
			for (Book collConvertToPrint : convertResult) {
				hasResult.add(collConvertToPrint);
			}
		} else if (compareMethod.equals(methodDate)) {
			Collections.sort(convertResult, new DateCompare());
			hasResult.addAll(convertResult);
		}
		return hasResult;
	}
}