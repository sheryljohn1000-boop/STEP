class PayrollAccount {

    private double basicSalary;
    private double bonus;

    // Constructor
    public PayrollAccount(double basicSalary) {

        if (basicSalary < 0) {
            this.basicSalary = 0;
            System.out.println("Negative salary not allowed. Starting with 0.");
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    // Add bonus
    public void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be positive.");
        } else {
            bonus = bonus + amount;
        }
    }

    // Deduct tax
    public void deductTax(double percent) {

        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percent must be between 0 and 100.");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
        }
    }

    // Getter
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        PayrollAccount account = new PayrollAccount(50000);

        account.creditBonus(5000);

        System.out.println("Bonus credited: Rs " + 5000.0);

        account.deductTax(10);

        System.out.println("Tax deducted: 10%");

        System.out.println("Net salary: " + account.getNetSalary());
    }
}