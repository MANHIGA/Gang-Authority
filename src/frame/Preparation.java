package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import model.Entrainer;
import model.Joueur;
import model.SessionJoueur;
import model.TypeSbire;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Preparation extends JFrame {

	private JPanel contentPane;
	private Integer nbHDM = 0;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preparation frame = new Preparation(args[0]);
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
	public Preparation(final String arg) {
		setTitle("Gang Authority - Préparer un combat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Joueur ennemi = Joueur.getJoueurByPseudo(arg);
		final Joueur j = SessionJoueur.getInstance().getJoueur();
		
		JLabel lblJoueurEnnemi = new JLabel("Ennemi : "+arg+"("+ennemi.getPointAutorite()+" points d'autorité)");
		lblJoueurEnnemi.setBounds(24, 26, 279, 16);
		contentPane.add(lblJoueurEnnemi);
		
		
		JLabel lblHDM = new JLabel("Nombre d'hommes de main :");
		lblHDM.setBounds(24, 54, 254, 16);
		contentPane.add(lblHDM);
		
		JButton btnPlusHDM = new JButton("+");
		btnPlusHDM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for(Entrainer sbire : j.getMesSbires()){
					if(sbire.getTypeSbire().getLibelleTypeSbire().equals("Homme de main")){
						if(sbire.getNbSbire() >= nbHDM + 1){
							nbHDM += 1;
						}
					}
				}
			}
		});
		btnPlusHDM.setBounds(24, 82, 40, 30);
		contentPane.add(btnPlusHDM);
		
		JButton btnMoinsHDM = new JButton("-");
		btnMoinsHDM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nbHDM > 0){
					nbHDM -= 1;
				}
			}
		});
		btnMoinsHDM.setBounds(144, 82, 40, 30);
		contentPane.add(btnMoinsHDM);
		
		JLabel lblNbHDM = new JLabel(""+nbHDM);
		lblNbHDM.setBounds(92, 88, 40, 16);
		contentPane.add(lblNbHDM);
		List<Entrainer> sbires = j.getMesSbires();
		Integer atk = 0;
		Integer def = 0;
		for(Entrainer sbire : sbires){
			if(sbire.getTypeSbire().getLibelleTypeSbire().equals("Homme de main")){
				atk = sbire.getPointAttaque();
				def = sbire.getPointDefense();
			}
		}
		Integer puiAtk = nbHDM * atk;
		Integer puiDef = nbHDM * def;
		JLabel lblAttaque = new JLabel("Puissance d'attaque : "+puiAtk);
		lblAttaque.setBounds(256, 81, 194, 16);
		contentPane.add(lblAttaque);
		
		JLabel lblDefense = new JLabel("Puissance défensive : "+puiDef);
		lblDefense.setBounds(256, 152, 194, 16);
		contentPane.add(lblDefense);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				j.combattreJoueur(ennemi, nbHDM);
				Combats.main(new String[0]);
				dispose();
			}
		});
		btnValider.setBounds(144, 187, 89, 23);
		contentPane.add(btnValider);
	}
}
