package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.projetopw.domain.CPF;
import br.com.bandtec.projetopw.domain.Cidadao;
import br.com.bandtec.projetopw.domain.ConsultaNoSUS;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosCidadaosTest {
	
	@Autowired
	private TodosCidadaos todosCidadaos;
	
	@Autowired
	private EntityManager em;
	
	private Cidadao pacheco;
	private ConsultaNoSUS consulta;
	private CPF cpf;
	
	@Before
	public void setUp() {
		cpf = new CPF("03701519099");
		pacheco = new Cidadao("Pacheco dos Santos", cpf, 33);
		consulta = new ConsultaNoSUS(LocalDate.now(), "otorrinolaringologista");
		pacheco.inserir(consulta);
		todosCidadaos.saveAndFlush(pacheco);
		em.clear();
	}
	
	@Test
	public void persistirPacheco() {
		Cidadao pachecoEncontrado = todosCidadaos.comCpf(cpf);
		
		assertEquals(pacheco, pachecoEncontrado);
		assertTrue(pachecoEncontrado.contem(consulta));
		
		List<ConsultaNoSUS> consultas = pachecoEncontrado.getConsultas();
		for(ConsultaNoSUS consulta : consultas) {
			assertEquals(pachecoEncontrado, consulta.getCidadao());
		}
	}
}

