public class Employee {
    private String fullName;
    private int departament;
    private int salary;
    private static int ID;

    public Employee(String fullName, int departament, int salary) {
        this.fullName = fullName;
        this.departament = departament;
        this.salary = salary;
        Employee.ID++;
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartament() {
        return departament;
    }

    public int getSalary() {
        return salary;
    }

    public static int getID() {
        return ID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
