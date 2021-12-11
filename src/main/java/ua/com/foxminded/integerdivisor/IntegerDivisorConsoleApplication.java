package ua.com.foxminded.integerdivisor;

import java.util.Scanner;

public class IntegerDivisorConsoleApplication {
    public static void main(String[] args) {
        Scanner streamIn = new Scanner(System.in);
        System.out.print("Please enter divided: ");
        int divided = streamIn.nextInt();
        System.out.print("Please enter divisor: ");
        int divisor = streamIn.nextInt();
        IntegerDivisor integerDivisor = new IntegerDivisor(divided, divisor);
        System.out.println('\n' + ViewIntegerDivision.viewLongIntegerDivision(integerDivisor));
        streamIn.close();
    }
}
