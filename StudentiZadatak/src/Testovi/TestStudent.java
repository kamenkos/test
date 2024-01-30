package Testovi;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import Studenti.Student;

public class TestStudent {
public Student s;
@Rule
public final Timeout timeout = Timeout.seconds(6);
@BeforeClass
public static void proveriOS() {
	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
}
@Before
public void init() {
	s = new Student("Filip",4,180);
}
@Rule
public final TestName name = new TestName();
	@Test
	public void testGetGodinaStudija() {
		assertEquals("testGetGodinaStudija",name.getMethodName());
		int ocekivani = 4;
		int stvarni = s.getGodinaStudija();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetGodinaStudija() {
		assertEquals("testSetGodinaStudija",name.getMethodName());
		int ocekivani = 4;
		int stvarni = s.getGodinaStudija();
		assertEquals(ocekivani,stvarni);
		s.setGodinaStudija(-2);
	}
	@Test(expected = RuntimeException.class)
	public void testSetGodinaStudija2() {
		assertEquals("testSetGodinaStudija2",name.getMethodName());
		int ocekivani = 4;
		int stvarni = s.getGodinaStudija();
		assertEquals(ocekivani,stvarni);
		s.setGodinaStudija(6);
	}
	@Test
	public void testSetGodinaStudija3() {
		assertEquals("testSetGodinaStudija3",name.getMethodName());
		int ocekivani = 4;
		int stvarni = s.getGodinaStudija();
		assertEquals(ocekivani,stvarni);
		s.setGodinaStudija(3);
	}

	@Test
	public void testGetBrojESPB() {
		assertEquals("testGetBrojESPB",name.getMethodName());
		int ocekivani = 180;
		int stvarni = s.getBrojESPB();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetBrojESPB() {
		assertEquals("testSetBrojESPB",name.getMethodName());
		int ocekivani = 180;
		int stvarni = s.getBrojESPB();
		assertEquals(ocekivani,stvarni);
		s.setBrojESPB(-2);
	}
	@Test(expected = RuntimeException.class)
	public void testSetBrojESPB2() {
		assertEquals("testSetBrojESPB2",name.getMethodName());
		int ocekivani = 180;
		int stvarni = s.getBrojESPB();
		assertEquals(ocekivani,stvarni);
		s.setBrojESPB(252);
	}
	@Test
	public void testSetBrojESPB3() {
		assertEquals("testSetBrojESPB3",name.getMethodName());
		int ocekivani = 180;
		int stvarni = s.getBrojESPB();
		assertEquals(ocekivani,stvarni);
		s.setBrojESPB(186);
	}

	@Test
	public void testGetImeIPrezime() {
		assertEquals("testGetImeIPrezime",name.getMethodName());
		String ocekivani = "Filip";
		String stvarni = s.getImeIPrezime();
		assertEquals(ocekivani,stvarni);
		
	}

	@Test(expected = RuntimeException.class)
	public void testSetImeIPrezime() {
		assertEquals("testSetImeIPrezime",name.getMethodName());
		String ocekivani = "Filip";
		String stvarni = s.getImeIPrezime();
		assertEquals(ocekivani,stvarni);
		s.setImeIPrezime(null);
	}
	@Test
	public void testSetImeIPrezime2() {
		assertEquals("testSetImeIPrezime2",name.getMethodName());
		String ocekivani = "Filip";
		String stvarni = s.getImeIPrezime();
		assertEquals(ocekivani,stvarni);
		s.setImeIPrezime("Filip");
	}

	@Test
	public void testProsekESPB() {
	double ocekivani = s.getBrojESPB() / s.getGodinaStudija();
	double stvarni = s.prosekESPB();
	assertEquals(ocekivani,stvarni,0.001);
	}

	@Test
	public void testRedovniDrugaGod() {
		assertFalse(s.redovniDrugaGod());
	}
	@Test
	public void testRedovniDrugaGod2() {
		s.setBrojESPB(120);
		assertTrue(s.redovniDrugaGod());
	}

	@Test
	public void testToString() {
		String ocekivani = "Student [ime i prezime=" + s.getImeIPrezime()+ ", godina studija =" + s.getGodinaStudija() + ", broj ESPB =" +s.getBrojESPB()+ "]";
		String stvarni = s.toString();
		assertEquals(ocekivani,stvarni);
	}

}
