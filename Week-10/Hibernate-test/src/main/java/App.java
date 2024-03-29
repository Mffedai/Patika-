import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // Hibernate Configuration
        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");

        // Build Hibernate Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session
        try (Session session = sessionFactory.openSession()) {
            // Hibernate operations go here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
