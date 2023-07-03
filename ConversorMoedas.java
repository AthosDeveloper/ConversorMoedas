package exercicioExcecao.conversorMoedas;

import java.math.BigDecimal;

public interface ConversorMoedas {
    BigDecimal converter(BigDecimal valor, Moeda origem, Moeda destino);
}
