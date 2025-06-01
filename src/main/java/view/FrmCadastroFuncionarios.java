/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ClienteController;
import controller.FuncionarioController;
import dao.ClienteDAO;
import dao.FuncionarioDAO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.FuncionarioModel;
import services.ViaCepService;

public class FrmCadastroFuncionarios extends javax.swing.JFrame {
 
    public FrmCadastroFuncionarios() {
        initComponents();
       
        txtCEP.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            buscarCep();
        }
    });
    }
    
    FuncionarioController funcionarioController = new FuncionarioController();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @SuppressWarnings("unchecked")
    
 
// FAZ A VALIDAÇÃO DO CEP PARA PRENCHIMENTO AUTOMATICO DO ENDEREÇO
private void buscarCep() { 
    String cep = txtCEP.getText().trim(); // Pega o CEP digitado no campo
    
    // Valida se o CEP está preenchido corretamente - verifica se tem os 9 digitos(1 a mais por causa do traço)
    if (cep.length() !=9) {
        JOptionPane.showMessageDialog(this, "CEP inválido! Digite um CEP com 8 dígitos.", 
                "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    //Instancia o serviço ViaCepService
    //ViaCepService viaCepService = new ViaCepService();
    //ViaCepService.Endereco endereco = viaCepService.buscarEndereco(cep);

    try {
    ViaCepService viaCepService = new ViaCepService();
    ViaCepService.Endereco endereco = viaCepService.buscarEndereco(cep);
    
         // Verifica se o CEP foi encontrado
        if (endereco != null) {
        txtLogradouro.setText(endereco.logradouro);
        txtBairro.setText(endereco.bairro);
        txtCidade.setText(endereco.localidade);
        txtEstado.setText(endereco.uf);
        } else {
        JOptionPane.showMessageDialog(this, "CEP não encontrado!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
        return;
        }
    
    } catch (Exception ex) {
    JOptionPane.showMessageDialog(this, "Erro ao buscar CEP: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }  
}
  
    // VALIDAÇÃO DOS CAMPOS NA TELA DE CADASTRO DE FUNCIONÁRIOS.
private boolean validarCampos() { 
    if (txtNome.getText().trim().isEmpty()) {
        mostrarErro("Nome", txtNome);
        return false;
    }
    if (txtCPF.getText().trim().isEmpty() || isCampoMascaradoVazio(txtCPF)) {
        mostrarErro("CPF", txtCPF);
        return false;
    }
    if (txtTelefone.getText().trim().isEmpty() || isCampoMascaradoVazio(txtTelefone)) {
        mostrarErro("Telefone", txtTelefone);
        return false;
    }
    if (txtCargo.getText().trim().isEmpty()) {
        mostrarErro("Cargo", txtCargo);
        return false;
    }
    if (txtSalario.getText().replace("R$", "").trim().isEmpty()) {
    mostrarErro("Salário", txtSalario);
    return false;
    }
    if (txtDataAdmissao.getText().trim().isEmpty() || isCampoMascaradoVazio(txtDataAdmissao)) {
        mostrarErro("Data de Admissão", txtDataAdmissao);
        return false;
    }

    if (txtCEP.getText().trim().isEmpty() || isCampoMascaradoVazio(txtCEP)) {
        mostrarErro("CEP", txtCEP);
        return false;
    }
    if (txtEstado.getText().trim().isEmpty()) {
        mostrarErro("Estado", txtEstado);
        return false;
    }
    if (txtCidade.getText().trim().isEmpty()) {
        mostrarErro("Cidade", txtCidade);
        return false;
    }
    if (txtBairro.getText().trim().isEmpty()) {
        mostrarErro("Bairro", txtBairro);
        return false;
    }
    if (txtLogradouro.getText().trim().isEmpty()) {
        mostrarErro("Logradouro", txtLogradouro);
        return false;
    }
    if (isComboBoxInvalida(cbComplemento)) {
        mostrarErro("Complemento", cbComplemento);
        return false;
    }
    if (txtNumero.getText().trim().isEmpty()) {
        mostrarErro("Número", txtNumero);
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
        List<FuncionarioModel> funcionarios = funcionarioDAO.listarTodos();
        
        // Ordena a lista por ID para manter ordem consistente
        funcionarios.sort(Comparator.comparing(FuncionarioModel::getId));
        
        DefaultTableModel modelo = (DefaultTableModel) tblFuncionarios.getModel();
        modelo.setRowCount(0);
        
        for (FuncionarioModel c : funcionarios) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getTelefone(),
                c.getCargo(),
                c.getSalario(),
                c.getDataAdmissao(),
                
                c.getCep(),
                c.getEstado(),
                c.getCidade(),
                c.getBairro(),
                c.getLogradouro(),
                c.getComplemento(),
                c.getNumero()
                
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar o funcionário: " + e.getMessage());
    }
    
        tblFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(100);   
        tblFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(150);  
        tblFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(150); 
        tblFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(100);  
        tblFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(100);  
        tblFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(150);
        
        tblFuncionarios.getColumnModel().getColumn(7).setPreferredWidth(100);  
        tblFuncionarios.getColumnModel().getColumn(8).setPreferredWidth(100);
        tblFuncionarios.getColumnModel().getColumn(9).setPreferredWidth(100);  
        tblFuncionarios.getColumnModel().getColumn(10).setPreferredWidth(100);
        tblFuncionarios.getColumnModel().getColumn(11).setPreferredWidth(150);
        tblFuncionarios.getColumnModel().getColumn(12).setPreferredWidth(120);  
        tblFuncionarios.getColumnModel().getColumn(13).setPreferredWidth(100);
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Panelinf = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        txtDataAdmissao = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtSalario = new javax.swing.JTextField();
        PanelEnd = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCEP = new javax.swing.JFormattedTextField();
        txtEstado = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtLogradouro = new javax.swing.JTextField();
        cbComplemento = new javax.swing.JComboBox<>();
        txtNumero = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btVoltarMenu = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        SPFuncionarios = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Funcionários");

        Panelinf.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray), "Informações do Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setText("Nome : *");

        jLabel4.setText("CPF : *");

        jLabel5.setText("Telefone : *");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        jLabel3.setText("Cargo : *");

        jLabel6.setText("Salário : *");

        jLabel7.setText("Data de Admissão : *");

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        try {
            txtDataAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataAdmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataAdmissaoActionPerformed(evt);
            }
        });

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtSalario.setText("R$ ");

        javax.swing.GroupLayout PanelinfLayout = new javax.swing.GroupLayout(Panelinf);
        Panelinf.setLayout(PanelinfLayout);
        PanelinfLayout.setHorizontalGroup(
            PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelinfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome)
                    .addComponent(txtCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataAdmissao)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        PanelinfLayout.setVerticalGroup(
            PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelinfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelinfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        PanelEnd.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray), "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel8.setText("CEP : *");

        jLabel9.setText("Estado :  * ");

        jLabel10.setText("Cidade : *");

        jLabel11.setText("Bairro : *");

        jLabel12.setText("Logradouro : * ");

        jLabel13.setText("Complemento :  *");

        jLabel14.setText("Número : *");

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCEPActionPerformed(evt);
            }
        });

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });

        txtLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouroActionPerformed(evt);
            }
        });

        cbComplemento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "CASA", "APARTAMENTO", " " }));
        cbComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComplementoActionPerformed(evt);
            }
        });

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEndLayout = new javax.swing.GroupLayout(PanelEnd);
        PanelEnd.setLayout(PanelEndLayout);
        PanelEndLayout.setHorizontalGroup(
            PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEndLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEndLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addGroup(PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCidade)
                    .addComponent(cbComplemento, 0, 170, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        PanelEndLayout.setVerticalGroup(
            PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEndLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray), "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btEditar.png")); // NOI18N
        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btExcluir.png")); // NOI18N
        btExcluir.setText("EXCLUIR");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btLimpar.png")); // NOI18N
        btLimpar.setText("LIMPAR");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btVoltarMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btVoltarMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btVoltarMenu.png")); // NOI18N
        btVoltarMenu.setText("VOLTAR AO MENU");
        btVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarMenuActionPerformed(evt);
            }
        });

        btSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\OneDrive\\Documentos\\NetBeansProjects\\Trabalho1_Desktop\\CadastroLoja\\src\\main\\java\\imagens_botao\\btSalvar.png")); // NOI18N
        btSalvar.setText("SALVAR");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltarMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        SPFuncionarios.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        SPFuncionarios.setAutoscrolls(true);

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Funcionários", "Nome", "CPF", "Telefone", "Cargo", "Salário", "Data de Admissão", "CEP", "Estado", "Cidade", "Bairro", "Logradouro", "Complemento", "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFuncionarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        SPFuncionarios.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Panelinf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SPFuncionarios))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panelinf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCEPActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouroActionPerformed

    private void cbComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbComplementoActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void txtDataAdmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataAdmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataAdmissaoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE EDITAR ALGUM REGISTRO NA TELA DE CADASTRO FUNCIONARIOS.
        int row = tblFuncionarios.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para atualizar.");
            return;
        }

        Long id = Long.valueOf(tblFuncionarios.getValueAt(row, 0).toString());
        FuncionarioModel funcionarioAtualizado = new FuncionarioModel();
        
        funcionarioAtualizado.setNome(txtNome.getText());
        funcionarioAtualizado.setCpf(txtCPF.getText());
        funcionarioAtualizado.setTelefone(txtTelefone.getText());
        funcionarioAtualizado.setCargo(txtCargo.getText());
        funcionarioAtualizado.setSalario(txtSalario.getText());
        funcionarioAtualizado.setDataAdmissao(txtDataAdmissao.getText());
        
        funcionarioAtualizado.setCep(txtCEP.getText());
        funcionarioAtualizado.setEstado(txtEstado.getText());
        funcionarioAtualizado.setCidade(txtCidade.getText());
        funcionarioAtualizado.setBairro(txtBairro.getText());
        funcionarioAtualizado.setLogradouro(txtLogradouro.getText());
        funcionarioAtualizado.setComplemento(cbComplemento.getSelectedItem().toString());
        funcionarioAtualizado.setNumero(txtNumero.getText());

        funcionarioController.atualizarFuncionarioPorId(id, funcionarioAtualizado);
        carregarTabelaClientes();

    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        // BOTÃO DE EXCLUIR TODOS OS REGISTROS NA TELA DE CADASTRO FUNCIONARIOS.
        int row = tblFuncionarios.getSelectedRow();
        Long id = Long.valueOf(tblFuncionarios.getValueAt(row, 0).toString());
        funcionarioController.excluirFuncionarioPorId(id);
        carregarTabelaClientes();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
        // BOTÃO PARA LIMPAR OS DADOS DIGITADOS NA TELA DE CADASTRO FUNCIONARIOS.
        txtNome.setText("");
        txtCPF.setText("");
        txtTelefone.setText("");
        txtCargo.setText("");
        txtSalario.setText(""); 
        txtDataAdmissao.setText("");
        
        txtCEP.setText("");
        txtEstado.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtLogradouro.setText("");
        cbComplemento.setSelectedIndex(0);
        txtNumero.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarMenuActionPerformed
        // BOTÃO DE FECHAR A TELA DE CADASTRO DE FUNCIONARIOS E VOLTAR AO MENU.
        
        // Fecha a tela atual
        this.dispose(); 
    
        // Abre a tela do menu principal
        FrmMenu menu = new FrmMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_btVoltarMenuActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        if(validarCampos()){
          
            String nome = txtNome.getText().trim();
            String cpf = txtCPF.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String cargo = txtCargo.getText().trim();
            String salario = txtSalario.getText().trim();
            String admissao = txtDataAdmissao.getText().trim();
            
            String cep = txtCEP.getText().trim();
            String estado = txtEstado.getText().trim();
            String cidade = txtCidade.getText().trim();
            String bairro = txtBairro.getText().trim();
            String logradouro = txtLogradouro.getText().trim();
            String complemento = cbComplemento.getSelectedItem().toString(); 
            String numero = txtNumero.getText().trim();
   
            funcionarioController.salvarFuncionario(nome, cpf, telefone, cargo, salario, admissao,
            cep, estado, cidade, bairro, logradouro, complemento, numero);
            carregarTabelaClientes();
              
        }   
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        // TODO add your handling code here:
         try {
            if (evt.getClickCount() == 2) {
                int row = tblFuncionarios.getSelectedRow();
                int colCount = tblFuncionarios.getColumnCount();

                List<Object> valores = new ArrayList<>();
                for (int col = 0; col < colCount; col++) {
                    valores.add(tblFuncionarios.getValueAt(row, col));
                }

                txtNome.setText(valores.get(1).toString());
                txtCPF.setText(valores.get(2).toString());
                txtTelefone.setText(valores.get(3).toString());
                txtCargo.setText(valores.get(4).toString());
                txtSalario.setText(valores.get(5).toString());
                txtDataAdmissao.setText(valores.get(6).toString());

                txtCEP.setText(valores.get(7).toString());
                txtEstado.setText(valores.get(8).toString());
                txtCidade.setText(valores.get(9).toString());
                txtBairro.setText(valores.get(10).toString());
                txtLogradouro.setText(valores.get(11).toString());
                cbComplemento.setSelectedItem(valores.get(12).toString());
                txtNumero.setText(valores.get(13).toString());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, "Erro ao carregar o funcionário: " + e.getMessage());
        }
   
    }//GEN-LAST:event_tblFuncionariosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCadastroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEnd;
    private javax.swing.JPanel Panelinf;
    private javax.swing.JScrollPane SPFuncionarios;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltarMenu;
    private javax.swing.JComboBox<String> cbComplemento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtDataAdmissao;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
