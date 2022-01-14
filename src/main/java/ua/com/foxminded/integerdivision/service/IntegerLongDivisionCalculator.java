package ua.com.foxminded.integerdivision.service;

import java.util.Objects;

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
        IntegerLongDivisionResult integerLongDivisionResult = integerLongDivisionMathProvider
                    .provideMathIntegerLongDivision(divided, divisor);
        return integerLongDivisionViewProvider.integerLongDivisionProvideView(integerLongDivisionResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(integerLongDivisionMathProvider, integerLongDivisionValidator,
                    integerLongDivisionViewProvider);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        IntegerLongDivisionCalculator other = (IntegerLongDivisionCalculator) obj;
        return Objects.equals(integerLongDivisionMathProvider, other.integerLongDivisionMathProvider) &&
               Objects.equals(integerLongDivisionValidator, other.integerLongDivisionValidator) &&
               Objects.equals(integerLongDivisionViewProvider, other.integerLongDivisionViewProvider);
    }

    @Override
    public String toString() {
        return "IntegerLongDivisionCalculator [integerLongDivisionValidator="
               + integerLongDivisionValidator
               + ", integerLongDivisionMathProvider="
               + integerLongDivisionMathProvider
               + ", integerLongDivisionViewProvider="
               + integerLongDivisionViewProvider
               + "]";
    }
}
