package com.naresh.Jersey2.x_BookProvider.dao;

import org.hibernate.HibernateException;

import com.naresh.Jersey2.x_BookProvider.domain.Book;

public interface BookDao {
	public Book getBookDetails(Integer bookId)throws HibernateException,Exception;
	public String registerBook(Book book)throws HibernateException,Exception;
	

}
