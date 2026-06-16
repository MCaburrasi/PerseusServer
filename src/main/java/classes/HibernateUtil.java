package classes;


import org.apache.ibatis.jdbc.ScriptRunner;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = buildSessionFactory();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static SessionFactory buildSessionFactory() throws IOException, SQLException, ClassNotFoundException {
        do {
            try {
                // Create the SessionFactory from hibernate.cfg.xml
                return new Configuration().configure()
                        .buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
            } catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        } while (true);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
