package ynovm.vue;

import java.util.List;

import ynovm.controleur.Manager;
import ynovm.modele.technique.ConnexionException;
import ynovm.modele.technique.ProfileException;
import ynovm.modele.technique.StationException;
import ynovm.utilitaire.EtatStation;
import ynovm.utilitaire.TypeStation;

public class YnovM {

	public void afficher() throws ProfileException {
		Manager.getInstance().getStations().forEach(System.out::println);
	}
	
	public void ajout(int id, int x, int y, String nom, String localisation, double temperature, double hygrometrie,
			int nebulosite, int anemometre, int pluviometrie, String remarques, TypeStation type) throws ProfileException {
		Manager.getInstance().ajouter(id, x, y, nom, localisation, temperature, hygrometrie, nebulosite, anemometre, pluviometrie, remarques, type);
	}
	
	public void supprimer(int id) throws StationException, ProfileException {
		Manager.getInstance().supprimer(id);
	}
	
	public void redemarrer(int id) throws StationException, ProfileException {
		Manager.getInstance().redemarrer(id);
	}
	
	public void reinitialiser(int id, String appareil) throws StationException, ProfileException {
		Manager.getInstance().reinitialiser(id, appareil);
	}
	
	public void create_random_mesure_all(int id) {
		Manager.getInstance().create_random_mesure_all(id);
	}
	
	public String rechercherParID(int id) throws StationException, ProfileException {
		return Manager.getInstance().getStationById(id);
	}
	
	public void rechercherParNom(String name) throws StationException, ProfileException {
		Manager.getInstance().getStationsByName(name).forEach(System.out::println);
	}
	
	public void rechercherParLoc(String loc) throws StationException, ProfileException {
		Manager.getInstance().getStationsByLocalisation(loc).forEach(System.out::println);
	}
	
	public void rechercherParEtat(EtatStation etat) throws StationException, ProfileException {
		Manager.getInstance().getStationsByEtat(etat).forEach(System.out::println);
	}
	
	public void rechercherParType(TypeStation type) throws StationException, ProfileException {
		Manager.getInstance().getStationsByType(type).forEach(System.out::println);
	}
	
	public void connect(String login, String mdp) throws ConnexionException {
        Manager.getInstance().connexion(login,mdp);
        System.out.println(Manager.getInstance().getUtilisateur().toString());
    }
	
	public static void main(String[] args) {
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
		try {
			z.afficher();
		} catch (ProfileException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("----------------SUPPRIMER-------------");		
		try {
			z.supprimer(1);
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			z.supprimer(2);
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------APRES SUPPRIMER-----------");
		try {
			z.afficher();
		} catch (ProfileException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("-------------AJOUT---------------");
		try {
			z.ajout(1, 7, 8, "AlphaStation", "Bretagne", 17, 4, 5, 8, 7, "RAS", TypeStation.AUTONOME);
		} catch (ProfileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			z.ajout(2, 7, 8, "BetaStation", "Aix", 17, 4, 5, 8, 7, "RAS", TypeStation.ESCLAVE);
		} catch (ProfileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("---------------APRES AJOUT-------------");
		try {
			z.afficher();
		} catch (ProfileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		System.out.println("-----------------------------");
		System.out.println("-------------AVANT REDEMARRER----------------");
		try {
			z.redemarrer(1);
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			z.redemarrer(2);
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------APRES REDEMARRER--------------");
		try {
			z.afficher();
		} catch (ProfileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("------------RECHERCHE PAR ID-----------------");
		try {
			System.out.println(z.rechercherParID(1));
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------RECHERCHE PAR ETAT------------------");
		try {
			z.rechercherParEtat(EtatStation.EN_MARCHE);
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------RECHERCHE PAR TYPE----------------");
		try {
			z.rechercherParType(TypeStation.AUTONOME);
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------RECHERHCE PAR LOC--------------");
		try {
			z.rechercherParLoc("Paris");
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------RECHERHCE PAR NOM----------------");
		try {
			z.rechercherParNom("CharlieStation");
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------SLEEP (15s) ET VERIF STATION REDEMARRAGE---------------");
		System.out.println("WAIT PLEASE");
		try {
			Thread.sleep(15000);
			z.afficher();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			z.rechercherParID(1);
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------AVANT REINITIALISATION---------------");
		try {
			z.reinitialiser(1, "pluviometrie");
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------APRES REINITIALISATION---------------");
		try {
			z.rechercherParID(1);
		} catch (StationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------AVANT CREATE RANDOM MESURE ALL APPAREIL---------------");
		z.create_random_mesure_all(1);
		System.out.println("-----------------APRES CREATE RANDOM MESURE ALL APPAREIL---------------");
		try {
			z.afficher();
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
