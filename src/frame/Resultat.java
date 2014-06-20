package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Resultat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultat frame = new Resultat();
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
	public Resultat() {
		setTitle("Gang Authority - Compte Rendu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCombatContreJoueur = new JLabel("Combat contre Joueur");
		lblCombatContreJoueur.setBounds(37, 49, 200, 16);
		contentPane.add(lblCombatContreJoueur);
		
		JLabel lblDefaite = new JLabel("DEFAITE");
		lblDefaite.setBounds(323, 49, 61, 16);
		contentPane.add(lblDefaite);
		
		JLabel lblPerte = new JLabel("Perte : 0$ et 0 points d'autorit\u00E9");
		lblPerte.setBounds(86, 105, 321, 16);
		contentPane.add(lblPerte);
		
		JButton btnSignalerLeJoueur = new JButton("Signaler le joueur");
		btnSignalerLeJoueur.setBounds(129, 164, 173, 77);
		contentPane.add(btnSignalerLeJoueur);
	}

}
