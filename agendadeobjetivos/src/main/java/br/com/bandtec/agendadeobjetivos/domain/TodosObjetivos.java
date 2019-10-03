package br.com.bandtec.agendadeobjetivos.domain;

//import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosObjetivos extends JpaRepository <Objetivo, Long >{


//linguagem HQL ou JPQL para escrever os scripts do banco

    @Query("select o from Objetivo o where o.dataMaximaParaExecucao <= :data")
    public List<Objetivo> ate(@Param("data")LocalDate data);

}
