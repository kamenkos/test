package testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

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
public class ProdukcijaFilmDodajFilmTest {

	private Film f;
	private ProdukcijaFilm pf;
	
	@Rule
	public final TestRule timeout= Timeout.seconds(6);
	
	@BeforeClass
	public static void proveriOperativniSistem()
	{
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	public ProdukcijaFilmDodajFilmTest(Film f)
	{
		this.f=f;
	}
	
	@Before
	public void init()
	{
		pf = new ProdukcijaFilm();
	}
	
	@Parameters
	public static Collection<Object[]> film() {
		return Arrays.asList(new Object[][] {
			{new Film("Munje",2,300)},
			{new Film("Munje",2,300)},
			{new Film("Munje",2,300)},
			{new Film("Orao",3,250)}
		});
	}
	
	@Test(expected = RuntimeException.class)
	public void dodajFilmTest()
	{
		f=null;
		pf.dodajFilm(f);
	}
	
	@Test(expected = RuntimeException.class)
	public void dodajFilmTest2()
	{
		pf.dodajFilm(f);
		pf.dodajFilm(f);
	}
	
	@Test
	public void dodajFilmTest3()
	{
		assertFalse(pf.film.contains(f));
		pf.dodajFilm(f);
		assertTrue(pf.film.contains(f));
	}
	
	@After
	public void destroy()
	{
		pf=null;
	}
	
	
	
}
