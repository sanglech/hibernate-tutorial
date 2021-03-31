package com.christian.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.christian.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			
			//start txn
			session.beginTransaction();
			
			//retrieve the student obj
			System.out.println("Retrieving Student obj");
			
			List<Student> theStudents= session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery(" from Student s where s.lastName = 'Doe'").getResultList();
			System.out.println("Students with the last name Doe: ");
			displayStudents(theStudents);
			
			
			theStudents = session.createQuery(" from Student s where "
					+ " s.email LIKE '%sangle.com'").getResultList();
			System.out.println("Students with the email ending with sangle.com: ");
			displayStudents(theStudents);
			
			//comit txn
			session.getTransaction().commit();
			
			System.out.println("Complete");
			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student s: theStudents) {
			System.out.println("Student retrieved: " + s);
		}
	}

}
