package by.epam.jb24.library.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.epam.jb24.library.entity.Book;
import by.epam.jb24.library.entity.PrintedEdition;

public class Libinit {

	public static List<PrintedEdition> BookReader() throws IOException {
		List<String> BookLstSt = new ArrayList<String>();
		List<Book> BookLstLib = new ArrayList<>();
		List<PrintedEdition> convertToPrint = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("Library.txt"));

			while (sc.hasNextLine()) {
				BookLstSt.add(sc.nextLine());
			}
		} finally {
			sc.close();
		}

		for (String lst : BookLstSt) {
			System.out.println(lst);
			String[] params = lst.split(", ");
			BookLstLib.add(new Book(params[0].trim(), params[1].trim(), Integer.parseInt(params[2].trim()),
					Double.parseDouble(params[3].trim()), params[4].trim()));
		}

		for (Book collConvertPrint : BookLstLib) {
			convertToPrint.add(collConvertPrint);
		}
		return convertToPrint;
	}

}
