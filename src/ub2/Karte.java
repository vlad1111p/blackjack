package ub2;

@SuppressWarnings("unused")
public class Karte {

	Farbenwert farbenwert;
	private Kartenwert kartenwert;

	// Konstruktor
	public Karte(Farbenwert farbenwert, Kartenwert kartenwert) {
		this.farbenwert = farbenwert;
		this.kartenwert = kartenwert;
	}

	// farbenwert von der karte
	public static enum Farbenwert {
		Herz, Karo, Kreuz, Pik;
	}

	// Kartenwert von der karte
	public static enum Kartenwert {
		// Bube Dame Konig mussen den Wert 10 haben
		Ass(11), Zwei(2), Drei(3), Vier(4), Funf(5), Sechs(6), Sieben(7), Acht(8), Neun(9), Zehn(10), Bube(10), Dame(
				10), König(10);

		private final int wert;

		Kartenwert(final int wert) {
			this.wert = wert;
		}

	}

	// tostring methode
	public String toString() {
		// wählt aus, ob der Wert oder der Name der Karte angezeigt wird
		if (getwert() == 10 || getwert() == 11) {
			return farbenwert + "-" + kartenwert;

		} else {
			return farbenwert + "-" + getwert();
		}

	}

	// Getter für den Wert der Karte
	public int getwert() {

		return kartenwert.wert;
	}

}
