/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Veljko Trifunovic
 *
 */
public class TwitterPorukaTest {
	
	private TwitterPoruka twitterPoruka;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twitterPoruka = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitterPoruka = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		twitterPoruka.setKorisnik("Pera Peric");
		
		assertEquals("Pera Peric", twitterPoruka.getKorisnik());
	}
	
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		twitterPoruka.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		twitterPoruka.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		twitterPoruka.setPoruka("Zdravo svima!");
		
		assertEquals("Zdravo svima!", twitterPoruka.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		twitterPoruka.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaMessageTooLong() {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				   "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				   "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				   "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + 
				   "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		twitterPoruka.setPoruka(s);
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		twitterPoruka.setKorisnik("Pera Peric");
		twitterPoruka.setPoruka("Zdravo svima!");
		
		assertEquals("KORISNIK: Pera Peric PORUKA: Zdravo svima!", twitterPoruka.toString());
	}

}
