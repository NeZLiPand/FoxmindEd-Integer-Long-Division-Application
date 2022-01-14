package ua.com.foxminded.integerdivision.validator;

public class IntegerLongDivisionValidatorImpl implements IntegerLongDivisionValidator {

    public void validate(int divided,
                         int divisor) {

        if (divided < 0) {
            throw new IllegalArgumentException("divided is less than zero");
        }
        if (divisor < 0) {
            throw new IllegalArgumentException("divisor is less than zero");
        }
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor is zero");
        }
    }
}
