import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;

public class CAI {
    public static double calculation(double num1, double num2, int questionType, SecureRandom random) {
        double calc = 0;
        if (questionType == 5) {
            questionType = random.nextInt(4) + 1;
        }
        switch (questionType) {
            case 1:
                calc = num1 + num2;
                System.out.println("How much is " + num1 + " plus " + num2 + "?");
                break;
            case 2:
                calc = num1 * num2;
                System.out.println("How much is " + num1 + " times " + num2 + "?");
                break;
            case 3:
                calc = num1 - num2;
                System.out.println("How much is " + num1 + " minus " + num2 + "?");
                break;
            case 4:
                calc = num1 / num2;
                System.out.println("How much is " + num1 + " divided by " + num2 + "?");
                break;

        }
        return calc;

    }


    public static double getNumber(SecureRandom random, int difficulty, int questionType) {
        double num1 = 0;
        double num2 = 0;
        switch (difficulty) {
            case 1:
                num1 = random.nextInt(10);
                num2 = random.nextInt(10);
                break;
            case 2:
                num1 = random.nextInt(20) + 10;
                num2 = random.nextInt(20);
                break;
            case 3:
                num1 = random.nextInt(100);
                num2 = random.nextInt(20);
                ;
                break;
            case 4:
                num1 = random.nextInt(100);
                num2 = random.nextInt(100);
                break;

        }
        double correct = calculation(num1, num2, questionType, random);


        return correct;
    }

    public static void response(int response) {

        switch (response) {
            case 0:
                System.out.println("No. Please try again");

                break;
            case 1:
                System.out.println("Wrong. Try once more.");

                break;
            case 2:
                System.out.println("Don't give up!");

                break;
            case 3:
                System.out.println("No. Keep trying.");

                break;
            case 4:
                System.out.println("Very good!");

                break;
            case 5:
                System.out.println("Excellent!");

                break;
            case 6:
                System.out.println("Nice work!");

                break;
            case 7:
                System.out.println("Keep up the good work");

                break;
        }

    }

    public static void main(String[] args) {
        SecureRandom secure = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        double correctAnswer;
        double x = 0;
        int y = 0;
        while (y != 1) {
            System.out.println("What difficulty do you want?\n 1.Easy \n 2.Normal\n 3.Hard\n 4.Very Hard\n");
            int difficulty = scnr.nextInt();
            System.out.println("What type of question do you want?\n 1.Addition\n 2.Multiplication\n 3.Subtraction\n 4.division\n 5.Random mixture\n");
            int questionType = scnr.nextInt();
            correctAnswer = getNumber(secure, difficulty, questionType);
            for (int i = 0; i < 10; i++) {
                int ans = rand.nextInt(4);
                double studentAnswer = scnr.nextDouble();
                if (java.lang.Math.abs(studentAnswer - correctAnswer) < 0.0000001) {
                    ans = ans + 4;
                    x = x + 1;
                } else {
                    ans = rand.nextInt(4);
                }
                response(ans);
                if (i < 9) {
                    correctAnswer = getNumber(secure, difficulty, questionType);
                }
            }
            double percentRight = (x / 10) * 100;
            if ((percentRight) - 75 >= 0.000000001) {
                System.out.println("Congratulations, you are ready ready to go to the next level!");
            } else {
                System.out.println("Please ask your teacher for extra help");
            }
            System.out.println("Do you wish to start another session?\n0 for yes, 1 for no");
            y = scnr.nextInt();
        }

    }

}
