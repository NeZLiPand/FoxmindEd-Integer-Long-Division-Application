package ua.com.foxminded.integerdivision.genus;

import java.util.List;
import java.util.Objects;

public final class IntegerLongDivisionResult {
    private final IntegerDivisionResult integerDivisionResult;
    private final List<IntegerLongDivisionStep> integerLongDivisionSteps;

    public IntegerLongDivisionResult(IntegerDivisionResult integerDivisionResult,
                                     List<IntegerLongDivisionStep> integerLongDivisionSteps) {
        this.integerDivisionResult = integerDivisionResult;
        this.integerLongDivisionSteps = integerLongDivisionSteps;
    }

    public IntegerDivisionResult getIntegerDivisionResult() {
        return integerDivisionResult;
    }

    public List<IntegerLongDivisionStep> getIntegerLongDivisionSteps() {
        return integerLongDivisionSteps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(integerDivisionResult, integerLongDivisionSteps);
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
        return Objects.equals(integerDivisionResult, other.integerDivisionResult) &&
               Objects.equals(integerLongDivisionSteps, other.integerLongDivisionSteps);
    }

    @Override
    public String toString() {
        return "IntegerLongDivisionResult [integerDivisionResult="
               + integerDivisionResult
               + ", integerLongDivisionSteps="
               + integerLongDivisionSteps
               + "]";
    }
}
