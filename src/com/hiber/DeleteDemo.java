package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int id = 2;
			Instructor instructor = session.get(Instructor.class, id);
			
			if(instructor!=null) {
				System.out.println("Found");
				session.delete(instructor);
			}
			
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
