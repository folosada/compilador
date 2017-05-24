package br.furb.compilador;

/**
 *
 * @author usuario
 */
public class Compilador {

    public static String compilar(String codigoFonte) {
        try {
            Sintatico sintatico = new Sintatico();
            Lexico lexico = new Lexico();
            lexico.setInput(codigoFonte);
            Semantico semantico = new Semantico();
            sintatico.parse(lexico, null);
        } catch (LexicalError | SyntaticError | SemanticError le) {
            return le.getMessage();
        }
        return "Programa compilado com sucesso!";
    }

    private static String analiseLexica(String codigoFonte) throws LexicalError {
        Lexico lexico = new Lexico();
        lexico.setInput(codigoFonte);
        Token t = null;
        StringBuilder tabela = new StringBuilder();
        while ((t = lexico.nextToken()) != null) {
            tabela.append("Linha ").append(t.getLine()).append(" - ").
                    append(t.getClassToken()).append(": ").append(t.getLexeme()).append("\n");
        }
        return tabela.toString();
    }
}
