package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import model.Joueur;
import model.SessionJoueur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signalement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signalement frame = new Signalement(args[0]);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param args 
	 */
	public Signalement(String args) {
		setTitle("Gang Authority - Signaler un joueur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPseudoJoueur = new JLabel("Nom du joueur :"+args);
		lblPseudoJoueur.setBounds(97, 23, 198, 16);
		contentPane.add(lblPseudoJoueur);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 56, 408, 129);
		contentPane.add(textArea);
		
		final Joueur joueur = SessionJoueur.getInstance().getJoueur();
		JButton btnSignaler = new JButton("Signaler");
		btnSignaler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu.main(new String[0]);
			}
		});
		btnSignaler.setBounds(145, 217, 117, 29);
		contentPane.add(btnSignaler);
	}

}
