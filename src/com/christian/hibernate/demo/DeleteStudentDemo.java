package com.christian.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.christian.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			Student tempStudent = new Student("Daffy","Duck","dafn@dunk.com");
			
			//start txn
			session.beginTransaction();
			
			//save the student obj
			System.out.println("Saving new Student "+ tempStudent);
			session.save(tempStudent);
			
			//Deleting obj
			System.out.println("Deleting  Student "+ tempStudent);
			//session.createQuery ("delete from Student where id = 2")
			
			
			//comit txn
			session.getTransaction().commit();
			
			System.out.println("Complete");
			
		}finally {
			factory.close();
		}
	}

}
