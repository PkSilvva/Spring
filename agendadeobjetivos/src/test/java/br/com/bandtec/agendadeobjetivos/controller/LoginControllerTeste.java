package br.com.bandtec.agendadeobjetivos.controller;
import javax.xml.ws.Response;
import static org.junit.Assert.assertEquals;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.domain.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.*;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public class LoginControllerTeste {
	private TodosUsuarios todosUsuarios;

	@Before
	public void setUp(){
	 	this.todosUsuarios = Mockito.mock(TodosUsuarios.class);
	 }

	@Test
	public void loginComSucesso() {
		Credenciais c = new Credenciais("login", "login");
		Mockito.when(todosUsuarios.buscarUsando(c))
				.thenReturn(new Usuario("Rodrigo",39));
		LoginController controller = new LoginController(todosUsuarios);



		ResponseEntity<String> resposta  = controller.validarLogin(c);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("sucesso", resposta.getBody());

	}
	
	
	@Test
	public void loginComFalha() {
		Credenciais c = new Credenciais("login", "login");
		Mockito.when(todosUsuarios.buscarUsando(c))
				.thenReturn(null);
		LoginController controller = new LoginController(todosUsuarios);

		
		
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login", "senha"));
		
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
		assertEquals("erro", resposta.getBody());

	}

}
