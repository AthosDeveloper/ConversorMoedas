package exercicioExcecao.conversorMoedas;

public class ValidaMoeda {
    public boolean validar (String tipoDeMoeda){
        try {
       Moeda.valueOf(tipoDeMoeda);
       return  true;


        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
