package ua.com.foxminded.integerdivision.service;

import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionMathProvider;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionViewProvider;
import ua.com.foxminded.integerdivision.validator.IntegerLongDivisionValidator;

public class IntegerLongDivisionCalculator {
    private final IntegerLongDivisionValidator integerLongDivisionValidator;
    private final IntegerLongDivisionMathProvider integerLongDivisionMathProvider;
    private final IntegerLongDivisionViewProvider integerLongDivisionViewProvider;

    public IntegerLongDivisionCalculator(IntegerLongDivisionValidator integerLongDivisionValidator,
                                         IntegerLongDivisionMathProvider integerLongDivisionMathProvider,
                                         IntegerLongDivisionViewProvider integerLongDivisionViewProvider) {
        this.integerLongDivisionValidator = integerLongDivisionValidator;
        this.integerLongDivisionMathProvider = integerLongDivisionMathProvider;
        this.integerLongDivisionViewProvider = integerLongDivisionViewProvider;
    }

    public String calculateDivision(int divided,
                                    int divisor) {
        integerLongDivisionValidator.validate(divided, divisor);
        IntegerLongDivisionResult integerLongDivisionResult = integerLongDivisionMathProvider.provideMathIntegerLongDivision(
                    divided, divisor);
        return integerLongDivisionViewProvider.integerLongDivisionProvideView(integerLongDivisionResult);
    }
}
