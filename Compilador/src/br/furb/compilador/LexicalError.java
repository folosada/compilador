package br.furb.compilador;

public class LexicalError extends AnalysisError {

    public LexicalError(String msg, int position) {
        super(msg, position);
    }

    public LexicalError(String msg) {
        super(msg);
    }

    public LexicalError(String msg, int position, int line, char firstChar) {
        super(getMessage(msg, line, firstChar), position);
    }

    private static String getMessage(String msg, int line, char firstChar) {
        String message = "Erro na linha " + line + " - " + msg;
        if ("Símbolo inválido".equals(msg)) {
            message += " -> " + firstChar;
        }
        return message;
    }
}
