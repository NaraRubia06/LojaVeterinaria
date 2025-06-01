/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

public class FrmMenu extends javax.swing.JFrame {

    public FrmMenu() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadFunc = new javax.swing.JMenu();
        MenuCadClientes = new javax.swing.JMenuItem();
        MenuCadFuncionarios = new javax.swing.JMenuItem();
        MenuCadFornec = new javax.swing.JMenuItem();
        MenuCadProd = new javax.swing.JMenuItem();
        MenuCadastroAnimais = new javax.swing.JMenuItem();
        MenuCadastroConsultas = new javax.swing.JMenuItem();
        MenuLancVendas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btSair.setBackground(new java.awt.Color(255, 204, 204));
        btSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.gray, java.awt.Color.lightGray));

        MenuCadFunc.setBackground(new java.awt.Color(0, 0, 0));
        MenuCadFunc.setText("Cadastros");

        MenuCadClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuCadClientes.setText("Cadastro de Clientes / Tutores");
        MenuCadClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadClientesActionPerformed(evt);
            }
        });
        MenuCadFunc.add(MenuCadClientes);

        MenuCadFuncionarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuCadFuncionarios.setText("Cadastro de Funcionários");
        MenuCadFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadFuncionariosActionPerformed(evt);
            }
        });
        MenuCadFunc.add(MenuCadFuncionarios);

        MenuCadFornec.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuCadFornec.setText("Cadastro de Fornecedores");
        MenuCadFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadFornecActionPerformed(evt);
            }
        });
        MenuCadFunc.add(MenuCadFornec);

        MenuCadProd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuCadProd.setText("Cadastro de Produtos");
        MenuCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadProdActionPerformed(evt);
            }
        });
        MenuCadFunc.add(MenuCadProd);

        MenuCadastroAnimais.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuCadastroAnimais.setText("Cadastro de Animais");
        MenuCadastroAnimais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroAnimaisActionPerformed(evt);
            }
        });
        MenuCadFunc.add(MenuCadastroAnimais);

        MenuCadastroConsultas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuCadastroConsultas.setText("Cadastro de Consultas");
        MenuCadastroConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroConsultasActionPerformed(evt);
            }
        });
        MenuCadFunc.add(MenuCadastroConsultas);

        MenuLancVendas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuLancVendas.setText("Vendas de Produtos / NF");
        MenuLancVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLancVendasActionPerformed(evt);
            }
        });
        MenuCadFunc.add(MenuLancVendas);

        jMenuBar1.add(MenuCadFunc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(584, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
         System.exit(0);

    }//GEN-LAST:event_btSairActionPerformed

    private void MenuCadastroAnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroAnimaisActionPerformed
        // TODO add your handling code here:
        // TELA DE MENU DE CADASTRO DE ANIMAIS.
        FrmCadastroAnimais frmCadastroAnimais = new FrmCadastroAnimais();
        frmCadastroAnimais.setLocationRelativeTo(null);
        frmCadastroAnimais.setResizable(false);
        frmCadastroAnimais.setVisible(true); // deixa la no topo superior esquerdo
    }//GEN-LAST:event_MenuCadastroAnimaisActionPerformed

    private void MenuCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadProdActionPerformed
        // TODO add your handling code here:
        // TELA DE MENU DE CADASTRO DE PRODUTO.
        FrmCadastroProdutos frmCadastroProdutos = new FrmCadastroProdutos();
        frmCadastroProdutos.setLocationRelativeTo(null);
        frmCadastroProdutos.setResizable(false);
        frmCadastroProdutos.setVisible(true);
    }//GEN-LAST:event_MenuCadProdActionPerformed

    private void MenuCadFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadFornecActionPerformed
        // TODO add your handling code here:
        // TELA DE MENU DE CADASTRO DE FORNECEDORES.
        FrmCadastroFornecedores frmCadastroFornecedores = new FrmCadastroFornecedores ();
        frmCadastroFornecedores.setLocationRelativeTo(null);
        frmCadastroFornecedores.setResizable(false);
        frmCadastroFornecedores.setVisible(true);
    }//GEN-LAST:event_MenuCadFornecActionPerformed

    private void MenuCadFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadFuncionariosActionPerformed
        // TODO add your handling code here:
        // TELA DE MENU DE CADASTRO DE FUNCIONARIOS.
        FrmCadastroFuncionarios frmCadastroFuncionarios = new FrmCadastroFuncionarios ();
        frmCadastroFuncionarios.setLocationRelativeTo(null);
        frmCadastroFuncionarios.setResizable(false);
        frmCadastroFuncionarios.setVisible(true);
    }//GEN-LAST:event_MenuCadFuncionariosActionPerformed

    private void MenuCadClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadClientesActionPerformed
        // TODO add your handling code here:
        // TELA DE MENU DE CADASTRO DE CLIENTES.
        FrmCadastroClientes frmCadastroClientes = new FrmCadastroClientes ();
        frmCadastroClientes.setLocationRelativeTo(null);
        frmCadastroClientes.setResizable(false);
        frmCadastroClientes.setVisible(true);

    }//GEN-LAST:event_MenuCadClientesActionPerformed

    private void MenuLancVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLancVendasActionPerformed
        // TODO add your handling code here:
        // TELA DE MENU DE LANÇAMENTO DE VENDAS.
        FrmLancamentoVendas frmLancamentoVendas = new FrmLancamentoVendas();
        frmLancamentoVendas.setLocationRelativeTo(null);
        frmLancamentoVendas.setResizable(false);
        frmLancamentoVendas.setVisible(true);
    }//GEN-LAST:event_MenuLancVendasActionPerformed

    private void MenuCadastroConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroConsultasActionPerformed
        // TODO add your handling code here:
        // TELA DE MENU DE CADASTRO DE CONSULTAS PARA OS ANIMAIS.
        FrmCadastroConsulta frmCadastroConsulta = new FrmCadastroConsulta ();
        frmCadastroConsulta.setLocationRelativeTo(null);
        frmCadastroConsulta.setResizable(false);
        frmCadastroConsulta.setVisible(true);
    }//GEN-LAST:event_MenuCadastroConsultasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
                
            }
            
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCadClientes;
    private javax.swing.JMenuItem MenuCadFornec;
    private javax.swing.JMenu MenuCadFunc;
    private javax.swing.JMenuItem MenuCadFuncionarios;
    private javax.swing.JMenuItem MenuCadProd;
    private javax.swing.JMenuItem MenuCadastroAnimais;
    private javax.swing.JMenuItem MenuCadastroConsultas;
    private javax.swing.JMenuItem MenuLancVendas;
    private javax.swing.JButton btSair;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}