package br.otymus.calculos.controllers;

import br.otymus.calculos.entities.Carro;
import br.otymus.calculos.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Carro carro) {

        try {
            String mensagem = this.carroService.cadastrar(carro);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Algo errado ao salvar!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("buscarPorId/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable int id) {
        try {
            Carro carro = this.carroService.buscarPorIdService(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable int id) {
        try {
            Carro carro = this.carroService.buscarPorIdService(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

}
