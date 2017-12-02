/**
 * 
 */
package ynovm.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import ynovm.utilitaire.EtatAppareil;
import ynovm.utilitaire.EtatStation;
import ynovm.utilitaire.TypeStation;


/**
 * @author Rémy
 *
 */
@Entity
@Table(name ="station")
@NamedQuery(name="lireTous",query="SELECT cp FROM StationPOJO cp")
public class StationPOJO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int x;
	private int y;
	private String nom;
	private String localisation;
	private double temperature;
	private double hygrometrie;
	private int nebulosite;
	private int anemometre;
	private int pluviometrie;
	private String remarques;
	private EtatStation etat;
	private EtatAppareil etat_Temp;
	private EtatAppareil etat_Hygro;
	private EtatAppareil etat_Nebul;
	private EtatAppareil etat_Anemo;
	private EtatAppareil etat_Pluvio;
	private TypeStation type;	
	


	public StationPOJO() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHygrometrie() {
		return hygrometrie;
	}

	public void setHygrometrie(double hygrometrie) {
		this.hygrometrie = hygrometrie;
	}

	public int getNebulosite() {
		return nebulosite;
	}

	public void setNebulosite(int nebulosite) {
		this.nebulosite = nebulosite;
	}

	public int getAnemometre() {
		return anemometre;
	}

	public void setAnemometre(int anemometre) {
		this.anemometre = anemometre;
	}

	public int getPluviometrie() {
		return pluviometrie;
	}

	public void setPluviometrie(int pluviometrie) {
		this.pluviometrie = pluviometrie;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	/**
	 * @return the etat
	 */
	public EtatStation getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(EtatStation etat) {
		this.etat = etat;
	}

	/**
	 * @return the type
	 */
	public TypeStation getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeStation type) {
		this.type = type;
	}	
	
	public EtatAppareil getEtat_Temp() {
		return etat_Temp;
	}

	public void setEtat_Temp(EtatAppareil etat_Temp) {
		this.etat_Temp = etat_Temp;
	}

	public EtatAppareil getEtat_Hygro() {
		return etat_Hygro;
	}

	public void setEtat_Hygro(EtatAppareil etat_Hygro) {
		this.etat_Hygro = etat_Hygro;
	}

	public EtatAppareil getEtat_Nebul() {
		return etat_Nebul;
	}

	public void setEtat_Nebul(EtatAppareil etat_Nebul) {
		this.etat_Nebul = etat_Nebul;
	}

	public EtatAppareil getEtat_Anemo() {
		return etat_Anemo;
	}

	public void setEtat_Anemo(EtatAppareil etat_Anemo) {
		this.etat_Anemo = etat_Anemo;
	}

	public EtatAppareil getEtat_Pluvio() {
		return etat_Pluvio;
	}

	public void setEtat_Pluvio(EtatAppareil etat_Pluvio) {
		this.etat_Pluvio = etat_Pluvio;
	}
}
