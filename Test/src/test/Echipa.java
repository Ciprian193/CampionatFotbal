package test;

import java.util.List;

public class Echipa {
	private int id;
	private String nume;
	private int victorii = 0;
	private int egaluri = 0;
	private int infrangeri = 0;
	private int goluriMarcate = 0;
	private int goluriPrimite = 0;

	public Echipa(int id, String nume) {
		super();
		this.id = id;
		this.nume = nume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public int getVictorii() {
		return victorii;
	}

	public void setVictorii(int victorii) {
		this.victorii = victorii;
	}
	
	public void addVictorii() {
		this.victorii++;
	}

	public int getEgaluri() {
		return egaluri;
	}

	public void setEgaluri(int egaluri) {
		this.egaluri = egaluri;
	}
	
	public void addEgaluri() {
		this.egaluri++;
	}

	public int getInfrangeri() {
		return infrangeri;
	}

	public void setInfrangeri(int infrangeri) {
		this.infrangeri = infrangeri;
	}
	
	public void addInfrangeri() {
		this.infrangeri++;
	}

	public int getGoluriMarcate() {
		return goluriMarcate;
	}

	public void setGoluriMarcate(int goluriMarcate) {
		this.goluriMarcate = goluriMarcate;
	}
	
	public void addGoluriMarcate(int goluri) {
		this.goluriMarcate += goluri;
	}

	public int getGoluriPrimite() {
		return goluriPrimite;
	}

	public void setGoluriPrimite(int goluriPrimite) {
		this.goluriPrimite = goluriPrimite;
	}
	
	public void addGoluriPrimite(int goluri) {
		this.goluriPrimite += goluri;
	}
	
}
