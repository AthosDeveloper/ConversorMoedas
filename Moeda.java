package exercicioExcecao.conversorMoedas;

import java.math.BigDecimal;

public enum Moeda {
  REAL("Real", "R$"),  DOLAR_AMERICANO("Dolar americano", "US$"), DOLAR_CANADENSE( "Dolar canadense", "CA$"),  EURO( "Euro", "€"), LIBRA_ESTERLINA( "Libra esterlina", "£");


    private String nome;
    private String simbolo;

    private Moeda(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }
public BigDecimal obterCotacao(){
        switch (this){
            case  REAL:
                return  new BigDecimal("1.0");
            case DOLAR_AMERICANO:
                return  new BigDecimal("5.25");
               case  DOLAR_CANADENSE:
      return  new BigDecimal("4.15");
            case  EURO:
                return  new BigDecimal("6.15");
            case  LIBRA_ESTERLINA:
                return  new BigDecimal("7.50");
            default:
                return  BigDecimal.ZERO;
        }
}


}
