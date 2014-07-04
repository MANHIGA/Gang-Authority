package frame;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.AppFactory;
import model.Joueur;
import model.SessionJoueur;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JLabel lblCreerUnCompte;
	private JLabel lblOubliMotDePasse;
	private JPasswordField txtMotDePasse;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		setTitle("Gang Authority - Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblErreur = new JLabel();
		lblErreur.setForeground(Color.RED);
		lblErreur.setBounds(106, 25, 287, 16);
		contentPane.add(lblErreur);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setBounds(88, 53, 61, 16);
		contentPane.add(lblPseudo);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(68, 111, 96, 16);
		contentPane.add(lblMotDePasse);

		txtPseudo = new JTextField();
		lblPseudo.setLabelFor(txtPseudo);
		txtPseudo.setBounds(225, 53, 134, 28);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);

		try{
			Class.forName("model.Admin");
			Class.forName("frame.Administration");
			final JCheckBox chckbxAdministrateur = new JCheckBox("Administrateur");
			chckbxAdministrateur.setBounds(149, 155, 128, 23);
			contentPane.add(chckbxAdministrateur);
			
			JButton btnValider = new JButton("Valider");
			btnValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!txtPseudo.getText().equals("") && !txtMotDePasse.getText().equals("")) {
						if(chckbxAdministrateur.getSelectedObjects() == null){
							Joueur joueur = Joueur.getJoueurByPseudoMdp(
									txtPseudo.getText(), txtMotDePasse.getText());
							if (joueur != null) {
								SessionJoueur sessionJoueur = SessionJoueur
										.getInstance();
								sessionJoueur.setJoueur(joueur);
								Menu.main(new String[0]);
								dispose();
							}else{
								lblErreur.setText("Identifiant ou mot de passe incorrect");
							}
						}else{
							Integer adminId = model.Admin.getAdminId(txtPseudo.getText(), txtMotDePasse.getText());
							if(adminId != null){
								String str[] = {adminId.toString()};
								frame.Administration.main(str);
								dispose();
							}else{
								lblErreur.setText("Identifiant ou mot de passe incorrect");
							}
						}
					}
				}
			});
			btnValider.setBounds(149, 199, 117, 29);
			contentPane.add(btnValider);
		}catch(Exception e){
			JButton btnValider = new JButton("Valider");
			btnValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!txtPseudo.getText().equals("") && !txtMotDePasse.getText().equals("")) {
						Joueur joueur = Joueur.getJoueurByPseudoMdp(
								txtPseudo.getText(), txtMotDePasse.getText());
						if (joueur != null) {
							Session s = AppFactory.getSessionFactory().openSession();
							Transaction tx = s.beginTransaction();
							joueur.setJoueurConnecte(true);
							s.update(joueur);
							tx.commit();
							s.close();
							
							SessionJoueur sessionJoueur = SessionJoueur
									.getInstance();
							sessionJoueur.setJoueur(joueur);
							Menu.main(new String[0]);
							dispose();
						}else{
							lblErreur.setText("Identifiant ou mot de passe incorrect");
						}
					}
				}
			});
			btnValider.setBounds(149, 199, 117, 29);
			contentPane.add(btnValider);
		}

		lblCreerUnCompte = new JLabel("Cr\u00E9er un compte");
		lblCreerUnCompte.setForeground(Color.BLUE);
		lblCreerUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					if (Desktop.isDesktopSupported()) {
						// A remplacer par l'adresse menant à la création de
						// compte
						Desktop.getDesktop().browse(
								new URI("http://localhost/www.gangauthority.com/web/app.php/signup"));
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblCreerUnCompte.setBounds(68, 243, 117, 16);
		contentPane.add(lblCreerUnCompte);

		lblOubliMotDePasse = new JLabel("Mot de passe oubli\u00E9");
		lblOubliMotDePasse.setForeground(Color.BLUE);
		lblOubliMotDePasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (Desktop.isDesktopSupported()) {
						// A remplacer par l'adresse menant au mot de passe
						// oublié
						Desktop.getDesktop().browse(
								new URI("http://localhost/www.gangauthority.com/web/app.php/oublimdp"));
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblOubliMotDePasse.setBounds(238, 243, 155, 16);
		contentPane.add(lblOubliMotDePasse);
		
		txtMotDePasse = new JPasswordField();
		txtMotDePasse.setBounds(225, 105, 134, 28);
		contentPane.add(txtMotDePasse);
		
	}
}
