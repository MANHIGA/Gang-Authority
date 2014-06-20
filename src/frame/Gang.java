package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Gang extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gang frame = new Gang();
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
	public Gang() {
		setTitle("Gang Authority - Gérer mon Gang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAccederMissions = new JButton("Acc\u00E9der aux missions");
		btnAccederMissions.setBounds(16, 28, 191, 54);
		contentPane.add(btnAccederMissions);
		
		JButton btnRecruterSbires = new JButton("Recruter des sbires");
		btnRecruterSbires.setBounds(238, 106, 191, 57);
		contentPane.add(btnRecruterSbires);
		
		JButton btnGererBatiments = new JButton("G\u00E9rer les b\u00E2timents");
		btnGererBatiments.setBounds(16, 106, 191, 57);
		contentPane.add(btnGererBatiments);
		
		JButton btnConsulterPatrimoine = new JButton("Consulter mon patrimoine");
		btnConsulterPatrimoine.setBounds(238, 27, 191, 57);
		contentPane.add(btnConsulterPatrimoine);
		
		JButton btnAttaquerGang = new JButton("Attaquer un gang");
		btnAttaquerGang.setBounds(140, 192, 163, 57);
		contentPane.add(btnAttaquerGang);
	}

}
