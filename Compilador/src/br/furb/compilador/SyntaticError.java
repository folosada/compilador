package br.furb.compilador;

public class SyntaticError extends AnalysisError {

    public SyntaticError(String msg, int position) {
        super(msg, position);
    }

    public SyntaticError(String msg) {
        super(msg);
    }
    
    public SyntaticError(String msg, int position, int line, char firstChar) {
        super(getMessage(msg, line, firstChar), position);
    }
    
    private static String getMessage(String msg, int line, char firstChar) {
        String message = "Linha: " + line + " " + msg;
        if ("Símbolo inválido".equals(msg)) {
            message += " -> " + firstChar;
        }
        return message;
    }
}
