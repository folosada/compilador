package br.furb.compilador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Semantico implements Constants {

    private LinkedList<String> pilhaTipos = new LinkedList();
    private LinkedList<String> listaIdentificadores = new LinkedList();
    private ArrayList<String> listaMetodos = new ArrayList();
    private HashMap<String, String> tabelaSimbolosGlobal = new HashMap();
    private HashMap<String, HashMap<String, String>> tabelaSimbolosAuxiliar = new HashMap();
    private HashMap<String, HashMap<String, String>> tabelaParametros = new HashMap();
    private String tipoGlobal;
    private StringBuilder codigo = new StringBuilder();
    private String nomeArquivo = null;
    private String operador = null;
    private LinkedList<String> pilhaContexto = new LinkedList();
    private LinkedList<String> pilhaRotulos = new LinkedList();
    private int labelCount = 0;
    
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
                acao18();
                break;
            case 19:
                acao19(token);
                break;
            case 20:
                acao20(token);
                break;
            case 21:
                acao21(token);
                break;
            case 22:
                acao22(token);
                break;
            case 23:
                acao23(token);
                break;
            case 24:
                acao24(token);
                break;
            case 25:
                acao25(token);
                break;
            case 26:
                acao26(token);
                break;
            case 27:
                acao27(token);
                break;
            case 28:
                acao28(token);
                break;
            case 29:
                acao29(token);
                break;
            case 30:
                acao30(token);
                break;
            case 31:
                acao31(token);
                break;
            case 32:
                acao32(token);
                break;
            case 33:
                acao33(token);
                break;
            case 34:
                acao34(token);
                break;
            case 35:
                acao35(token);
                break;
            case 36:
                acao36(token);
                break;
            case 37:
                acao37(token);
                break;
            case 38:
                acao38(token);
                break;
            case 39:
                acao39(token);
                break;
            default:
                break;
        }
    }

    private void acaoOperadores(Token token) throws SemanticError {
        String tipo01 = pilhaTipos.pop();
        String tipo02 = pilhaTipos.pop();
        if ("float64".equals(tipo01) || "int64".equals(tipo01)
                && ("float64".equals(tipo02) || "int64".equals(tipo02))) {
            if ("float64".equals(tipo01) || "float64".equals(tipo02)) {
                pilhaTipos.push("float64");
            } else {
                pilhaTipos.push("int64");
            }
        } else {
            throw new SemanticError("Tipo incompatível em operação aritmética binária", token.getPosition(), token.getLine());
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
        pilhaTipos.push("int64");
        codigo.append("ldc.i8 ").append(token.getLexeme()).append("\n");
    }

    private void acao06(Token token) {
        pilhaTipos.push("float64");
        codigo.append("ldc.r8 ").append(token.getLexeme()).append("\n");
    }

    private void acao07() {
        String tipo = pilhaTipos.pop();
        codigo.append("call void [mscorlib]System.Console::Write(").append(tipo).append(")\n");
    }

    private void acao08(Token token) throws SemanticError {
        String tipo = pilhaTipos.pop();
        if ("float64".equals(tipo) || "int64".equals(tipo)) {
            pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("Tipo incompatível em operação aritmética unária", token.getPosition(), token.getLine());
        }
    }

    private void acao09(Token token) throws SemanticError {
        String tipo = pilhaTipos.pop();
        if ("float64".equals(tipo) || "int64".equals(tipo)) {
            pilhaTipos.push(tipo);
            codigo.append("ldc.i8 -1\n");
            codigo.append("mul\n");
        } else {
            throw new SemanticError("Tipo incompatível em operação aritmética unária", token.getPosition(), token.getLine());
        }
    }

    private void acao10(Token token) throws SemanticError {
        String tipo01 = pilhaTipos.pop();
        String tipo02 = pilhaTipos.pop();
        if (tipo01.equals("float64") && tipo02.equals("int64")
                || tipo01.equals("int64") && tipo02.equals("float64")
                || tipo01.equals("float64") && tipo02.equals("float64")
                || tipo01.equals("int64") && tipo02.equals("int64")
                || tipo01.equals("string") && tipo02.equals("string")) {
            pilhaTipos.push("bool");
        } else {
            throw new SemanticError("Tipo incompatível em operação relacional", token.getPosition(), token.getLine());
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
            case "<>":
                codigo.append("ceq\n");
                codigo.append("xor\n");
                break;
            case "<=":
                codigo.append("cgt\n");
                codigo.append("xor\n");
                break;
            case ">=":
                codigo.append("clt\n");
                codigo.append("xor\n");
                break;
        }
    }

    private void acao11(Token token) {
        operador = token.getLexeme();
    }

    private void acao12(Token token) {
        pilhaTipos.push("bool");
        codigo.append("ldc.i4.1\n");
    }

    private void acao13(Token token) {
        pilhaTipos.push("bool");
        codigo.append("ldc.i4.0\n");
    }

    private void acao14(Token token) throws SemanticError {
        String tipo = pilhaTipos.pop();
        if ("bool".equals(tipo)) {
            pilhaTipos.push(tipo);
            codigo.append("ldc.i4.1\n");
            codigo.append("xor\n");
        } else {
            throw new SemanticError("Tipo incompatível em operação lógica unária", token.getPosition(), token.getLine());
        }
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
        pilhaContexto.push("global");
    }

    private void acao16() {
        codigo.append("ret\n }\n");
        pilhaContexto.pop();
    }

    private void acao17() {
        codigo.append("}\n");
    }

    private void acao18() {
        pilhaTipos.push("string");
        codigo.append("ldstr \"\\n\"\n");
    }

    private void acao19(Token token) throws SemanticError {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        if ("bool".equals(tipo1) && "bool".equals(tipo2)) {
            pilhaTipos.push("bool");
            codigo.append("and\n");
        } else {
            throw new SemanticError("Tipo incompatível em operação lógica binária", token.getPosition(), token.getLine());
        }
    }

    private void acao20(Token token) throws SemanticError {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        if ("bool".equals(tipo1) && "bool".equals(tipo2)) {
            pilhaTipos.push("bool");
            codigo.append("or\n");
        } else {
            throw new SemanticError("Tipo incompatível em operação lógica binária", token.getPosition(), token.getLine());
        }
    }

    private void acao21(Token token) throws SemanticError {
        pilhaTipos.push("string");
        codigo.append("ldstr ").append(token.getLexeme()).append("\n");
    }

    private void acao22(Token token) throws SemanticError {
        tipoGlobal = token.getLexeme();
    }

    private void acao23(Token token) throws SemanticError {
        listaIdentificadores.add(token.getLexeme());
    }

    private void acao24(Token token) throws SemanticError {
        switch (tipoGlobal) {
            case "inteiro":
                tipoGlobal = "int64";
                break;
            case "lógico":
                tipoGlobal = "bool";
                break;
            case "caracter":
                tipoGlobal = "string";
                break;
            case "real":
                tipoGlobal = "float64";
                break;
        }
        for (String identificador : listaIdentificadores) {
            if (pilhaContexto.peek().equals("global")) {
                if (tabelaSimbolosGlobal.containsKey(identificador)) {
                    throw new SemanticError("Identificador já declarado -> " + identificador, token.getPosition(), token.getLine());
                }
                tabelaSimbolosGlobal.put(identificador, tipoGlobal);
            } else {
                HashMap<String, String> parametrosContexto = tabelaParametros.get(pilhaContexto.peek());
                HashMap<String, String> variaveisContexto = tabelaSimbolosAuxiliar.get(pilhaContexto.peek());

                if (parametrosContexto == null || !parametrosContexto.containsKey(identificador)
                        && variaveisContexto == null || !variaveisContexto.containsKey(identificador)
                        && !listaMetodos.contains(identificador)) {

                    if (variaveisContexto == null) {
                        variaveisContexto = new HashMap();
                        variaveisContexto.put(identificador, tipoGlobal);
                        tabelaSimbolosAuxiliar.put(pilhaContexto.peek(), variaveisContexto);
                    } else {
                        variaveisContexto.put(identificador, tipoGlobal);
                    }
                } else {
                    throw new SemanticError("Identificador já declarado -> " + identificador, token.getPosition(), token.getLine());
                }
            }
            codigo.append(".locals(").append(tipoGlobal).append(" ").append(identificador).append(")\n");
        }
        listaIdentificadores.clear();
    }

    private void acao25(Token token) throws SemanticError {
        String tipo;
        for (String identificador : listaIdentificadores) {
            if (pilhaContexto.peek().equals("global")) {
                if (!tabelaSimbolosGlobal.containsKey(identificador)) {
                    throw new SemanticError("Identificador não declarado -> " + token.getLexeme(), token.getPosition(), token.getLine());
                }
                tipo = tabelaSimbolosGlobal.get(identificador);
            } else {
                HashMap<String, String> parametrosContexto = tabelaParametros.get(pilhaContexto.peek());
                HashMap<String, String> variaveisContexto = tabelaSimbolosAuxiliar.get(pilhaContexto.peek());
                if ((parametrosContexto == null || !parametrosContexto.containsKey(identificador))
                        && (variaveisContexto == null || !variaveisContexto.containsKey(identificador))) {
                    throw new SemanticError("Identificador não declarado -> " + token.getLexeme(), token.getPosition(), token.getLine());
                }
                tipo = parametrosContexto.get(identificador) == null ? variaveisContexto.get(identificador) : parametrosContexto.get(identificador);
            }
            
            codigo.append("call string [mscorlib]System.Console::ReadLine()\n");
            if (!tipo.equals("string")) {
                codigo.append("call ")
                        .append(tipo)
                        .append(" [mscorlib]System.")
                        .append(tipo.equals("int64") ? "Int64" : tipo.equals("float64") ? "Double" : "Boolean")
                        .append("::Parse(string)\n");
            }
            codigo.append("stloc ").append(identificador).append("\n");
        }
        listaIdentificadores.clear();
    }

    private void acao26(Token token) throws SemanticError {
        String identificador = listaIdentificadores.removeLast();
        String tipo;
        if (pilhaContexto.peek().equals("global")) {
            if (!tabelaSimbolosGlobal.containsKey(identificador)) {
                throw new SemanticError("Identificador não declarado -> " + identificador, token.getPosition(), token.getLine());
            }
            tipo = tabelaSimbolosGlobal.get(identificador);
            pilhaTipos.push(tipo);
            codigo.append("ldloc ").append(identificador).append("\n");
        } else {
            HashMap<String, String> parametrosContexto = tabelaParametros.get(pilhaContexto.peek());
            HashMap<String, String> variaveisContexto = tabelaSimbolosAuxiliar.get(pilhaContexto.peek());
            if (parametrosContexto != null && parametrosContexto.containsKey(identificador)) {
                tipo = parametrosContexto.get(identificador);
                pilhaTipos.push(tipo);
                codigo.append("ldarg ").append(identificador).append("\n");
            } else {
                if (variaveisContexto != null && variaveisContexto.containsKey(identificador)) {
                    tipo = variaveisContexto.get(identificador);
                    pilhaTipos.push(tipo);
                    codigo.append("ldloc ").append(identificador).append("\n");
                } else {
                    throw new SemanticError("Identificador não declarado -> " + identificador, token.getPosition(), token.getLine());
                }
            }
        }        
    }

    private void acao27(Token token) throws SemanticError {
        String identificador = listaIdentificadores.removeLast();
        String tipo;
        if (pilhaContexto.peek().equals("global")) {
            if (!tabelaSimbolosGlobal.containsKey(identificador)) {
                throw new SemanticError("Identificador não declarado -> " + identificador, token.getPosition(), token.getLine());
            }
            tipo = tabelaSimbolosGlobal.get(identificador);
        } else {
            HashMap<String, String> parametrosContexto = tabelaParametros.get(pilhaContexto.peek());
            HashMap<String, String> variaveisContexto = tabelaSimbolosAuxiliar.get(pilhaContexto.peek());
            
            if (parametrosContexto != null && parametrosContexto.containsKey(identificador)) {
                tipo = parametrosContexto.get(identificador);
            } else {
                if (variaveisContexto != null && variaveisContexto.containsKey(identificador)) {
                    tipo = variaveisContexto.get(identificador);
                } else {
                    throw new SemanticError("Identificador não declarado -> " + identificador, token.getPosition(), token.getLine());
                }
            }
        }
        String tipoExp = pilhaTipos.pop();
        if (!tipo.equals(tipoExp)) {
            throw new SemanticError("Tipos incompatíveis em comando de atribuição", token.getPosition(), token.getLine());
        }
        codigo.append("stloc ").append(identificador).append("\n");
    }
    
    private void acao28(Token token) throws SemanticError {
        codigo.append("brfalse label").append(labelCount).append("\n");
        pilhaRotulos.push("label" + labelCount);
        labelCount++;
    }
    
    private void acao29(Token token) throws SemanticError {
        codigo.append(pilhaRotulos.pop()).append(":\n");
    }
    
    private void acao30(Token token) throws SemanticError {
        codigo.append("br label").append(labelCount).append("\n").append(pilhaRotulos.pop()).append(":\n");
        pilhaRotulos.push("label" + labelCount);
        labelCount++;
    }
    
    private void acao31(Token token) throws SemanticError {
        codigo.append("label").append(labelCount).append(":\n");
        pilhaRotulos.push("label" + labelCount);
        labelCount++;
    }

    private void acao32(Token token) throws SemanticError {
        codigo.append("brfalse ").append(pilhaRotulos.pop()).append("\n");
    }
    
    private void acao33(Token token) throws SemanticError {
        if (tabelaSimbolosGlobal.containsKey(token.getLexeme())) {
            throw new SemanticError("Identificador já declarado -> " + token.getLexeme(), token.getPosition(), token.getLine());
        }
        tabelaSimbolosGlobal.put(token.getLexeme(), "");
        tabelaParametros.put(token.getLexeme(), new HashMap());
        pilhaContexto.push(token.getLexeme());
        listaMetodos.add(token.getLexeme());
    }

    private void acao34(Token token) throws SemanticError {
        switch (tipoGlobal) {
            case "inteiro":
                tipoGlobal = "int64";
                break;
            case "lógico":
                tipoGlobal = "bool";
                break;
            case "caracter":
                tipoGlobal = "string";
                break;
            case "real":
                tipoGlobal = "float64";
                break;
        }
        tabelaSimbolosGlobal.put(pilhaContexto.pop(), tipoGlobal);
    }

    private void acao35(Token token) throws SemanticError {
        tabelaSimbolosGlobal.put(pilhaContexto.pop(), "void");
    }
    
    private void acao36(Token token) throws SemanticError {
        HashMap parametrosContexto;
        if ((parametrosContexto = tabelaParametros.get(pilhaContexto.peek())) != null) {
            switch (tipoGlobal) {
                case "inteiro":
                    tipoGlobal = "int64";
                    break;
                case "lógico":
                    tipoGlobal = "bool";
                    break;
                case "caracter":
                    tipoGlobal = "string";
                    break;
                case "real":
                    tipoGlobal = "float64";
                    break;
            }
            for (String identificador : listaIdentificadores) {
                if (parametrosContexto.containsKey(identificador)) {
                    throw new SemanticError("Identificador já declarado -> " + identificador, token.getPosition(), token.getLine());
                }
                if (listaMetodos.contains(identificador)) {
                    throw new SemanticError("Identificador já declarado -> " + identificador, token.getPosition(), token.getLine());
                }
                parametrosContexto.put(identificador, tipoGlobal);
            }
            listaIdentificadores.clear();
        }
    }

    private void acao37(Token token) throws SemanticError {
        pilhaContexto.push(token.getLexeme());
        if (!tabelaSimbolosGlobal.containsKey(token.getLexeme())) {
            throw new SemanticError("Idetificador não declarado -> " + token.getLexeme(), token.getPosition(), token.getLine());
        }

        String tipo = tabelaSimbolosGlobal.get(token.getLexeme());
        codigo.append(".method public static ").append(tipo).append(" _").append(token.getLexeme()).append("(");
        HashMap<String, String> parametrosContexto;
        if ((parametrosContexto = tabelaParametros.get(pilhaContexto.peek())) != null) {
            if (parametrosContexto.size() > 0) {
                for (Map.Entry<String, String> parametro : parametrosContexto.entrySet()) {
                    String param = parametro.getKey();
                    String tipoParam = parametro.getValue();
                    codigo.append(tipoParam).append(" ").append(param).append(", ");
                }
                codigo.delete(codigo.length() - 2, codigo.length());
            }
        }
        codigo.append(") {\n");
    }
    
    private void acao38(Token token) throws SemanticError {
        String identificador = listaIdentificadores.removeLast();
        if (!tabelaSimbolosGlobal.containsKey(identificador)) {
            throw new SemanticError("Identificador não declarado -> " + identificador, token.getPosition(), token.getLine());
        }
        codigo.append("call void _Principal::_").append(identificador).append("(");
        HashMap<String, String> parametrosContexto;
        if ((parametrosContexto = tabelaParametros.get(identificador)) != null) {
            if (parametrosContexto.size() > 0) {
                for (Map.Entry<String, String> parametro : parametrosContexto.entrySet()) {
                    String tipoParam = parametro.getValue();
                    codigo.append(tipoParam).append(", ");
                }
                codigo.delete(codigo.length() - 2, codigo.length());
            }
        }
        codigo.append(")\n");
    }
    
    private void acao39(Token token) throws SemanticError {
        String identificador = listaIdentificadores.removeLast();
        if (!tabelaSimbolosGlobal.containsKey(identificador)) {
            throw new SemanticError("Identificador não declarado -> " + identificador, token.getPosition(), token.getLine());
        }
        String tipo = tabelaSimbolosGlobal.get(identificador);
        codigo.append("call ").append(tipo).append(" _Principal::_").append(identificador).append("(");
        HashMap<String, String> parametrosContexto;
        if ((parametrosContexto = tabelaParametros.get(identificador)) != null) {
            if (parametrosContexto.size() > 0) {
                for (Map.Entry<String, String> parametro : parametrosContexto.entrySet()) {
                    String tipoParam = parametro.getValue();
                    codigo.append(tipoParam).append(", ");
                }
                codigo.delete(codigo.length() - 2, codigo.length());
            }
        }
        codigo.append(")\n");
        //listaIdentificadores.add(identificador);
    }
}
