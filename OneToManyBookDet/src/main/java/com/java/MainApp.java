package com.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {

	public static void main(String[] args) {

		Configuration conn=new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Publisher.class);	
	    ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conn.getProperties()).buildServiceRegistry();
	    SessionFactory sf=conn.buildSessionFactory(reg);
	    Session sess=sf.openSession();
	   Transaction tx=sess.beginTransaction();
		
	   
		 Book book1=new Book(1,"Oracle" ,"Steven",900);
		 Book book2=new Book(2,"C++ " ,"Reema",900);
		 Book book3=new Book(3,"PHP" ,"Kevin",800);
 Set<Book>booklist=new HashSet<Book>(Arrays.asList(book1,book2,book3));

      
	Publisher pub=new Publisher();
	pub.setPublisherId(1);
	pub.setPublisherName("AAA pubb");
	pub.setBooklist(booklist);
	sess.save(pub);
	tx.commit();
	
	
	
	sess.close();
	}

}
