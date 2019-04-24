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

//        session.beginTransaction();


//
//        Department department = new Department();
//        Lector lector = new Lector();
//        Lector lector2 = new Lector();
//        department.setDepartmentName("Tormund");
//        lector.setLectorDegree(Degree.PROFESSOR);
//        lector.setLectorSalary(2340);
//        lector2.setLectorDegree(Degree.ASSOCIATE_PROFESSOR);
//        lector2.setLectorSalary(2500);
//        lector2.setLectorName("Name");
//        lector2.setLectorSurname("Surname");
//        department.getLectors().add(lector);
//        department.getLectors().add(lector2);
//        department.setHeadOfDepartment(lector2);
//        session.save(department);

//        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
