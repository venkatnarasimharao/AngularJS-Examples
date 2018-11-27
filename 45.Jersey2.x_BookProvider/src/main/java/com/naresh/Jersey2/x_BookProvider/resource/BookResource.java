package com.naresh.Jersey2.x_BookProvider.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;

import com.naresh.Jersey2.x_BookProvider.dao.BookDao;
import com.naresh.Jersey2.x_BookProvider.dao.factory.DaoFactory;
import com.naresh.Jersey2.x_BookProvider.domain.Book;
import com.naresh.Jersey2.x_BookProvider.domain.ResponseDTO;
import com.naresh.Jersey2.x_BookProvider.util.JsonUtil;

@Path(value="bookDetails")
public class BookResource {
	
	@GET
	@Path(value="searchBookByXml")
	@Produces(value= {MediaType.APPLICATION_XML})
	public Book	 getBookDetailsByXml(@MatrixParam(value="bid")Integer bookId) {
		 BookDao bookDao=DaoFactory.getBookFactory();
		 Book book=null;
		
		try {
		book=bookDao.getBookDetails(bookId);
		} 
		catch (HibernateException e) {
			
			e.printStackTrace();
		}
		catch (Exception e) {
	
			e.printStackTrace();
		}
		return book;
	}
	@GET
	@Path(value="searchBookByJson")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public String getBookDetailsByJson(@MatrixParam(value="bid")Integer bookId) {
		 BookDao bookDao=DaoFactory.getBookFactory();
		 String status="not ok";
		 String message="not fetched successfully";
		 String json=null;
		 ResponseDTO responseDTO= new ResponseDTO();
		 responseDTO.setStatus(status);
		 responseDTO.setMessage(message);
		 responseDTO.setData("N/A book data");
		 json=JsonUtil.convertJavaToJson(responseDTO);
		 Book book=null;
		try {
		book=bookDao.getBookDetails(bookId);
		if(book!=null ) {
		status="ok";
		message="successfully fetched";
		
		responseDTO.setData(book);
		responseDTO.setStatus(status);
		responseDTO.setMessage(message);
		json=JsonUtil.convertJavaToJson(responseDTO);
		return json;
		}
		else {
			return json;
		}
		} 
		catch (HibernateException e) {
			
			System.out.println(e.getMessage());;
		}
		catch (Exception e) {
	
			System.out.println(e.getMessage());
		}
		return json;
		
	}
	@POST
	@Path(value="registerBookByJson")
	@Consumes(value= {MediaType.APPLICATION_JSON})
	@Produces(value= {MediaType.APPLICATION_JSON})
	public String registerBookByJson(String json) {
		Book book=JsonUtil.convertJsonToJava(Book.class, json);
		BookDao bookDao=DaoFactory.getBookFactory();
		String status="not ok";
		String message="not registered successfully";
		String jsonObject=null;
		ResponseDTO responseDTO= new ResponseDTO();
		responseDTO.setMessage(message);
		responseDTO.setStatus(status);
		responseDTO.setData("invisible");
		jsonObject=JsonUtil.convertJavaToJson(responseDTO);
		
		try {
			message=bookDao.registerBook(book);
			if(message!=null) {
			responseDTO.setMessage(message);
			responseDTO.setStatus("OK");
			responseDTO.setData("invisible");
			jsonObject=JsonUtil.convertJavaToJson(responseDTO);
			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage()+" "+"database problem");
		}
		return jsonObject;
		
	}
	@POST
	@Path(value="registerBookByXml")
	@Consumes(value= {MediaType.APPLICATION_XML})
	@Produces(value= {MediaType.APPLICATION_XML})
	public String registerBookByXml(Book book) {
		
		System.out.println(book);
		BookDao bookDao=DaoFactory.getBookFactory();
		String message="not registered successfully";
		try {
			message=bookDao.registerBook(book);
		} catch (Exception e) {
			
			System.out.println(e.getMessage()+" "+"database problem");
		}
		return message;
		
	}

}
