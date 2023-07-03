package exercicioExcecao.conversorMoedas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversorMoedasPorCotacao implements ConversorMoedas {
    private CotacaoDoDia cotacaoDoDia;

    public ConversorMoedasPorCotacao(CotacaoDoDia cotacaoDoDia) {
        this.cotacaoDoDia = cotacaoDoDia;
    }

    @Override
    public BigDecimal converter(BigDecimal valor, Moeda origem, Moeda destino) {
        BigDecimal cotacaoOrigem = origem.obterCotacao();
        BigDecimal cotacaoDestino = destino.obterCotacao();
        BigDecimal valorReal = valor.divide(cotacaoOrigem, RoundingMode.HALF_UP);
      BigDecimal valorConvertido = valorReal.multiply(cotacaoDestino);
        return valorConvertido;
    }
}
