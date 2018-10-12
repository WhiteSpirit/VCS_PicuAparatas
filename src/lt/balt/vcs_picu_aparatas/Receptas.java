package lt.balt;

class Receptas {

	private String pavadinimas;
	private Produktai produktai;

	Receptas(String pavadinimas, double[] produktuRinkinys) {
		this.pavadinimas = pavadinimas;
		this.produktai = new Produktai(produktuRinkinys);
	}

	Receptas() {
		this(" ", new double[PicuAparatas.VIETU_SKAICIUS_SKIRTINGIEMS_PRODUKTAMS]);
	}

	String getPavadinimas() {
		return pavadinimas;
	}

	Produktai getProduktai() {
		return produktai;
	}

}
