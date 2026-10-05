import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final int MONTH_IN_YEARS = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        int principal;
            while (true) {
                System.out.print("Principal ($1K ~ $1M) :");
                principal = scanner.nextInt();

                if (principal >=1_000 && principal <= 1_000_000)
                    break;

                System.out.println("Enter a number between 1,000 and 1,000,000");


            }
        float annualInterestRate;
            while (true){
                System.out.print("Annual Interest Rate: ");
                annualInterestRate = scanner.nextFloat();

                if (annualInterestRate > 0 && annualInterestRate <= 30)
                    break;

                System.out.println("Enter a value greater than 0 and less than or equal to 30");
            }

        byte years;
            while (true){
                System.out.println("period (years): ");
                years = scanner.nextByte();
                if ( years >=1 &&  years <=35)
                    break;

                System.out.println("enter a value between 1 and 30");

            }


        double monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEARS;
        int numberOfPayments = years * MONTH_IN_YEARS;


        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);


        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));


        }






        }
