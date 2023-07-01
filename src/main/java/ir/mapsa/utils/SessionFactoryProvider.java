package ir.mapsa.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    private static SessionFactory sf;


    private SessionFactoryProvider() {
    }


    public static SessionFactory getSessionFactory() {
        if (sf == null) {
            Configuration cfg = new Configuration();
            cfg.configure();
            SessionFactory sf = cfg.buildSessionFactory();
            return sf;

        }
        return sf;
    }
}
