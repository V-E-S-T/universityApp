package dao;

import model.Department;
import model.Lector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAO_universityApp {

    private SessionFactory sessionFactory;

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }


    public DAO_universityApp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Department> getDepartments() {

        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Department.class);
        //departmentSet.addAll(criteria.list());
        //session.close();

        return new ArrayList<Department>(criteria.list());
    }

    public List<Lector> getLectors() {

        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Lector.class);
//        Set<Lector> lectorSet = new HashSet<>();
//        lectorSet.addAll(criteria.list());
        //session.close();

        return new ArrayList<Lector>(criteria.list());
    }
}
