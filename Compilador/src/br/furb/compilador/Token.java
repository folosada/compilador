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
        switch (id) {
            case 2: return "identificador";
            case 3: return "constante inteira";
            case 4: return "constante real";
            case 5: return "constante caracter";
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32: return "palavra reservada";
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51: return "símbolo especial";
        }
        return "";
    }

    public final String getLexeme() {
        return lexeme;
    }

    public String toString() {
        return id + " ( " + lexeme + " ) @ " + position;
    }
;
}
