package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.AppFactory;
import model.Combattre;
import model.Joueur;
import model.SessionJoueur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Resultat extends JFrame {

	private JPanel contentPane;
	private Combattre combat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, final Combattre combat) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultat frame = new Resultat(combat);
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
	public Resultat(Combattre combat) {
		setTitle("Gang Authority - Compte Rendu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Joueur j = SessionJoueur.getInstance().getJoueur();
		
		final Joueur ennemi = combat.getDefenseur();
		
		JLabel lblCombatContreJoueur = new JLabel("Combat contre"+ennemi.getPseudo());
		lblCombatContreJoueur.setBounds(37, 49, 200, 16);
		contentPane.add(lblCombatContreJoueur);
		
		String resultat = "";
		if(j.getIdCompte().equals(combat.getGagnant().getIdCompte())){
			resultat += "VICTOIRE";
		} else {
			resultat += "DEFAITE";
		}
		JLabel lblDefaite = new JLabel(resultat);
		lblDefaite.setBounds(323, 49, 61, 16);
		contentPane.add(lblDefaite);
		
		JLabel lblPerte = new JLabel("Perte : 0$ et 0 points d'autorit\u00E9");
		lblPerte.setBounds(86, 105, 321, 16);
		contentPane.add(lblPerte);
		
		JButton btnSignalerLeJoueur = new JButton("Signaler le joueur");
		btnSignalerLeJoueur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] s = new String[1];
				s[0] = ennemi.getPseudo();
				Signalement.main(s);
				dispose();
			}
		});
		btnSignalerLeJoueur.setBounds(129, 164, 173, 77);
		contentPane.add(btnSignalerLeJoueur);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu.main(new String[0]);
				dispose();
			}
		});
		menuBar.add(mnMenu);
		
		JMenu mnDconnexion = new JMenu("Déconnexion");
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
	}

}
