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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.AppFactory;
import model.SessionJoueur;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Gang Authority - Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGererGang = new JButton("G\u00E9rer mon gang");
		btnGererGang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gang.main(new String[0]);
				dispose();
			}
		});
		btnGererGang.setBounds(24, 56, 183, 81);
		contentPane.add(btnGererGang);
		
		JButton btnConsulterProfil = new JButton("Consulter mon profil");
		btnConsulterProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Profil.main(new String[0]);
				dispose();
			}
		});
		btnConsulterProfil.setBounds(246, 56, 175, 81);
		contentPane.add(btnConsulterProfil);
		
		JButton btnRedirectionSite = new JButton("Aller sur le site");
		btnRedirectionSite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(Desktop.isDesktopSupported()){
						//A remplacer par l'adresse menant à la création de compte
						Desktop.getDesktop().browse(new URI("http://localhost/www.gangauthority.com/web/app.php/"));
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
		btnRedirectionSite.setBounds(137, 201, 175, 29);
		contentPane.add(btnRedirectionSite);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		contentPane.add(menuBar);
		
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
