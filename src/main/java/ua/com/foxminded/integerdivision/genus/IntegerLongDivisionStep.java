package ua.com.foxminded.integerdivision.genus;

import java.util.Objects;

public final class IntegerLongDivisionStep {
    private final int minuend;
    private final int subtrahend;

    public IntegerLongDivisionStep(int minuend,
                                   int subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;

    }

    public int getMinuend() {
        return minuend;
    }

    public int getSubtrahend() {
        return subtrahend;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtrahend, minuend);
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
        IntegerLongDivisionStep other = (IntegerLongDivisionStep) obj;
        return subtrahend == other.subtrahend &&
               minuend == other.minuend;
    }

    @Override
    public String toString() {
        return "IntegerLongDivisionStep [minuend="
               + minuend
               + ", subtrahend="
               + subtrahend
               + "]";
    }
}
