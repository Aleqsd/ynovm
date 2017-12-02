package ynovm.vue;

import java.util.List;

import ynovm.controleur.Manager;
import ynovm.modele.technique.ConnexionException;
import ynovm.modele.technique.StationException;
import ynovm.utilitaire.EtatStation;
import ynovm.utilitaire.TypeStation;

public class YnovM {

	public void afficher() {
		Manager.getInstance().getStations().forEach(System.out::println);
	}
	
	public void ajout(int id, int x, int y, String nom, String localisation, double temperature, double hygrometrie,
			int nebulosite, int anemometre, int pluviometrie, String remarques, TypeStation type) {
		Manager.getInstance().ajouter(id, x, y, nom, localisation, temperature, hygrometrie, nebulosite, anemometre, pluviometrie, remarques, type);
	}
	
	public void supprimer(int id) throws StationException {
		Manager.getInstance().supprimer(id);
	}
	
	public void redemarrer(int id) throws StationException {
		Manager.getInstance().redemarrer(id);
	}
	
	public void reinitialiser(int id, String appareil) throws StationException {
		Manager.getInstance().reinitialiser(id, appareil);
	}
	
	public void create_panne(int id, String appareil) throws StationException {
		Manager.getInstance().create_panne(id, appareil);
	}
	
	public void create_random_mesure_all(int id) {
		Manager.getInstance().create_random_mesure_all(id);
	}
	
	public String rechercherParID(int id) throws StationException {
		return Manager.getInstance().getStationById(id);
	}
	
	public void rechercherParNom(String name) throws StationException {
		Manager.getInstance().getStationsByName(name).forEach(System.out::println);
	}
	
	public void rechercherParLoc(String loc) throws StationException {
		Manager.getInstance().getStationsByLocalisation(loc).forEach(System.out::println);
	}
	
	public void rechercherParEtat(EtatStation etat) throws StationException {
		Manager.getInstance().getStationsByEtat(etat).forEach(System.out::println);
	}
	
	public void rechercherParType(TypeStation type) throws StationException {
		Manager.getInstance().getStationsByType(type).forEach(System.out::println);
	}
	
	private void connect(String login, String mdp) throws ConnexionException {
        Manager.getInstance().connexion(login,mdp);
        System.out.println(Manager.getInstance().getUtilisateur().toString());
    }
	
	public static void main(String[] args) throws StationException, InterruptedException {
		YnovM z = null;
		z = new YnovM();
		
		try {
			z.connect("admin","admin");
		} catch (ConnexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*z.ajout(1, 7, 8, "AlphaStation", "Bretagne", 17, 4, 5, 8, 7, "RAS", TypeStation.AUTONOME);
		z.ajout(2, 7, 8, "BetaStation", "Aix", 17, 4, 5, 8, 7, "RAS", TypeStation.ESCLAVE);
		z.ajout(3, 7, 8, "CharlieStation", "Marseille", 17, 4, 5, 8, 7, "RAS", TypeStation.AUTONOME);
		z.ajout(4, 7, 8, "DeltaStation", "Paris", 17, 4, 5, 8, 7, "RAS", TypeStation.ESCLAVE);*/
		
		System.out.println("-------------AFFICHAGE---------------");
		z.afficher();
		System.out.println("----------------SUPPRIMER-------------");		
		z.supprimer(1);
		z.supprimer(2);
		System.out.println("------------------APRES SUPPRIMER-----------");
		z.afficher();
		System.out.println("-------------AJOUT---------------");
		z.ajout(1, 7, 8, "AlphaStation", "Bretagne", 17, 4, 5, 8, 7, "RAS", TypeStation.AUTONOME);
		z.ajout(2, 7, 8, "BetaStation", "Aix", 17, 4, 5, 8, 7, "RAS", TypeStation.ESCLAVE);
		System.out.println("---------------APRES AJOUT-------------");
		z.afficher();		
		System.out.println("-----------------------------");
		System.out.println("-------------AVANT REDEMARRER----------------");
		z.redemarrer(1);
		z.redemarrer(2);
		System.out.println("--------------APRES REDEMARRER--------------");
		z.afficher();
		System.out.println("------------RECHERCHE PAR ID-----------------");
		System.out.println(z.rechercherParID(1));
		System.out.println("-----------RECHERCHE PAR ETAT------------------");
		z.rechercherParEtat(EtatStation.EN_MARCHE);
		System.out.println("-------------RECHERCHE PAR TYPE----------------");
		z.rechercherParType(TypeStation.AUTONOME);
		System.out.println("---------------RECHERHCE PAR LOC--------------");
		z.rechercherParLoc("Paris");
		System.out.println("-------------RECHERHCE PAR NOM----------------");
		z.rechercherParNom("CharlieStation");
		System.out.println("-------------SLEEP (15s) ET VERIF STATION REDEMARRAGE---------------");
		System.out.println("WAIT PLEASE");
		Thread.sleep(15000);
		z.afficher();
		System.out.println("-----------------AVANT CREATE PANNE---------------");
		z.create_panne(1, "pluviometrie");
		System.out.println("-----------------APRES CREATE PANNE---------------");
		z.rechercherParID(1);
		System.out.println("-----------------AVANT REINITIALISATION---------------");
		z.reinitialiser(1, "pluviometrie");
		System.out.println("-----------------APRES REINITIALISATION---------------");
		z.rechercherParID(1);
		System.out.println("-----------------AVANT CREATE RANDOM MESURE ALL APPAREIL---------------");
		z.create_random_mesure_all(1);
		System.out.println("-----------------APRES CREATE RANDOM MESURE ALL APPAREIL---------------");
		z.afficher();
	}
}
