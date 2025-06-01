/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.UsuarioLoginModel;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Nara Rubia B. Balena
 */
public class UsuarioLoginDAO {
    
    public UsuarioLoginModel login(String usuario, String senha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery(
                    "FROM UsuarioLoginModel WHERE usuario = :usuario AND senha = :senha",
                    UsuarioLoginModel.class)
                    .setParameter("usuario", usuario)
                    .setParameter("senha", senha)
                    .uniqueResult();
        } finally {
            session.close();
        }
    }
}
