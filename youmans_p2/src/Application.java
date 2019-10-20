import org.junit.Test;

import static org.junit.Assert.*;

public class Application {

    @Test
    public void checkMonthlyInterest() {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.modifyInterestRate(4.00);
        saver1.setSavingsBalance(2000);
        saver2.setSavingsBalance(3000);

        double[] expectedsaver1 = {6.67, 6.69, 6.71, 6.73, 6.76, 6.78, 6.80, 6.82, 6.85, 6.87, 6.89, 6.92};
        double[] expectedsaver2 = {10.00, 10.03, 10.07, 10.10, 10.13, 10.17, 10.20, 10.24, 10.27, 10.30, 10.34, 10.37};


        double[] monthly = new double[12];
        for (int i = 0; i < 12; i++) {
            monthly[i] = saver1.calculateMonthlyInterestRate();
            assertEquals(monthly[i], expectedsaver1[i], 0.01);
            monthly[i] = saver2.calculateMonthlyInterestRate();
            assertEquals(monthly[i], expectedsaver2[i], 0.01);
        }
        assertEquals(saver1.getSavingsBalance(), 2081.48, 0.01);
        assertEquals(saver2.getSavingsBalance(), 3122.22, 0.01);

        saver1.setSavingsBalance(2000);
        saver2.setSavingsBalance(3000);
        saver1.modifyInterestRate(5.00);

        double MIR = saver1.calculateMonthlyInterestRate();
        assertEquals(MIR, 8.33, 0.01);
        MIR = saver2.calculateMonthlyInterestRate();
        assertEquals(MIR, 12.50, 0.01);
        assertEquals(saver1.getSavingsBalance(), 2008.33, 0.01);
        assertEquals(saver2.getSavingsBalance(), 3012.50, 0.01);
    }


}
