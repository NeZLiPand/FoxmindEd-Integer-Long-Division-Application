package ua.com.foxminded.integerdivision.genus;

import java.util.List;
import java.util.Objects;

public class IntegerLongDivisionResult {
    private int divided;
    private int divisor;
    private int remainder;
    private List<IntegerLongDivisionStep> divisionSteps;

    private IntegerLongDivisionResult(Builder builder) {
        this.divided = builder.divided;
        this.divisor = builder.divisor;
        this.remainder = builder.remainder;
        this.divisionSteps = builder.divisionSteps;
    }

    public static Builder builder() {
        return new Builder();
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

    public List<IntegerLongDivisionStep> getDivisionSteps() {
        return divisionSteps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(divided, divisor, divisionSteps, remainder);
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
               Objects.equals(divisionSteps, other.divisionSteps) &&
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
               + ", divisionSteps="
               + divisionSteps
               + "]";
    }

    public static class Builder {
        private int divided;
        private int divisor;
        private int remainder;
        private List<IntegerLongDivisionStep> divisionSteps;

        private Builder() {
        }

        public Builder withDivided(int divided) {
            this.divided = divided;
            return this;
        }

        public Builder withDivisor(int divisor) {
            this.divisor = divisor;
            return this;
        }

        public Builder withRemainder(int remainder) {
            this.remainder = remainder;
            return this;
        }

        public Builder withDivisionSteps(List<IntegerLongDivisionStep> divisionSteps) {
            this.divisionSteps = divisionSteps;
            return this;
        }

        public IntegerLongDivisionResult build() {
            return new IntegerLongDivisionResult(this);
        }
    }
}
