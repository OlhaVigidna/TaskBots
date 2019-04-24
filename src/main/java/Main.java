import models.Degree;
import models.Department;
import models.Lector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Lector.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Helper helper = new Helper(session);
        helper.menu();

        session.close();
        sessionFactory.close();
    }
}
