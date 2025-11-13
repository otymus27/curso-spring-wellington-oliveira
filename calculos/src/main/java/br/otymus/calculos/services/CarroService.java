package br.otymus.calculos.services;

import br.otymus.calculos.entities.Carro;
import org.springframework.stereotype.Service;

@Service
public class CarroService {


    public String cadastrar(Carro carro) {
        return "Carro salvo com sucesso!";
    }

    public Carro buscarPorIdService(int id) {
        Carro carro = new Carro();

        if (id==1){
            carro.setId(1L);
            carro.setMarca("HONDA");
            carro.setModelo("FIT");
            carro.setCor("Preto");
            return carro;
        }else if(id==2){
            carro.setId(2L);
            carro.setMarca("GM");
            carro.setModelo("ASTRA");
            carro.setCor("Preto");
            return carro;
        }else{
            return null;
        }

    }
}
