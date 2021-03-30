package com.christian.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.christian.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		///create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session= factory.getCurrentSession();
		
		try {
			
			//create multiple studen objects
			Student studentOne = new Student("Mary","Poppins","mary@poppins.com");
			Student studentTwo = new Student("John","Doe","john@doe.com");
			Student studentThree = new Student("Apple","Bom","apple@bom.com");
			
			//start txn
			session.beginTransaction();
			
			//save the student objs
			System.out.println("Saving new Student obj");
			session.save(studentOne);
			session.save(studentTwo);
			session.save(studentThree);
			
			//comit txn
			session.getTransaction().commit();
			
			System.out.println("Complete");
			
		}finally {
			factory.close();
		}
	}

}
