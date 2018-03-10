import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import services.Department_services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }


        Department_services department_services = new Department_services();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            System.out.println("Please, enter 1 if you want see HEAD OF DEPARTMENT\n" +
                               "Please, enter 2 if you want see DEPARTMENT STATISTIC\n" +
                               "Please, enter 3 if you want see AVERAGE SALARY OF DEPARTMENT\n" +
                               "Please, enter 4 if you want see COUNT OF EMPLOYEE FOR DEPARTMENT\n" +
                               "Please, enter 5 for GLOBAL SEARCH");
            String commandName = reader.readLine();
            switch (commandName)
            {
                case "1":
                {
                    System.out.println("Please, enter DEPARTMENT NAME");
                    String departmentName = reader.readLine();
                    System.out.println(
                           department_services.getHeadOfDepartment(departmentName));
                }
                case "2":
                {
                    System.out.println("Please, enter DEPARTMENT NAME");
                    String departmentName = reader.readLine();
                    System.out.println(
                           department_services.showStatistic(departmentName));
                }
                case "3":
                {
                    System.out.println("Please, enter DEPARTMENT NAME");
                    String departmentName = reader.readLine();
                    //System.out.println(
                    //       department_services.getHeadOfDepartment(departmentName));
                }
                case "4":
                {
                    System.out.println("Please, enter DEPARTMENT NAME");
                    String departmentName = reader.readLine();
//                    System.out.println(
//                           department_services.getHeadOfDepartment(departmentName));
                }
                case "5":
                {
                    System.out.println("Please, enter your QUERY FOR GLOBAL SEARCH");
                    String departmentName = reader.readLine();
//                    System.out.println(
//                           department_services.getHeadOfDepartment(departmentName));
                }
                default:
                    System.out.println("Invalid command. Try again");
            }
        }
    }
}