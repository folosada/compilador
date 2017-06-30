package br.furb.compilador;

public class Lexico implements Constants {

    private int position;
    private String input;

    public Lexico() {
        this("");
    }

    public Lexico(String input) {
        setInput(input);
    }

    public void setInput(String input) {
        this.input = input;
        setPosition(0);
    }

    public void setPosition(int pos) {
        position = pos;
    }

    public Token nextToken() throws LexicalError {
        if (!hasInput()) {
            return null;
        }

        int start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;

        while (hasInput()) {
            lastState = state;
            state = nextState(nextChar(), state);

            if (state < 0) {
                break;
            } else {
                if (tokenForState(state) >= 0) {
                    endState = state;
                    end = position;
                }
            }
        }
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2)) {
            throw new LexicalError(SCANNER_ERROR[lastState], start, getLine(start), input.charAt(start));
        }

        position = end;

        int token = tokenForState(endState);

        if (token == 0) {
            return nextToken();
        } else {
            String lexeme = input.substring(start, end);
            token = lookupToken(token, lexeme);
            lexeme = token == 2 ? trataIdentificador(lexeme) : lexeme;
            return new Token(token, lexeme, start, getLine(start));
        }
    }

    private String trataIdentificador(String identificador) {
        //á|Á|â|Â|ã|Ã|à|À|é|É|ê|Ê|í|Í|î|Î|ó|Ó|ô|Ô|õ|Õ|ú|Ú|û|Û|ç|Ç
        //Ilasm não aceita caracter especial
        String result = identificador;
        result = result.replaceAll("á", "a" + ((int) 'á'));
        result = result.replaceAll("Á", "A" + ((int) 'Á'));
        result = result.replaceAll("â", "a" + ((int) 'â'));
        result = result.replaceAll("Â", "A" + ((int) 'Â'));
        result = result.replaceAll("à", "a" + ((int) 'à'));
        result = result.replaceAll("À", "A" + ((int) 'À'));
        result = result.replaceAll("é", "e" + ((int) 'é'));
        result = result.replaceAll("É", "E" + ((int) 'É'));
        result = result.replaceAll("ê", "e" + ((int) 'ê'));
        result = result.replaceAll("Ê", "E" + ((int) 'Ê'));
        result = result.replaceAll("í", "i" + ((int) 'í'));
        result = result.replaceAll("Í", "I" + ((int) 'Í'));
        result = result.replaceAll("î", "i" + ((int) 'î'));
        result = result.replaceAll("ó", "o" + ((int) 'ó'));
        result = result.replaceAll("Ó", "O" + ((int) 'Ó'));
        result = result.replaceAll("ô", "o" + ((int) 'ô'));
        result = result.replaceAll("Ô", "O" + ((int) 'Ô'));
        result = result.replaceAll("õ", "o" + ((int) 'õ'));
        result = result.replaceAll("Õ", "O" + ((int) 'Õ'));
        result = result.replaceAll("ú", "u" + ((int) 'ú'));
        result = result.replaceAll("Ú", "U" + ((int) 'Ú'));
        result = result.replaceAll("û", "u" + ((int) 'û'));
        result = result.replaceAll("Û", "U" + ((int) 'Û'));
        result = result.replaceAll("ç", "c" + ((int) 'ç'));
        result = result.replaceAll("Ç", "C" + ((int) 'Ç'));
        // Feito dessa forma pois assim evita que identificadores "média" e 
        //"mêdia" sejam considerados iguais ao gerar código
        if (!result.equals(identificador)) {
            result = "_" + result;
        }
        return result;
    }
    
    public String getInput() {
        return input;
    }

    private int nextState(char c, int state) {
        int start = SCANNER_TABLE_INDEXES[state];
        int end = SCANNER_TABLE_INDEXES[state + 1] - 1;

        while (start <= end) {
            int half = (start + end) / 2;

            if (SCANNER_TABLE[half][0] == c) {
                return SCANNER_TABLE[half][1];
            } else if (SCANNER_TABLE[half][0] < c) {
                start = half + 1;
            } else {//(SCANNER_TABLE[half][0] > c)
                end = half - 1;
            }
        }

        return -1;
    }

    private int tokenForState(int state) {
        if (state < 0 || state >= TOKEN_STATE.length) {
            return -1;
        }

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key) {
        int start = SPECIAL_CASES_INDEXES[base];
        int end = SPECIAL_CASES_INDEXES[base + 1] - 1;

        key = key.toUpperCase();

        while (start <= end) {
            int half = (start + end) / 2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0) {
                return SPECIAL_CASES_VALUES[half];
            } else if (comp < 0) {
                start = half + 1;
            } else {//(comp > 0)
                end = half - 1;
            }
        }

        return base;
    }

    private boolean hasInput() {
        return position < input.length();
    }

    private char nextChar() {
        if (hasInput()) {
            return input.charAt(position++);
        } else {
            return (char) -1;
        }
    }

    public final int getLine(int positionStart) {
        int position = 0;
        int line = 0;
        String[] codigo = input.split("\n");
        for (int i = 0; i < codigo.length; i++) {
            for (int j = 0; j < codigo[i].length(); j++) {
                if (position == positionStart) {
                    line = i + 1;
                    return line;
                }
                ++position;
            }
            ++position;
        }
        return line;
    }
}
