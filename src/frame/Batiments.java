package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
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
import model.TypeBatiment;

public class Batiments extends JFrame {

	private JPanel contentPane;
	private Integer lvlQG = 0;
	private Integer lvlCas = 0;
	private Integer lvlUs = 0;
	private Integer lvlCyb = 0;
	private Integer argent = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Batiments frame = new Batiments();
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
	public Batiments() {
		setTitle("Gang Authority - Améliorer des Bâtiments");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Joueur joueur = SessionJoueur.getInstance().getJoueur();
		final List<Construire> batiments = joueur.getMesBatiments();
		argent = joueur.getArgent();
		
		for(Construire batiment : batiments){
			if(batiment.getTypeBatiment().getLibelleTypeBatiment().equals("Quartier Général")){
				lvlQG = batiment.getNiveau();
			} else if(batiment.getTypeBatiment().getLibelleTypeBatiment().equals("Casino")) {
				lvlCas = batiment.getNiveau();
			} else if(batiment.getTypeBatiment().getLibelleTypeBatiment().equals("Usine")) {
				lvlUs = batiment.getNiveau();
			} else if(batiment.getTypeBatiment().getLibelleTypeBatiment().equals("Cybercafe")) {
				lvlCyb = batiment.getNiveau();
			}
		}
		
		
		final JLabel lblCapital = new JLabel("Capital : $"+ argent);
		lblCapital.setBounds(20, 33, 109, 16);
		contentPane.add(lblCapital);
		
		JLabel lblQuartierGeneral = new JLabel("Quartier Général");
		lblQuartierGeneral.setBackground(Color.RED);
		lblQuartierGeneral.setBounds(20, 73, 109, 23);
		contentPane.add(lblQuartierGeneral);

		final JLabel lblNiveauQG = new JLabel("Niveau : "+lvlQG);
		lblNiveauQG.setBounds(190, 76, 109, 16);
		contentPane.add(lblNiveauQG);
		
		JButton btnConstruireQG = new JButton("Construire");
		btnConstruireQG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean trouve = false;
				for(Construire batiment : batiments){
					if(batiment.getTypeBatiment().getLibelleTypeBatiment().equals("Quartier Général")){
						joueur.ameliorerBatiment(batiment);
						trouve = true;
						lvlQG = batiment.getNiveau();
					}
				}
				if(trouve == false){
					List<TypeBatiment> listTypeBatiment = TypeBatiment.getTypesBatiments();
					int i = 0;
					while(i < listTypeBatiment.size() && trouve == false){
						if(listTypeBatiment.get(i).getLibelleTypeBatiment().equals("Quartier Général")){
							trouve = true;
							joueur.creerBatiment(listTypeBatiment.get(i));
							lvlQG = 1;
						}
						i++;
					}	
					
				}
				argent = joueur.getArgent();
				lblNiveauQG.setText("Niveau : "+lvlQG);
				lblCapital.setText("Capital : $"+ argent);
				Batiments.main(new String[0]);
				dispose();
			}
		});
		btnConstruireQG.setBounds(309, 70, 117, 29);
		contentPane.add(btnConstruireQG);
		
		JLabel lblCasino = new JLabel("Casino");
		lblCasino.setBounds(20, 124, 109, 16);
		contentPane.add(lblCasino);
		
		JLabel lblUsine = new JLabel("Usine");
		lblUsine.setBounds(20, 173, 109, 16);
		contentPane.add(lblUsine);
		
		JLabel lblCybercaf = new JLabel("Cybercafé");
		lblCybercaf.setBounds(20, 222, 109, 16);
		contentPane.add(lblCybercaf);
		
		final JLabel lblNiveauCa = new JLabel("Niveau : "+lvlCas);
		lblNiveauCa.setBounds(190, 124, 109, 16);
		contentPane.add(lblNiveauCa);
		
		final JLabel lvlNiveauU = new JLabel("Niveau : "+lvlUs);
		lvlNiveauU.setBounds(190, 173, 109, 16);
		contentPane.add(lvlNiveauU);
		
		final JLabel lblNiveauCy = new JLabel("Niveau : "+lvlCyb);
		lblNiveauCy.setBounds(190, 222, 109, 16);
		contentPane.add(lblNiveauCy);
		
		JButton btnConstruireCa = new JButton("Construire");
		btnConstruireCa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean trouve = false;
				for(Construire batiment : batiments){
					if(batiment.getTypeBatiment().getLibelleTypeBatiment().equals("Casino")){
						trouve = true;
						joueur.ameliorerBatiment(batiment);
					}
				}
				if(trouve == false){
					List<TypeBatiment> listTypeBatiment = TypeBatiment.getTypesBatiments();
					int i = 0;
					while(i < listTypeBatiment.size() && trouve == false){
						if(listTypeBatiment.get(i).getLibelleTypeBatiment().equals("Casino")){
							trouve = true;
							joueur.creerBatiment(listTypeBatiment.get(i));
							lvlCas = 1;
						}
						i++;
					}	
					
				}
				argent = joueur.getArgent();
				lblNiveauCa.setText("Niveau : "+lvlQG);
				lblCapital.setText("Capital : $"+ argent);
				Batiments.main(new String[0]);
				dispose();
			}
		});
		btnConstruireCa.setBounds(309, 118, 117, 29);
		contentPane.add(btnConstruireCa);
		
		JButton btnConstruireU = new JButton("Construire");
		btnConstruireU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean trouve = false;
				for(Construire batiment : batiments){
					if(batiment.getTypeBatiment().getLibelleTypeBatiment().equals("Usine")){
						trouve = true;
						joueur.ameliorerBatiment(batiment);
					}
				}
				if(trouve == false){
					List<TypeBatiment> listTypeBatiment = TypeBatiment.getTypesBatiments();
					int i = 0;
					while(i < listTypeBatiment.size() && trouve == false){
						if(listTypeBatiment.get(i).getLibelleTypeBatiment().equals("Usine")){
							trouve = true;
							joueur.creerBatiment(listTypeBatiment.get(i));
							lvlUs = 1;
						}
						i++;
					}	
					
				}
				argent = joueur.getArgent();
				lvlNiveauU.setText("Niveau : "+lvlUs);
				lblCapital.setText("Capital : $"+ argent);
				Batiments.main(new String[0]);
				dispose();
			}
		});
		btnConstruireU.setBounds(309, 167, 117, 29);
		contentPane.add(btnConstruireU);
		
		JButton btnConstruireCy = new JButton("Construire");
		btnConstruireCy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean trouve = false;
				for(Construire batiment : batiments){
					if(batiment.getTypeBatiment().getLibelleTypeBatiment().equals("Cybercafe")){
						trouve = true;
						joueur.ameliorerBatiment(batiment);
					}
				}
				if(trouve == false){
					List<TypeBatiment> listTypeBatiment = TypeBatiment.getTypesBatiments();
					int i = 0;
					while(i < listTypeBatiment.size() && trouve == false){
						if(listTypeBatiment.get(i).getLibelleTypeBatiment().equals("Cybercafe")){
							trouve = true;
							joueur.creerBatiment(listTypeBatiment.get(i));
							lvlCyb = 1;
						}
						i++;
					}	
					
				}
				argent = joueur.getArgent();
				lblNiveauCy.setText("Niveau : "+lvlQG);
				lblCapital.setText("Capital : $"+ argent);
				Batiments.main(new String[0]);
				dispose();
			}
		});
		btnConstruireCy.setBounds(327, 217, 117, 29);
		contentPane.add(btnConstruireCy);
		
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
