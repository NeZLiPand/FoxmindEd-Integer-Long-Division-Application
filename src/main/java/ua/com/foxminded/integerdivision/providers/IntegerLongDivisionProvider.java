package ua.com.foxminded.integerdivision.providers;

import java.util.Arrays;

public class IntegerLongDivisionProvider {
    private int dividend;
    private int divider;
    private int quotient;
    private int[] digitsFormQuotient;
    private IntegerLongDivisionStepsProvider divisionSteps;

    public IntegerLongDivisionProvider() {
        super();
    }

    public IntegerLongDivisionProvider(int dividend, int divider, int quotient, int[] digitsValueQuotient) {
        super();
        this.dividend = dividend;
        this.divider = divider;
        this.quotient = quotient;
        this.digitsFormQuotient = digitsValueQuotient.clone();
    }

    public IntegerLongDivisionProvider(int dividend, int divider, int quotient, int[] digitsFormQuotient,
            IntegerLongDivisionStepsProvider divisionSteps) {
        super();
        this.dividend = dividend;
        this.divider = divider;
        this.quotient = quotient;
        this.digitsFormQuotient = digitsFormQuotient.clone();
        this.divisionSteps = divisionSteps;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivider() {
        return divider;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    public int getQuotient() {
        return quotient;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public int[] getDigitsFromQuotient() {
        return digitsFormQuotient.clone();
    }

    public void setDigitsFromQuotient(int[] digitsValueQuotient) {
        this.digitsFormQuotient = digitsValueQuotient.clone();
    }

    public IntegerLongDivisionStepsProvider getDivisionSteps() {
        return divisionSteps;
    }

    public void setDivisionSteps(IntegerLongDivisionStepsProvider divisionSteps) {
        this.divisionSteps = divisionSteps;
    }
    
    @Override
    public String toString() {
        return "IntegerLongDivisionProvider [dividend=" + dividend + ", divider=" + divider + ", quotient=" + quotient
                + ", digitsValueQuotient=" + Arrays.toString(digitsFormQuotient) + ", divisionSteps=" + divisionSteps
                + "]";
    }
}
