package ua.com.foxminded.integerdivision;

import java.util.Scanner;

import ua.com.foxminded.integerdivision.services.IntegerLongDivisionCalculator;

public class IntegerDivisionConsoleApplication {
    public static void main(String[] args) {
        Scanner streamIn = new Scanner(System.in);
        int dividend = 0;
        int divider = 0;
        System.out.print("Please enter dividend: ");
        dividend = streamIn.nextInt();
        System.out.print("Please enter divider: ");
        divider = streamIn.nextInt();
        System.out.println('\n' + IntegerLongDivisionCalculator.longIntegerDivisionCalculation(dividend, divider));
        streamIn.close();
    }
}
