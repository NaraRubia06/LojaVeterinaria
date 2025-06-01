/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.ClienteModel;
import model.FornecedorModel;
import java.util.Properties;
import model.AnimalModel;
import model.ConsultaModel;
import model.FuncionarioModel;
import model.ProdutoModel;
import model.UsuarioLoginModel;
import model.VendaModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/** @author Nara Rubia B. Balena */

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Properties settings = new Properties();
            settings.put(AvailableSettings.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
            settings.put(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/CadastroLoja");
            settings.put(AvailableSettings.JAKARTA_JDBC_USER, "postgres");
            settings.put(AvailableSettings.JAKARTA_JDBC_PASSWORD, "nara");
            settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.put(AvailableSettings.HBM2DDL_AUTO, "update");
            settings.put(AvailableSettings.SHOW_SQL, "true");
            settings.put(AvailableSettings.FORMAT_SQL, "true");

            Configuration configuration = new Configuration();
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(ClienteModel.class);
            configuration.addAnnotatedClass(FornecedorModel.class);
            configuration.addAnnotatedClass(FuncionarioModel.class); 
            configuration.addAnnotatedClass(ProdutoModel.class); 
            configuration.addAnnotatedClass(VendaModel.class); 
            configuration.addAnnotatedClass(AnimalModel.class); 
            configuration.addAnnotatedClass(ConsultaModel.class); 
             configuration.addAnnotatedClass(UsuarioLoginModel.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            System.err.println("Erro ao criar SessionFactory: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
    
}
/*
HibernateUtil é o pilar da infraestrutura de conexão com o banco de dados no seu sistema
*/