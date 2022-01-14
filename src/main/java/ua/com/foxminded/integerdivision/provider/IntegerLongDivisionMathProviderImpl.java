package ua.com.foxminded.integerdivision.provider;

import java.util.LinkedList;
import java.util.List;

import ua.com.foxminded.integerdivision.genus.IntegerDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionStep;
import ua.com.foxminded.integerdivision.utility.IntegerCalculationUtilities;

public class IntegerLongDivisionMathProviderImpl implements IntegerLongDivisionMathProvider {
    private static final int DECIMAL_BASE = 10;

    @Override
    public IntegerLongDivisionResult provideMathIntegerLongDivision(int divided,
                                                                    int divisor) {
        return DivisionResult(divided, divisor);
    }

    private IntegerLongDivisionResult DivisionResult(int divided,
                                                     int divisor) {
        int quotient = divided / divisor;
        int[] digitsFromQuotient = IntegerCalculationUtilities.arrayInitializationByDigitsOfNumber(quotient);
        int amountOfDivisionSteps = digitsFromQuotient.length;
        int numerator = divided / (int) Math.pow(DECIMAL_BASE, amountOfDivisionSteps - 1);
        int remainderOfTheDivision = 0;
        List<IntegerLongDivisionStep> integerLongDivisionSteps = new LinkedList<>();
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(numerator, digitsFromQuotient[0] * divisor));
        numerator = numerator - (digitsFromQuotient[0] * divisor);
        for (int iterator = 1; iterator < amountOfDivisionSteps; iterator++) {
            if (numerator != 0) {
                if (numerator < divisor) {
                    numerator = numerator * DECIMAL_BASE
                        + IntegerCalculationUtilities.digitFromNumber(divided, amountOfDivisionSteps - iterator);
                }
            } else {
                numerator = IntegerCalculationUtilities.digitFromNumber(divided, amountOfDivisionSteps - iterator);
            }
            if ((numerator == 0) ||
                (numerator >= divisor)) {
                integerLongDivisionSteps
                            .add(new IntegerLongDivisionStep(numerator, digitsFromQuotient[iterator] * divisor));
                numerator = numerator - digitsFromQuotient[iterator] * divisor;
            }
        }
        remainderOfTheDivision += numerator;
        IntegerDivisionResult integerDivisionResult = new IntegerDivisionResult(divided, divisor,
                    remainderOfTheDivision);
        return new IntegerLongDivisionResult(integerDivisionResult, integerLongDivisionSteps);
    }
}
