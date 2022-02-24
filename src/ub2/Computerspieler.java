package ub2;

//Klasse Computerspieler
public class Computerspieler extends Spieler {
	Kartestapel v = new Kartestapel();

	Computerspieler(int money) {
		super();
		this.Name = "Dealer";
		this.money = money;
	}

	public void setkonto(int money) {
		this.money = money;

	}

	@Override
	public Karte take() {
		return Kartestapel.ziehen();
	}

	// Wenn der Wert der Computerhand weniger als 16 ist ,wird eine Karte ziehen
	public boolean wantToHit() {
		if (getHandValue() < 16)
			return true;
		if (getHandValue() > 16)
			return false;

		return false;
	}

	public Karte hit(Karte card) {
		if (wantToHit()) {
			cards.add(Kartestapel.ziehen());
			total = getHandValue();
			return card;
		} else {
			return null;
		}
	}

	@Override
	int moneyget() {

		return money;
	}

}