/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import alertaj.Jop;
import controle.ControlePais;
import controle.ControleUf;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Pais;
import modelo.Uf;

/**
 *
 * @author T-Gamer
 */
public class VisaoUf extends javax.swing.JFrame {

    private List<Pais> paises;
    private List<Uf> ufs;

    /**
     * Creates new form PaisVisao
     */
    public VisaoUf() {

        initComponents();
        carregarListaPaises();
        desativarBotoes();
        desativarCamposDeTexto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlLogo = new javax.swing.JLabel();
        jplOpcoes = new javax.swing.JPanel();
        jbtIncluir = new javax.swing.JButton();
        jbtNovo = new javax.swing.JToggleButton();
        jbtSalvar = new javax.swing.JToggleButton();
        jbtExcluir = new javax.swing.JToggleButton();
        jbtAlterar = new javax.swing.JToggleButton();
        jbtCancelar = new javax.swing.JToggleButton();
        jbtConsulta = new javax.swing.JButton();
        jbtSair = new javax.swing.JToggleButton();
        jplCampos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfSigla = new javax.swing.JTextField();
        jtfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbPais = new javax.swing.JComboBox();
        jbtBuscaCodigo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jplTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Manter Unidade Federativa");

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_pequeno.png"))); // NOI18N

        javax.swing.GroupLayout jplTituloLayout = new javax.swing.GroupLayout(jplTitulo);
        jplTitulo.setLayout(jplTituloLayout);
        jplTituloLayout.setHorizontalGroup(
            jplTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplTituloLayout.createSequentialGroup()
                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 71, Short.MAX_VALUE))
        );
        jplTituloLayout.setVerticalGroup(
            jplTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplTituloLayout.createSequentialGroup()
                .addGroup(jplTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLogo)
                    .addGroup(jplTituloLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jplOpcoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbtIncluir.setText("Incluir");
        jbtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIncluirActionPerformed(evt);
            }
        });

        jbtNovo.setText("Novo");
        jbtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoActionPerformed(evt);
            }
        });

        jbtSalvar.setText("Salvar");
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });

        jbtExcluir.setText("Excluir");
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        jbtAlterar.setText("Alterar");
        jbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarActionPerformed(evt);
            }
        });

        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtConsulta.setText("Consultar");
        jbtConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConsultaActionPerformed(evt);
            }
        });

        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplOpcoesLayout = new javax.swing.GroupLayout(jplOpcoes);
        jplOpcoes.setLayout(jplOpcoesLayout);
        jplOpcoesLayout.setHorizontalGroup(
            jplOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jplOpcoesLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jplOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jplOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtIncluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jbtConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jplOpcoesLayout.setVerticalGroup(
            jplOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jbtSair)
                .addGap(31, 31, 31))
        );

        jLabel3.setText("Sigla");

        jLabel2.setText("Código");

        jLabel4.setText("Nome");

        jLabel5.setText("Pais");

        jcbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaisActionPerformed(evt);
            }
        });

        jbtBuscaCodigo.setText("Busca por Código");
        jbtBuscaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscaCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplCamposLayout = new javax.swing.GroupLayout(jplCampos);
        jplCampos.setLayout(jplCamposLayout);
        jplCamposLayout.setHorizontalGroup(
            jplCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplCamposLayout.createSequentialGroup()
                .addGroup(jplCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplCamposLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jplCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplCamposLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplCamposLayout.createSequentialGroup()
                        .addComponent(jtfCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfNome)
                    .addGroup(jplCamposLayout.createSequentialGroup()
                        .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtBuscaCodigo)))
                .addContainerGap())
        );
        jplCamposLayout.setVerticalGroup(
            jplCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscaCodigo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código Pais", "Sigla", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jplCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jplOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jplTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jplCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jplOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIncluirActionPerformed
        ativarBotoes();
        jbtIncluir.setEnabled(false);
        ativarCamposDeTexto();

    }//GEN-LAST:event_jbtIncluirActionPerformed

    private void jbtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoActionPerformed
        limparCampos();
        ativarCamposDeTexto();
    }//GEN-LAST:event_jbtNovoActionPerformed

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        checarChave();
        ControleUf cuf = new ControleUf();
        int chavePrimaria = cuf.insert((Uf) criarUf());
        popularChave(Integer.toString(chavePrimaria));
        desativarCamposDeTexto();

    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        new VisaoPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed

        int opcao = Jop.alertaOpcao("Deseja realmente excluir esse registro?");
        if (opcao == 0) {
            ControleUf cuf = new ControleUf();
            int chavePrimaria = cuf.delete((Uf) criarUf());
            popularChave(Integer.toString(chavePrimaria));
        }

    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed
        int opcao = Jop.alertaOpcao("Deseja realmente alterar esse registro?");
        if (opcao == 0) {
            ControleUf cuf = new ControleUf();
            int chavePrimaria = cuf.update((Uf) criarUf());
            popularChave(Integer.toString(chavePrimaria));
        }
    }//GEN-LAST:event_jbtAlterarActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        limparCampos();
        jbtIncluir.setEnabled(true);
        desativarCamposDeTexto();
        desativarBotoes();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConsultaActionPerformed
        carregarListaUfs();
        Object[] columnNames = {"Código", "Código Pais", "Sigla", "Nome"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
        for (Uf uf : ufs) {
            Object[] o = new Object[4];
            o[0] = uf.getCodigo();
            o[1] = uf.getCodigo_Pais();
            o[2] = uf.getSigla();
            o[3] = uf.getDescricao();

            model.addRow(o);
        }
        jtConsulta.setModel(model);

    }//GEN-LAST:event_jbtConsultaActionPerformed

    private void jbtBuscaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscaCodigoActionPerformed
        ControleUf cuf = new ControleUf();
        Uf uf = (Uf) cuf.selectCodigo(Integer.parseInt(jtfCodigo.getText()));
        popularCampos(Integer.toString(uf.getCodigo()), uf.getCodigo_Pais(), uf.getSigla(), uf.getDescricao());

    }//GEN-LAST:event_jbtBuscaCodigoActionPerformed

    private void jcbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPaisActionPerformed

    private void carregarListaUfs() {
        ControleUf uc = new ControleUf();
        ufs = uc.select();
    }

    private void carregarListaPaises() {
        ControlePais cp = new ControlePais();
        paises = cp.select();
        jcbPais.removeAllItems();
        for (Pais pais : paises) {
            jcbPais.addItem(pais);
        }

    }

    private void checarChave() {
        if (jtfCodigo.getText().length() <= 0) {
            jtfCodigo.setText("0");
        }
    }

    private Object criarUf() {
        int codigo = Integer.parseInt(jtfCodigo.getText());
        Pais pais = (Pais) jcbPais.getSelectedItem();
        int codigo_pais = pais.getCodigo();
        String sigla = jtfSigla.getText();
        String nome = jtfNome.getText();
        Uf uf = new Uf(codigo, codigo_pais, sigla, nome);
        return uf;
    }

    private void desativarBotoes() {
        jbtNovo.setEnabled(false);
        jbtSalvar.setEnabled(false);
        jbtAlterar.setEnabled(false);
        jbtCancelar.setEnabled(false);
        jbtExcluir.setEnabled(false);
    }

    private void ativarBotoes() {
        jbtIncluir.setEnabled(true);
        jbtNovo.setEnabled(true);
        jbtSalvar.setEnabled(true);
        jbtAlterar.setEnabled(true);
        jbtCancelar.setEnabled(true);
        jbtExcluir.setEnabled(true);
    }

    private void desativarCamposDeTexto() {
        jtfCodigo.setEnabled(false);
        jtfSigla.setEnabled(false);
    }

    private void ativarCamposDeTexto() {
        jtfCodigo.setEnabled(true);
        jtfSigla.setEnabled(true);
    }

    private void limparCampos() {
        jtfCodigo.setText(null);
        jtfSigla.setText(null);
    }

    private void popularChave(String chave) {
        jtfCodigo.setText(chave);

    }

    private void popularCampos(String codigo, int codigoPais, String sigla, String nome) {
        jtfCodigo.setText(codigo);
        jtfSigla.setText(sigla);
        jtfNome.setText(nome);
        int index = 0;
        for (int i = 0; i < paises.size(); i++) {
            if (paises.get(i).getCodigo() == codigoPais) { // Or use equals() if it actually returns an Object.
                index = i;
            }
        }

        jcbPais.setSelectedIndex(index);

    }

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
            java.util.logging.Logger.getLogger(VisaoUf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoUf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoUf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoUf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoUf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jbtAlterar;
    private javax.swing.JButton jbtBuscaCodigo;
    private javax.swing.JToggleButton jbtCancelar;
    private javax.swing.JButton jbtConsulta;
    private javax.swing.JToggleButton jbtExcluir;
    private javax.swing.JButton jbtIncluir;
    private javax.swing.JToggleButton jbtNovo;
    private javax.swing.JToggleButton jbtSair;
    private javax.swing.JToggleButton jbtSalvar;
    private javax.swing.JComboBox jcbPais;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JPanel jplCampos;
    private javax.swing.JPanel jplOpcoes;
    private javax.swing.JPanel jplTitulo;
    private javax.swing.JTable jtConsulta;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfSigla;
    // End of variables declaration//GEN-END:variables
}