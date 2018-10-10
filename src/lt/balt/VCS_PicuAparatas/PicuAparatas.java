package lt.balt;

class PicuAparatas {

	static final int VIETU_SKAICIUS_SKIRTINGIEMS_PRODUKTAMS = 5;
	static final int MAX_PANAUDOJIMU_SKAICIUS_IKI_VALYMO = 20;

	private Produktai produktai;
	private int aparatoPanaudojimuSkaicius;

	PicuAparatas() {
		this(new double[VIETU_SKAICIUS_SKIRTINGIEMS_PRODUKTAMS]);
	}

	PicuAparatas(double[] produktuRinkinys) {
		this.produktai = new Produktai(produktuRinkinys);
	}

	Pica gamintiPica(Receptas receptas, String dydzioApibudinimas) {
		Pica pica;
		if (arProduktuPicaiPakanka(receptas, dydzioApibudinimas)) {
			pica = new Pica(receptas, dydzioApibudinimas);
			this.produktai.sumazintiProduktuKiekius(pica.getReikalingiProduktai());
			System.out.println(
					"Pagaminta pica: " + receptas.getPavadinimas() + ". Dydis: " + pica.getDydzioApibudinimas() + ".");
			aparatoPanaudojimuSkaicius++;
			if (aparatoPanaudojimuSkaicius >= MAX_PANAUDOJIMU_SKAICIUS_IKI_VALYMO) {
				prasytiValymo();
				new Servisas().valytiPicuAparata(this);
			}
		} else {
			pica = new Pica();
		}
		return pica;
	}

	boolean arProduktuPicaiPakanka(Receptas receptas, String dydzioApibudinimas) {
		Pica pica = new Pica(receptas, dydzioApibudinimas);
		double[] produktuLikuciai = this.produktai.sumazintiProduktuKiekius(pica.getReikalingiProduktai());
		boolean arProduktuPicaiPakanka = true;
		for (int produktoEilesNr = 0; produktoEilesNr < produktuLikuciai.length; produktoEilesNr++) {
			if (produktuLikuciai[produktoEilesNr] < 0) {
				arProduktuPicaiPakanka = false;
			}
		}
		return arProduktuPicaiPakanka;
	}

	private void prasytiValymo() {
		System.out.println("Reikia isvalyti aparata.");
	}

	int getAparatoPanaudojimuSkaicius() {
		return aparatoPanaudojimuSkaicius;
	}

	void setAparatoPanaudojimuSkaicius(int aparatoPanaudojimuSkaicius) {
		this.aparatoPanaudojimuSkaicius = aparatoPanaudojimuSkaicius;
	}

}
