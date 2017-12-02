package ynovm.utilitaire;

public enum EtatAppareil {
	
	REINITIALISATION(0), EN_PANNE(1), OPERATIONNEL(2);
	private int etatApp;

	public int getEtatAppareil() {
		return etatApp;
	}

	private EtatAppareil(int etatapp) {
		etatApp = etatapp;
	}
}
