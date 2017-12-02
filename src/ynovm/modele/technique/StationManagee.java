package ynovm.modele.technique;

import ynovm.modele.metier.Station;
import ynovm.service.StationPOJO;
import ynovm.stockage.Dao;
import ynovm.utilitaire.Conversion;
import ynovm.utilitaire.EtatAppareil;
import ynovm.utilitaire.EtatStation;

public class StationManagee {
	private Station station;
	private StationPOJO sp;
	private Dao<StationPOJO> dao;
	private int cle;

	/**
	 * 
	 */
	public StationManagee() {
		cle = -1;
		station = null;
		sp = null;
		dao = null;
	}

	/**
	 * 
	 * @param clef
	 * @param d
	 */
	public StationManagee(int clef, Dao<StationPOJO> d) {
		cle = clef;
		dao = d;
		init();
	}

	/**
	 * 
	 * @param p
	 * @param d
	 */
	public StationManagee(StationPOJO p, Dao<StationPOJO> d) {
		cle = p.getId();
		sp = p;
		dao = d;
		station = Conversion.pojoToStation(p);
	}

	/**
	 * 
	 */
	private void init() {
		sp = dao.lire(cle);
		station = Conversion.pojoToStation(sp);
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return String.join(" ", "id:", ("" + cle), station.toString());
	}

	public StationPOJO getPOJO() {
		return sp;
	}
	
	public void create_random_mesure_all() {
		if(station != null) {
			sp.setAnemometre((int)(1+Math.random()*100));
			sp.setTemperature((int)(1+Math.random()*20));
	        sp.setHygrometrie((int)(1+Math.random()*100));
	        sp.setNebulosite((int)(1+Math.random()*100));
	        sp.setPluviometrie((int)(1+Math.random()*100));
		}
	}
	
	public void redemarrer() throws StationException {
		if(station != null)	{
			station.redemarrer();
			sp.setEtat(station.getEtat());
			dao.update(cle, sp);
		}		
	}
	
	public void reinitialiser(String appareil) throws StationException {
		if(station != null) {
			switch (appareil.toLowerCase()) {
			case "temperature":	
				if(sp.getEtat_Anemo() == EtatAppareil.EN_PANNE) {
					sp.setTemperature(0);
					sp.setEtat_Temp(EtatAppareil.OPERATIONNEL);
					dao.update(cle, sp);
				}
				else
					throw new StationException("Impossible de reinitialiser l'appareil: "+appareil+", car il n'est pas en Panne...");
				break;
			case "hygrometrie":
				if(sp.getEtat_Hygro() == EtatAppareil.EN_PANNE) {
					sp.setHygrometrie(0);
					sp.setEtat_Hygro(EtatAppareil.OPERATIONNEL);
					dao.update(cle, sp);
				}
				else
					throw new StationException("Impossible de reinitialiser l'appareil: "+appareil+", car il n'est pas en Panne...");
				break;				
			case "nebulosite":
				if(sp.getEtat_Nebul() == EtatAppareil.EN_PANNE) {
					sp.setNebulosite(0);
					sp.setEtat_Nebul(EtatAppareil.OPERATIONNEL);
					dao.update(cle, sp);
				}
				else
					throw new StationException("Impossible de reinitialiser l'appareil: "+appareil+", car il n'est pas en Panne...");				
				break;
			case "anemometre":
				if(sp.getEtat_Anemo() == EtatAppareil.EN_PANNE) {
					sp.setAnemometre(0);
					sp.setEtat_Anemo(EtatAppareil.OPERATIONNEL);
					dao.update(cle, sp);
				}
				else
					throw new StationException("Impossible de reinitialiser l'appareil: "+appareil+", car il n'est pas en Panne...");				
				break;
			case "pluviometrie":
				if(sp.getEtat_Pluvio() == EtatAppareil.EN_PANNE) {
					sp.setPluviometrie(0);
					sp.setEtat_Pluvio(EtatAppareil.OPERATIONNEL);
					dao.update(cle, sp);
				}
				else
					throw new StationException("Impossible de reinitialiser l'appareil: "+appareil+", car il n'est pas en Panne...");
				
				break;
			default:
				throw new StationException("Impossible de reinitialiser : Appareil inexistant...");
			}
		}
	}
	
	public void checkEtatStation() {
		if(station != null)	{
			sp.setEtat(station.getEtat());
			dao.update(cle, sp);
		}	
	}
	
	public void supprimer() {
		if(station != null){
			dao.effacer(cle);
			station = null;
		}
	}

	public void ajouter(StationPOJO sp) {
		if(station != null) {
			dao.inserer(sp);
		}		
	}
}
