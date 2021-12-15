package ua.com.foxminded.integerdivision.validation;

public class IntegerDivisionValidation {
    private static final int ZERO = 0;

    public static void validateValues(int dividend, int divider) {
        if (divider == ZERO) {
            throw new IllegalArgumentException("Divider is zero");
        }
        if (dividend < ZERO) {
            throw new IllegalArgumentException("dividend is less than zero");
        }
        if (divider < ZERO) {
            throw new IllegalArgumentException("divider is less than zero");
        }
    }
}
