public class EmployeeBook {
    // for third lvl difficulty
    private final Employee[] EMPLOYEE_LIST = new Employee[10];

    public EmployeeBook() {
        initEmployees();
    }

    private void initEmployees() {
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

    public void printEmployees() {
        for (Employee employee : EMPLOYEE_LIST) {
            System.out.println(employee);
        }
    }

    public int salaryCosts() {
        int result = 0;
        for (Employee employee : EMPLOYEE_LIST) {
            result += employee.getSalary();
        }
        return result;
    }

    public Employee minSalaryEmployee() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEE_LIST) {
            int salary = employee.getSalary();
            if (employeeWithMinSalary == null || salary < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee maxSalaryEmployee() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEE_LIST) {
            int salary = employee.getSalary();
            if (employeeWithMaxSalary == null || salary > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public double averageSalaries() {
        return (double) salaryCosts() / EMPLOYEE_LIST.length;
    }

    public void printFullNames() {
        for (Employee employee : EMPLOYEE_LIST) {
            System.out.println(employee.getFullName());
        }
    }

    public void indexingSalaries(int percent) {
        for (Employee employee : EMPLOYEE_LIST) {
            int newSalary = employee.getSalary() + (employee.getSalary() * percent / 100);
            employee.setSalary(newSalary);
        }
    }

    public Employee minSalaryEmployeeByDep(int dep) {
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

    public Employee maxSalaryEmployeeByDep(int dep) {
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

    public int salaryCostsByDep(int dep) {
        int result = 0;
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                result += employee.getSalary();
            }
        }
        return result;
    }

    public double averageSalariesByDep(int dep) {
        int lengthSortedList = 0;
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                lengthSortedList++;
            }
        }
        return (double) salaryCosts() / lengthSortedList;
    }

    public void indexingSalariesByDep(int percent, int dep) {
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                int newSalary = employee.getSalary() + (employee.getSalary() * percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    public void printEmployees(int dep) {
        String stringDep = ", отдел №" + dep;
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getDepartament() == dep) {
                System.out.println(employee.toString().replace(stringDep, ""));
            }
        }
    }

    public void employeeWithLowerSalary(int num) {
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getSalary() < num) {
                System.out.println("Сотрудник (ID " + employee.getID() + "), '" + employee.getFullName() + "', ЗП " + employee.getSalary() + " руб.");
            }
        }
    }

    public void employeeWithHigherSalary(int num) {
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getSalary() >= num) {
                System.out.println("Сотрудник (ID " + employee.getID() + "), '" + employee.getFullName() + "', ЗП " + employee.getSalary() + " руб.");
            }
        }
    }

    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < EMPLOYEE_LIST.length; i++) {
            if (EMPLOYEE_LIST[i] == null) {
                EMPLOYEE_LIST[i] = newEmployee;
                System.out.println("Ячейка " + i + " была свободна и сотрудник был добавлен!");
                return true;
            }
        }
        return false;
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < EMPLOYEE_LIST.length; i++) {
            if (EMPLOYEE_LIST[i].getID() == id) {
                System.out.println(EMPLOYEE_LIST[i] + " был успешно найден и удалён!");
                EMPLOYEE_LIST[i] = null;
                return;
            }
        }
        System.out.println("Сотрудник с id " + id + " не найден!");
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        System.out.println("Сотрудник с id " + id + " не найден!");
        return null;
    }
}
