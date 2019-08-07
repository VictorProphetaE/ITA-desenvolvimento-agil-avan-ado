import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/*
 * Cenários:
 * (x) Tradutor sem palavras
 * (x) Uma tradução
 * (x) Duas traduções
 * (x) Duas traduções mesma palavra
 * (x) Traduzir frases
 * (x) Traduzir frase c/ 2 traduções para mesma palavra
 */

public class TesteTradutor {
	
	private Tradutor t;
	
	@Before
	public void criarTradutor(){
		t = new Tradutor();
	}

	@Test
	public void testTradutor(){
		t.adicionaTraducao("bom","good");
		assertFalse(t.estaVazio());
		assertEquals("good",t.traduzir("bom"));
		
	}
	
	@Test
	public void testTradutor1(){
		t.adicionaTraducao("bom","good");
		t.adicionaTraducao("mau","bad");
		
		assertEquals("good",t.traduzir("bom"));
		assertEquals("bad",t.traduzir("mau"));
	}
	
	@Test
	public void testTradutor2(){
		t.adicionaTraducao("mau","good");
		assertFalse(t.estaVazio());
		assertEquals("mau","good");
	}
		
}