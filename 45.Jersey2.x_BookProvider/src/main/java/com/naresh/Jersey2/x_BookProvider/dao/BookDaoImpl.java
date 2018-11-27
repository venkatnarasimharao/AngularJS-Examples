package com.naresh.Jersey2.x_BookProvider.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naresh.Jersey2.x_BookProvider.domain.Book;
import com.naresh.Jersey2.x_BookProvider.util.HibernateUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public Book getBookDetails(Integer bookId) throws HibernateException,Exception{
		Book book=null;
		Session session=HibernateUtil.getSession();
		
		if(session!=null) {
			String hql="from "+Book.class.getName()+" where bookId=?";
			
			Query<?> query=session.createQuery(hql);
			query.setParameter(0, bookId);
			book=(Book) query.uniqueResult();
			
		}else {
			return book;
		}
		    return book;
	}

	@Override
	public String registerBook(Book book) throws HibernateException,Exception{
        Session session=HibernateUtil.getSession();
        String message="not registered successfully";
        Transaction tx=null;
        if(session!=null) {
        	tx=session.beginTransaction();
        	Integer serialId=(Integer) session.save(book);
        
        	if(serialId!=null && serialId>0) {
        		tx.commit();
        		message="successfully registered";
        		return message;
        	}
        	else {
        		tx.rollback();
        		return message;
        	}
        }
        else {
        	return "session problem";
        }
	}

	


}