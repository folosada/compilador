package br.furb.compilador;

public class LexicalError extends AnalysisError {

    private int line;
    
    public LexicalError(String msg, int position, int line) {
        super(msg, position);
        this.line = line;
    }

    public LexicalError(String msg) {
        super(msg);
    }
}
