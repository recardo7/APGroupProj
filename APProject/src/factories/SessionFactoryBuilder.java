package factories;

import javax.swing.JOptionPane;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Student;

public class SessionFactoryBuilder {
	private static final Configuration config = new Configuration();
	private static SessionFactory sessionFactory = null;
	private static SessionFactory getSessionFactory() throws HibernateException {
		if(sessionFactory == null) {
			config.configure("hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	protected static Session getSession() {
		
		SessionFactory factory = getSessionFactory();
		if(factory != null) {
			return factory.openSession();
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	public Boolean insertStudent(Student studentObj) {
		Session session = getSession();
		Transaction trans = null;//hibernate import
		try {
			trans = (Transaction) session.beginTransaction();
			session.save(studentObj); //Save the student record
			trans.commit(); //Commit the database transaction
			JOptionPane.showMessageDialog(null, "Record inserted successfully", 
					"Insersion success", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
