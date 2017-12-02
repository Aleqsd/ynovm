package ynovm.controleur;

import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import esclave.stockage.DaoRemote;
import ynovm.stockage.DaoFactory;
import ynovm.utilitaire.DaoEnum;
import ynovm.utilitaire.EtatAppareil;
import ynovm.utilitaire.EtatStation;
import ynovm.utilitaire.Profile;
import ynovm.utilitaire.TypeStation;
import ynovm.service.Compte;
import ynovm.modele.technique.ConnexionException;
import ynovm.modele.technique.ProfileException;
import ynovm.modele.technique.StationException;
import ynovm.modele.technique.StationManagee;
import ynovm.service.StationPOJO;

public final class Manager {
	private static Manager instance = null;
	private Vector<StationManagee> lesStations;
	private Compte utilisateur;

	private Manager() {
		lesStations = new Vector<>();
		init();
		//initEJB();
	}

	private void init() {
		List<StationPOJO> tmp = null;
		tmp = DaoFactory.getInstance().getDao(DaoEnum.JPA).lireTous();
		for (StationPOJO cp : tmp) {
			lesStations.add(new StationManagee(cp, DaoFactory.getInstance().getDao(DaoEnum.JPA)));
		}
	}

	private void initEJB() {
		List<StationPOJO> tmp = null;
		InitialContext contexteWildFly = null;
		Properties env = null;
		DaoRemote daoLocal = null;

		env = new Properties();
		env.put("jboss.naming.client.ejb.context", true);
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

		try {
			contexteWildFly = new InitialContext(env);
			daoLocal = (DaoRemote) contexteWildFly.lookup("//esclave/DaoJPA!esclave.stockage.DaoRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp = daoLocal.lireTous();
		for (StationPOJO cp : tmp) {
			lesStations.add(new StationManagee(cp, daoLocal));
		}

	}
	
	private void initEJBAutonome() {
		List<StationPOJO> tmp = null;
		InitialContext contexteWildFly = null;
		Properties env = null;
		DaoRemote daoLocal = null;

		env = new Properties();
		env.put("jboss.naming.client.ejb.context", true);
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

		try {
			contexteWildFly = new InitialContext(env);
			daoLocal = (DaoRemote) contexteWildFly.lookup("//stationAutonome/DaoJPA!autonome.stockage.DaoRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp = daoLocal.lireTous();
		for (StationPOJO cp : tmp) {
			lesStations.add(new StationManagee(cp, daoLocal));
		}

	}

	// manager est un singleton
	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}

	public void redemarrer(int id) throws StationException, ProfileException {
		if(utilisateur.getProfile() == Profile.ADMINISTRATEUR)
		{
			StationManagee sm = null;
			for (StationManagee a : lesStations) {
				if (a.getPOJO().getId() == id) {
					sm = a;
				}
					
			}
			sm.redemarrer();
		}
		else
			throw new ProfileException("Vous devez être Administrateur pour effectuer cette action.");
	}
	
	public void reinitialiser(int id, String appareil) throws StationException, ProfileException {
		if((utilisateur.getProfile() == Profile.SUPERVISEUR) && (utilisateur.getProfile() == Profile.SUPERVISEUR)) {
			StationManagee sm = null;
			for (StationManagee a : lesStations) {
				if (a.getPOJO().getId() == id) {
					sm = a;
				}
			}
			sm.reinitialiser(appareil);
		}
		else
			throw new ProfileException("Vous ne devez pas être Controleur pour effectuer cette action.");
	}
	
	public void create_random_mesure_all(int id) {
		StationManagee sm = null;
		for (StationManagee a : lesStations) {
			if (a.getPOJO().getId() == id) {
				sm = a;
			}				
		}
		sm.create_random_mesure_all();
	}

	// Ajout d'une nouvelle station autonome par defaut et avec un etat en marche
	public void ajouter(int id, int x, int y, String nom, String localisation, double temperature, double hygrometrie,
			int nebulosite, int anemometre, int pluviometrie, String remarques, TypeStation type) throws ProfileException {
		if(utilisateur.getProfile() == Profile.ADMINISTRATEUR) {
			StationPOJO sp = new StationPOJO();
			sp.setId(id);
			sp.setX(x);
			sp.setY(y);
			sp.setNom(nom);
			sp.setLocalisation(localisation);
			sp.setTemperature(temperature);
			sp.setHygrometrie(hygrometrie);
			sp.setNebulosite(nebulosite);
			sp.setAnemometre(anemometre);
			sp.setPluviometrie(pluviometrie);
			sp.setRemarques(remarques);
			sp.setEtat(EtatStation.EN_MARCHE);
			sp.setEtat_Anemo(EtatAppareil.OPERATIONNEL);
			sp.setEtat_Hygro(EtatAppareil.OPERATIONNEL);
			sp.setEtat_Temp(EtatAppareil.OPERATIONNEL);
			sp.setEtat_Pluvio(EtatAppareil.OPERATIONNEL);
			sp.setEtat_Nebul(EtatAppareil.OPERATIONNEL);
			sp.setType(type);

			lesStations.add(new StationManagee(sp, DaoFactory.getInstance().getDao(DaoEnum.JPA)));
			lesStations.lastElement().ajouter(sp);
		}
		else
			throw new ProfileException("Vous devez être Administrateur pour effectuer cette action.");
	}

	// suppression d'une station avec l'id indiquer
	public void supprimer(int id) throws StationException, ProfileException {
		if(utilisateur.getProfile() == Profile.ADMINISTRATEUR) {
			StationManagee sm = null;
			for (StationManagee a : lesStations) {
				if (a.getPOJO().getId() == id) {
					sm = a;
				}
			}
			if (sm == null)
				throw new StationException("Station " + id + " non trouvé !");
			sm.supprimer();
			lesStations.remove(sm);
		}		
		else
			throw new ProfileException("Vous devez être Administrateur pour effectuer cette action.");
	}

	public String getStationById(int id) throws StationException, ProfileException {
		if((utilisateur.getProfile() != Profile.CONTROLEUR) && (utilisateur.getProfile() != Profile.SUPERVISEUR) && (utilisateur.getProfile() != Profile.ADMINISTRATEUR)) {
			throw new ProfileException("Vous n'êtes pas autorisé à effectuer cette action...");
		}
		String ret = "";
		for (StationManagee a : lesStations) {
			if (a.getPOJO().getId() == id) {
				a.checkEtatStation();
				ret = a.toString();
			}
		}
		if (ret == "")
			throw new StationException();
		return ret;
	}

	public List<String> getStationsByName(String name) throws StationException, ProfileException {
		if((utilisateur.getProfile() != Profile.CONTROLEUR) && (utilisateur.getProfile() != Profile.SUPERVISEUR) && (utilisateur.getProfile() != Profile.ADMINISTRATEUR)) {
			throw new ProfileException("Vous n'êtes pas autorisé à effectuer cette action...");
		}
		List<String> ret = null;
		ret = new Vector<>();
		for (StationManagee a : lesStations) {
			if (a.getPOJO().getNom().toLowerCase().contentEquals(name.toLowerCase())) {
				a.checkEtatStation();
				ret.add(a.toString());
			}
		}
		if (ret.isEmpty())
			throw new StationException();
		return ret;
	}

	public List<String> getStationsByLocalisation(String localisation) throws StationException, ProfileException {
		if((utilisateur.getProfile() != Profile.CONTROLEUR) && (utilisateur.getProfile() != Profile.SUPERVISEUR) && (utilisateur.getProfile() != Profile.ADMINISTRATEUR)) {
			throw new ProfileException("Vous n'êtes pas autorisé à effectuer cette action...");
		}
		List<String> ret = null;
		ret = new Vector<>();
		for (StationManagee a : lesStations) {
			if (a.getPOJO().getLocalisation().toLowerCase().contentEquals(localisation.toLowerCase())) {
				a.checkEtatStation();
				ret.add(a.toString());
			}
		}
		if (ret.isEmpty())
			throw new StationException("Pas de station en " + localisation);
		return ret;
	}

	public List<String> getStationsByEtat(EtatStation etat) throws StationException, ProfileException {
		if((utilisateur.getProfile() != Profile.CONTROLEUR) && (utilisateur.getProfile() != Profile.SUPERVISEUR) && (utilisateur.getProfile() != Profile.ADMINISTRATEUR)) {
			throw new ProfileException("Vous n'êtes pas autorisé à effectuer cette action...");
		}
		List<String> ret = null;
		ret = new Vector<>();
		for (StationManagee a : lesStations) {
			if (a.getPOJO().getEtat() == etat) {
				a.checkEtatStation();
				ret.add(a.toString());
			}
		}
		if (ret.isEmpty())
			throw new StationException();
		return ret;
	}

	public List<String> getStationsByType(TypeStation type) throws StationException, ProfileException {
		if((utilisateur.getProfile() != Profile.CONTROLEUR) && (utilisateur.getProfile() != Profile.SUPERVISEUR) && (utilisateur.getProfile() != Profile.ADMINISTRATEUR)) {
			throw new ProfileException("Vous n'êtes pas autorisé à effectuer cette action...");
		}
		List<String> ret = null;
		ret = new Vector<>();
		for (StationManagee a : lesStations) {
			if (a.getPOJO().getType() == type) {
				a.checkEtatStation();
				ret.add(a.toString());
			}
		}
		if (ret.isEmpty())
			throw new StationException();
		return ret;
	}

	public List<String> getStations() throws ProfileException {
		if((utilisateur.getProfile() != Profile.CONTROLEUR) && (utilisateur.getProfile() != Profile.SUPERVISEUR) && (utilisateur.getProfile() != Profile.ADMINISTRATEUR)) {
			throw new ProfileException("Vous n'êtes pas autorisé à effectuer cette action...");
		}
		List<String> ret = null;
		ret = new Vector<>();
		for (StationManagee a : lesStations) {
			a.checkEtatStation();
			ret.add(a.toString());
		}
		return ret;
	}

	public List<StationPOJO> getPOJOs() {
		List<StationPOJO> ret = null;
		ret = new Vector<>();
		for (StationManagee a : lesStations) {
			ret.add(a.getPOJO());
		}
		return ret;
	}

	public void connexion(String login, String password) throws ConnexionException {
		List<Compte> tmp = null;

		tmp = DaoFactory.getInstance().getDaoCompte().lireTous();
		for (Compte c : tmp) {
			if (c.getlogin().equals(login) && c.getmdp().equals(password)) {
				setUtilisateur(new Compte(c.getlogin(), c.getmdp(), c.getProfile().getProfile()));
			}
		}
		if (this.utilisateur == null)
			throw new ConnexionException("Echec de connexion");
	}

	public Compte getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Compte utilisateur) {
		this.utilisateur = utilisateur;
	}
}
