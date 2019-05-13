package AppPackage;

import DatabasePackage.*;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory(){}
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration().configure();
                configuration.configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(DepartmentEntity.class);
                configuration.addAnnotatedClass(CalendarEntity.class);
                configuration.addAnnotatedClass(MarkEntity.class);
                configuration.addAnnotatedClass(EmployeesEntity.class);
                configuration.addAnnotatedClass(PositionEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
