package frame;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.AppFactory;
import model.SessionJoueur;

public class Gang extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gang frame = new Gang();
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
	public Gang() {
		setTitle("Gang Authority - Gérer mon Gang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAccederMissions = new JButton("Acc\u00E9der aux missions");
		btnAccederMissions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Missions.main(new String[0]);
				dispose();
			}
		});
		btnAccederMissions.setBounds(16, 40, 191, 54);
		contentPane.add(btnAccederMissions);
		
		JButton btnRecruterSbires = new JButton("Recruter des sbires");
		btnRecruterSbires.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sbires.main(new String[0]);
				dispose();
			}
		});
		btnRecruterSbires.setBounds(238, 120, 191, 57);
		contentPane.add(btnRecruterSbires);
		
		JButton btnGererBatiments = new JButton("G\u00E9rer les b\u00E2timents");
		btnGererBatiments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Batiments.main(new String[0]);
				dispose();
			}
		});
		btnGererBatiments.setBounds(16, 120, 191, 57);
		contentPane.add(btnGererBatiments);
		
		JButton btnConsulterPatrimoine = new JButton("Consulter mon patrimoine");
		btnConsulterPatrimoine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Patrimoine.main(new String[0]);
				dispose();
			}
		});
		btnConsulterPatrimoine.setBounds(238, 39, 191, 57);
		contentPane.add(btnConsulterPatrimoine);
		
		JButton btnAttaquerGang = new JButton("Attaquer un gang");
		btnAttaquerGang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Attaque.main(new String[0]);
				dispose();
			}
		});
		btnAttaquerGang.setBounds(142, 203, 163, 57);
		contentPane.add(btnAttaquerGang);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 460, 22);
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
