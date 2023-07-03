package exercicioExcecao.conversorMoedas;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorDeValoresMonetarios {
    public String formatar(ValorMonetario valorMonetario){
        NumberFormat formatador = NumberFormat.getInstance(new Locale("pt", "BR"));
        formatador.setMinimumFractionDigits(2);
        formatador.setMaximumFractionDigits(2);
   formatador.setRoundingMode(RoundingMode.HALF_UP);
  return formatador.format(valorMonetario.getValor()) + " " + valorMonetario.getMoeda().getSimbolo();

    }
}
