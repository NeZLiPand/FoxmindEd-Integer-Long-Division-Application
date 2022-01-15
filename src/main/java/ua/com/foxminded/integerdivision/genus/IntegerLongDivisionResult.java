package ua.com.foxminded.integerdivision.genus;

import java.util.List;
import java.util.Objects;

public final class IntegerLongDivisionResult {
    private final int divided;
    private final int divisor;
    private final int remainder;
    private final List<IntegerLongDivisionStep> steps;

    public IntegerLongDivisionResult(int divided,
                                     int divisor,
                                     int remainder,
                                     List<IntegerLongDivisionStep> steps) {
        this.divided = divided;
        this.divisor = divisor;
        this.remainder = remainder;
        this.steps = steps;
    }

    public int getDivided() {
        return divided;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getRemainder() {
        return remainder;
    }

    public List<IntegerLongDivisionStep> steps() {
        return steps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(divided, divisor, steps, remainder);
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
        IntegerLongDivisionResult other = (IntegerLongDivisionResult) obj;
        return divided == other.divided &&
               divisor == other.divisor &&
               Objects.equals(steps, other.steps) &&
               remainder == other.remainder;
    }

    @Override
    public String toString() {
        return "IntegerLongDivisionResult [divided="
               + divided
               + ", divisor="
               + divisor
               + ", remainder="
               + remainder
               + ", steps="
               + steps
               + "]";
    }
}
