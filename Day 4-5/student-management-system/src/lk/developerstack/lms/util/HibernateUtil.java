package lk.developerstack.lms.util;

import lk.developerstack.lms.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {
    private static HibernateUtil hibernateUtil;
    private final static SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil() {
    }

    public static HibernateUtil getInstance() {
        return (hibernateUtil == null ? hibernateUtil = new HibernateUtil() : hibernateUtil);
    }

    private static SessionFactory buildSessionFactory() {
        Properties properties = new Properties();
        try (InputStream in = ClassLoader.getSystemResourceAsStream("hibernate.properties")) {
            if (in == null) {
                throw new IllegalStateException("Missing hibernate.properties on classpath");
            }
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load hibernate.properties", e);
        }
        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Student.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Registration.class);
        return configuration.buildSessionFactory();


        /*
        * public class FactoryConfig {
    private static FactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private FactoryConfig() {

        Configuration config = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(Program.class).addAnnotatedClass(Registration.class);
        sessionFactory = config.buildSessionFactory();
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static FactoryConfig getInstance() {
        return factoryConfig == null ? factoryConfig = new FactoryConfig() : factoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
        *
        *
        * */

        /*StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)

                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();*/

    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

}
