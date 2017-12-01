package ynovm.utilitaire;

import ynovm.modele.metier.Station;
import ynovm.service.StationPOJO;

public class Conversion {
	public static Station pojoToStation(StationPOJO pojo) {		
		return new Station(pojo.getId(), pojo.getX(), pojo.getY(), pojo.getNom(), pojo.getLocalisation(), pojo.getTemperature(),
				pojo.getHygrometrie(), pojo.getNebulosite(), pojo.getAnemometre(), pojo.getPluviometrie(), pojo.getRemarques(), pojo.getType());	
	}
}
