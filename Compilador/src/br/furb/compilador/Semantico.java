package br.furb.compilador;

import java.util.Stack;

public class Semantico implements Constants {

    private Stack<String> pilha = new Stack();
    private StringBuilder codigo = new StringBuilder();
    private String nomeArquivo = null;

    
    public Semantico() {
    }
    public Semantico(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
    public StringBuilder getCodigoGerado() {
        return codigo;
    }
    
    public void executeAction(int action, Token token) throws SemanticError {

        switch (action) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
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
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
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
