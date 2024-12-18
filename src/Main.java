public class Main {
    private final static Employee[] EMPLOYEE_LIST = new Employee[10];

    public static void main(String[] args) {
        initEmployees();
        printEmployees();
        System.out.println("Общие затраты на зарплаты сотрудникам: " + salaryCosts());
        System.out.println("Сотрудник с минимальной ЗП: " + minSalaryEmployee());
        System.out.println("Сотрудник с максимальной ЗП: " + maxSalaryEmployee());
        System.out.println("Среднее значение зарплат сотрудников: " + averageSalaries());
        printFullNames();

        // second lvl difficulty
        indexingSalaries(5);
        System.out.println("Было произведено увеличение зарплат на определённый процент!");
        System.out.println("Сотрудник с минимальной зп в отделе: " + minSalaryEmployeeByDep(5));
        System.out.println("Сотрудник с максимальной зп в отделе: " + maxSalaryEmployeeByDep(3));
        System.out.println("Общие затраты на зарплаты сотрудникам в отделе: " + salaryCostsByDep(1));
        System.out.println("Среднее значение зарплат сотрудников в отделе: " + averageSalariesByDep(2));
        indexingSalariesByDep(5,2);
        printEmployees(4);
        System.out.println("Сотрудники с зарплатой ниже числа в параметрах: ");
        employeeWithLowerSalary(13000);
        System.out.println();
        System.out.println("Сотрудники с зарплатой выше или равному числу в параметрах: ");
        employeeWithHigherSalary(17000);

        // third lvl difficulty
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.printEmployees();
        Employee employee1 = new Employee("Иванов Иван Петрович", 1, 20000);
        if (!employeeBook.addEmployee(employee1)) {
            System.out.println("Сотрудник не был добавлен из-за нехватки ячеек.");
        } else {
            System.out.println("Сотрудник успешно добавлен!");
        }
        System.out.println(employeeBook.getEmployeeById(11));
        employeeBook.deleteEmployee(12);
        if (!employeeBook.addEmployee(employee1)) {
            System.out.println("Сотрудник не был добавлен из-за нехватки ячеек.");
        }
        System.out.println(employeeBook.getEmployeeById(21));
    }

    public static void initEmployees() {
        EMPLOYEE_LIST[0] = new Employee("Иванов Иван Иванович", 1, 10000);
        EMPLOYEE_LIST[1] = new Employee("Петров Петр Петрович", 2, 12000);
        EMPLOYEE_LIST[2] = new Employee("Сидоров Сидор Сидорович", 3, 11000);
        EMPLOYEE_LIST[3] = new Employee("Кузнецова Анна Сергеевна", 3, 15000);
        EMPLOYEE_LIST[4] = new Employee("Смирнова Ольга Викторовна", 1, 13000);
        EMPLOYEE_LIST[5] = new Employee("Ковалев Алексей Дмитриевич", 2, 14000);
        EMPLOYEE_LIST[6] = new Employee("Федорова Мария Александровна", 5, 16000);
        EMPLOYEE_LIST[7] = new Employee("Тихонов Сергей Валерьевич", 4, 11500);
        EMPLOYEE_LIST[8] = new Employee("Попова Екатерина Павловна", 4, 12500);
        EMPLOYEE_LIST[9] = new Employee("Григорьев Артем Юрьевич", 5, 17000);
    }

    public static void printEmployees() {
        for (Employee employee : EMPLOYEE_LIST) {
            System.out.println(employee);
        }
    }

    public static int salaryCosts() {
        int result = 0;
        for (Employee employee : EMPLOYEE_LIST) {
            result += employee.getSalary();
        }
        return result;
    }

    public static Employee minSalaryEmployee() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEE_LIST) {
            int salary = employee.getSalary();
            if (employeeWithMinSalary == null || salary < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee maxSalaryEmployee() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEE_LIST) {
            int salary = employee.getSalary();
            if (employeeWithMaxSalary == null || salary > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public static double averageSalaries() {
        return (double) salaryCosts() / EMPLOYEE_LIST.length;
    }

    public static void printFullNames() {
        for (Employee employee : EMPLOYEE_LIST) {
            System.out.println(employee.getFullName());
        }
    }

    // second lvl difficulty
    public static void indexingSalaries(int percent) {
        for (Employee employee : EMPLOYEE_LIST) {
            int newSalary = employee.getSalary() + (employee.getSalary() * percent / 100);
            employee.setSalary(newSalary);
        }
    }

    public static Employee minSalaryEmployeeByDep(int dep) {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                int salary = employee.getSalary();
                if (employeeWithMinSalary == null || salary < employeeWithMinSalary.getSalary()) {
                    employeeWithMinSalary = employee;
                }
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee maxSalaryEmployeeByDep(int dep) {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                int salary = employee.getSalary();
                if (employeeWithMaxSalary == null || salary > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = employee;
                }
            }
        }
        return employeeWithMaxSalary;
    }

    public static int salaryCostsByDep(int dep) {
        int result = 0;
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                result += employee.getSalary();
            }
        }
        return result;
    }

    public static double averageSalariesByDep(int dep) {
        int lengthSortedList = 0;
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                lengthSortedList++;
            }
        }
        return (double) salaryCosts() / lengthSortedList;
    }

    public static void indexingSalariesByDep(int percent, int dep) {
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                int newSalary = employee.getSalary() + (employee.getSalary() * percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    public static void printEmployees(int dep) {
        String stringDep = ", отдел №" + dep;
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                System.out.println(employee.toString().replace(stringDep, ""));
            }
        }
    }

    public static void employeeWithLowerSalary(int num) {
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getSalary() < num) {
                System.out.println("Сотрудник (ID " + employee.getID() + "), '" + employee.getFullName() + "', ЗП " + employee.getSalary() + " руб.");
            }
        }
    }

    public static void employeeWithHigherSalary(int num) {
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getSalary() >= num) {
                System.out.println("Сотрудник (ID " + employee.getID() + "), '" + employee.getFullName() + "', ЗП " + employee.getSalary() + " руб.");
            }
        }
    }
}