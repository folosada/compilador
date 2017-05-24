package br.furb.compilador;

public class Token {

    private int id;
    private String lexeme;
    private int position;
    private int line;

    public Token(int id, String lexeme, int position, int line) {
        this.id = id;
        this.lexeme = lexeme;
        this.position = position;
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public final int getId() {
        return id;
    }
    
    public final String getClassToken() {
        if (id == 2) {
            return "identificador";
        } else if (id == 3) {
            return "constante inteira";
        } else if (id == 4) {
            return "constante real";
        } else if (id == 5) {
            return "constante caracter";
        } else if (id >= 6 && id <= 30) {
            return "palavra reservada";
        } else if (id >= 31 && id <= 46) {
            return "símbolo especial";
        }
        return "";
    }

    public final String getLexeme() {
        return lexeme;
    }

	public final int getPosition() {
        return position;
    }
	
    public String toString() {
        return id + " ( " + lexeme + " ) @ " + position;
    }
;
}
