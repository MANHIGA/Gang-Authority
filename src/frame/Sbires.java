package frame;

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

public class Sbires extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sbires frame = new Sbires();
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
	public Sbires() {
		setTitle("Gang Authority - Recruter des sbires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHommeDeMain = new JLabel("Hommes de main");
		lblHommeDeMain.setBounds(16, 37, 110, 16);
		contentPane.add(lblHommeDeMain);
		
		JLabel lblTrafiquants = new JLabel("Trafiquants");
		lblTrafiquants.setBounds(181, 37, 72, 16);
		contentPane.add(lblTrafiquants);
		
		JLabel lblHacker = new JLabel("Hacker");
		lblHacker.setBounds(341, 37, 61, 16);
		contentPane.add(lblHacker);
		
		JLabel lblNombreHDM = new JLabel("Nombre : 0");
		lblNombreHDM.setBounds(16, 90, 106, 16);
		contentPane.add(lblNombreHDM);
		
		JLabel lblNombreT = new JLabel("Nombre : 0");
		lblNombreT.setBounds(181, 90, 106, 16);
		contentPane.add(lblNombreT);
		
		JLabel lblNombreH = new JLabel("Nombre : 0");
		lblNombreH.setBounds(318, 90, 106, 16);
		contentPane.add(lblNombreH);
		
		JButton btnRecruter = new JButton("Recruter");
		btnRecruter.setBounds(9, 190, 117, 29);
		contentPane.add(btnRecruter);
		
		JButton btnRecruter_1 = new JButton("Recruter");
		btnRecruter_1.setBounds(168, 190, 117, 29);
		contentPane.add(btnRecruter_1);
		
		JButton btnNewButton = new JButton("Recruter");
		btnNewButton.setBounds(318, 190, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblCoutHDM = new JLabel("Co\u00FBt :  0$");
		lblCoutHDM.setBounds(16, 146, 106, 16);
		contentPane.add(lblCoutHDM);
		
		JLabel lblCoutT = new JLabel("Co\u00FBt : 0$");
		lblCoutT.setBounds(181, 146, 106, 16);
		contentPane.add(lblCoutT);
		
		JLabel lblCoutH = new JLabel("Co\u00FBt : 0$");
		lblCoutH.setBounds(318, 146, 106, 16);
		contentPane.add(lblCoutH);
		
		JLabel lblCapital = new JLabel("Capital : 0$");
		lblCapital.setBounds(16, 234, 117, 16);
		contentPane.add(lblCapital);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(2, 0, 448, 22);
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
