package br.otymus.curso.services;

import br.otymus.curso.entities.Carro;
import br.otymus.curso.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listar() {
        List<Carro> lista = carroRepository.findAll();
        return lista;
    }

    public String cadastrar(Carro carro) {
        carroRepository.save(carro);
        return "Carro salvo com sucesso!";
    }

    public String atualizar(Carro carro, Long id) {
        carro.setId(id);
        carroRepository.save(carro);
        return "Carro salvo com sucesso!";
    }

    public Carro buscarPorId(Long id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.get();
    }

    public String excluir(Long id) {
        carroRepository.deleteById(id);
        return "Registro excluido com sucesso!";
    }
}
