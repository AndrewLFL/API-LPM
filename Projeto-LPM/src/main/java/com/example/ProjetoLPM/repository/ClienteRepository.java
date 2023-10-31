package com.example.ProjetoLPM.repository;

import com.example.ProjetoLPM.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository  extends JpaRepository<Cliente,Integer> {

    public List<Cliente> findByEmail(String email);

    @Query("select c from Cliente c where c.nome like ?1%")
    public List<Cliente> findByParteNome(String parteNome);

    @Query("select c from Cliente c where c.nome like %?1% and c.email like %?2%")
    public List<Cliente> findByParteNomeParteEmail(String parteNome, String parteEmail);
}
