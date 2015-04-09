package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter sadrzi metode za vracanje svih poruka, unos nove poruke i vracanje poruka
 * vezanih za odredjeni tag.
 * 
 * @author Veljko
 *
 */
public class Twitter {
	
	/**
	 * Atribut poruke koji predstavlja listu svih poruka, inicijalizovana je lista.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda vratiSvePoruke vraca sve poruke.
	 * 
	 * @return sve poruke iz liste
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke () {
		return poruke;
	}
	
	/**
	 * Metoda unosi novu poruku za korisnika.
	 * 
	 * @param korisnik koji unosi poruku
	 * @param poruka uneta od strane odredjenog korisnika
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda vraca sve poruke vezane za jedan odredjeni tag koji je unet kao parametar, a broj poruka
	 * je odredjen unetim maksimalnim brojem poruka koje mogu da prikazu - maxBroj.
	 * 
	 * @param maxBroj je maksimalan broj poruka koje je moguce prikazati odjednom
	 * @param tag predstavlja vrednost na osnovu koje pretrazujemo poruke, sve one koje sadrze taj tag
	 * @return lista poruka koje sadrze odredjeni tag
	 * @throws RuntimeException kada je tag null ili je prazan
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if ( (tag == null) || (tag.isEmpty()) ) {
			throw new RuntimeException("Morate uneti tag");
		}
			
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0) {
			maxBroj = 100;
		}
			
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
			
		//Pomocni niz koja predstavlja rezultat pretrage, tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
			
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++) {
			if (poruke.get(i).getPoruka().indexOf(tag) != -1) {
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				}
				else break;
			}
		}
			
		return rezultat;
	}
		
}
