package lt.balt;

import java.util.ArrayList;
import java.util.Scanner;

class Servisas {

	private Scanner s = new Scanner(System.in);

	private ArrayList<PicuAparatas> visiPicuAparatai = new ArrayList<PicuAparatas>();
	private ArrayList<Receptas> visiPicuReceptai = new ArrayList<Receptas>();

	private static ArrayList<String> picuDydziuApibudinimai = new ArrayList<>();

	static {
		for (int irasas = 0; irasas < Pica.dydziuApibudinimaiIrDydziai.size(); irasas++) {
			for (String dydzioApibudinimas : Pica.dydziuApibudinimaiIrDydziai.get(irasas).keySet()) {
				picuDydziuApibudinimai.add(dydzioApibudinimas);
			}
		}
	}

	Servisas() {
		sukurtiPicuRecepta("Studentiska", new double[] { 1, 2, 2, 2, 2 });
		sukurtiPicuRecepta("Turistine", new double[] { 1, 3, 3, 1, 1 });
		sukurtiPicuRecepta("Puikioji", new double[] { 1, 3, 3, 2, 2 });
		sukurtiPicuRecepta("Kuklioji", new double[] { 1, 1, 1, 2, 2 });
		sukurtiPicuRecepta("Vegetariska", new double[] { 1, 0, 2, 3, 3 });
		sukurtiPicuRecepta("Veganiska", new double[] { 1, 0, 0, 4, 4 });
		System.out.print("Sukurtas servisas. ");
	}

	PicuAparatas sukurtiPicuAparata(double[] produktuRinkinys) {
		PicuAparatas aparatas = new PicuAparatas(produktuRinkinys);
		visiPicuAparatai.add(aparatas);
		System.out.println("Sukurtas picu aparatas.");
		return aparatas;
	}

	void pasalintiPicuAparata(int aparatoEilesNumeris) {
		visiPicuAparatai.remove(aparatoEilesNumeris - 1);
		System.out.println("Picu aparatas pasalintas.");
	}

	void valytiPicuAparata(PicuAparatas aparatas) {
		aparatas.setAparatoPanaudojimuSkaicius(0);
		System.out.println("Picu aparatas isvalytas.");
	}

	void sukurtiPicuRecepta(String pavadinimas, double[] produktuRinkinys) {
		Receptas receptas = new Receptas(pavadinimas, produktuRinkinys);
		visiPicuReceptai.add(receptas);
	}

	void pasalintiPicuRecepta(int receptoEilesNumeris) {
		visiPicuReceptai.remove(receptoEilesNumeris - 1);
	}

	void uzsakytiPica(PicuAparatas aparatas) {
		int picosRusis = suzinotiPicosRusi();
		String picosDydis = suzinotiPicosDydi();
		while (!aparatas.arProduktuPicaiPakanka(getVisiPicuReceptai().get(picosRusis), picosDydis)) {
			System.out.println("Nepakanka produktu. Siulome pasirinkti kita pica.");
			picosRusis = suzinotiPicosRusi();
			picosDydis = suzinotiPicosDydi();
		}
		aparatas.gamintiPica(getVisiPicuReceptai().get(picosRusis), picosDydis);
	}

	private int suzinotiPicosRusi() {
		int rusis;
		do {
			System.out.print("Issirinkite picos rusi: ");
			for (int pasirinkimoNr = 1; pasirinkimoNr <= visiPicuReceptai.size(); pasirinkimoNr++) {
				System.out
						.print(pasirinkimoNr + " - " + visiPicuReceptai.get(pasirinkimoNr - 1).getPavadinimas() + "  ");
			}
			System.out.println("");
			rusis = (s.nextInt() - 1);
		} while (rusis < 0 || rusis > (visiPicuReceptai.size() - 1));
		return rusis;
	}

	private String suzinotiPicosDydi() {
		int didumas = 0;
		while (didumas < 1 || didumas > picuDydziuApibudinimai.size()) {
			System.out.print("Issirinkite picos dydi: ");
			for (int pasirinkimoNr = 1; pasirinkimoNr <= picuDydziuApibudinimai.size(); pasirinkimoNr++) {
				System.out.print(pasirinkimoNr + " - " + picuDydziuApibudinimai.get(pasirinkimoNr - 1) + "  ");
			}
			System.out.println("");
			didumas = s.nextInt();
		}
		String dydis = picuDydziuApibudinimai.get(didumas - 1);
		return dydis;
	}

	ArrayList<PicuAparatas> getVisiPicuAparatai() {
		return visiPicuAparatai;
	}

	ArrayList<Receptas> getVisiPicuReceptai() {
		return visiPicuReceptai;
	}

}
