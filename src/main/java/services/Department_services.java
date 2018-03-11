package services;


import dao.DAO_universityApp;
import model.Degree;
import model.Department;
import model.Lector;
import util.HibernateSessionFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Department_services {

    private DAO_universityApp dao_universityApp = new DAO_universityApp(HibernateSessionFactory.getSessionFactory());

    private List<Department> departmentList = dao_universityApp.getDepartments();

    private List<Lector> lectorList = dao_universityApp.getLectors();

    public String getHeadOfDepartment(String departmentName)
    {
        Department department = getDepartmentByName(departmentName);

        if (null != department)
        {
            return "Head of " + departmentName + " department is " + department.getHead_department();
        }
        else
            return "Invalid Department name. Try again.";
    }

    public String showStatistic(String departmentName)
    {
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

    public String averageSalary(String departmentName)
    {
        Department department = getDepartmentByName(departmentName);
        return department != null
                ? "The average salary of " + department.getName_department() + " is "
                + department.getLectors().stream().mapToInt(Lector::getSalary).sum()/department.getLectors().size()
                : "No data for this department";
    }

    public String countOfEmployee(String departmentName)
    {
        Department department = getDepartmentByName(departmentName);
        return String.valueOf(department != null ? department.getLectors().size() : 0);
    }

    public String globalSearch(String template)
    {
        String resultSearch = lectorList.stream().filter(lector -> lector.getName().toLowerCase().contains(template))
                .map(Lector::getName).collect(Collectors.joining(", "));
        return !Objects.equals(resultSearch, "") ? resultSearch : "Nothing found";
    }

    public static void enterDepartmentNameMessage()
    {
        System.out.println("HEAD OF DEPARTMENT: Please, enter DEPARTMENT NAME:\n" +
                "physic\n" +
                "mathematics\n" +
                "chemistry\n" +
                "biology\n" +
                "economic");
    }

    private Department getDepartmentByName(String departmentName)
    {
        for (Department department: departmentList)
        {
            if (departmentName.equals(department.getName_department()))
            {
                return department;
            }
        }
        return null;
    }
}



