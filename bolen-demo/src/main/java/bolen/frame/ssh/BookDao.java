package bolen.frame.ssh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bolen.pojo.Book;

public class BookDao extends HibernateDaoSupport {

	public void saveBook(Book book) {
		SessionFactory sessionFactory = this.getSessionFactory();
		org.hibernate.classic.Session currentSession = sessionFactory
				.getCurrentSession();
		org.hibernate.classic.Session openSession = sessionFactory
				.openSession();
		Session session = this.getSession();
		Session session2 = this.getSession();
		System.out.println("===================================");
		System.out.println(session == session2);

		System.out.println("===================================");
		Session session3 = this.getSession(true);
		Session session4 = this.getSession(true);
		System.out.println(session3 == session4);
		System.out.println("===================================");
		Session session5 = this.getSession(false);
		Session session6 = this.getSession(false);
		System.out.println(session3 == session4);
		this.getHibernateTemplate().saveOrUpdate(book);
	}

	public void updateBook(Book book) {

		this.getHibernateTemplate().saveOrUpdate(book);
	}
}
