package test;

public class Meci {
	private Echipa gazda;
	private Echipa oaspete;
	private String scor;
	
	public Meci(Echipa gazda, Echipa oaspete) {
		super();
		this.gazda = gazda;
		this.oaspete = oaspete;
		this.scor = scor;
	}
	
	public Echipa getGazda() {
		return gazda;
	}
	public void setGazda(Echipa gazda) {
		this.gazda = gazda;
	}
	public Echipa getOaspete() {
		return oaspete;
	}
	public void setOaspete(Echipa oaspete) {
		this.oaspete = oaspete;
	}
	
	public String getScor() {
		return scor;
	}
	
	public void setScor(String scor) {
		this.scor = scor;
	}
	
}
