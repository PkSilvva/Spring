package br.com.bandtec.agendadeobjetivos.domain;

        import br.com.bandtec.agendadeobjetivos.controller.Credenciais;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

        import java.util.List;


@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long > {
   //linguagem HQL ou JPQL para escrever os scripts do banco

   @Query("select u from Usuario u where u.credenciais = :credenciais")
   public  Usuario buscarUsando(@Param("credenciais") Credenciais credenciais);

    @Query("select u from Usuario u where u.nome = :nome")
    public List<Usuario> obterPorNome(String nome);


}
