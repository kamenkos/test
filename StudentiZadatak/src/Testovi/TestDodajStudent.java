package Testovi;

import static org.junit.Assert.*;

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

import Studenti.ListaStudenata;
import Studenti.Student;
@RunWith(Parameterized.class)
public class TestDodajStudent {
Student s;
ListaStudenata ls;
@Rule
public final TestRule timeout = Timeout.seconds(6);
@BeforeClass
public static void proveriOS() {
	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
}
public TestDodajStudent(Student s) {
	this.s = s;
}
@Parameters
public static Collection<Object[]> lista()
{
	return Arrays.asList(new Object[][] {
		{new Student("Filip",150,3)},
		{new Student("Filip",150,3)},
		{new Student("Filip",150,3)},
		{new Student("Filip",150,3)},
		{new Student("Milos",100,2)},
	});
}
@Before
public void init() {
	ls = new ListaStudenata();
}

	@Test(expected = NullPointerException.class)
	public void testDodajStudent() {
	s = null;
	ls.dodajStudent(s);
	}
	@Test(expected = RuntimeException.class)
	public void testDodajStudent2() {
	ls.dodajStudent(s);
	ls.dodajStudent(s);
	}
	@Test
	public void testDodajStudent3() {
	assertFalse(ls.lista.contains(s));
	ls.dodajStudent(s);
	assertTrue(ls.lista.contains(s));
	
	}
	@After
	public void destroy() {
		ls = null;
	}

}
