package com.example.ProjetoLPM.control;

import com.example.ProjetoLPM.model.Cliente;
import com.example.ProjetoLPM.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteControl {

    @Autowired
    ClienteRepository clRep;

    @PostMapping("/inserir")
    public void inserirCliente(@RequestBody Cliente c)
    {
        clRep.save(c);
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarTudo()
    {
        return clRep.findAll();
    }

    @GetMapping("/buscar/codigo/{codigo}")
    public Optional<Cliente> buscarPorCodigo(@PathVariable(value = "codigo") int codigo)
    {
        return clRep.findById(codigo);
    }

    @GetMapping("/buscar/parteNome/{parteNome}")
    public List<Cliente> buscarPorParteNome(@PathVariable ("parteNome") String parteNome)
    {
        return clRep.findByParteNome(parteNome);
    }

    @GetMapping("/buscar/email/{email}")
    public List<Cliente> buscarPorEmail(@PathVariable(value = "email") String email)
    {
        return clRep.findByEmail(email);
    }

    @GetMapping("/buscar/parteNome/{parteNome}/parteEmail/{parteEmail}")
    public List<Cliente> buscarPorParteNomeParteEmail(@PathVariable ("parteNome") String parteNome , @PathVariable ("parteEmail") String parteEmail)
    {
        return clRep.findByParteNomeParteEmail(parteNome,parteEmail);
    }

    @DeleteMapping("/remover")
    public void removerCliente(@RequestBody Cliente c)
    {
        clRep.delete(c);
    }

    @DeleteMapping("/remover/codigo/{codigo}")
    public void removerClientePorCodigo(@PathVariable ("codigo") int codigo)
    {
        clRep.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente c)
    {
        clRep.save(c);
    }
}
