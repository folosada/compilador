package br.furb.compilador;

/**
 *
 * @author usuario
 */
public class Compilador {

    public static boolean compilar(String codigoFonte) {
        return true;
    }

    public static String analiseLexica(String codigoFonte) throws LexicalError {
        Lexico lexico = new Lexico();
        //...
        lexico.setInput(codigoFonte);
        //...        
        Token t = null;
        while ((t = lexico.nextToken()) != null) {
            System.out.println(t.getLexeme());            
        }               
        return "";
    }
}
