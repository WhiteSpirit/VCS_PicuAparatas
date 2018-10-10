package lt.balt;

class Produktai {

	private double[] produktuRinkinys;

	Produktai(double[] produktuRinkinys) {
		this.produktuRinkinys = produktuRinkinys;
	}

	Produktai() {
		this(new double[PicuAparatas.VIETU_SKAICIUS_SKIRTINGIEMS_PRODUKTAMS]);
	}

	double[] sumazintiProduktuKiekius(Produktai atimamiProduktai) {
		for (int produktoEilesNr = 0; produktoEilesNr < atimamiProduktai.produktuRinkinys.length; produktoEilesNr++) {
			this.produktuRinkinys[produktoEilesNr] -= atimamiProduktai.produktuRinkinys[produktoEilesNr];
		}
		return this.produktuRinkinys;
	}

	double[] padidintiProduktuKiekius(Produktai pridedamiProduktai) {
		for (int produktoEilesNr = 0; produktoEilesNr < pridedamiProduktai.produktuRinkinys.length; produktoEilesNr++) {
			this.produktuRinkinys[produktoEilesNr] += pridedamiProduktai.produktuRinkinys[produktoEilesNr];
		}
		return this.produktuRinkinys;
	}

	double[] getProduktuRinkinys() {
		return produktuRinkinys;
	}

	void setProduktuRinkinys(double[] produktuRinkinys) {
		this.produktuRinkinys = produktuRinkinys;
	}

}
