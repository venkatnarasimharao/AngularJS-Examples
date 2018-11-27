package com.naresh.Jersey2.x_BookProvider.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	static {
		
		Configuration configuration= new Configuration().configure("com/naresh/Jersey2/x_BookProvider/cfg/cfg.xml");
		sessionFactory=configuration.buildSessionFactory();
		
	}
	public static Session getSession() {
		if(sessionFactory!=null) {
			session=sessionFactory.openSession();
		}
		return session;
		
	}
		
	public static void closeSession(Session session) {
			session.close();
		}

}
