package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.SessionJoueur;

public class Batiments extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblCapital = new JLabel("Capital : 0$");
		lblCapital.setBounds(335, 30, 109, 16);
		contentPane.add(lblCapital);
		
		JLabel lblQuartierGeneral = new JLabel("Quartier Général");
		lblQuartierGeneral.setBackground(Color.RED);
		lblQuartierGeneral.setBounds(20, 73, 109, 23);
		contentPane.add(lblQuartierGeneral);
		
		JButton btnConstruireQG = new JButton("Construire");
		btnConstruireQG.setBounds(327, 71, 117, 29);
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
		
		JLabel lblNiveauQG = new JLabel("Niveau : 0");
		lblNiveauQG.setBounds(190, 76, 109, 16);
		contentPane.add(lblNiveauQG);
		
		JLabel lblNiveauCa = new JLabel("Niveau : 0");
		lblNiveauCa.setBounds(190, 124, 109, 16);
		contentPane.add(lblNiveauCa);
		
		JLabel lvlNiveauU = new JLabel("Niveau : 0");
		lvlNiveauU.setBounds(190, 173, 109, 16);
		contentPane.add(lvlNiveauU);
		
		JLabel lblNiveauCy = new JLabel("Niveau : 0");
		lblNiveauCy.setBounds(190, 222, 109, 16);
		contentPane.add(lblNiveauCy);
		
		JButton btnConstruireCa = new JButton("Construire");
		btnConstruireCa.setBounds(327, 119, 117, 29);
		contentPane.add(btnConstruireCa);
		
		JButton btnConstruireU = new JButton("Construire");
		btnConstruireU.setBounds(327, 168, 117, 29);
		contentPane.add(btnConstruireU);
		
		JButton btnConstruireCy = new JButton("Construire");
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
				SessionJoueur.close();
				Connexion.main(new String[0]);
				dispose();
			}
		});
		menuBar.add(mnDconnexion);
	}

}
