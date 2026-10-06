import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        int principal = (int) readNumber("principal", 1_000, 1_000_000);

        float annualInterest = (float) readNumber("Annual Interest Rate", 0 , 30);

        byte years = (byte) readNumber("period (years)", 1, 35);





       double mortgage =  calculateMortgage(principal, annualInterest, years);






        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));


        }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {


        final int MONTH_IN_YEARS = 12;
        final byte PERCENT = 100;
        float numberOfPayments = years * MONTH_IN_YEARS;
        float monthlyInterestRate = annualInterest / PERCENT / MONTH_IN_YEARS;

        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return mortgage;


    }

    public static double readNumber (
            String prompt,
            double min,
            double max) {

        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt + " :");
            value = scanner.nextDouble();

            if (value >= min && value <= max)
                break;

            System.out.println("Enter a number between " + (int) min + " and " + (int) max);


        }

        return value;
    }



        }
