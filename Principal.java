package exercicioExcecao.conversorMoedas;

import java.math.BigDecimal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConversorMoedasPorCotacao cotacao = new ConversorMoedasPorCotacao(new CotacaoDoDia());
        FormatadorDeValoresMonetarios formatador = new FormatadorDeValoresMonetarios();
      ValidaMoeda validaTipoMoeda = new ValidaMoeda();
      InterfacePrograma interfacePrograma = new InterfacePrograma(sc, cotacao, formatador, validaTipoMoeda);
      interfacePrograma.exibirBoasVindas();
      boolean continuar = true;
      while (continuar){
          try {
              String tipoMoeda = interfacePrograma.lerTipoDeMoeda();
         interfacePrograma.informarCotacaoParaReal();
         BigDecimal valorAconverter = interfacePrograma.lerValorAConverter();
         Moeda moeda = Moeda.valueOf(tipoMoeda);
         ValorMonetario valorOriginal = new ValorMonetario(valorAconverter, moeda);
        ValorMonetario valorMonetarioConvertido = interfacePrograma.converterParaReal(valorOriginal);
        interfacePrograma.exibirResultado(valorOriginal, valorMonetarioConvertido);

          }
          catch (IllegalArgumentException e){
              System.out.println(e.getMessage());
          }


          continuar = interfacePrograma.perguntaConversao();

           }
    }
}

