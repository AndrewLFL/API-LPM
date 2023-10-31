package com.example.ProjetoLPM.repository;

import com.example.ProjetoLPM.model.Cliente;
import com.example.ProjetoLPM.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository  extends JpaRepository<Produto,Integer> {

    public List<Produto> findByMarca(String marca);

    @Query("select p from Produto p where p.descricao like ?1%")
    public List<Produto> findByParteDescricao(String parteDescricao);

    @Query("select p from Produto p where p.preco < ?1")
    public List<Produto> findByPrecoMenores(double preco);

    @Query("select p from Produto p where p.marca like %?1% and p.preco < ?2")
    public List<Produto> findByParteMarcaPrecoMenores(String parteMarca,double preco);
}
