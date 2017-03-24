package br.furb.compilador;

/**
 *
 * @author usuario
 */
public class Compilador {

    public static String compilar(String codigoFonte) throws LexicalError {
        return analiseLexica(codigoFonte);
    }

    private static String analiseLexica(String codigoFonte) throws LexicalError {
        Lexico lexico = new Lexico();
        lexico.setInput(codigoFonte);
        Token t = null;
        StringBuilder tabela = new StringBuilder(
                "+-----+--------------------+-----------------------------------+\n"
                + "|Linha|Classe              |Lexema                             |\n"
                + "+-----+--------------------+-----------------------------------+\n");
        while ((t = lexico.nextToken()) != null) {
            tabela.append(String.format("|%1$5s|%2$-20s|%3$-35s|\n", t.getLine(), t.getClassToken(), t.getLexeme()));
        }
        tabela.append("+-----+--------------------+-----------------------------------+");
        return tabela.toString();
    }
}    