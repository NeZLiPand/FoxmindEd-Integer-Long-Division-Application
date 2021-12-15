package ua.com.foxminded.integerdivision.services;

import ua.com.foxminded.integerdivision.providers.IntegerLongDivisionProvider;
import ua.com.foxminded.integerdivision.validation.IntegerDivisionValidation;

public class IntegerLongDivisionCalculator {
    public static String longIntegerDivisionCalculation(int dividend, int divider) {
        IntegerDivisionValidation.validateValues(dividend, divider);
        IntegerLongDivisionProvider integerLongDivision = IntegerLongDivisionMath.provideMathDivision(dividend, divider);
        return IntegerLongDivisionView.convertOnLongIntegerDivision(integerLongDivision);
    }
}
