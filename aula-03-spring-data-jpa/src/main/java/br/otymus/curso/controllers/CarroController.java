package br.otymus.curso.controllers;

import br.otymus.curso.entities.Carro;
import br.otymus.curso.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> listar() {
        try{
            List<Carro> lista = carroService.listar();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        try {
            Carro carro = this.carroService.buscarPorId(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Carro carro) {

        try {
            String mensagem = this.carroService.cadastrar(carro);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Algo errado ao criar novo registro!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Carro> atualizar(@RequestBody Carro carro, @PathVariable Long id) {
        try {
            String mensagem = this.carroService.atualizar(carro,id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            Carro carro = this.carroService.buscarPorId(id);
            carroService.excluir(carro.getId());
            return new ResponseEntity<>("Registro excluido com sucesso!", HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

}
