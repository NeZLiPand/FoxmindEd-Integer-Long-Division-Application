package ua.com.foxminded.integerdivision.genus;

import java.util.Objects;

public final class IntegerLongDivisionStep {
    private final int numeratorOfSubtractionColumns;
    private final int denominatorOfSubtractionColumns;

    public IntegerLongDivisionStep(int numeratorOfSubtractionColumns,
                                   int denominatorOfSubtractionColumns) {
        this.numeratorOfSubtractionColumns = numeratorOfSubtractionColumns;
        this.denominatorOfSubtractionColumns = denominatorOfSubtractionColumns;

    }

    public int getDenominatorOfSubtractionColumns() {
        return denominatorOfSubtractionColumns;
    }

    public int getNumeratorOfSubtractionColumns() {
        return numeratorOfSubtractionColumns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denominatorOfSubtractionColumns, numeratorOfSubtractionColumns);
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
        return denominatorOfSubtractionColumns == other.denominatorOfSubtractionColumns &&
               numeratorOfSubtractionColumns == other.numeratorOfSubtractionColumns;
    }

    @Override
    public String toString() {
        return "IntegerLongDivisionStep [numeratorOfSubtractionColumns="
               + numeratorOfSubtractionColumns
               + ", denominatorOfSubtractionColumns="
               + denominatorOfSubtractionColumns
               + "]";
    }
}
