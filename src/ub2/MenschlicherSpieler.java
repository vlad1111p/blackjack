package ub2;

import java.util.Scanner;

//Klasse MenschlicherSpieler
public class MenschlicherSpieler extends Spieler {
	private static Scanner sc;

	// Konstruktor MenschlicherSpieler
	MenschlicherSpieler() {
		super();
		sc = new Scanner(System.in);
		System.out.print("\n write your Name here  : ");
		this.Name = sc.nextLine();
		System.out.print("\n how much money : ");
		this.money = sc.nextInt();
		System.out.print("\n the bet : ");
		placeBet(sc.nextInt());

	}

	@Override
	public int moneyget() {
		return money;
	}

	@Override
	public Karte take() {
		if (Kartestapel.ziehen() != null) {
			return Kartestapel.ziehen();
		} else
			return null;
	}

	// ob der spieler \"hit\" oderr \"pass\":
	public boolean wantToHit() {
		System.out.print("\n hit oder pass: ");
		while (true) {
			String input = sc.nextLine();
			if (input.equals("hit")) {
				return true;
			} else if (input.equals("pass")) {
				return false;
			} else {
				System.out.print(" hit oder pass: ");
			}
		}
	}

	// Hit methode
	public Karte hit(Karte card) {
		if (wantToHit()) {
			cards.add(Kartestapel.ziehen());
			total = getHandValue();
			return card;
		} else {
			return null;
		}
	}
}
