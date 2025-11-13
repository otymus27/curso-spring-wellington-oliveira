package br.otymus.calculos.services;

import br.otymus.calculos.entities.Entrada;
import br.otymus.calculos.entities.Resultado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculosService {

    public Resultado calcular(Entrada entrada) {
        Resultado resultado = new Resultado();
        Integer soma = 0;

        if(entrada.getLista() !=null){
            for (int i = 0; i < entrada.getLista().size(); i++) {
                soma = soma + entrada.getLista().get(i);
            }
        }

        resultado.setSoma(soma);
        Double media = (double)(soma/entrada.getLista().size());
        Integer maiorNumero = entrada.getLista().stream().max(Double::compare).get();
        resultado.setMaiorNumero(maiorNumero);

        Integer menorNumero = entrada.getLista().stream().min(Double::compare).get();
        resultado.setMenorNumero(menorNumero);

        Integer totalElementos = (int) entrada.getLista().stream().count();
        resultado.setTotalElementos(totalElementos);

        resultado.setMedia(media);
        return resultado;
    }

    public int somar(List<Integer> lista){
        int soma = 0;

        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i) != null){
                soma = soma + lista.get(i);
            }

        }
        return soma;
    }
}
