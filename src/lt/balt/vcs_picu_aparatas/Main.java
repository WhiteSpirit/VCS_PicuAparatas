package lt.balt;

public class Main {

	public static void main(String[] args) {
		Servisas servisas = new Servisas();
		PicuAparatas aparatas = servisas.sukurtiPicuAparata(new double[] { 100, 100, 100, 100, 100 });

		servisas.uzsakytiPica(aparatas);
	}

}
