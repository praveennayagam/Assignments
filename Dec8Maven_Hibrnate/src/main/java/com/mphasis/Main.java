package com.mphasis;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mphasis.model.Student;
import com.mphasis.util.HibernateUtil;


public class Main {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// get all students
//		List<Student>student=session.createQuery("From Student",Student.class).list();
//		student.forEach(System.out::println);

		// addStudent
//		session.save(new Student(125,"saro","angular"));
//		session.save(new Student(127,"bala","java"));
//		session.save(new Student(128,"prabha","spring"));
//		tx.commit();

		// get all students()
		List<Student> student = session.createQuery("From Student", Student.class).list();
		student.forEach(System.out::println);

		// getStudentsByCourse()

		Query<Student> q1 = session.createQuery("From Student where course=:c");
		q1.setParameter("c", "spring");
		q1.list().forEach(System.out::println);
		
		
		//getAllStudents whose name starts with A
		Query<Student> q2 = session.createQuery("From Student where sname like 'p%'");
		q2.list().forEach(System.out::println);
		
		
		//getALLStudent by specific column
		Query<Object[]> q=session.createQuery("select sid,sname from Student",Object[].class);
		q.list().forEach(s->System.out.println(s[0]+" "+s[1]));
		//student.forEach(s->System.out.println(s.getSid()+" : "+s.getSname()));
		
		//count of rows
		
		Query<Student> q3=session.createQuery("select count(*) from Student");
		System.out.println(q3.uniqueResult());
		
		//group by using count of course
		
		Query<Object[]> q4=session.createQuery("select course,count(*) from Student group by course");
		q4.list().forEach(s->System.out.println(s[0]+" "+s[1]));
		
		
		
		//using named query
		Query<Student> q5=session.createNamedQuery("Student.findAll",Student.class);
		System.out.println("-------------------------using named query------------------------------");
		q5.list().forEach(System.out::println);
		
		System.out.println("-------------------------findbycourses using named query------------------------------");
		Query<Student> q6=session.createNamedQuery("Student.findByCourse",Student.class);
		q6.setParameter("course", "spring");
		q6.list().forEach(System.out::println);
		
		System.out.println("-------------------------findbycourses using named query------------------------------");
		Query<Long> q7=session.createNamedQuery("Student.count",Long.class);
		System.out.println(q7.uniqueResult());
		
		
		System.out.println("-------------------------groupbycourses using named query------------------------------");
		Query<Object[]> q8=session.createNamedQuery("Student.groupByCourse",Object[].class);
		q8.list().forEach(s->System.out.println(s[0]+" "+s[1]));
		
		
		System.out.println("-------------------------startswith using named query------------------------------");
		Query<Student> q9=session.createNamedQuery("Student.startsWith",Student.class);
		q9.list().forEach(System.out::println);
		
		tx.commit();
		session.close();
	}

}
