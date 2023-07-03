package exercicioExcecao.conversorMoedas;

import java.math.BigDecimal;

public class ValorMonetario {
    private BigDecimal valor;
    private Moeda moeda;

    public ValorMonetario(BigDecimal valor, Moeda moeda) {
        this.valor = valor;
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }
}
