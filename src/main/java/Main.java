import services.Department_services;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(final String[] args) throws Exception {

        Department_services department_services = new Department_services();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String commandName;
            while (true)
            {
                System.out.println("Please, enter 1 if you want see HEAD OF DEPARTMENT\n" +
                        "Please, enter 2 if you want see DEPARTMENT STATISTIC\n" +
                        "Please, enter 3 if you want see AVERAGE SALARY OF DEPARTMENT\n" +
                        "Please, enter 4 if you want see COUNT OF EMPLOYEE FOR DEPARTMENT\n" +
                        "Please, enter 5 for GLOBAL SEARCH\n" +
                        "Please, enter 6 for EXIT");

                commandName = reader.readLine();

                switch (commandName)
                {
                    case "1":
                    {
                        Department_services.enterDepartmentNameMessage();
                        String departmentName = reader.readLine();
                        System.out.println(
                                department_services.getHeadOfDepartment(departmentName));
                        break;
                    }
                    case "2":
                    {
                        Department_services.enterDepartmentNameMessage();
                        String departmentName = reader.readLine();
                        System.out.println(
                                department_services.showStatistic(departmentName));
                        break;
                    }
                    case "3":
                    {
                        Department_services.enterDepartmentNameMessage();
                        String departmentName = reader.readLine();
                        System.out.println(
                               department_services.averageSalary(departmentName));
                        break;
                    }
                    case "4":
                    {
                        Department_services.enterDepartmentNameMessage();
                        String departmentName = reader.readLine();
                        System.out.println(
                               department_services.countOfEmployee(departmentName));
                        break;
                    }
                    case "5":
                    {
                        System.out.println("GLOBAL SEARCH: Please, enter your QUERY FOR GLOBAL SEARCH");
                        String template = reader.readLine();
                        System.out.println(
                               department_services.globalSearch(template));
                        break;
                    }
                    case "6":
                    {
                        System.out.println("EXIT program");
                        System.exit(0);
                    }
                    default:
                        System.out.println("Invalid command. Try again");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}