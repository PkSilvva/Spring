package br.com.bandtec.projetopw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.domain.CPF;
import br.com.bandtec.projetopw.domain.Cidadao;

@Repository
public interface TodosCidadaos extends JpaRepository<Cidadao, Long>{

	@Query("from Cidadao c where c.cpf = ?1")
	Cidadao comCpf(CPF cpf);
}
