package br.furb.compilador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author usuario
 */
public class Compilador {

    public static String gerarCodigo(String codigoFonte, String caminhoArquivo) {
        try {            
            String nomeArquivo = Paths.get(caminhoArquivo).getFileName().toString();
            nomeArquivo = nomeArquivo.split(".txt$")[0];
            String diretorio = Paths.get(caminhoArquivo).getParent().toString();
            nomeArquivo = nomeArquivo.replace(' ', '_');
            Sintatico sintatico = new Sintatico();
            Lexico lexico = new Lexico();
            lexico.setInput(codigoFonte);
            Semantico semantico = new Semantico(nomeArquivo);
            sintatico.parse(lexico, semantico);

            StringBuilder codigoGerado = semantico.getCodigoGerado();

            BufferedWriter bw = new BufferedWriter(new FileWriter(diretorio + "\\" + nomeArquivo + ".il"));

            bw.write(codigoGerado.toString());

            bw.flush();
            bw.close();

        } catch (LexicalError | SyntaticError | SemanticError le) {
            return le.getMessage();
        } catch (IOException ie) {
            return "Problema ao gerar código!\n" + ie.getMessage();
        }
        return "Código objeto gerado com sucesso!";
    }

    public static String compilar(String codigoFonte) {
        try {
            Sintatico sintatico = new Sintatico();
            Lexico lexico = new Lexico();
            lexico.setInput(codigoFonte);
            Semantico semantico = new Semantico();
            sintatico.parse(lexico, semantico);
        } catch (LexicalError | SyntaticError | SemanticError le) {
            return le.getMessage();
        }
        return "Programa compilado com sucesso!";
    }

    private static String analiseLexica(String codigoFonte) throws LexicalError {
        Lexico lexico = new Lexico();
        lexico.setInput(codigoFonte);
        Token t = null;
        StringBuilder tabela = new StringBuilder();
        while ((t = lexico.nextToken()) != null) {
            tabela.append("Linha ").append(t.getLine()).append(" - ").
                    append(t.getClassToken()).append(": ").append(t.getLexeme()).append("\n");
        }
        return tabela.toString();
    }
}
