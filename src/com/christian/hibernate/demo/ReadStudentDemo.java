package com.christian.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.christian.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		///create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		
		Session session= factory.getCurrentSession();
		
		try {
			
			//create a student obj
			
			System.out.println("Creating a new Student obj");
			
			Student tempStudent;
			
			//start txn
			session.beginTransaction();
			
			//retrieve the student obj
			System.out.println("Retrieving Student obj");
			
			tempStudent= session.get(Student.class, 1);
			
			System.out.println("Student retrieved: " + tempStudent);
			
		
			//comit txn
			session.getTransaction().commit();
			
			System.out.println("Complete");
			
		}finally {
			factory.close();
		}
	}

}
