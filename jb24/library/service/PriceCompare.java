 package by.epam.jb24.library.service;

import java.util.Comparator;

import by.epam.jb24.library.entity.Book;


public class PriceCompare implements Comparator<Book>{

	
	@Override
	public int compare(Book arg0, Book arg1) {
		double price1 = arg0.getPrice();
		double price2 = arg1.getPrice();
			if(price1 < price2) {
				return -1;
			}else if (price1 == price2) {
				return 0;
			}else {
				return 1;
			}
	}

}
