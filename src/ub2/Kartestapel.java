package ub2;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Stack;

import ub2.Karte.Farbenwert;
import ub2.Karte.Kartenwert;

public class Kartestapel {
	ArrayList<Karte> v = new ArrayList<>();
	static Stack<Karte> s1 = new Stack<>();

	// erstellt ein Kartenstapel mit alle karten
	public Kartestapel() {
		for (Farbenwert s : Farbenwert.values()) {
			for (Kartenwert r : Kartenwert.values()) {
				Karte k = new Karte(s, r);
				s1.push(k);

			}
		}
		mischen();

		v.addAll(s1);
	}

	public Stack<Karte> get() {
		return s1;
	}

	// zieht eine karte
	public static Karte ziehen() {
		if (s1.empty() != true) {
			mischen();
			Karte s1card = s1.pop();
			return s1card;
		}
		return null;
	}

	public static void mischen() {
		Collections.shuffle(s1);
	}
}