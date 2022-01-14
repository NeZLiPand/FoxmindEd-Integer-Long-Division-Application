package ua.com.foxminded.integerdivision.genus;

import java.util.Objects;

public final class IntegerDivisionResult {
    private final int divided;
    private final int divisor;
    private final int remainder;

    public IntegerDivisionResult(int divided,
                                 int divisor,
                                 int remainderOfTheDivision) {
        this.divided = divided;
        this.divisor = divisor;
        this.remainder = remainderOfTheDivision;
    }

    public int getDivided() {
        return divided;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getRemainderOfTheDivision() {
        return remainder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(divided, divisor, remainder);
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
        IntegerDivisionResult other = (IntegerDivisionResult) obj;
        return divided == other.divided &&
               divisor == other.divisor &&
               remainder == other.remainder;
    }

    @Override
    public String toString() {
        return "IntegerDivisionResult [divided="
               + divided
               + ", divisor="
               + divisor
               + ", remainderOfTheDivision="
               + remainder
               + "]";
    }
}
