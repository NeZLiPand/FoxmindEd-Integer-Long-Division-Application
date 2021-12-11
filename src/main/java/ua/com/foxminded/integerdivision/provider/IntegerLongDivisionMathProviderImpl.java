package ua.com.foxminded.integerdivision.provider;

import java.util.LinkedList;
import java.util.List;

import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionStep;
import ua.com.foxminded.integerdivision.utility.IntegerCalculationUtilities;

public class IntegerLongDivisionMathProviderImpl implements IntegerLongDivisionMathProvider {

    @Override
    public IntegerLongDivisionResult provideMathIntegerLongDivision(int divided,
                                                                    int divisor) {
        int quotient = divided / divisor;
        int[] digitsFromQuotient = IntegerCalculationUtilities.arrayInitializationByDigitsOfNumber(quotient);
        int amountOfDivisionSteps = digitsFromQuotient.length;
        int minuend = divided / (int) Math.pow(10, amountOfDivisionSteps - 1);
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(minuend, digitsFromQuotient[0] * divisor));
        minuend = minuend - (digitsFromQuotient[0] * divisor);
        for (int iterator = 1; iterator < amountOfDivisionSteps; iterator++) {
            if (minuend != 0) {
                if (minuend < divisor) {
                    minuend = minuend * 10
                        + IntegerCalculationUtilities.digitFromNumber(divided, amountOfDivisionSteps - iterator);
                }
            } else {
                minuend = IntegerCalculationUtilities.digitFromNumber(divided, amountOfDivisionSteps - iterator);
            }
            if ((minuend == 0) ||
                (minuend >= divisor)) {
                divisionSteps.add(new IntegerLongDivisionStep(minuend, digitsFromQuotient[iterator] * divisor));
                minuend = minuend - digitsFromQuotient[iterator] * divisor;
            }
        }
        return IntegerLongDivisionResult.builder()
                                        .withDivided(divided)
                                        .withDivisor(divisor)
                                        .withRemainder(minuend)
                                        .withDivisionSteps(divisionSteps)
                                        .build();
    }
}
