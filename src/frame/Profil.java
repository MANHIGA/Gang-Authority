package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Joueur;
import model.SessionJoueur;

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
