import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int principal = 0;
        float annualInterest = 0;
        byte years = 0;

        Scanner scanner = new Scanner(System.in);

        ;
            while (true) {
                System.out.print("Principal ($1K ~ $1M) :");
                principal = scanner.nextInt();

                if (principal >=1_000 && principal <= 1_000_000)
                    break;

                System.out.println("Enter a number between 1,000 and 1,000,000");


            }
        ;
            while (true){
                System.out.print("Annual Interest Rate: ");
                annualInterest = scanner.nextFloat();

                if (annualInterest > 0 && annualInterest <= 30)
                    break;

                System.out.println("Enter a value greater than 0 and less than or equal to 30");
            }


            while (true){
                System.out.print("period (years): ");
                years = scanner.nextByte();
                if ( years >=1 &&  years <=35)
                    break;

                System.out.println("enter a value between 1 and 30");

            }


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




        }
