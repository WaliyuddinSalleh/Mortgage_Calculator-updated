import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static byte MONTH_IN_YEARS = 12;
    final static byte PERCENT = 100;


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int principal = (int) readNumber("principal", 1_000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate", 0 , 30);
        byte years = (byte) readNumber("period (years)", 1, 35);

        printMortgage(principal, annualInterest, years);

        printPaymentSchedule(years, principal, annualInterest);


    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage =  calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage Payments: " + mortgageFormatted) ;
    }

    private static void printPaymentSchedule(byte years, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (short month = 1; month <= years * MONTH_IN_YEARS; month++){
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));

        }
    }

    public static double calculateBalance (
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade){



        float numberOfPayments = years * MONTH_IN_YEARS;
        float monthlyInterestRate = annualInterest / PERCENT / MONTH_IN_YEARS;

        double balance = principal * (Math.pow(1 + monthlyInterestRate, numberOfPayments) -
                Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade)) / (Math.pow(1 +
                monthlyInterestRate, numberOfPayments) - 1);

        return balance;

    }




    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {



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
