class EmployeeStatic {

    // Instance variables
    String empName;
    double salary;

    // Static variable shared by all employees
    static String companyName = "Bright Horizon Technologies";

    // Static counter
    static int employeeCount = 0;

    EmployeeStatic(String empName, double salary) {

        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println("Employees on record: "
                + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeStatic e1 =
                new EmployeeStatic("Ravi", 50000);

        EmployeeStatic e2 =
                new EmployeeStatic("Priya", 60000);

        EmployeeStatic e3 =
                new EmployeeStatic("Arjun", 55000);

        EmployeeStatic.printCompanyInfo();
    }
}