package services;


import dao.DAO_universityApp;
import util.HibernateSessionFactory;

public class Department_services {

    private DAO_universityApp DAO_universityApp = new DAO_universityApp(HibernateSessionFactory.getSessionFactory());

    public String getHead(String departmentName)
    {
        return DAO_universityApp.getHead(departmentName);
    }

    public String showStatistic(String departmentName)
    {
        return DAO_universityApp.showStatistic(departmentName);
    }

    public String averageSalary(String departmentName)
    {
        return DAO_universityApp.averageSalary(departmentName);
    }

    public String countOfEmployee(String departmentName)
    {
        return DAO_universityApp.countOfEmployee(departmentName);
    }

    public String globalSearch(String template)
    {
        return DAO_universityApp.globalSearch(template);
    }

    public static void enterName()
    {
        System.out.println("HEAD OF DEPARTMENT: Please, enter DEPARTMENT NAME:\n" +
                "physic\n" +
                "mathematics\n" +
                "chemistry\n" +
                "biology\n" +
                "economic");
    }
}



