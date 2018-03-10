package dao;

import model.Department;
import model.Lector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Set;

public class DAO_universityApp {

    private SessionFactory sessionFactory;

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }


    public DAO_universityApp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Set<Department> getDepartments() {

        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Department.class);

        return (Set<Department>)criteria.list();
    }

    public Set<Lector> getLectors() {

        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Lector.class);

        return (Set<Lector>)criteria.list();
    }
}
