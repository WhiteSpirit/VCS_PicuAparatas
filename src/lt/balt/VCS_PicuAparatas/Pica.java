package lt.balt;

import java.util.ArrayList;
import java.util.HashMap;

class Pica {

	private Receptas receptas;
	private String dydzioApibudinimas;
	private double dydis;

	private Produktai reikalingiProduktai;

	static ArrayList<HashMap<String, Double>> dydziuApibudinimaiIrDydziai = new ArrayList<>();

	static {
		dydziuApibudinimaiIrDydziai.add(new HashMap<>());
		dydziuApibudinimaiIrDydziai.get(0).put("puse picos", 0.5);
		dydziuApibudinimaiIrDydziai.add(new HashMap<>());
		dydziuApibudinimaiIrDydziai.get(1).put("vidutine pica", 1.0);
		dydziuApibudinimaiIrDydziai.add(new HashMap<>());
		dydziuApibudinimaiIrDydziai.get(2).put("dviguba pica", 2.0);
	}

	Pica(Receptas receptas, String dydzioApibudinimas) {
		this.receptas = receptas;
		this.dydzioApibudinimas = dydzioApibudinimas;
		this.dydis = getDydis(dydzioApibudinimas);
		this.reikalingiProduktai = new Produktai();
		double[] produktuRinkinys = new double[this.reikalingiProduktai.getProduktuRinkinys().length];
		for (int produktoEilesNr = 0; produktoEilesNr < this.reikalingiProduktai
				.getProduktuRinkinys().length; produktoEilesNr++) {
			produktuRinkinys[produktoEilesNr] = receptas.getProduktai().getProduktuRinkinys()[produktoEilesNr]
					* this.dydis;
		}
		this.reikalingiProduktai.setProduktuRinkinys(produktuRinkinys);
	}

	Pica() {
		this(new Receptas(), "vidutine pica");
	}

	private static double getDydis(String dydzioApibudinimas) {
		double didumas = 1;
		for (int irasas = 0; irasas < dydziuApibudinimaiIrDydziai.size(); irasas++) {
			if (dydziuApibudinimaiIrDydziai.get(irasas).containsKey(dydzioApibudinimas)) {
				didumas = dydziuApibudinimaiIrDydziai.get(irasas).get(dydzioApibudinimas);
			}
		}
		return didumas;
	}

	double getDydis() {
		return dydis;
	}

	String getDydzioApibudinimas() {
		return dydzioApibudinimas;
	}

	Receptas getReceptas() {
		return receptas;
	}

	Produktai getReikalingiProduktai() {
		return reikalingiProduktai;
	}

}
