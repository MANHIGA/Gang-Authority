package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Preparation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preparation frame = new Preparation();
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
	public Preparation() {
		setTitle("Gang Authority - Préparer un combat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJoueurEnnemi = new JLabel("Ennemi : Joueur 0 (0 points d'autorité)");
		lblJoueurEnnemi.setBounds(24, 26, 279, 16);
		contentPane.add(lblJoueurEnnemi);
		
		JLabel lblHDM = new JLabel("Nombre d'hommes de main :");
		lblHDM.setBounds(24, 54, 254, 16);
		contentPane.add(lblHDM);
		
		JLabel lblT = new JLabel("Nombre de trafiquants :");
		lblT.setBounds(24, 124, 199, 16);
		contentPane.add(lblT);
		
		JLabel lblH = new JLabel("Nombre de hackers :");
		lblH.setBounds(24, 194, 199, 16);
		contentPane.add(lblH);
		
		JButton btnPlusHDM = new JButton("+");
		btnPlusHDM.setBounds(24, 82, 30, 30);
		contentPane.add(btnPlusHDM);
		
		JButton btnMoinsHDM = new JButton("-");
		btnMoinsHDM.setBounds(144, 82, 30, 30);
		contentPane.add(btnMoinsHDM);
		
		JButton btnPlusT = new JButton("+");
		btnPlusT.setBounds(24, 152, 30, 30);
		contentPane.add(btnPlusT);
		
		JButton btnMoinsT = new JButton("-");
		btnMoinsT.setBounds(144, 153, 30, 30);
		contentPane.add(btnMoinsT);
		
		JButton btnPlusH = new JButton("+");
		btnPlusH.setBounds(24, 222, 30, 30);
		contentPane.add(btnPlusH);
		
		JButton btnMoinsH = new JButton("-");
		btnMoinsH.setBounds(144, 222, 30, 30);
		contentPane.add(btnMoinsH);
		
		JLabel lblNbHDM = new JLabel("0");
		lblNbHDM.setBounds(92, 88, 40, 16);
		contentPane.add(lblNbHDM);
		
		JLabel lblNbT = new JLabel("0");
		lblNbT.setBounds(92, 158, 40, 16);
		contentPane.add(lblNbT);
		
		JLabel lblNbH = new JLabel("0");
		lblNbH.setBounds(92, 228, 40, 16);
		contentPane.add(lblNbH);
		
		JLabel lblTempsRestant = new JLabel("Temps restant : 0 secondes");
		lblTempsRestant.setBounds(256, 106, 194, 16);
		contentPane.add(lblTempsRestant);
		
		JLabel lblAttaque = new JLabel("Puissance d'attaque : 0");
		lblAttaque.setBounds(256, 176, 194, 16);
		contentPane.add(lblAttaque);
		
		JLabel lblDefense = new JLabel("Puissance défensive : 0");
		lblDefense.setBounds(256, 210, 194, 16);
		contentPane.add(lblDefense);
	}

}
