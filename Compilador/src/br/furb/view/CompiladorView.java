/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.view;

import br.furb.compilador.Compilador;
import br.furb.compilador.LexicalError;
import br.furb.lib.NumberedBorder;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author flavioomar
 */
public class CompiladorView extends javax.swing.JFrame {
    
    private String caminhoArquivo;
    
    /**
     * Creates new form CompiladorView
     */
    public CompiladorView() {
        initComponents();
        this.editorTA.setBorder(new NumberedBorder());
        this.setSize(914, 627);
        this.editorTA.addKeyListener(new TextAreaListener());
        this.caminhoArquivo = null;
        
        //Atalho do botão novo
        jBNovo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK), "evento");
        jBNovo.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBNovo.doClick();
            }
        });

        //Atalho do botão abrir
        jBAbrir.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK), "evento");
        jBAbrir.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBAbrir.doClick();
            }
        });

        //Atalho do botão salvar
        jBSalvar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "evento");
        jBSalvar.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBSalvar.doClick();
            }
        });

        //Atalho do botão copiar
        jBCopiar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK), "evento");
        jBCopiar.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBCopiar.doClick();
            }
        });

        //Atalho do botão colar
        jBColar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK), "evento");
        jBColar.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBColar.doClick();
            }
        });

        //Atalho do botão recortar
        jBRecortar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK), "evento");
        jBRecortar.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBRecortar.doClick();
            }
        });

        //Atalho do botão compilar
        jBCompilar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "evento");
        jBCompilar.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBCompilar.doClick();
            }
        });

        //Atalho do botão gerar código
        jBGerCod.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "evento");
        jBGerCod.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBGerCod.doClick();
            }
        });

        //Atalho do botão equipe
        jBEquipe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "evento");
        jBEquipe.getActionMap().put("evento", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBEquipe.doClick();
            }
        });

    }

    class TextAreaListener implements KeyListener {

        public TextAreaListener() {
        }

        @Override
        public void keyTyped(java.awt.event.KeyEvent ke) {
            statusJL.setText("Modificado");
        }

        @Override
        public void keyPressed(java.awt.event.KeyEvent ke) {
            statusJL.setText("Modificado");
        }

        @Override
        public void keyReleased(java.awt.event.KeyEvent ke) {
            statusJL.setText("Modificado");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        principalJP = new javax.swing.JPanel();
        toolBarJP = new javax.swing.JPanel();
        barraFerramentaTB = new javax.swing.JToolBar();
        jBNovo = new javax.swing.JButton();
        jBAbrir = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jBCopiar = new javax.swing.JButton();
        jBColar = new javax.swing.JButton();
        jBRecortar = new javax.swing.JButton();
        jBCompilar = new javax.swing.JButton();
        jBGerCod = new javax.swing.JButton();
        jBEquipe = new javax.swing.JButton();
        editorJP = new javax.swing.JPanel();
        editorJSP = new javax.swing.JScrollPane();
        editorTA = new javax.swing.JTextArea();
        mensagemJP = new javax.swing.JPanel();
        mensagemJSP = new javax.swing.JScrollPane();
        mensagemTA = new javax.swing.JTextArea();
        statusJP = new javax.swing.JPanel();
        statusJL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(914, 627));
        setSize(new java.awt.Dimension(914, 627));

        principalJP.setLayout(new java.awt.GridBagLayout());

        toolBarJP.setMinimumSize(new java.awt.Dimension(144, 544));
        toolBarJP.setPreferredSize(new java.awt.Dimension(144, 544));
        toolBarJP.setLayout(new java.awt.BorderLayout());

        barraFerramentaTB.setFloatable(false);
        barraFerramentaTB.setOrientation(javax.swing.SwingConstants.VERTICAL);
        barraFerramentaTB.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        barraFerramentaTB.setMinimumSize(new java.awt.Dimension(144, 544));
        barraFerramentaTB.setPreferredSize(new java.awt.Dimension(144, 544));

        jBNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/text-document.png"))); // NOI18N
        jBNovo.setText("novo [ctrl-n]");
        jBNovo.setFocusable(false);
        jBNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBNovo.setMaximumSize(new java.awt.Dimension(145, 62));
        jBNovo.setMinimumSize(new java.awt.Dimension(145, 62));
        jBNovo.setPreferredSize(new java.awt.Dimension(145, 62));
        jBNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBNovo);

        jBAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/file-in-folder.png"))); // NOI18N
        jBAbrir.setText("abrir [ctrl-o]");
        jBAbrir.setFocusable(false);
        jBAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAbrir.setMaximumSize(new java.awt.Dimension(145, 62));
        jBAbrir.setMinimumSize(new java.awt.Dimension(145, 62));
        jBAbrir.setPreferredSize(new java.awt.Dimension(145, 62));
        jBAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBAbrir);

        jBSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/diskette.png"))); // NOI18N
        jBSalvar.setText("salvar [ctrl-s]");
        jBSalvar.setToolTipText("");
        jBSalvar.setFocusable(false);
        jBSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBSalvar.setMaximumSize(new java.awt.Dimension(145, 62));
        jBSalvar.setMinimumSize(new java.awt.Dimension(145, 62));
        jBSalvar.setPreferredSize(new java.awt.Dimension(145, 62));
        jBSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBSalvar);

        jBCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/text-documents.png"))); // NOI18N
        jBCopiar.setText("copiar [ctrl-c]");
        jBCopiar.setFocusable(false);
        jBCopiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBCopiar.setMaximumSize(new java.awt.Dimension(145, 62));
        jBCopiar.setMinimumSize(new java.awt.Dimension(145, 62));
        jBCopiar.setPreferredSize(new java.awt.Dimension(145, 62));
        jBCopiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCopiarActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBCopiar);

        jBColar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/paste-file.png"))); // NOI18N
        jBColar.setText("colar [ctrl-v]");
        jBColar.setFocusable(false);
        jBColar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBColar.setMaximumSize(new java.awt.Dimension(145, 62));
        jBColar.setMinimumSize(new java.awt.Dimension(145, 62));
        jBColar.setPreferredSize(new java.awt.Dimension(145, 62));
        jBColar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBColar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBColarActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBColar);

        jBRecortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/icon.png"))); // NOI18N
        jBRecortar.setText("recortar [ctrl-x]");
        jBRecortar.setFocusable(false);
        jBRecortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBRecortar.setMaximumSize(new java.awt.Dimension(145, 62));
        jBRecortar.setMinimumSize(new java.awt.Dimension(145, 62));
        jBRecortar.setPreferredSize(new java.awt.Dimension(145, 62));
        jBRecortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRecortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRecortarActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBRecortar);

        jBCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/music-player-play.png"))); // NOI18N
        jBCompilar.setText("compilar [F8]");
        jBCompilar.setFocusable(false);
        jBCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBCompilar.setMaximumSize(new java.awt.Dimension(145, 62));
        jBCompilar.setMinimumSize(new java.awt.Dimension(145, 62));
        jBCompilar.setPreferredSize(new java.awt.Dimension(145, 62));
        jBCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCompilarActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBCompilar);

        jBGerCod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/handyman-tools.png"))); // NOI18N
        jBGerCod.setText("gerar código [F9]");
        jBGerCod.setFocusable(false);
        jBGerCod.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBGerCod.setMaximumSize(new java.awt.Dimension(145, 62));
        jBGerCod.setMinimumSize(new java.awt.Dimension(145, 62));
        jBGerCod.setPreferredSize(new java.awt.Dimension(145, 62));
        jBGerCod.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBGerCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGerCodActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBGerCod);

        jBEquipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/imgs/team.png"))); // NOI18N
        jBEquipe.setText("equipe [F1]");
        jBEquipe.setFocusable(false);
        jBEquipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBEquipe.setMaximumSize(new java.awt.Dimension(145, 62));
        jBEquipe.setMinimumSize(new java.awt.Dimension(145, 62));
        jBEquipe.setPreferredSize(new java.awt.Dimension(145, 62));
        jBEquipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEquipeActionPerformed(evt);
            }
        });
        barraFerramentaTB.add(jBEquipe);

        toolBarJP.add(barraFerramentaTB, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 0.88;
        principalJP.add(toolBarJP, gridBagConstraints);

        editorJP.setMinimumSize(new java.awt.Dimension(750, 480));
        editorJP.setPreferredSize(new java.awt.Dimension(750, 480));
        editorJP.setLayout(new java.awt.BorderLayout());

        editorJSP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        editorJSP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        editorJSP.setMinimumSize(new java.awt.Dimension(750, 480));
        editorJSP.setPreferredSize(new java.awt.Dimension(750, 480));

        editorTA.setColumns(20);
        editorTA.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        editorTA.setRows(5);
        editorJSP.setViewportView(editorTA);

        editorJP.add(editorJSP, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.83;
        gridBagConstraints.weighty = 0.77;
        principalJP.add(editorJP, gridBagConstraints);

        mensagemJP.setMinimumSize(new java.awt.Dimension(750, 90));
        mensagemJP.setPreferredSize(new java.awt.Dimension(750, 90));
        mensagemJP.setLayout(new java.awt.BorderLayout());

        mensagemJSP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mensagemJSP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mensagemJSP.setMinimumSize(new java.awt.Dimension(750, 90));
        mensagemJSP.setPreferredSize(new java.awt.Dimension(750, 90));

        mensagemTA.setEditable(false);
        mensagemTA.setColumns(20);
        mensagemTA.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        mensagemTA.setRows(5);
        mensagemJSP.setViewportView(mensagemTA);

        mensagemJP.add(mensagemJSP, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.83;
        gridBagConstraints.weighty = 0.14;
        principalJP.add(mensagemJP, gridBagConstraints);

        statusJP.setMinimumSize(new java.awt.Dimension(900, 25));
        statusJP.setPreferredSize(new java.awt.Dimension(900, 25));
        statusJP.setLayout(new java.awt.BorderLayout());

        statusJL.setText("Não modificado");
        statusJL.setMinimumSize(new java.awt.Dimension(900, 25));
        statusJL.setPreferredSize(new java.awt.Dimension(900, 25));
        statusJP.add(statusJL, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.04;
        principalJP.add(statusJP, gridBagConstraints);

        getContentPane().add(principalJP, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jBEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEquipeActionPerformed
        mensagemTA.setText("Equipe: Flávio Omar Losada, Gabriel da Silva Bernardi, Matheus Waltrich Da Silva");
    }//GEN-LAST:event_jBEquipeActionPerformed

    private void jBCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCompilarActionPerformed
        mensagemTA.setText(Compilador.compilar(editorTA.getText()).trim());
    }//GEN-LAST:event_jBCompilarActionPerformed

    private void jBGerCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGerCodActionPerformed
        mensagemTA.setText("geração de código ainda não foi implementada.");
    }//GEN-LAST:event_jBGerCodActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        editorTA.setText("");
        mensagemTA.setText("");
        statusJL.setText("Não modificado");
        this.caminhoArquivo = null;
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCopiarActionPerformed
        editorTA.copy();
    }//GEN-LAST:event_jBCopiarActionPerformed

    private void jBColarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBColarActionPerformed
        editorTA.paste();
    }//GEN-LAST:event_jBColarActionPerformed

    private void jBRecortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRecortarActionPerformed
        editorTA.cut();
    }//GEN-LAST:event_jBRecortarActionPerformed

    private void jBAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirActionPerformed
        JFileChooser abreArquivo = new JFileChooser();
        abreArquivo.setFileFilter(new ExtensionFileFilter());
        abreArquivo.setAcceptAllFileFilterUsed(false);
        abreArquivo.setDialogType(JFileChooser.OPEN_DIALOG);
        if (abreArquivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File arquivo = abreArquivo.getSelectedFile();
            this.caminhoArquivo = abreArquivo.getSelectedFile().toString();
            try {
                BufferedReader bf = new BufferedReader(new FileReader(arquivo));
                StringBuilder conteudoArquivo = new StringBuilder();
                String linha = bf.readLine();
                while (linha != null) {
                    conteudoArquivo.append(linha).append("\n");
                    linha = bf.readLine();
                }
                editorTA.setText(conteudoArquivo.toString());
                bf.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Não foi possível encontrar o arquivo selecionado.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Houve um problema ao tentar abrir o arquivo.");
            }
        }
    }//GEN-LAST:event_jBAbrirActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        JFileChooser salvaArquivo = new JFileChooser();
        salvaArquivo.setFileFilter(new ExtensionFileFilter());
        salvaArquivo.setAcceptAllFileFilterUsed(false);
        salvaArquivo.setDialogType(JFileChooser.SAVE_DIALOG);
        File arquivo = null;
        
        boolean caminhoSelecionado = true;
        
        if (this.caminhoArquivo == null) {
            caminhoSelecionado = salvaArquivo.showSaveDialog(this) == JFileChooser.APPROVE_OPTION;
            if (caminhoSelecionado) {
                arquivo = salvaArquivo.getSelectedFile();
                arquivo = new File(arquivo.getAbsolutePath() + ".txt");
            }
        } else {
            arquivo = new File(this.caminhoArquivo);
        }
        
        try {
            if (caminhoSelecionado) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
                bw.write(editorTA.getText().replace("\n", "\r\n"));
                bw.flush();
                bw.close();
                this.caminhoArquivo = arquivo.toString();
                statusJL.setText("Não modificado.");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível encontrar o arquivo selecionado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Houve um problema ao tentar abrir o arquivo.");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompiladorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompiladorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompiladorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompiladorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompiladorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraFerramentaTB;
    private javax.swing.JPanel editorJP;
    private javax.swing.JScrollPane editorJSP;
    private javax.swing.JTextArea editorTA;
    private javax.swing.JButton jBAbrir;
    private javax.swing.JButton jBColar;
    private javax.swing.JButton jBCompilar;
    private javax.swing.JButton jBCopiar;
    private javax.swing.JButton jBEquipe;
    private javax.swing.JButton jBGerCod;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBRecortar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JPanel mensagemJP;
    private javax.swing.JScrollPane mensagemJSP;
    private javax.swing.JTextArea mensagemTA;
    private javax.swing.JPanel principalJP;
    private javax.swing.JLabel statusJL;
    private javax.swing.JPanel statusJP;
    private javax.swing.JPanel toolBarJP;
    // End of variables declaration//GEN-END:variables
}
