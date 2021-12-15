package ua.com.foxminded.integerdivision.providers;

import java.util.Arrays;

public class IntegerLongDivisionStepsProvider {
    private int[] numeratorsOfDivisionColumns;
    private int[] denomiratorsOfDivisionColumns;
    private int amountOfDivisionSteps;
    private int amountMiniDivision;
    
    public IntegerLongDivisionStepsProvider() {
        super();
    }
    
    public IntegerLongDivisionStepsProvider(int amountOfDivisionSteps, int amountMiniDivision) {
        super();
        this.amountOfDivisionSteps = amountOfDivisionSteps;
        this.amountMiniDivision = amountMiniDivision;
    }

    public IntegerLongDivisionStepsProvider(int[] numeratorsOfDivisionColumns, int[] denomiratorsOfDivisionColumns,
            int amountOfDivisionSteps, int amountMiniDivision) {
        super();
        this.numeratorsOfDivisionColumns = numeratorsOfDivisionColumns.clone();
        this.denomiratorsOfDivisionColumns = denomiratorsOfDivisionColumns.clone();
        this.amountOfDivisionSteps = amountOfDivisionSteps;
        this.amountMiniDivision = amountMiniDivision;
    }

    public int[] getNumeratorsOfDivisionColumns() {
        return numeratorsOfDivisionColumns.clone();
    }

    public void setNumeratorsOfDivisionColumns(int[] numeratorsOfDivisionColumns) {
        this.numeratorsOfDivisionColumns = numeratorsOfDivisionColumns.clone();
    }

    public int[] getDenomiratorsOfDivisionColumns() {
        return denomiratorsOfDivisionColumns.clone();
    }

    public void setDenomiratorsOfDivisionColumns(int[] denomiratorsOfDivisionColumns) {
        this.denomiratorsOfDivisionColumns = denomiratorsOfDivisionColumns.clone();
    }

    public int getAmountOfDivisionSteps() {
        return amountOfDivisionSteps;
    }

    public void setAmountOfDivisionSteps(int amountOfDivisionSteps) {
        this.amountOfDivisionSteps = amountOfDivisionSteps;
    }

    public int getAmountMiniDivision() {
        return amountMiniDivision;
    }

    public void setAmountMiniDivision(int amountMiniDivision) {
        this.amountMiniDivision = amountMiniDivision;
    }

    @Override
    public String toString() {
        return "IntegerLongDivisionStepProvider [numeratorsOfDivisionColumns="
                + Arrays.toString(numeratorsOfDivisionColumns) + ", denomiratorsOfDivisionColumns="
                + Arrays.toString(denomiratorsOfDivisionColumns) + ", amountOfDivisionSteps=" + amountOfDivisionSteps
                + ", amountMiniDivision=" + amountMiniDivision + "]";
    }
}
