package ub2;

import java.util.LinkedList;

public abstract class Spieler {
	String Name;
	int money;
	int bet;
	int total;

	LinkedList<Karte> cards;

	// Konstruktor
	Spieler() {
		this.cards = new LinkedList<>();
	}

	abstract boolean wantToHit();

	abstract int moneyget();

	public LinkedList<Karte> getcards() {
		return cards;
	}

	public void add(Karte e) {
		cards.add(e);
	}

	public void placeBet(int newBet) {

		if (newBet > this.money) {
			this.bet = this.money;
			this.money = 0;
		} else {
			this.bet = newBet;
			this.money -= this.bet;
		}
	}

	public String getName() {
		return Name;
	}

	// Aktualisierung
	public void finish(boolean won) {
		if (won) {
			money += bet * 2;
		}

	}

	// Wert von der hand
	public int getHandValue() {
		int value = 0;
		int aces = 0;
		for (Karte card : cards) {
			if (card.getwert() == 11) {
				aces++;
			}
			value += card.getwert();
		}
		// wert von ass kann 1 oder 11 sein
		if (value > 21 && aces > 0) {
			value -= 10;
		}
		return value;
	}

	public int getBet() {
		return bet;
	}

	abstract Karte take();

}
