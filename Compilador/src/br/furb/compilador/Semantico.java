package br.furb.compilador;

import java.util.Stack;

public class Semantico implements Constants {

    Stack pilha = new Stack();
    StringBuffer Codigo = new StringBuffer();

    public void executeAction(int action, Token token) throws SemanticError {

//        switch (action) {
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                pilha.push("int64");
//                Codigo.append("ldc.i8 " + token.getLexeme());
//                break;
//            case 6:
//                pilha.push("float64");
//                Codigo.append("ldc.i8 " + token.getLexeme());
//                break;
//            case 7:
//                char tipo = (char) pilha.pop();
//                Codigo.append("call void [mscorlib]System.Console::Write(" + tipo + ")");
//                break;
//            case 8:
//                break;
//            case 9:
//                break;
//            case 10:
//                break;
//            case 11:
//                break;
//            case 12:
//                break;
//            case 13:
//                break;
//            case 14:
//                break;
//            case 15:
//                String filename = "";
//                Codigo.append(".assembly extern mscorlib {}\n"
//                        + " .assembly " + filename + "{}\n"
//                        + " .module " + filename + ".exe\n"
//                        + " .class public _Principal{\n"
//                        + " .method static public void _principal()\n"
//                        + " { .entrypoint\n"
//                        + " )");
//                break;
//            case 16:
//                Codigo.append("ret\n"
//                        + " }");
//                break;
//            case 17:
//                Codigo.append("}");
//                break;
//            case 18:
//                break;
//            case 19:
//                break;
//            case 20:
//                break;
//            case 21:
//                break;
//            default:
//                break;
//        }
    }
}
