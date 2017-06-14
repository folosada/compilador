package br.furb.compilador;

public class SyntaticError extends AnalysisError {

    public SyntaticError(String msg, int position) {
        super(msg, position);
    }

    public SyntaticError(String msg) {
        super(msg);
    }

    public SyntaticError(String msg, int position, int line, Token lexeme) {
        super(getMessage(msg, line, lexeme), position);
    }

    private static String getMessage(String msg, int line, Token lexeme) {
        String message = "Erro na linha " + line + " - Encontrado " + lexeme.getLexeme() + ". " + msg + ".";
        return message;
    }
}
