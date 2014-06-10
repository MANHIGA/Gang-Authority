package frame;

import model.*;

import org.hibernate.*;

public class Run {
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {
		Session session = null;
		try {
			try {
				sessionFactory = AppFactory.getSessionFactory();
				session = sessionFactory.openSession();

				System.out.println("Inserting Record");
				Transaction tx = session.beginTransaction();

				//Joueur person = new Joueur();
				System.out.println(Joueur.etreJoueur("noob", "yamete"));

				//session.save(person);
				tx.commit();

				System.out.println("Done");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
