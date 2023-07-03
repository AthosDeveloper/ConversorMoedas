package exercicioExcecao.conversorMoedas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class InterfacePrograma {
    private Scanner sc;
    private ConversorMoedas conversorMoedas;
    private FormatadorDeValoresMonetarios formatadorDeValoresMonetarios;
    private ValidaMoeda moeda;

    public InterfacePrograma(Scanner sc, ConversorMoedas conversorMoedas, FormatadorDeValoresMonetarios formatadorDeValoresMonetarios, ValidaMoeda moeda) {
        this.sc = sc;
        this.conversorMoedas = conversorMoedas;
        this.formatadorDeValoresMonetarios = formatadorDeValoresMonetarios;
        this.moeda = moeda;
    }
    public void exibirBoasVindas(){
        System.out.println("Seja bem-vindo ao conversor de moedas!");
        System.out.println();
    }
    public String lerTipoDeMoeda() throws IllegalArgumentException{
        System.out.println("qual moeda você quer converter?");
        System.out.println("As opções são: Dolar Americano, Dolar Canadense, euro ou Libra esterlina.");
  String tipoDeMoeda = sc.nextLine();
  if (moeda.validar(tipoDeMoeda)){
      return  tipoDeMoeda;

  } else  {
      throw new IllegalArgumentException("tipo de moeda inválido");

  }
    }
    public void informarCotacaoParaReal(){
        System.out.println("o programa só converte para real (r$)");
        System.out.println();
    }
    public BigDecimal lerValorAConverter () throws  NumberFormatException{
        System.out.println("digite o valor a ser convertido");
   String valor = sc.nextLine();
try {
    BigDecimal valorAConverter = new BigDecimal(valor);
    if (valorAConverter.compareTo(BigDecimal.ZERO) > 0){
        return  valorAConverter;
    } else  {
        System.out.println("o valor deverá ser positivo. Por favor, tente novamente.");
        System.out.println();
   return  lerValorAConverter();
    }

} catch ( NumberFormatException e){
    throw new NumberFormatException("para moeda, o valor monetário deve ser em formato decimal");
}
    }

    public ValorMonetario converterParaReal(ValorMonetario valorMonetarioOriginal){
        Moeda moedaOriginal = valorMonetarioOriginal.getMoeda();
   BigDecimal valorOriginal = valorMonetarioOriginal.getValor();
   BigDecimal valorConverte = conversorMoedas.converter(valorOriginal, moedaOriginal, Moeda.REAL);
   ValorMonetario valorConvertido = new ValorMonetario(valorConverte, Moeda.REAL);
   return  valorConvertido;
    }
    public void exibirResultado(ValorMonetario original, ValorMonetario valorConvertido){
        Moeda moedaOriginal = original.getMoeda();
  BigDecimal cotacao = moedaOriginal.obterCotacao();
        LocalDate dataAtual = LocalDate.now();
        String valorFormatado = formatadorDeValoresMonetarios.formatar(original);
        String cotacaoFormatada = formatadorDeValoresMonetarios .formatar(new ValorMonetario(cotacao, Moeda.REAL));
   String valorConvertidoFormatado = formatadorDeValoresMonetarios.formatar(valorConvertido);
        System.out.println();
        System.out.println("a moeda " + moedaOriginal.getNome() + " na cotação de hoje " + dataAtual + " está em " + cotacaoFormatada + ".");
        System.out.println("o valor solicitado para converter de " + valorFormatado + " em reais é " + valorConvertidoFormatado  + ".");

    }
    public boolean perguntaConversao(){
        System.out.println();
        System.out.println("você deseja fazer outra conversão? s/n? ");
   String resposta = sc.nextLine();
   if (resposta.equalsIgnoreCase("s")){
       return  true;
   } else  {
       return  false;
   }
    }
}
