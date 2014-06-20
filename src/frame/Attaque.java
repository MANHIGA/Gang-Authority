package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class Attaque extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attaque frame = new Attaque();
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
	public Attaque() {
		setTitle("Attaquer un gang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGangsDisponibles = new JLabel("Gangs disponibles");
		lblGangsDisponibles.setBounds(83, 6, 125, 16);
		contentPane.add(lblGangsDisponibles);
		
		JList listGangsDisponibles = new JList();
		listGangsDisponibles.setBounds(16, 34, 263, 227);
		contentPane.add(listGangsDisponibles);
		
		JButton btnAttaquer = new JButton("Attaquer");
		btnAttaquer.setBounds(309, 66, 117, 29);
		contentPane.add(btnAttaquer);
		
		JButton btnSignalerJoueur = new JButton("Signaler le joueur");
		btnSignalerJoueur.setBounds(291, 159, 153, 29);
		contentPane.add(btnSignalerJoueur);
	}

}
