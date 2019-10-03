package br.com.bandtec.agendadeobjetivos.controller;

import br.com.bandtec.agendadeobjetivos.domain.Objetivo;
import br.com.bandtec.agendadeobjetivos.domain.TodosObjetivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ObjetivosController {

    private TodosObjetivos todosObjetivos;

    @Autowired
    public ObjetivosController(TodosObjetivos todosObjetivos) {
        this.todosObjetivos = todosObjetivos;
    }

    @PostMapping("/objetivos")
    public ResponseEntity<String> salvar(@RequestBody Objetivo objetivo) {
        this.todosObjetivos.save(objetivo);
        return ResponseEntity.ok("Sucesso");
    }

    @GetMapping("/objetivos/data/{data}")
    public ResponseEntity<List<Objetivo>> obterPorData(@PathVariable("data") String dataString) {
        LocalDate data = LocalDate.parse(dataString);

        //todosObjetivos.ate(data);

        List<Objetivo> objetivos = todosObjetivos.ate(data);

        if(objetivos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(objetivos);
    }


}
