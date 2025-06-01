/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.hibernate.cadastroloja;

import util.HibernateUtil;
import javax.swing.JOptionPane;
import view.FrmLogin;
import javax.swing.UIManager;
import org.hibernate.Session;

public class CadastroLoja {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            Session session = HibernateUtil.getSession();
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            session.close();
            FrmLogin frmLogin = new FrmLogin();
            frmLogin.setVisible(true);
            frmLogin.setLocationRelativeTo(null);
        } catch (Exception e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Conexão com o banco de dados encerrada.");
        }
    }
}
