package br.com.bandtec.projetopw.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SistemaDoGovernoTest {
	
	private SistemaDoGoverno sistemaDoGoverno;
	
	@Before
	public void setUp() {
		sistemaDoGoverno = new SistemaDoGoverno();
	}
	
	@Test
	public void obterMunicipiosDeSaoPaulo() {
		List<Municipio> municipios = sistemaDoGoverno.municipiosDoEstado("SP");
		
		assertEquals(2, municipios.size());
		for(Municipio m : municipios) {
			assertNotNull(m.getEstado());
			assertNotNull(m.getNome());
		}
	}
	
	@Test
	public void obterMunicipiosDoRioDeJaneiro() {
		List<Municipio> municipios = sistemaDoGoverno.municipiosDoEstado("RJ");
		
		assertEquals(1, municipios.size());
		for(Municipio m : municipios) {
			assertNotNull(m.getEstado());
			assertNotNull(m.getNome());
		}
	}
}
