package frame;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Construire;
import model.Joueur;
import model.SessionJoueur;

public class Patrimoine extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patrimoine frame = new Patrimoine();
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
	public Patrimoine() {
		setTitle("Gang Authority - Consulter le patrimoine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Joueur joueur = SessionJoueur.getInstance().getJoueur();
		List<Construire> batiments = joueur.getMesBatiments();
		
		for(int i=0; i<batiments.size(); i++){
			
		}
		
		JLabel lblQG = new JLabel("Quartier G\u00E9n\u00E9ral");
		lblQG.setBounds(25, 34, 107, 16);
		contentPane.add(lblQG);
		
		JLabel lblNiveauQG = new JLabel("Niveau : 0");
		lblNiveauQG.setBounds(176, 34, 97, 16);
		contentPane.add(lblNiveauQG);
		
		JLabel lblPopulationQG = new JLabel("Population totale : 0");
		lblPopulationQG.setBounds(285, 34, 159, 16);
		contentPane.add(lblPopulationQG);
		
		JLabel lblCa = new JLabel("Casino");
		lblCa.setBounds(25, 77, 61, 16);
		contentPane.add(lblCa);
		
		JLabel lblNiveauCa = new JLabel("Niveau : 0");
		lblNiveauCa.setBounds(176, 77, 85, 16);
		contentPane.add(lblNiveauCa);
		
		JLabel lblPopulationHDM = new JLabel("Hommes de main : 0");
		lblPopulationHDM.setBounds(285, 77, 159, 16);
		contentPane.add(lblPopulationHDM);
		
		JLabel lblCy = new JLabel("Cybercafe");
		lblCy.setBounds(25, 125, 107, 16);
		contentPane.add(lblCy);
		
		JLabel lblNiveauCy = new JLabel("Niveau : 0");
		lblNiveauCy.setBounds(176, 125, 97, 16);
		contentPane.add(lblNiveauCy);
		
		JLabel lblPopulationH = new JLabel("Hackers : 0");
		lblPopulationH.setBounds(285, 125, 159, 16);
		contentPane.add(lblPopulationH);
		
		JLabel lblU = new JLabel("Usine");
		lblU.setBounds(25, 174, 61, 16);
		contentPane.add(lblU);
		
		JLabel lblNiveauU = new JLabel("Niveau : 0");
		lblNiveauU.setBounds(176, 174, 97, 16);
		contentPane.add(lblNiveauU);
		
		JLabel lblPopulationT = new JLabel("Trafiquants : 0");
		lblPopulationT.setBounds(285, 174, 159, 16);
		contentPane.add(lblPopulationT);
		
		JLabel lblCapital = new JLabel("Capital : 0$");
		lblCapital.setBounds(61, 238, 139, 16);
		contentPane.add(lblCapital);
		
		JLabel lblPointsAutorite = new JLabel("Points d'autorit\u00E9 : 0");
		lblPointsAutorite.setBounds(200, 238, 175, 16);
		contentPane.add(lblPointsAutorite);
		
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
