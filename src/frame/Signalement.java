package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Signalement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signalement frame = new Signalement();
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
	public Signalement() {
		setTitle("Gang Authority - Signaler un joueur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPseudoJoueur = new JLabel("Nom du joueur :");
		lblPseudoJoueur.setBounds(97, 23, 198, 16);
		contentPane.add(lblPseudoJoueur);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 56, 408, 129);
		contentPane.add(textArea);
		
		JButton btnSignaler = new JButton("Signaler");
		btnSignaler.setBounds(145, 217, 117, 29);
		contentPane.add(btnSignaler);
	}

}
