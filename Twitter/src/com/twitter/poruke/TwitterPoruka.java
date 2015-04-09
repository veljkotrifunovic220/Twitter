package com.twitter.poruke;

/**
 * Ova klasa predstavlja poruku na twitter-u.
 * @author Veljko Trifunovic
 * @version 0.1
 */
public class TwitterPoruka {
	
	/**
	 * Korisnik twitter-a
	 */
	private String korisnik;
	
	/**
	 * Tekst twitter poruka;
	 */
	private String poruka;
	
	/**
	 * Metoda vraca vrednost atributa korisnik.
	 * @return korisnik twitter-a kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja vrednost atributa korisnik na unetu vrednost.
	 * @param korisnik Nova vrednost za korisnika twitter-a
	 * @throws java.lang.RuntimeException ako je
	 * <ul>
	 *  <li>uneti korisnik null</li>
	 * 	<li>ili prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if ( (korisnik == null) || (korisnik.equals("")) ) {
			throw new RuntimeException("Ime korisnika mora biti uneto!");
		}
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda vraca vrednost atributa poruka.
	 * @return tekst twitter poruke kao String
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda postavlja vrednost atributa poruka na unetu vrednost.
	 * @param poruka Nova vrednost za twitter poruku
	 * @throws java.lang.RuntimeException ako je
	 * <ul>
	 *  <li>uneta poruka null</li>
	 * 	<li>ili prazan String</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if ( (poruka == null) || (poruka.length() > 140) ) {
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova!");
		}
		this.poruka = poruka;
	}
	
	/**
	 * Metoda vraca atribute korisnik i poruka u tekstualnom obliku.
	 * @return korisnik twitter-a i twitter poruka kao String
	 */
	public String toString() {
		return "KORISNIK: " + korisnik + " PORUKA: " + poruka;
	}

}
