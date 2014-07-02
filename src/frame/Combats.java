package frame;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;
import org.hibernate.Session;

import model.AppFactory;
import model.Combattre;
import model.Joueur;
import model.SessionJoueur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
		
		Joueur j = SessionJoueur.getInstance().getJoueur();
		List<Combattre> combats = j.getMesCombats();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for(Combattre combat : combats){
			if(combat.getAttaquant().getIdCompte().equals(j.getIdCompte())){
				dlm.addElement(combat.getDefenseur().getPseudo());
			} else {
				dlm.addElement(combat.getAttaquant().getPseudo());
			}
		}
		final JList listCombats = new JList(dlm);
		listCombats.setBounds(6, 6, 242, 266);
		contentPane.add(listCombats);
		
		JButton btnVoirCompteRendu = new JButton("Voir le compte rendu");
		btnVoirCompteRendu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnVoirCompteRendu.setBounds(272, 92, 160, 77);
		contentPane.add(btnVoirCompteRendu);
	}

}
