package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private TwitterPoruka twitterPoruka;
	private Twitter twitter;
	private LinkedList<TwitterPoruka> lista;

	@Before
	public void setUp() throws Exception {
		twitterPoruka = new TwitterPoruka();
		twitter = new Twitter();
		lista = new LinkedList<TwitterPoruka>();
	}

	@After
	public void tearDown() throws Exception {
		twitterPoruka = null;
		twitter = null;
		lista = null;
	}

	@Test
	public void testVratiSvePorukeNull() {
		assertEquals(lista, twitter.vratiSvePoruke());
	}
	
	@Test
	public void testVratiSvePorukeJedna() {
		twitterPoruka.setKorisnik("Pera Peric");
		twitterPoruka.setPoruka("Zdravo svima!");
		
		twitter.unesi(twitterPoruka.getKorisnik(), twitterPoruka.getPoruka());
		
		lista.addLast(twitterPoruka);
		
		assertEquals(lista, twitter.vratiSvePoruke());
	}
	
	@Test
	public void testVratiSvePorukeDve() {
		twitterPoruka.setKorisnik("Pera Peric");
		twitterPoruka.setPoruka("Zdravo svima!");
		
		TwitterPoruka twitterPoruka2 = new TwitterPoruka();
		twitterPoruka2.setKorisnik("Petar Petrovic");
		twitterPoruka2.setPoruka("Kako ste?");
		
		twitter.unesi(twitterPoruka.getKorisnik(), twitterPoruka.getPoruka());
		twitter.unesi(twitterPoruka2.getKorisnik(), twitterPoruka2.getPoruka());
		
		lista.addLast(twitterPoruka);
		lista.addLast(twitterPoruka2);
		
		assertEquals(lista, twitter.vratiSvePoruke());
	}
	
	@Test
	public void testUnesiJedan() {
		twitterPoruka.setKorisnik("Pera Peric");
		twitterPoruka.setPoruka("Zdravo svima!");
		
		twitter.unesi(twitterPoruka.getKorisnik(), twitterPoruka.getPoruka());
		lista.addLast(twitterPoruka);
		
		assertEquals(lista, twitter.vratiSvePoruke());
		
		// uoceno je da nije pravilno napisana metoda u klasi Twitter, jer umesto "korisnik" treba da pise samo
		// korisnik kako se ne bi vrednost postavljala na "korisnik" vec na unetu vrednost
		
		// greska je ispravljena
	}
	
	@Test
	public void testUnesiDva() {
		twitterPoruka.setKorisnik("Pera Peric");
		twitterPoruka.setPoruka("Zdravo svima!");
		
		TwitterPoruka twitterPoruka2 = new TwitterPoruka();

		twitterPoruka2.setKorisnik("Petar Petrovic");
		twitterPoruka2.setPoruka("Kako ste?");
		
		twitter.unesi(twitterPoruka.getKorisnik(), twitterPoruka.getPoruka());
		twitter.unesi(twitterPoruka2.getKorisnik(), twitterPoruka2.getPoruka());
		
		lista.addLast(twitterPoruka);
		lista.addLast(twitterPoruka2);
		
		assertEquals(lista, twitter.vratiSvePoruke());
	} 
	
	@Test
	public void testVratiPoruke() {
		twitterPoruka.setKorisnik("Pera Peric");
		twitterPoruka.setPoruka("Poruka 1!");
		
		TwitterPoruka twitterPoruka2 = new TwitterPoruka();
		
		twitterPoruka2.setKorisnik("Petar Petrovic");
		twitterPoruka2.setPoruka("Poruka 2!");
		
		TwitterPoruka[] niz = new TwitterPoruka[2];
		
		niz[0] = twitterPoruka;
		niz[1] = twitterPoruka2;
		
		twitter.unesi(twitterPoruka.getKorisnik(), twitterPoruka.getPoruka());
		twitter.unesi(twitterPoruka2.getKorisnik(), twitterPoruka2.getPoruka());
		
		
		assertArrayEquals(niz, twitter.vratiPoruke(2, "Poruka"));
		// postoji greska u metodi, kada se postavlja u niz pronadjeni element sa odredjenim tagom, postavlja se na brojac+1,
		// a potrebno je da se postavi na brojac jer ce u suprotnom izaci iz granica niza
		 
		// greska je ispravljena
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagJeNull() {
		twitter.vratiPoruke(15, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagJePrazan() {
		twitter.vratiPoruke(15, "");
	}

}
