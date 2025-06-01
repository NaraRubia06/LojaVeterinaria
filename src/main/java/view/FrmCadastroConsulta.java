/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ConsultaController;
import dao.ConsultaDAO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConsultaModel;

/**  @author Nara Rubia B. Balena */

public class FrmCadastroConsulta extends javax.swing.JFrame {

    public FrmCadastroConsulta() {
        initComponents();
    }
    
    ConsultaController consultaController = new ConsultaController();
    ConsultaDAO consultaDAO = new ConsultaDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeAnimal = new javax.swing.JTextField();
        txtNomeTutor = new javax.swing.JTextField();
        txtNomeVeterinario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDataConsulta = new javax.swing.JFormattedTextField();
        txtHoraConsulta = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        cbStatusConsulta = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivoConsulta = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btSalvar3 = new javax.swing.JButton();
        btEditar3 = new javax.swing.JButton();
        btExcluir3 = new javax.swing.JButton();
        btLimpar3 = new javax.swing.JButton();
        btVoltarMenu3 = new javax.swing.JButton();
        spaneCadastroConsulta = new javax.swing.JScrollPane();
        tabelaCadastroConsulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Cadastro da Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel3.setText("Nome do Animal : *");

        jLabel4.setText("Nome do Tutor : *");

        jLabel5.setText("Nome do Veterinário(a) : *");

        txtNomeAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAnimalActionPerformed(evt);
            }
        });

        txtNomeTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeTutorActionPerformed(evt);
            }
        });

        txtNomeVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeVeterinarioActionPerformed(evt);
            }
        });

        jLabel6.setText("Data da Consulta : *");

        jLabel7.setText("Hora da Consulta : *");

        try {
            txtDataConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataConsultaActionPerformed(evt);
            }
        });

        try {
            txtHoraConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraConsultaActionPerformed(evt);
            }
        });

        jLabel8.setText("Status da Consulta : *");

        cbStatusConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "Agendada", "Confirmada", "Realizada", "Cancelada" }));
        cbStatusConsulta.setToolTipText("");
        cbStatusConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusConsultaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo da Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtMotivoConsulta.setColumns(20);
        txtMotivoConsulta.setRows(5);
        jScrollPane1.setViewportView(txtMotivoConsulta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtObservacoes.setColumns(20);
        txtObservacoes.setRows(5);
        jScrollPane2.setViewportView(txtObservacoes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(txtDataConsulta))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeTutor)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtHoraConsulta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeVeterinario)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatusConsulta, 0, 197, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatusConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Cadastro de Consultas");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray), "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btSalvar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSalvar3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btSalvar.png")); // NOI18N
        btSalvar3.setText("SALVAR");
        btSalvar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvar3ActionPerformed(evt);
            }
        });

        btEditar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btEditar3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btEditar.png")); // NOI18N
        btEditar3.setText("EDITAR");
        btEditar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar3ActionPerformed(evt);
            }
        });

        btExcluir3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btExcluir3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btExcluir.png")); // NOI18N
        btExcluir3.setText("EXCLUIR");
        btExcluir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluir3ActionPerformed(evt);
            }
        });

        btLimpar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btLimpar3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btLimpar.png")); // NOI18N
        btLimpar3.setText("LIMPAR");
        btLimpar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpar3ActionPerformed(evt);
            }
        });

        btVoltarMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btVoltarMenu3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btVoltarMenu.png")); // NOI18N
        btVoltarMenu3.setText("VOLTAR AO MENU");
        btVoltarMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarMenu3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btSalvar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLimpar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltarMenu3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltarMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        spaneCadastroConsulta.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        spaneCadastroConsulta.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tabelaCadastroConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Consulta", "Nome do Animal", "Nome do Tutor", "Nome do Veterinário", "Data da Consulta", "Hora da Consulta", "Status da Consulta", "Motivo da Consulta", "Observações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCadastroConsulta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaCadastroConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaCadastroConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCadastroConsultaMouseClicked(evt);
            }
        });
        spaneCadastroConsulta.setViewportView(tabelaCadastroConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spaneCadastroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spaneCadastroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
      // VALIDAÇÃO DOS CAMPOS NA TELA DE CADASTRO DE PRODUTOS.
private boolean validarCampos() { 
    if (txtNomeAnimal.getText().trim().isEmpty()) {
        mostrarErro("Nome Animal", txtNomeAnimal);
        return false;
    }
    if (txtNomeTutor.getText().trim().isEmpty()) {
        mostrarErro("Nome Tutor", txtNomeTutor);
        return false;
    }
    if (txtNomeVeterinario.getText().trim().isEmpty()) {
        mostrarErro("Nome Veterinario", txtNomeVeterinario);
        return false;
    }
    if (txtDataConsulta.getText().trim().isEmpty() || isCampoMascaradoVazio(txtDataConsulta)) {
        mostrarErro("Data da Consulta", txtDataConsulta);
        return false;
    }
    
    if (txtHoraConsulta.getText().trim().isEmpty() || isCampoMascaradoVazio(txtHoraConsulta)) {
        mostrarErro("Hora da Consulta", txtHoraConsulta);
        return false;
    }
    
    if (isComboBoxInvalida(cbStatusConsulta)) {
        mostrarErro("Status da Consulta", cbStatusConsulta);
        return false;
    }
    
    if (txtMotivoConsulta.getText().trim().isEmpty()) {
        mostrarErro("Motivo Consulta", txtMotivoConsulta);
        return false;
    }


    return true;
}

// Verifica se o campo de máscara está vazio
private boolean isCampoMascaradoVazio(JFormattedTextField campo) {
    String texto = campo.getText().replaceAll("[^0-9A-Za-z]", "").trim();
    return texto.isEmpty();
}

// Verifica se a ComboBox tem valor inválido
private boolean isComboBoxInvalida(JComboBox<?> comboBox) {
    Object selectedItem = comboBox.getSelectedItem();
    // Verifica se não tem nada selecionado ou se o valor é "Selecione"
    return selectedItem == null || selectedItem.toString().trim().isEmpty() || selectedItem.toString().equalsIgnoreCase("Selecione");
}

// Mostra erro e foca no campo
private void mostrarErro(String campo, java.awt.Component componente) {
    JOptionPane.showMessageDialog(this, "O campo " + campo + " é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
    componente.requestFocus();
}

 // CARREGAR DADOS NA TABELA 
private void carregarTabelaClientes() {
    try {
        List<ConsultaModel> consulta = consultaDAO.listarTodos();
        
         // Ordena a lista por ID para manter ordem consistente
        consulta.sort(Comparator.comparing(ConsultaModel::getId));
        
        DefaultTableModel modelo = (DefaultTableModel)  tabelaCadastroConsulta.getModel();
        modelo.setRowCount(0);
        
        for (ConsultaModel c : consulta) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getAnimal(),
                c.getTutor(),
                c.getVeterinario(),
                c.getDataConsulta(),
                c.getHoraConsulta(),
                c.getStatusConsulta(),
                c.getMotivoConsulta(),
                c.getObservacao(),
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar o cadastro da consulta: " + e.getMessage());
    }
    
        tabelaCadastroConsulta.getColumnModel().getColumn(0).setPreferredWidth(80);   
        tabelaCadastroConsulta.getColumnModel().getColumn(1).setPreferredWidth(150);  
        tabelaCadastroConsulta.getColumnModel().getColumn(2).setPreferredWidth(150); 
        tabelaCadastroConsulta.getColumnModel().getColumn(3).setPreferredWidth(150);  
        tabelaCadastroConsulta.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabelaCadastroConsulta.getColumnModel().getColumn(5).setPreferredWidth(120);  
        tabelaCadastroConsulta.getColumnModel().getColumn(6).setPreferredWidth(150); 
        tabelaCadastroConsulta.getColumnModel().getColumn(7).setPreferredWidth(200);  
        tabelaCadastroConsulta.getColumnModel().getColumn(8).setPreferredWidth(200);  
}
    private void txtNomeAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAnimalActionPerformed

    private void txtNomeTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeTutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeTutorActionPerformed

    private void txtNomeVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeVeterinarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeVeterinarioActionPerformed

    private void txtDataConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataConsultaActionPerformed

    private void txtHoraConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraConsultaActionPerformed

    private void cbStatusConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusConsultaActionPerformed

    private void btSalvar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvar3ActionPerformed
        // TODO add your handling code here:
        // BOTÃO SALVAR DA TELA DE CADASTRO DE CONSULTA.
            if(validarCampos()){

            String animal = txtNomeAnimal.getText().trim();
            String tutor = txtNomeTutor.getText().trim();
            String veterinario = txtNomeVeterinario.getText().trim();
            String dataConsulta = txtDataConsulta.getText().trim();
            String horaConsulta = txtHoraConsulta.getText().trim();
            String statusConsulta = cbStatusConsulta.getSelectedItem().toString();
            String motivoConsulta = txtMotivoConsulta.getText().trim();
            String observacao = txtObservacoes.getText().trim();
           
            consultaController.salvarConsulta(animal, tutor, veterinario, dataConsulta, horaConsulta, statusConsulta, motivoConsulta, observacao );
            carregarTabelaClientes();
        } 

    }//GEN-LAST:event_btSalvar3ActionPerformed

    private void btEditar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar3ActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE EDITAR ALGUM REGISTRO NA TELA DE CADASTRO DE CONSULTA.
        int row = tabelaCadastroConsulta.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para atualizar.");
            return;
        }

        Long id = Long.valueOf(tabelaCadastroConsulta.getValueAt(row, 0).toString());
        ConsultaModel consultaAtualizado = new ConsultaModel();
        
        consultaAtualizado.setAnimal(txtNomeAnimal.getText());
        consultaAtualizado.setTutor(txtNomeTutor.getText());
        consultaAtualizado.setVeterinario(txtNomeVeterinario.getText());
        consultaAtualizado.setDataConsulta(txtDataConsulta.getText());
        consultaAtualizado.setHoraConsulta(txtHoraConsulta.getText());
        consultaAtualizado.setStatusConsulta(cbStatusConsulta.getSelectedItem().toString());
        consultaAtualizado.setMotivoConsulta(txtMotivoConsulta.getText());
        consultaAtualizado.setObservacao(txtObservacoes.getText());

        consultaController.atualizarConsultaPorId(id, consultaAtualizado);
        carregarTabelaClientes();

    }//GEN-LAST:event_btEditar3ActionPerformed

    private void btExcluir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluir3ActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE EXCLUIR TODO REGISTRO NA TELA DE CADASTRO DE CONSULTA.
        int row = tabelaCadastroConsulta.getSelectedRow();
        Long id = Long.valueOf(tabelaCadastroConsulta.getValueAt(row, 0).toString());
        consultaController.excluirConsultaPorId(id);
        carregarTabelaClientes();

    }//GEN-LAST:event_btExcluir3ActionPerformed

    private void btLimpar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpar3ActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE LIMPAR TODOS OS CAMPOS NA TELA DE CADASTRO DE CONSULTA.
        txtNomeAnimal.setText("");
        txtNomeTutor.setText("");
        txtNomeVeterinario.setText("");
        txtDataConsulta.setText("");
        txtHoraConsulta.setText("");
        cbStatusConsulta.setSelectedIndex(0);
        txtMotivoConsulta.setText("");
        txtObservacoes.setText("");

    }//GEN-LAST:event_btLimpar3ActionPerformed

    private void btVoltarMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarMenu3ActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE VOLTAR A TELA DE MENU.

        // Fecha a tela atual
        this.dispose();

        // Abre a tela do menu principal
        FrmMenu menu = new FrmMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_btVoltarMenu3ActionPerformed

    private void tabelaCadastroConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCadastroConsultaMouseClicked
        // TODO add your handling code here:
        try {
            if (evt.getClickCount() == 2) {
                int row = tabelaCadastroConsulta.getSelectedRow();
                int colCount = tabelaCadastroConsulta.getColumnCount();

                List<Object> valores = new ArrayList<>();
                for (int col = 0; col < colCount; col++) {
                    valores.add(tabelaCadastroConsulta.getValueAt(row, col));
                }

                txtNomeAnimal.setText(valores.get(1).toString());
                txtNomeTutor.setText(valores.get(2).toString());
                txtNomeVeterinario.setText(valores.get(3).toString());
                txtDataConsulta.setText(valores.get(4).toString());
                txtHoraConsulta.setText(valores.get(5).toString());
                cbStatusConsulta.setSelectedItem(valores.get(6).toString());
                txtMotivoConsulta.setText(valores.get(7).toString());
                txtObservacoes.setText(valores.get(8).toString());
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, "Erro ao carregar a consulta: " + e.getMessage());
        }
    }//GEN-LAST:event_tabelaCadastroConsultaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        carregarTabelaClientes();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(FrmCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar3;
    private javax.swing.JButton btExcluir3;
    private javax.swing.JButton btLimpar3;
    private javax.swing.JButton btSalvar3;
    private javax.swing.JButton btVoltarMenu3;
    private javax.swing.JComboBox<String> cbStatusConsulta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane spaneCadastroConsulta;
    private javax.swing.JTable tabelaCadastroConsulta;
    private javax.swing.JFormattedTextField txtDataConsulta;
    private javax.swing.JFormattedTextField txtHoraConsulta;
    private javax.swing.JTextArea txtMotivoConsulta;
    private javax.swing.JTextField txtNomeAnimal;
    private javax.swing.JTextField txtNomeTutor;
    private javax.swing.JTextField txtNomeVeterinario;
    private javax.swing.JTextArea txtObservacoes;
    // End of variables declaration//GEN-END:variables
}
