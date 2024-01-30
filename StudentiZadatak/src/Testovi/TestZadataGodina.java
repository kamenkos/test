package Testovi;


import static org.junit.Assert.*;

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

import Studenti.ListaStudenata;
import Studenti.Student;
@RunWith(Parameterized.class)
public class TestZadataGodina {
Student s;
ListaStudenata ls;
	@Rule
	public final TestRule timeout = Timeout.seconds(6);
	@BeforeClass
	public static void proveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
		
	}
	public TestZadataGodina(Student s) {
		this.s = s;
	}
	@Before
	public void init() {
		ls = new ListaStudenata();
	}
	
	@Parameters
	public static Collection<Object[]> lista(){
		return Arrays.asList(new Object[][] {
			{new Student ("Sreten",100,2)},
			{new Student ("Sreten",100,2)},
			{new Student ("Sreten",100,2)},
			{new Student ("Sreten",100,2)},
			{new Student ("Sreten",100,2)},
			{new Student ("Sreten",100,2)},
		});
	}
	
	
	@Test
	public void testStudentiZadateGodine() {
		int godinaStudija = 0;
		ls.studentiZadateGodine(godinaStudija);
		
	}
	@Test
	public void testStudentiZadateGodine2() {
		assertFalse(ls.lista.contains(s));
		ls.dodajStudent(s);
		LinkedList<Student> lista = new LinkedList<Student>();
		lista.add(s);
		assertEquals(lista,ls.studentiZadateGodine(100));
		
	}
	 @Test
	 public void testStudentiZadateGodine3() {
		 assertFalse(ls.lista.contains(s));
			ls.dodajStudent(s);
			LinkedList<Student> listas = new LinkedList<Student>();
			listas.add(s);
			assertNotEquals(listas, ls.studentiZadateGodine(150));
	 }

}
