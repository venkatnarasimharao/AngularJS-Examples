package com.naresh.Jersey2.x_BookProvider.dao.factory;

import com.naresh.Jersey2.x_BookProvider.dao.BookDao;
import com.naresh.Jersey2.x_BookProvider.dao.BookDaoImpl;

public class DaoFactory {

	private static BookDao bookDao;
	static {
		bookDao=new BookDaoImpl();
	}
    public static  BookDao getBookFactory() {
    	 return bookDao;
     }
}
