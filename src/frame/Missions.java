package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.SessionJoueur;

public class Missions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Missions frame = new Missions();
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
	public Missions() {
		setTitle("Gang Authority - Réaliser des missions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMissions = new JLabel("Missions disponibles");
		lblMissions.setBounds(36, 30, 144, 16);
		contentPane.add(lblMissions);
		
		JList listMissions = new JList();
		lblMissions.setLabelFor(listMissions);
		listMissions.setBounds(36, 58, 138, 146);
		contentPane.add(listMissions);
		
		JLabel lblNombreDeSbires = new JLabel("Nombre de sbires");
		lblNombreDeSbires.setBounds(220, 33, 117, 16);
		contentPane.add(lblNombreDeSbires);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(220, 61, 30, 30);
		contentPane.add(btnPlus);
		
		JLabel lblCountSbires = new JLabel("0");
		lblCountSbires.setBackground(Color.LIGHT_GRAY);
		lblCountSbires.setBounds(293, 61, 44, 29);
		contentPane.add(lblCountSbires);
		
		JButton btnMoins = new JButton("-");
		btnMoins.setBounds(349, 61, 30, 30);
		contentPane.add(btnMoins);
		
		JLabel lblAttaque = new JLabel("Puissance d'attaque : 0");
		lblAttaque.setBounds(220, 118, 156, 16);
		contentPane.add(lblAttaque);
		
		JLabel lblDefense = new JLabel("Puissance défensive : 0");
		lblDefense.setBounds(220, 146, 156, 16);
		contentPane.add(lblDefense);
		
		JLabel lblRecompense = new JLabel("Récompense : 0$");
		lblRecompense.setBounds(36, 216, 211, 16);
		contentPane.add(lblRecompense);
		
		JLabel lblTempsRequis = new JLabel("Temps requis : 0 secondes");
		lblTempsRequis.setBounds(36, 244, 211, 16);
		contentPane.add(lblTempsRequis);
		
		JButton btnAttaquer = new JButton("Attaquer");
		btnAttaquer.setBounds(310, 231, 117, 29);
		contentPane.add(btnAttaquer);
		
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
				SessionJoueur.close();
				Connexion.main(new String[0]);
				dispose();
			}
		});
		menuBar.add(mnDconnexion);
	}
}
