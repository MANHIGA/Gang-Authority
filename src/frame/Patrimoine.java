package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

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
		
		JLabel lblQG = new JLabel("Quartier G\u00E9n\u00E9ral");
		lblQG.setBounds(25, 17, 107, 16);
		contentPane.add(lblQG);
		
		JLabel lblNiveauQG = new JLabel("Niveau : 0");
		lblNiveauQG.setBounds(176, 17, 97, 16);
		contentPane.add(lblNiveauQG);
		
		JLabel lblPopulationQG = new JLabel("Population totale : 0");
		lblPopulationQG.setBounds(285, 17, 159, 16);
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
		lblCy.setBounds(25, 137, 107, 16);
		contentPane.add(lblCy);
		
		JLabel lblNiveauCy = new JLabel("Niveau : 0");
		lblNiveauCy.setBounds(176, 137, 97, 16);
		contentPane.add(lblNiveauCy);
		
		JLabel lblPopulationH = new JLabel("Hackers : 0");
		lblPopulationH.setBounds(285, 137, 159, 16);
		contentPane.add(lblPopulationH);
		
		JLabel lblU = new JLabel("Usine");
		lblU.setBounds(25, 197, 61, 16);
		contentPane.add(lblU);
		
		JLabel lblNiveauU = new JLabel("Niveau : 0");
		lblNiveauU.setBounds(176, 197, 97, 16);
		contentPane.add(lblNiveauU);
		
		JLabel lblPopulationT = new JLabel("Trafiquants : 0");
		lblPopulationT.setBounds(285, 197, 159, 16);
		contentPane.add(lblPopulationT);
		
		JLabel lblCapital = new JLabel("Capital : 0$");
		lblCapital.setBounds(61, 238, 139, 16);
		contentPane.add(lblCapital);
		
		JLabel lblPointsAutorite = new JLabel("Points d'autorit\u00E9 : 0");
		lblPointsAutorite.setBounds(200, 238, 175, 16);
		contentPane.add(lblPointsAutorite);
	}

}
