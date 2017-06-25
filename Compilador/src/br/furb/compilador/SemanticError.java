package br.furb.compilador;

public class SemanticError extends AnalysisError {

    public SemanticError(String msg, int position) {
        super(msg, position);
    }

    public SemanticError(String msg) {
        super(msg);
    }
    
    public SemanticError(String msg, int position, int line) {
        super(getMessage(msg, line), position);
    }

    private static String getMessage(String msg, int line) {
        String message = "Erro na linha " + line + " - " + msg;
        return message;
    }
}
