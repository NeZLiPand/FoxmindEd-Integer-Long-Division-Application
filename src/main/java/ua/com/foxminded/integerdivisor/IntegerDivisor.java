package ua.com.foxminded.integerdivisor;

public class IntegerDivisor {
    private static final int ZERO = 0;
    
    private final int dividend;
    private final int divider;
    private final int quotient;

    public IntegerDivisor(int dividend, int divider) {
        super();
        validateValues(dividend, divider);
        this.dividend = dividend;
        this.divider = divider;
        this.quotient = dividend / divider;
    }

    private static void validateValues(int dividend, int divider) {
        if (dividend == ZERO || divider == ZERO) {
            throw new IllegalArgumentException("Values are null");
        }
        if (dividend < ZERO || divider < ZERO) {
            throw new IllegalArgumentException("Values are less than null");
        }
        if (dividend < divider) {
            throw new IllegalArgumentException("dividend less than divisor");
        }
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    public int getQuotient() {
        return quotient;
    }
}
