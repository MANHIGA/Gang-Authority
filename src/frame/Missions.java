package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.AppFactory;
import model.Entrainer;
import model.Joueur;
import model.Mission;
import model.SessionJoueur;

public class Missions extends JFrame {

	private JPanel contentPane;
	private Integer nbHDM = 0;
	private Integer recompenseArg = 0;
	private Integer dureeMission = 0;
	private Integer ata = 0;
	private Integer defs = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Missions frame = new Missions();
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
	public Missions() {
		setTitle("Gang Authority - Réaliser des missions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Joueur j = SessionJoueur.getInstance().getJoueur();
		JLabel lblMissions = new JLabel("Missions disponibles");
		lblMissions.setBounds(36, 30, 144, 16);
		contentPane.add(lblMissions);
		
		List<Mission> missions = Mission.getMissions();
		//List<Mission> missions = j.getMissionsDisponibles();
		DefaultListModel<Mission> dlm = new DefaultListModel<Mission>();
		for(Mission m : missions){
			dlm.addElement(m);
		}
		
		JLabel lblNombreDeSbires = new JLabel("Nombre de sbires");
		lblNombreDeSbires.setBounds(220, 33, 117, 16);
		contentPane.add(lblNombreDeSbires);
		
		final JLabel lblCountSbires = new JLabel(""+nbHDM);
		lblCountSbires.setBackground(Color.LIGHT_GRAY);
		lblCountSbires.setBounds(305, 62, 44, 29);
		contentPane.add(lblCountSbires);
		
		final JLabel lblAttaque = new JLabel("Puissance d'attaque : "+nbHDM*ata);
		lblAttaque.setBounds(220, 118, 211, 16);
		contentPane.add(lblAttaque);
		
		final JLabel lblDefense = new JLabel("Puissance défensive : "+nbHDM*defs);
		lblDefense.setBounds(220, 146, 211, 16);
		contentPane.add(lblDefense);
		
		final JLabel lblRecompense = new JLabel("Récompense : $"+recompenseArg);
		lblRecompense.setBounds(36, 216, 211, 16);
		contentPane.add(lblRecompense);
		
		final JList<Mission> listMissions = new JList(dlm);
		listMissions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Entrainer> sbires = j.getMesSbires();
				for(Entrainer sbire : sbires){
					if(sbire.getTypeSbire().getLibelleTypeSbire().equals(listMissions.getSelectedValue().getMissionTypeSbire().getLibelleTypeSbire())){
						ata = sbire.getPointAttaque();
						defs = sbire.getPointDefense();
					}
				}
				recompenseArg = listMissions.getSelectedValue().getRecompenseArgent();
				dureeMission = listMissions.getSelectedValue().getDureeMission();
				lblRecompense.setText("Récompense : $"+recompenseArg);
				nbHDM = 0;
				lblCountSbires.setText(""+nbHDM);
				lblAttaque.setText("Puissance d'attaque : "+nbHDM*ata);
				lblDefense.setText("Puissance défensive : "+nbHDM*defs);
			}
		});
		listMissions.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Mission) {
                    ((JLabel) renderer).setText(((Mission) value).getDifficulte() + ((Mission) value).getRecompenseArgent() + ((Mission) value).getRecompensePointsAutorites() + ((Mission) value).getDureeMission());
                }
                return renderer;
            }
        });
		lblMissions.setLabelFor(listMissions);
		listMissions.setBounds(36, 58, 138, 146);
		contentPane.add(listMissions);
		
		JButton btnMoins = new JButton("-");
		btnMoins.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nbHDM > 0){
					nbHDM -= 1;
					lblCountSbires.setText(""+nbHDM);
					lblAttaque.setText("Puissance d'attaque : "+nbHDM*ata);
					lblDefense.setText("Puissance défensive : "+nbHDM*defs);
				}
			}
		});
		btnMoins.setBounds(349, 61, 44, 30);
		contentPane.add(btnMoins);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Entrainer sbire : j.getMesSbires()){
					if(sbire.getTypeSbire().getLibelleTypeSbire().equals(listMissions.getSelectedValue().getMissionTypeSbire().getLibelleTypeSbire())){
						if(sbire.getNbSbire() >= nbHDM + 1){
							nbHDM += 1;
							lblCountSbires.setText(""+nbHDM);
							lblAttaque.setText("Puissance d'attaque : "+nbHDM*ata);
							lblDefense.setText("Puissance défensive : "+nbHDM*defs);
						}
					}
				}
			}
		});
		btnPlus.setBounds(220, 61, 44, 30);
		contentPane.add(btnPlus);
		
		JButton btnAttaquer = new JButton("Attaquer");
		btnAttaquer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(nbHDM > 0){
				j.realiserMission(listMissions.getSelectedValue(), nbHDM);
				Missions.main(new String[0]);
				dispose();
				}
			}
		});
		btnAttaquer.setBounds(257, 210, 117, 29);
		contentPane.add(btnAttaquer);
		
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
		
		JMenu mnDconnexion = new JMenu("Déconnexion");
		mnDconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SessionJoueur.getInstance().getJoueur().setJoueurConnecte(false);
				Session session = AppFactory.getSessionFactory().openSession();
				Transaction tx = session.beginTransaction();
				session.update(SessionJoueur.getInstance().getJoueur());
				tx.commit();
				session.close();
				SessionJoueur.close();
				Connexion.main(new String[0]);
				dispose();
			}
		});
		menuBar.add(mnDconnexion);
	}
}
