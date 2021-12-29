package ua.com.foxminded.integerdivision;

import java.util.Scanner;

import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionMathProvider;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionMathProviderImpl;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionViewProvider;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionViewProviderImpl;
import ua.com.foxminded.integerdivision.service.IntegerLongDivisionCalculator;
import ua.com.foxminded.integerdivision.validator.IntegerLongDivisionValidator;
import ua.com.foxminded.integerdivision.validator.IntegerLongDivisionValidatorImpl;

public class IntegerDivisionConsoleApplication {
    public static void main(String[] args) {
        IntegerLongDivisionValidator integerLongDivisionValidator = new IntegerLongDivisionValidatorImpl();
        IntegerLongDivisionMathProvider integerLongDivisionMathProvider = new IntegerLongDivisionMathProviderImpl();
        IntegerLongDivisionViewProvider integerLongDivisionViewProvider = new IntegerLongDivisionViewProviderImpl();
        Scanner streamIn = new Scanner(System.in);
        IntegerLongDivisionCalculator integerLongDivisionCalculator = new IntegerLongDivisionCalculator(
                    integerLongDivisionValidator, integerLongDivisionMathProvider, integerLongDivisionViewProvider);
        System.out.print("Please enter divided: ");
        int divided = streamIn.nextInt();
        System.out.print("Please enter divisor: ");
        int divisor = streamIn.nextInt();
        String result = integerLongDivisionCalculator.calculateDivision(divided, divisor);
        System.out.println("Result: ");
        System.out.println(result);
        streamIn.close();
    }
}
