package br.otymus.calculos.entities;

public class Resultado {
    private Integer soma;
    private Double media;
    private Integer maiorNumero;
    private Integer menorNumero;

    public Integer getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(Integer totalElementos) {
        this.totalElementos = totalElementos;
    }

    private Integer totalElementos;

    public Integer getMenorNumero() {
        return menorNumero;
    }

    public void setMenorNumero(Integer menorNumero) {
        this.menorNumero = menorNumero;
    }



    public Integer getMaiorNumero() {
        return maiorNumero;
    }

    public void setMaiorNumero(Integer maiorNumero) {
        this.maiorNumero = maiorNumero;
    }

    public Integer getSoma() {
        return soma;
    }

    public void setSoma(Integer soma) {
        this.soma = soma;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }



}
