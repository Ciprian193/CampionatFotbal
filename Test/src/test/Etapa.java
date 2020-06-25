package test;

import java.util.List;

public class Etapa {
	private int numarEtapa;
	private List<Meci> meciuri;
	
	public Etapa(int numarEtapa, List<Meci> meciuri) {
		super();
		this.numarEtapa = numarEtapa;
		this.meciuri = meciuri;
	}
	
	public int getNumarEtapa() {
		return numarEtapa;
	}

	public void setNumarEtapa(int numarEtapa) {
		this.numarEtapa = numarEtapa;
	}

	public List<Meci> getMeciuri() {
		return meciuri;
	}

	public void setMeciuri(List<Meci> meciuri) {
		this.meciuri = meciuri;
	}	
}
