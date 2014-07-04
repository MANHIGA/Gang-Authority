package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AppFactory;
import model.Joueur;
import model.SessionJoueur;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profil frame = new Profil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Profil() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu.main(new String[0]);
				dispose();
			}
		});
		menuBar.add(mnMenu);
		
		JMenu mnDconnexion = new JMenu("D\u00E9connexion");
		mnDconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SessionJoueur.getInstance().getJoueur().setJoueurConnecte(false);
				Session session = AppFactory.getSessionFactory().openSession();
				Transaction tx = session.beginTransaction();
				session.update(SessionJoueur.getInstance().getJoueur());
				tx.commit();
				session.close();
				SessionJoueur.close();
				Connexion.main(new String[0]);
				dispose();
			}
		});
		menuBar.add(mnDconnexion);
		SessionJoueur sessionJoueur = SessionJoueur.getInstance();
		if(sessionJoueur != null){
			Joueur joueur = sessionJoueur.getJoueur();
			
			setTitle("Gang Authority - Profil joueur");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblGang = new JLabel("Gang : " + joueur.getNomGang());
			lblGang.setBounds(146, 23, 251, 16);
			contentPane.add(lblGang);
			
			JLabel lblCapital = new JLabel("Capital : " + joueur.getArgent() + "$");
			lblCapital.setBounds(30, 99, 202, 16);
			contentPane.add(lblCapital);
			
			JLabel lblNbMorts = new JLabel("Nombre de victoires : " + joueur.getNbTues());
			lblNbMorts.setBounds(30, 175, 202, 16);
			contentPane.add(lblNbMorts);
			
			JLabel lblNbDefaites = new JLabel("Nombre de d\u00E9faites : " + joueur.getNbMorts());
			lblNbDefaites.setBounds(242, 175, 202, 16);
			contentPane.add(lblNbDefaites);
			
			JLabel lblNbPoints = new JLabel("Nombre de points d'autorit\u00E9s : " + joueur.getPointAutorite());
			lblNbPoints.setBounds(193, 99, 251, 16);
			contentPane.add(lblNbPoints);
		}else{
			Connexion.main(new String[0]);
		}
	}
}
