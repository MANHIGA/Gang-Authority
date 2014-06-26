package frame;

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
		lblGangsDisponibles.setBounds(82, 31, 125, 16);
		contentPane.add(lblGangsDisponibles);
		
		JList listGangsDisponibles = new JList();
		listGangsDisponibles.setBounds(16, 68, 263, 193);
		contentPane.add(listGangsDisponibles);
		
		JButton btnAttaquer = new JButton("Attaquer");
		btnAttaquer.setBounds(309, 66, 117, 29);
		contentPane.add(btnAttaquer);
		
		JButton btnSignalerJoueur = new JButton("Signaler le joueur");
		btnSignalerJoueur.setBounds(291, 159, 153, 29);
		contentPane.add(btnSignalerJoueur);
		
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
		
		JMenu mnDconnexion = new JMenu("D\u00E9connexion");
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
