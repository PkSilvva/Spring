package br.com.bandtec.agendadeobjetivos.controller;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;


public class LoginControllerTeste {
     @Test
    public void loginComSucesso(){
        loginController controller = new loginController();

       ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login","login"));
       assertEquals(HttpStatus.OK, resposta.getStatusCode());
       assertEquals("Sucesso",resposta.getBody());

    }
    @Test
    public void loginComFalha(){

        loginController controller = new loginController();
        ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login","senha"));
        assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
        assertEquals("Erro",resposta.getBody());


    }


}
