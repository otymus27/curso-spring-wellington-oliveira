package br.otymus.calculos.controllers;

import br.otymus.calculos.entities.Entrada;
import br.otymus.calculos.entities.Resultado;
import br.otymus.calculos.services.CalculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculos")
public class CalculosController {

    @Autowired
    private CalculosService calculosService;

    @GetMapping
    public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada) {
        try {
            Resultado resultado =this.calculosService.calcular(entrada);
            return new  ResponseEntity<Resultado>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
