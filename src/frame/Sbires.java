package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

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
		lblNombreHDM.setBounds(20, 109, 106, 16);
		contentPane.add(lblNombreHDM);
		
		JLabel lblNombreT = new JLabel("Nombre : 0");
		lblNombreT.setBounds(181, 109, 106, 16);
		contentPane.add(lblNombreT);
		
		JLabel lblNombreH = new JLabel("Nombre : 0");
		lblNombreH.setBounds(329, 109, 106, 16);
		contentPane.add(lblNombreH);
		
		JButton btnRecruter = new JButton("Recruter");
		btnRecruter.setBounds(6, 210, 117, 29);
		contentPane.add(btnRecruter);
		
		JButton btnRecruter_1 = new JButton("Recruter");
		btnRecruter_1.setBounds(170, 210, 117, 29);
		contentPane.add(btnRecruter_1);
		
		JButton btnNewButton = new JButton("Recruter");
		btnNewButton.setBounds(318, 210, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblCoutHDM = new JLabel("Co\u00FBt :  0$");
		lblCoutHDM.setBounds(20, 167, 106, 16);
		contentPane.add(lblCoutHDM);
		
		JLabel lblCoutT = new JLabel("Co\u00FBt : 0$");
		lblCoutT.setBounds(181, 167, 106, 16);
		contentPane.add(lblCoutT);
		
		JLabel lblCoutH = new JLabel("Co\u00FBt : 0$");
		lblCoutH.setBounds(329, 167, 106, 16);
		contentPane.add(lblCoutH);
		
		JLabel lblCapital = new JLabel("Capital : 0$");
		lblCapital.setBounds(16, 251, 117, 16);
		contentPane.add(lblCapital);
	}

}
