package model;

public class SessionJoueur {
	private Joueur joueur;
	private static SessionJoueur instance;
	
	public static SessionJoueur getInstance(){
		if(instance != null){
			return instance;
		}else{
			instance = new SessionJoueur();
			return instance;
		}
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Joueur getJoueur() {
		return joueur;
	}

}
