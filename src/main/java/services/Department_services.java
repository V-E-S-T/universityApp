package services;


import dao.DAO_universityApp;
import model.Degree;
import model.Department;
import model.Lector;
import util.HibernateSessionFactory;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Department_services {

    private DAO_universityApp dao_universityApp = new DAO_universityApp(HibernateSessionFactory.getSessionFactory());

    private Set<Department> departmentSet = dao_universityApp.getDepartments();

    private Set<Lector> lectorSet = dao_universityApp.getLectors();

    public String getHeadOfDepartment(String departmentName)
    {
        Department department = getDepartmentByName(departmentName);
        //departmentSet.forEach((department) -> );
        //departmentSet.stream().filter(department ->  (department.getHead_department()).equals(departmentName));
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
            Map<Degree, Long> statistic = department.getLectors().stream()
                                .collect(Collectors.groupingBy(Lector::getDegree, Collectors.counting()));
            return statistic != null ? statistic.entrySet().stream()
                    .map(entry -> entry.getKey().toString() + " - " + entry.getValue())
                    .collect(Collectors.joining("\n")) : "No statistic for this department";
        }
        else
            return "Invalid Department name. Try again.";
    }

    private Department getDepartmentByName(String departmentName)
    {
        for (Department department: departmentSet)
        {
            if (departmentName.equals(department.getName_department()))
            {
                return department;
            }
        }
        return null;
    }

    }



