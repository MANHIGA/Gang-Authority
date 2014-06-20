package frame;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JTextField txtMotDePasse;
	private JLabel lblCreerUnCompte;
	private JLabel lblOubliMotDePasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setBounds(88, 88, 61, 16);
		contentPane.add(lblPseudo);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(72, 140, 96, 16);
		contentPane.add(lblMotDePasse);
		
		txtPseudo = new JTextField();
		lblPseudo.setLabelFor(txtPseudo);
		txtPseudo.setBounds(225, 82, 134, 28);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		txtMotDePasse = new JTextField();
		lblMotDePasse.setLabelFor(txtMotDePasse);
		txtMotDePasse.setBounds(225, 134, 134, 28);
		contentPane.add(txtMotDePasse);
		txtMotDePasse.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnValider.setBounds(149, 199, 117, 29);
		contentPane.add(btnValider);
		
		lblCreerUnCompte = new JLabel("Cr\u00E9er un compte");
		lblCreerUnCompte.setForeground(Color.BLUE);
		lblCreerUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					if(Desktop.isDesktopSupported()){
						//A remplacer par l'adresse menant à la création de compte
						Desktop.getDesktop().browse(new URI("http://www.google.com"));
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
					if(Desktop.isDesktopSupported()){
						//A remplacer par l'adresse menant au mot de passe oublié
						Desktop.getDesktop().browse(new URI("http://www.google.com"));
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
	}
}