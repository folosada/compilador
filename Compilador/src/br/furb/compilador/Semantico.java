package br.furb.compilador;

import java.util.LinkedList;

public class Semantico implements Constants {

    private LinkedList<String> pilha = new LinkedList();
    private StringBuilder codigo = new StringBuilder();
    private String nomeArquivo = null;
    private String operador = null;

    public Semantico() {
    }

    public Semantico(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public StringBuilder getCodigoGerado() {
        return codigo;
    }

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println(action);
        switch (action) {
            case 1:
                acao01(token);
                break;
            case 2:
                acao02(token);
                break;
            case 3:
                acao03(token);
                break;
            case 4:
                acao04(token);
                break;
            case 5:
                acao05(token);
                break;
            case 6:
                acao06(token);
                break;
            case 7:
                acao07();
                break;
            case 8:
                acao08(token);
                break;
            case 9:
                acao09(token);
                break;
            case 10:
                acao10(token);
                break;
            case 11:
                acao11(token);
                break;
            case 12:
                acao12(token);
                break;
            case 13:
                acao13(token);
                break;
            case 14:
                acao14(token);
                break;
            case 15:
                acao15();
                break;
            case 16:
                acao16();
                break;
            case 17:
                acao17();
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            default:
                break;
        }
    }

    private void acaoOperadores(Token token) throws SemanticError {
        String tipo01 = pilha.pop();
        String tipo02 = pilha.pop();
        if ("float64".equals(tipo01) || "int64".equals(tipo01)
                && ("float64".equals(tipo02) || "int64".equals(tipo02))) {
            if ("float64".equals(tipo01) || "float64".equals(tipo02)) {
                pilha.push("float64");
            } else {
                pilha.push("int64");
            }
        } else {
            throw new SemanticError("Tipos incompatíveis", token.getPosition());
        }
    }

    private void acao01(Token token) throws SemanticError {
        acaoOperadores(token);
        codigo.append("add\n");
    }

    private void acao02(Token token) throws SemanticError {
        acaoOperadores(token);
        codigo.append("sub\n");
    }

    private void acao03(Token token) throws SemanticError {
        acaoOperadores(token);
        codigo.append("mul\n");
    }

    private void acao04(Token token) throws SemanticError {
        acaoOperadores(token);
        codigo.append("div\n");
    }

    private void acao05(Token token) {
        pilha.push("int64");
        codigo.append("ldc.i8 ").append(token.getLexeme()).append("\n");
    }

    private void acao06(Token token) {
        pilha.push("float64");
        codigo.append("ldc.i8 ").append(token.getLexeme()).append("\n");
    }

    private void acao07() {
        String tipo = pilha.pop();
        codigo.append("call void [mscorlib]System.Console::Write(").append(tipo).append(")\n");
    }

    private void acao08(Token token) throws SemanticError {
        String tipo = pilha.pop();
        if ("float64".equals(tipo) || "int64".equals(tipo)) {
            pilha.push(tipo);
        } else {
            throw new SemanticError("Tipo incompatível em operação unária", token.getPosition());
        }
    }

    private void acao09(Token token) throws SemanticError {
        String tipo = pilha.pop();
        if ("float64".equals(tipo) || "int64".equals(tipo)) {
            pilha.push(tipo);
            codigo.append("ldc.i8 -1\n");
            codigo.append("mul\n");
        } else {
            throw new SemanticError("Tipo incompatível em operação unária", token.getPosition());
        }
    }

    private void acao10(Token token) throws SemanticError {
        String tipo01 = pilha.pop();
        String tipo02 = pilha.pop();
        if (tipo01.equals(tipo02)) {
            pilha.push("bool");
        } else {
            throw new SemanticError("Tipo incompatível em expressão relacional", token.getPosition());
        }
        switch (operador) {
            case "=":
                codigo.append("ceq\n");
                break;
            case ">":
                codigo.append("cgt\n");
                break;
            case "<":
                codigo.append("clt\n");
                break;
        }
    }

    private void acao11(Token token) {
        operador = token.getLexeme();
    }

    private void acao12(Token token) {
        pilha.push("bool");
        codigo.append("ldc.i4.1\n");
    }

    private void acao13(Token token) {
        pilha.push("bool");
        codigo.append("ldc.i4.0\n");
    }

    private void acao14(Token token) throws SemanticError {
        String tipo = pilha.pop();
        if ("bool".equals(tipo)) {
            pilha.push(tipo);
        } else {
            throw new SemanticError("Tipo incompatível em operação 'não'", token.getPosition());
        }
        codigo.append("ldc.i4.1\n");
        codigo.append("xor\n");
    }

    private void acao15() {
        String filename = "";
        codigo.append(".assembly extern mscorlib {}\n")
                .append(" .assembly ")
                .append(nomeArquivo)
                .append("{}\n")
                .append(" .module ")
                .append(nomeArquivo)
                .append(".exe\n")
                .append(" .class public _Principal{\n")
                .append(" .method static public void _principal()\n")
                .append(" { .entrypoint\n");
    }

    private void acao16() {
        codigo.append("ret\n }\n");
    }

    private void acao17() {
        codigo.append("}\n");
    }
}
