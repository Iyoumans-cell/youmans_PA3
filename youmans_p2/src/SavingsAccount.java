public class SavingsAccount {


    private static double annualInterestRate;
    private double savingsBalance;
    double monthlyInterest;
    private double switchValues;

    public void setSavingsBalance(double savings) {
        savingsBalance = savings;

    }

    public static Double modifyInterestRate(Double aIR) {
        annualInterestRate = aIR;
        return annualInterestRate;
    }

    public double calculateMonthlyInterestRate() {
        monthlyInterest = ((annualInterestRate / 100) / 12) * savingsBalance;
        savingsBalance = monthlyInterest + savingsBalance;
        return monthlyInterest;
    }


    public void printMonthlyInterest() {
        System.out.printf("%.2f", monthlyInterest);
    }

    public double getSavingsBalance() {
        System.out.printf("%.2f\n", savingsBalance);
        return savingsBalance;
    }

}