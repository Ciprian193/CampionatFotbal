package test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Echipa> echipe = new ArrayList<>();
		List<Meci> meciuri = new ArrayList<>();
		List<Meci> meciuriTur = new ArrayList<>();
		List<Meci> meciuriRetur = new ArrayList<> ();
		List<Etapa> etape = new ArrayList<>();
		
		for(int i = 1; i <= 4; i++) {
			echipe.add(new Echipa(i, "e"+i));
		}
		for(Echipa echipa : echipe) {
			for(Echipa adversara : echipe) {
				if(adversara.getId() != echipa.getId()) {
					meciuri.add(new Meci(echipa, adversara));
				}
			}
		}
		
		while(meciuri.size() > 0) {
			int indexMeci = (int)(Math.random() * meciuri.size());
			Meci meciTur = meciuri.get(indexMeci);
			meciuriTur.add(meciTur);
			meciuri.remove(indexMeci);
			for(int i = meciuri.size() - 1; i >= 0; i--) {
				Meci meciRetur = meciuri.get(i);
				if(meciRetur.getGazda().equals(meciTur.getOaspete()) && meciRetur.getOaspete().equals(meciTur.getGazda())) {
					meciuriRetur.add(meciRetur);
					meciuri.remove(i);
				}
			}
		}
		
		etape = adaugaEtape(meciuriTur, etape);
		etape = adaugaEtape(meciuriRetur, etape);
		
		System.out.println("Nume-----V-----E-----I-----GM-----GP-----P");
		for(Echipa echipa : echipe) {
			int punctaj = 3 * echipa.getVictorii() + echipa.getEgaluri();
			System.out.println(echipa.getNume() + "       " + echipa.getVictorii() + "     " + echipa.getEgaluri() + "     " + echipa.getInfrangeri() + "     " + echipa.getGoluriMarcate() + "     " + echipa.getGoluriPrimite() + "     " + punctaj);
		}


//		System.out.println(echipe);
	}
	
	public static List<Etapa> adaugaEtape(List<Meci> meciuri, List<Etapa> etape) {
		int etapa = etape.size() + 1;
		while(meciuri.size() > 0) {
			List<Meci> meciuriPosibile = new ArrayList<>(meciuri);
			List<Meci> meciuriEtapa = new ArrayList<>();
			int indexMeci = (int)(Math.random() * meciuri.size());
			Meci meci1 = meciuri.get(indexMeci);
			meci1 = genereazaScor(meci1);
			meciuriEtapa.add(meci1);
			meciuri.remove(indexMeci);
			for(Meci meci2 : meciuriPosibile) {
				if(!(meci2.getGazda().equals(meci1.getGazda()) || meci2.getGazda().equals(meci1.getOaspete()) || meci2.getOaspete().equals(meci1.getGazda()) || meci2.getOaspete().equals(meci1.getOaspete()))) {
					meciuriEtapa.add(meci2);
					meci2 = genereazaScor(meci2);
					for(int i = meciuri.size() - 1; i >= 0; i--) {
						if(meci2.getGazda().equals(meciuri.get(i).getGazda()) && meci2.getOaspete().equals(meciuri.get(i).getOaspete())) {
							meciuri.remove(i);
						}
					}		
				}
			}
			etape.add(new Etapa(etapa, meciuriEtapa));
			etapa++;
		}
		return etape;
	}
	
	public static Meci genereazaScor(Meci meci) {
		int goluriGazda = (int)(Math.random() * 6);
		int goluriOaspete = (int)(Math.random() * 6);
		Echipa gazda = meci.getGazda();
		Echipa oaspete = meci.getOaspete();
		String scor = goluriGazda + " - " + goluriOaspete;
		meci.setScor(scor);
		if(goluriGazda > goluriOaspete) {
			actualizeazaClasamentVictorie(gazda, oaspete, goluriGazda, goluriOaspete);
		} else if (goluriGazda < goluriOaspete) {
			actualizeazaClasamentVictorie(oaspete, gazda, goluriOaspete, goluriGazda);
		} else if (goluriGazda == goluriOaspete) {
			actualizeazaClasamentEgal(gazda, oaspete, goluriGazda, goluriOaspete);
		}
		
		return meci;
	}
	
	public static void actualizeazaClasamentVictorie(Echipa castigator, Echipa infrant, int goluriCastigator, int goluriInfrant) {
		castigator.addVictorii();
		castigator.addGoluriMarcate(goluriCastigator);
		castigator.addGoluriPrimite(goluriInfrant);
		infrant.addInfrangeri();
		infrant.addGoluriMarcate(goluriInfrant);
		infrant.addGoluriPrimite(goluriCastigator);
	}
	public static void actualizeazaClasamentEgal(Echipa gazda, Echipa oaspete, int goluriGazda, int goluriOaspete) {
		gazda.addEgaluri();
		gazda.addGoluriMarcate(goluriGazda);
		gazda.addGoluriPrimite(goluriOaspete);
		oaspete.addEgaluri();
		oaspete.addGoluriMarcate(goluriOaspete);
		oaspete.addGoluriPrimite(goluriGazda);
	}
}
