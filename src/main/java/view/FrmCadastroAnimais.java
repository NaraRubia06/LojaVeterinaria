/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AnimalController;
import dao.AnimalDAO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AnimalModel;
import model.ConsultaModel;

/**@author Nara Rubia B. Balena */

public class FrmCadastroAnimais extends javax.swing.JFrame {

    public FrmCadastroAnimais() {
        initComponents();
    }
    
    AnimalController animalController = new AnimalController();
    AnimalDAO animalDAO = new AnimalDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeAnimal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbEspecie = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtRaca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDataNasc = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPesoKg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNomeTutor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btSalvar2 = new javax.swing.JButton();
        btEditar2 = new javax.swing.JButton();
        btExcluir2 = new javax.swing.JButton();
        btLimpar2 = new javax.swing.JButton();
        btVoltarMenu2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCadastroAnimais = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações Cadastrais do Animal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setText("Nome do Animal : *");

        txtNomeAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAnimalActionPerformed(evt);
            }
        });

        jLabel3.setText("Espécie : *");

        cbEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "Cães", "Gatos", "Aves", "Répteis", "Roedores", "Outros tipos de espécie de animal" }));
        cbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecieActionPerformed(evt);
            }
        });

        jLabel4.setText("Raça : *");

        txtRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRacaActionPerformed(evt);
            }
        });

        jLabel5.setText("Sexo : *");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "Macho", "Fêmea", " " }));

        jLabel6.setText("Idade : *");

        txtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeActionPerformed(evt);
            }
        });

        jLabel7.setText("Data de Nascimento : *");

        try {
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascActionPerformed(evt);
            }
        });

        jLabel8.setText("Peso (kg) : *");

        txtPesoKg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoKgActionPerformed(evt);
            }
        });

        jLabel9.setText("Cor : *");

        txtCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorActionPerformed(evt);
            }
        });

        jLabel10.setText("Nome do Tutor : *");

        txtNomeTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeTutorActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtObservacoes.setColumns(20);
        txtObservacoes.setRows(5);
        jScrollPane2.setViewportView(txtObservacoes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPesoKg, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNomeTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesoKg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataNasc))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Animais");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray), "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btSalvar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSalvar2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btSalvar.png")); // NOI18N
        btSalvar2.setText("SALVAR");
        btSalvar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvar2ActionPerformed(evt);
            }
        });

        btEditar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btEditar2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btEditar.png")); // NOI18N
        btEditar2.setText("EDITAR");
        btEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar2ActionPerformed(evt);
            }
        });

        btExcluir2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btExcluir2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btExcluir.png")); // NOI18N
        btExcluir2.setText("EXCLUIR");
        btExcluir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluir2ActionPerformed(evt);
            }
        });

        btLimpar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btLimpar2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btLimpar.png")); // NOI18N
        btLimpar2.setText("LIMPAR");
        btLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpar2ActionPerformed(evt);
            }
        });

        btVoltarMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btVoltarMenu2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btVoltarMenu.png")); // NOI18N
        btVoltarMenu2.setText("VOLTAR AO MENU");
        btVoltarMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarMenu2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btSalvar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLimpar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltarMenu2)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltarMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        tabelaCadastroAnimais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Animal", "Nome do Animal", "Espécie", "Raça", "Sexo", "Idade", "Data de Nascimento", "Peso (KG)", "Cor ", "Nome do Tutor", "Observações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCadastroAnimais.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaCadastroAnimais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCadastroAnimaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCadastroAnimais);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

          // VALIDAÇÃO DOS CAMPOS NA TELA DE CADASTRO DE PRODUTOS.
private boolean validarCampos() { 
    
    if (txtNomeAnimal.getText().trim().isEmpty()) {
        mostrarErro("Nome do Animal", txtNomeAnimal);
        return false;
    }
    
    if (isComboBoxInvalida(cbEspecie)) {
        mostrarErro("Espécie", cbEspecie);
        return false;
    }
    
    if (txtRaca.getText().trim().isEmpty()) {
        mostrarErro("Raça", txtRaca);
        return false;
    }
    
    if (isComboBoxInvalida(cbSexo)) {
        mostrarErro("Sexo", cbSexo);
        return false;
    }
    
    if (txtIdade.getText().trim().isEmpty()) {
        mostrarErro("Idade", txtIdade);
        return false;
    }
    
    if (txtDataNasc.getText().trim().isEmpty() || isCampoMascaradoVazio(txtDataNasc)) {
        mostrarErro("Data de Nascimento", txtDataNasc);
        return false;
    }
    
    if (txtPesoKg.getText().trim().isEmpty()) {
        mostrarErro("Peso (KG)", txtPesoKg);
        return false;
    }
    
    if (txtCor.getText().trim().isEmpty()) {
        mostrarErro("Cor", txtCor);
        return false;
    }

    if (txtNomeTutor.getText().trim().isEmpty()) {
        mostrarErro("Nome Tutor", txtNomeTutor);
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
        List<AnimalModel> animal = animalDAO.listarTodos();
        
        // Ordena a lista por ID para manter ordem consistente
        animal.sort(Comparator.comparing(AnimalModel::getId));
        
        DefaultTableModel modelo = (DefaultTableModel)  tabelaCadastroAnimais.getModel();
        modelo.setRowCount(0);
        
        for (AnimalModel c : animal) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getEspecie(),
                c.getRaca(),
                c.getSexo(),
                c.getIdade(),
                c.getDataNascimento(),
                c.getPeso(),
                c.getCor(),
                c.getNomeTutor(),
                c.getObservacao(),
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar o cadastro do animal: " + e.getMessage());
    }
        tabelaCadastroAnimais.getColumnModel().getColumn(0).setPreferredWidth(80);   
        tabelaCadastroAnimais.getColumnModel().getColumn(1).setPreferredWidth(100);  
        tabelaCadastroAnimais.getColumnModel().getColumn(2).setPreferredWidth(100); 
        tabelaCadastroAnimais.getColumnModel().getColumn(3).setPreferredWidth(100);  
        tabelaCadastroAnimais.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabelaCadastroAnimais.getColumnModel().getColumn(5).setPreferredWidth(100);  
        tabelaCadastroAnimais.getColumnModel().getColumn(6).setPreferredWidth(100); 
        tabelaCadastroAnimais.getColumnModel().getColumn(7).setPreferredWidth(100);  
        tabelaCadastroAnimais.getColumnModel().getColumn(8).setPreferredWidth(100);
        tabelaCadastroAnimais.getColumnModel().getColumn(9).setPreferredWidth(100);  
        tabelaCadastroAnimais.getColumnModel().getColumn(10).setPreferredWidth(100);
}
    private void txtCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorActionPerformed

    private void txtNomeAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAnimalActionPerformed

    private void txtNomeTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeTutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeTutorActionPerformed

    private void cbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecieActionPerformed

    private void txtRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRacaActionPerformed

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void txtDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascActionPerformed

    private void txtPesoKgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoKgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoKgActionPerformed

    private void btSalvar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvar2ActionPerformed
        // TODO add your handling code here:
        // BOTÃO SALVAR DA TELA DE CADASTRO DE ANIMAIS.
            
        if(validarCampos()){

            String nome = txtNomeAnimal.getText().trim();
            String especie = cbEspecie.getSelectedItem().toString();
            String raca = txtRaca.getText().trim();
            String sexo = cbSexo.getSelectedItem().toString();
            String idade = txtIdade.getText().trim();
            String dataNascimento = txtDataNasc.getText().trim();
            String peso = txtPesoKg.getText().trim();
            String cor = txtCor.getText().trim();
            String nomeTutor = txtNomeTutor.getText().trim();
            String observacao = txtObservacoes.getText().trim();
           
            animalController.salvarAnimal(nome,  especie,  raca,  sexo, idade,  dataNascimento,  peso,  cor,  nomeTutor,  observacao);
            carregarTabelaClientes();
        } 
    }//GEN-LAST:event_btSalvar2ActionPerformed

    private void btEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar2ActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE EDITAR ALGUM REGISTRO NA TELA DE CADASTRO DE ANIMAIS.
        int row = tabelaCadastroAnimais.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um animal para atualizar.");
            return;
        }

        Long id = Long.valueOf(tabelaCadastroAnimais.getValueAt(row, 0).toString());
        AnimalModel animalAtualizado = new AnimalModel();
        
        animalAtualizado.setNome(txtNomeAnimal.getText());
        animalAtualizado.setEspecie(cbEspecie.getSelectedItem().toString());
        animalAtualizado.setRaca(txtRaca.getText());
        animalAtualizado.setSexo(cbSexo.getSelectedItem().toString());
        animalAtualizado.setIdade(txtIdade.getText());
        animalAtualizado.setDataNascimento(txtDataNasc.getText());
        animalAtualizado.setPeso(txtPesoKg.getText());
        animalAtualizado.setCor(txtCor.getText());      
        animalAtualizado.setNomeTutor(txtNomeTutor.getText());
        animalAtualizado.setObservacao(txtObservacoes.getText());

        animalController.atualizarAnimalPorId(id, animalAtualizado);
        carregarTabelaClientes();
    }//GEN-LAST:event_btEditar2ActionPerformed

    private void btExcluir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluir2ActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE EXCLUIR TODO REGISTRO NA TELA DE CADASTRO DE ANIMAIS.
        int row = tabelaCadastroAnimais.getSelectedRow();
        Long id = Long.valueOf(tabelaCadastroAnimais.getValueAt(row, 0).toString());
        animalController.excluirAnimalPorId(id);
        carregarTabelaClientes();
    
    }//GEN-LAST:event_btExcluir2ActionPerformed

    private void btLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpar2ActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE LIMPAR TODOS OS CAMPOS NA TELA DE CADASTRO DE ANIMAIS.
        txtNomeAnimal.setText("");
        cbEspecie.setSelectedIndex(0);
        txtRaca.setText("");
        cbSexo.setSelectedIndex(0);
        txtIdade.setText("");
        txtDataNasc.setText("");
        txtPesoKg.setText("");
        txtCor.setText("");
        txtNomeTutor.setText("");
        txtObservacoes.setText("");
    }//GEN-LAST:event_btLimpar2ActionPerformed

    private void btVoltarMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarMenu2ActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE VOLTAR A TELA DE MENU.

        // Fecha a tela atual
        this.dispose();

        // Abre a tela do menu principal
        FrmMenu menu = new FrmMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_btVoltarMenu2ActionPerformed

    private void tabelaCadastroAnimaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCadastroAnimaisMouseClicked
        // TODO add your handling code here:
        try {
            if (evt.getClickCount() == 2) {
                int row = tabelaCadastroAnimais.getSelectedRow();
                int colCount = tabelaCadastroAnimais.getColumnCount();

                List<Object> valores = new ArrayList<>();
                for (int col = 0; col < colCount; col++) {
                    valores.add(tabelaCadastroAnimais.getValueAt(row, col));
                }

                txtNomeAnimal.setText(valores.get(1).toString());
                cbEspecie.setSelectedItem(valores.get(2).toString());
                txtRaca.setText(valores.get(3).toString());
                cbSexo.setSelectedItem(valores.get(4).toString());
                txtIdade.setText(valores.get(5).toString());
                txtDataNasc.setText(valores.get(6).toString());
                txtPesoKg.setText(valores.get(7).toString());
                txtCor.setText(valores.get(8).toString());
                txtNomeTutor.setText(valores.get(9).toString());
                txtObservacoes.setText(valores.get(10).toString());
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, "Erro ao carregar o animal: " + e.getMessage());
        }
    }//GEN-LAST:event_tabelaCadastroAnimaisMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCadastroAnimais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroAnimais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroAnimais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroAnimais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroAnimais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar2;
    private javax.swing.JButton btExcluir2;
    private javax.swing.JButton btLimpar2;
    private javax.swing.JButton btSalvar2;
    private javax.swing.JButton btVoltarMenu2;
    private javax.swing.JComboBox<String> cbEspecie;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaCadastroAnimais;
    private javax.swing.JTextField txtCor;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNomeAnimal;
    private javax.swing.JTextField txtNomeTutor;
    private javax.swing.JTextArea txtObservacoes;
    private javax.swing.JTextField txtPesoKg;
    private javax.swing.JTextField txtRaca;
    // End of variables declaration//GEN-END:variables
}
