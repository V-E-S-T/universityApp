package dao;

import model.Degree;
import model.Department;
import model.Lector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DAO_universityApp {

    private SessionFactory sessionFactory;

    public DAO_universityApp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String getHead(String departmentName){
        Department department = getDepartmentByName(departmentName);

        return null !=  department ? department.getHead(): "Invalid Department name. Try again.";
    }

    public String showStatistic(String departmentName){
        Department department = getDepartmentByName(departmentName);

        if (null != department)
        {
            Map<Degree, List<Lector>> lectorsByDegree = department.getLectors().stream()
                    .collect(Collectors.groupingBy(Lector :: getDegree));

            return lectorsByDegree != null ? lectorsByDegree.entrySet().stream()
                    .map(entry -> entry.getKey().toString() + " - " + entry.getValue().size())
                    .collect(Collectors.joining("\n")) : "No statistic for this department";
        }
        else
            return "Invalid Department name. Try again.";
    }

    public String averageSalary(String departmentName){
        Department department = getDepartmentByName(departmentName);
        return department != null
                ? "The average salary of " + department.getName() + " is "
                + department.getLectors().stream().mapToInt(Lector::getSalary).sum()/department.getLectors().size()
                : "No data for this department";
    }

    public String countOfEmployee(String departmentName){
        Department department = getDepartmentByName(departmentName);
        return String.valueOf(department != null ? department.getLectors().size() : 0);
    }

    public String globalSearch(String template){
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Lector.class);
        List<Lector> resultList = criteria.add(Restrictions.like("name", "%" + template + "%")).list();
        String resultSearch = resultList.stream().map(Lector::getName).collect(Collectors.joining(", "));
        return !Objects.equals(resultSearch, "") ? resultSearch : "Nothing found";
    }

    private Department getDepartmentByName(String departmentName){
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Department.class);
        List<Department> departments = criteria.add(Restrictions.eq("name", departmentName)).setMaxResults(1).list();
        return departments.size() != 0 ? departments.get(0) : null;
    }
}
