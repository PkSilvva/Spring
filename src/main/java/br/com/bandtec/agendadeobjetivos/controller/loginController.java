package br.com.bandtec.agendadeobjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {
@PostMapping("/login")

    public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
        if(credenciais.getLogin().equals(credenciais.getSenha())){

            return ResponseEntity.ok("Sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body("Erro");
        }

    }

}
