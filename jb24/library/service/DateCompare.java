package by.epam.jb24.library.service;

import java.util.Comparator;
import java.util.Date;

import by.epam.jb24.library.entity.Book;

public class DateCompare implements Comparator<Book>{

	@Override
	public int compare(Book arg0, Book arg1) {
		
		//return arg0.getPublishDate().compareTo(arg1.getPublishDate());
		Date date1 = arg0.getPublishDate();
		Date date2 = arg1.getPublishDate();
		if(0 > (date1.getTime() - date2.getTime())) {
			return -1;
		}else if (date1.getTime() == date2.getTime()) {
			return 0;
		}else {
			return 1;
		}
	}

}
