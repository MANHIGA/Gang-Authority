package frame;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.AppFactory;
import model.Construire;
import model.Joueur;
import model.SessionJoueur;

public class Patrimoine extends JFrame {

	private JPanel contentPane;
	private Integer lvlQG = 0;
	private Integer lvlCas = 0;
	private Integer lvlUs = 0;
	private Integer lvlCyb = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patrimoine frame = new Patrimoine();
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
	public Patrimoine() {
		setTitle("Gang Authority - Consulter le patrimoine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Joueur joueur = SessionJoueur.getInstance().getJoueur();
		List<Construire> batiments = joueur.getMesBatiments();
		Integer argent = joueur.getArgent();
		Integer points = joueur.getPointAutorite();
		
		for(Construire c : batiments){
			if(c.getTypeBatiment().getLibelleTypeBatiment().equals("Quartier Général")){
				lvlQG = c.getNiveau();
			} else if(c.getTypeBatiment().getLibelleTypeBatiment().equals("Casino")){
				lvlCas = c.getNiveau();
			} else if(c.getTypeBatiment().getLibelleTypeBatiment().equals("Cybercafe")){
				lvlCyb = c.getNiveau();
			} else if(c.getTypeBatiment().getLibelleTypeBatiment().equals("Usine")){
				lvlUs = c.getNiveau();
			}
		}
		
		JLabel lblQG = new JLabel("Quartier G\u00E9n\u00E9ral");
		lblQG.setBounds(25, 34, 107, 16);
		contentPane.add(lblQG);
		
		JLabel lblNiveauQG = new JLabel("Niveau : "+lvlQG);
		lblNiveauQG.setBounds(176, 34, 97, 16);
		contentPane.add(lblNiveauQG);
		
		JLabel lblCa = new JLabel("Casino");
		lblCa.setBounds(25, 77, 61, 16);
		contentPane.add(lblCa);
		
		JLabel lblNiveauCa = new JLabel("Niveau : "+lvlCas);
		lblNiveauCa.setBounds(176, 77, 85, 16);
		contentPane.add(lblNiveauCa);
		
		
		JLabel lblCy = new JLabel("Cybercafe");
		lblCy.setBounds(25, 125, 107, 16);
		contentPane.add(lblCy);
		
		JLabel lblNiveauCy = new JLabel("Niveau : "+lvlCyb);
		lblNiveauCy.setBounds(176, 125, 97, 16);
		contentPane.add(lblNiveauCy);
		
		JLabel lblU = new JLabel("Usine");
		lblU.setBounds(25, 174, 61, 16);
		contentPane.add(lblU);
		
		JLabel lblNiveauU = new JLabel("Niveau : "+lvlUs);
		lblNiveauU.setBounds(176, 174, 97, 16);
		contentPane.add(lblNiveauU);
		
		JLabel lblCapital = new JLabel("Capital : $"+argent);
		lblCapital.setBounds(61, 238, 139, 16);
		contentPane.add(lblCapital);
		
		JLabel lblPointsAutorite = new JLabel("Points d'autorit\u00E9 : "+points);
		lblPointsAutorite.setBounds(200, 238, 175, 16);
		contentPane.add(lblPointsAutorite);
		
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
	}
}
