package testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import zad.Film;
import zad.ProdukcijaFilm;

@RunWith(Parameterized.class)
public class ProdukcijaFilmPronadjiFilmTest {

	private ProdukcijaFilm pf;
	private Film f;
	
	@Rule 
	public final TestRule timeout= Timeout.seconds(6);
	
	@BeforeClass
	public static void proveriOperativniSistem()
	{
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Before
	public void init()
	{
		pf = new ProdukcijaFilm();
	}
	
	public ProdukcijaFilmPronadjiFilmTest(Film f)
	{
		this.f=f;
	}
	
	@Parameters
	public static Collection<Object[]> film(){
		return Arrays.asList(new Object[][] {
			{new Film("Munje",2,300)},
			{new Film("Munje",1,250)},
			{new Film("Munje",3,350)},
			{new Film("Munje",4,100)}
		});
	}
	
	@Test
	public void pronadjiFilmTest()
	{
		String naslov=null;
		assertNull(pf.pronadjiFilm(naslov));
	}
	
	@Test
	public void pronadjiFilmTest2()
	{
		assertFalse(pf.film.contains(f));
		pf.dodajFilm(f);
		LinkedList<Film> film = new LinkedList<Film>();
		film.add(f);
		assertEquals(film,pf.pronadjiFilm("Munje"));
	}
	
	@Test
	public void pronadjiFilmTest3()
	{
		assertFalse(pf.film.contains(f));
		pf.dodajFilm(f);
		LinkedList<Film> film = new LinkedList<Film>();
		film.add(f);
		assertEquals(film,pf.pronadjiFilm("Munje - NotExistingName"));
	}
	
	@After
	public void destroy()
	{
		pf=null;
	}
}
