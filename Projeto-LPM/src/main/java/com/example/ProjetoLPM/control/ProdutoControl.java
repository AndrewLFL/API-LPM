package com.example.ProjetoLPM.control;
import com.example.ProjetoLPM.model.Produto;
import com.example.ProjetoLPM.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProduto")
public class ProdutoControl {

    @Autowired
    ProdutoRepository prRep;

    @PostMapping("/inserir")
    public void inserirProduto(@RequestBody Produto p)
    {
        prRep.save(p);
    }

    @GetMapping("/buscar")
    public List<Produto> buscarTudo()
    {
        return prRep.findAll();
    }

    @GetMapping("/buscar/codigo/{codigo}")
    public Optional<Produto> buscarPorCodigo(@PathVariable(value = "codigo") int codigo)
    {
        return prRep.findById(codigo);
    }

    @GetMapping("/buscar/parteDescricao/{parteDescricao}")
    public List<Produto> buscarPorParteDescricao(@PathVariable ("parteDescricao") String parteDescricao)
    {
        return prRep.findByParteDescricao(parteDescricao);
    }

    @GetMapping("/buscar/marca/{marca}")
    public List<Produto> buscarPorMarca(@PathVariable(value = "marca") String marca)
    {
        return prRep.findByMarca(marca);
    }

    @GetMapping("/buscar/precosMenores/{preco}")
    public List<Produto> buscarPorParteNomeParteEmail(@PathVariable ("preco") double preco)
    {
        return prRep.findByPrecoMenores(preco);
    }

    @GetMapping("/buscar/parteMarca/{parteMarca}/precosMenores/{preco}")
    public List<Produto> buscarPorParteMarcaPrecoMenores(@PathVariable ("parteMarca") String parteMarca, @PathVariable ("preco") double preco)
    {
        return prRep.findByParteMarcaPrecoMenores(parteMarca,preco);
    }

    @DeleteMapping("/remover")
    public void removerProduto(@RequestBody Produto p)
    {
        prRep.delete(p);
    }

    @DeleteMapping("/remover/codigo/{codigo}")
    public void removerProdutoPorCodigo(@PathVariable ("codigo") int codigo)
    {
        prRep.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarProduto(@RequestBody Produto p)
    {
        prRep.save(p);
    }
}
