package ub2;

import java.util.LinkedList;
import java.util.Scanner;

import ub2.Karte.Farbenwert;
import ub2.Karte.Kartenwert;

//Konstruktor
public class Partie {

	static LinkedList<Spieler> stack = new LinkedList<Spieler>();;
	String Name;
	MenschlicherSpieler player1;
	Computerspieler player2;
	private Scanner keyboard;
	private Scanner keyboard1;

	// der Start des Spiels
	Partie() {
		new Kartestapel();
		initgame();
		dealCards();
		takeTurns();
		declareWinner();
		// Setzt alle Karten zurück
		for (Spieler player : stack) {
			player.cards.clear();
		}
		playAgain();

	}

	// die Fortsetzung des Spiels
	void Partie1() {
		new Kartestapel();
		// fragt den Spieler nach einer neuen Wette
		keyboard1 = new Scanner(System.in);
		System.out.print("\n the bet : ");
		int bet = keyboard1.nextInt();
		for (Spieler player : stack) {
			player.bet = bet;

		}
		dealCards();
		takeTurns();
		declareWinner();
		// Setzt alle Karten zurück
		for (Spieler player : stack) {
			player.cards.clear();
		}
		playAgain();

	}

	// initialisiert das Spiel
	void initgame() {

		MenschlicherSpieler player1 = new MenschlicherSpieler();
		Computerspieler player2 = new Computerspieler(player1.moneyget());

		player2.placeBet(player1.bet);

		stack.add(player1);
		stack.add(player2);
		// Der Computer erhält den gleichen Geldbetrag wie der Spieler und die gleiche
		// Wette
	}

	// gibt zuerst 2 Karten
	private void dealCards() {
		for (Spieler player : stack) {
			player.cards.add(Kartestapel.ziehen());
			player.cards.add(Kartestapel.ziehen());

		}

	}

	// wählt den Gewinner
	private void declareWinner() {
		int highest = -1;
		int topPlayer = -1;
		for (int i = 0; i < stack.size(); i++) {
			String name = stack.get(i).getName();
			int total = stack.get(i).getHandValue();

			System.out.println(name + " has a total of " + total + ".");

			if (total > highest && total <= 21) {
				highest = total;
				topPlayer = i;
			}
			if (total == highest && name.equals("Dealer")) {
				topPlayer = i;
			}
		}
		// Wenn jeder verliert, dann verliert jeder Geld
		if (topPlayer == -1) {
			System.out.println("draw");
			for (Spieler player : stack) {

				player.finish(false);

			}
		} else {
			// Der Gewinner erhält sein aktualisiertes Konto
			stack.get(topPlayer).finish(true);
			System.out.println(stack.get(topPlayer).getName() + " wins!");
		}

	}

	// alle Spieleraktionen
	private void takeTurns() {
		for (Spieler player : stack) {
			boolean endOfTurn = false;
			while (!endOfTurn) {
				System.out.println(player.getcards());
				boolean hit = player.wantToHit();
				if (hit) {
					player.cards.add(Kartestapel.ziehen());
					System.out.println(player.getName() + " hit.\n");
					if (player.getHandValue() > 21) {
						endOfTurn = true;
						System.out.println(player.getName() + " overdrawn.\n");
					}
				} else {
					endOfTurn = true;
					System.out.println(player.getName() + " passed.\n");
				}
			}
		}

	}

	private void playAgain() {
		System.out.print("\nagain? y or n or m for (money) : ");
		keyboard = new Scanner(System.in);
		while (true) {
			String input = keyboard.next();
			if (input.equals("y")) {

				Partie1();
			} else if (input.equals("n")) {

				System.exit(0);

			} else if (input.equals("m")) {

				for (Spieler player : stack) {
					System.out.println(player.getName() + " " + player.moneyget());
				}
				System.out.print("type y or n or m for (money) : ");

			}

			else {
				System.out.print("type y or n or m :");
			}
		}
	}

	// mainmethode
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Farbenwert herz = Farbenwert.Herz;
		Kartenwert val = Kartenwert.Acht;
		Kartenwert val1 = Kartenwert.Ass;

		Karte card = new Karte(herz, val);
		Karte card1 = new Karte(herz, val1);
		Kartestapel stack = new Kartestapel();

		System.out.println("some examples\n" + card);
		System.out.println(card1.getwert());
		System.out.println("all the cards in the stack after mischen " + stack.s1);
		System.out.println("all the cards in the array mischen " + stack.v);
		System.out.println("drawing all the cards randomly");

		while (stack.s1.isEmpty() != true) {
			System.out.print(Kartestapel.ziehen() + " ");
		}

		new Partie();

	}

}