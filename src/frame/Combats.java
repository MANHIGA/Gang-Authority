package frame;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Combats extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combats frame = new Combats();
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
	public Combats() {
		setTitle("Gang Authority - Combats en cours");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listCombats = new JList();
		listCombats.setBounds(6, 6, 242, 266);
		contentPane.add(listCombats);
		
		JButton btnVoirCompteRendu = new JButton("Voir le compte rendu");
		btnVoirCompteRendu.setBounds(272, 92, 160, 77);
		contentPane.add(btnVoirCompteRendu);
	}

}
