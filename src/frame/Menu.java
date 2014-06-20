package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

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
		setTitle("Gang Authority - Accueil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGererGang = new JButton("G\u00E9rer mon gang");
		btnGererGang.setBounds(24, 56, 183, 81);
		contentPane.add(btnGererGang);
		
		JButton btnConsulterProfil = new JButton("Consulter mon profil");
		btnConsulterProfil.setBounds(246, 56, 175, 81);
		contentPane.add(btnConsulterProfil);
		
		JButton btnRedirectionSite = new JButton("Aller sur le site");
		btnRedirectionSite.setBounds(137, 201, 175, 29);
		contentPane.add(btnRedirectionSite);
	}
}
