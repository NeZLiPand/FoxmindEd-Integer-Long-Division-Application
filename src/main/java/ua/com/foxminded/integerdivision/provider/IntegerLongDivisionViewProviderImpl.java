package ua.com.foxminded.integerdivision.provider;

import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionStep;
import ua.com.foxminded.integerdivision.utility.IntegerCalculationUtilities;

public class IntegerLongDivisionViewProviderImpl implements IntegerLongDivisionViewProvider {
    private static final char SYM_NEW_LINE = '\n';
    private static final char SYM_SUBTRACTION = '_';
    private static final char SYM_SPACE_DELIMITER = ' ';
    private static final char SYM_PILLAR = '|';
    private static final char SYM_FENCE = '-';

    @Override
    public String integerLongDivisionProvideView(IntegerLongDivisionResult integerLongDivisionResult) {
        StringBuilder sketchOfIntegerLongDivision = new StringBuilder("");
        sketchOfIntegerLongDivision.append(addingFirstAndSecondParticlesOfLongDivision(integerLongDivisionResult));
        sketchOfIntegerLongDivision.append(addingThirdParticleOfLongDivision(integerLongDivisionResult));
        return sketchOfIntegerLongDivision.append(addingRemainingParticlesOfLongDivision(integerLongDivisionResult))
                    .toString();
    }
    
    private String addingFirstAndSecondParticlesOfLongDivision(IntegerLongDivisionResult integerLongDivisionResult) {
        StringBuilder sketchPart = new StringBuilder("");
        int divided = integerLongDivisionResult.getDivided();
        int divisor = integerLongDivisionResult.getDivisor();
        List<IntegerLongDivisionStep> divisionSteps = new ArrayList<>(integerLongDivisionResult.getDivisionSteps());
        int amountOfDigitsInQuotient = IntegerCalculationUtilities.calculateAmountOfDigits(divided / divisor);
        int amountOfDigitsInDivisor = IntegerCalculationUtilities.calculateAmountOfDigits(divisor);
        int amountSpaceDelimitersBeforePillar = IntegerCalculationUtilities.calculateAmountOfDigits(divided)
                    - IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                                .getMinuend());
        sketchPart.append(SYM_SUBTRACTION)
        .append(divided)
        .append(SYM_PILLAR)
        .append(divisor)
        .append(SYM_NEW_LINE)
        .append(SYM_SPACE_DELIMITER);
        addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER,
                    (IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                                .getMinuend())
                                - IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                                            .getSubtrahend())));
        sketchPart.append(divisionSteps.get(0)
                    .getSubtrahend());
        addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER, amountSpaceDelimitersBeforePillar);
        sketchPart.append(SYM_PILLAR);
        if (amountOfDigitsInQuotient >= amountOfDigitsInDivisor) {
            addingMultipleCopiesOfSymbol(sketchPart, SYM_FENCE, amountOfDigitsInQuotient);
        } else {
            addingMultipleCopiesOfSymbol(sketchPart, SYM_FENCE, amountOfDigitsInDivisor);
        }
        sketchPart.append(SYM_NEW_LINE)
        .append(SYM_SPACE_DELIMITER);
        return sketchPart.toString();
    }
    
    private String addingThirdParticleOfLongDivision(IntegerLongDivisionResult integerLongDivisionResult) {
        StringBuilder sketchPart = new StringBuilder("");
        int divided = integerLongDivisionResult.getDivided();
        int divisor = integerLongDivisionResult.getDivisor();
        List<IntegerLongDivisionStep> divisionSteps = new ArrayList<>(integerLongDivisionResult.getDivisionSteps());
        int amountSpaceDelimitersBeforePillar = IntegerCalculationUtilities.calculateAmountOfDigits(divided)
                    - IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                                .getMinuend());
        addingMultipleCopiesOfSymbol(sketchPart, SYM_FENCE,
                    IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                                .getMinuend()));
        addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER, amountSpaceDelimitersBeforePillar);
        sketchPart.append(SYM_PILLAR)
        .append(divided / divisor)
        .append(SYM_NEW_LINE);
        return sketchPart.toString();
    }
    
    private String addingRemainingParticlesOfLongDivision(IntegerLongDivisionResult integerLongDivisionResult) {
        StringBuilder sketchPart = new StringBuilder("");
        List<IntegerLongDivisionStep> divisionSteps = new ArrayList<>(integerLongDivisionResult.getDivisionSteps());
        int amountColumnsSubtraction = divisionSteps.size();
        int amountSpacesBeforeValues = IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                    .getMinuend())
                    - IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                                .getMinuend()
                                - divisionSteps.get(0)
                                .getSubtrahend());
        if (amountColumnsSubtraction > 1) {
            if ((divisionSteps.get(0)
                        .getMinuend()
                        - divisionSteps.get(0)
                        .getSubtrahend()) == 0) {
                amountSpacesBeforeValues = IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                            .getSubtrahend());
            }
            addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER, amountSpacesBeforeValues);
            sketchPart.append(SYM_SUBTRACTION)
            .append(divisionSteps.get(1)
                        .getMinuend())
            .append(SYM_NEW_LINE);
        } else {
            if (integerLongDivisionResult.getRemainder() == 0) {
                amountSpacesBeforeValues = amountSpacesBeforeValues + 1;
            }
            if (IntegerCalculationUtilities.calculateAmountOfDigits(
                        integerLongDivisionResult.getDivided()) > IntegerCalculationUtilities.calculateAmountOfDigits(
                                    divisionSteps.get(0)
                                    .getSubtrahend())) {
                amountSpacesBeforeValues = amountSpacesBeforeValues
                            + IntegerCalculationUtilities.calculateAmountOfDigits(integerLongDivisionResult.getDivided())
                            - IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(0)
                                        .getSubtrahend());
            }
            addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER, amountSpacesBeforeValues);
            sketchPart.append(integerLongDivisionResult.getRemainder());
        }
        for (int iterator = 1; iterator < amountColumnsSubtraction; iterator++) {
            addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER, amountSpacesBeforeValues + 1);
            sketchPart.append(divisionSteps.get(iterator)
                        .getSubtrahend())
            .append(SYM_NEW_LINE);
            addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER, amountSpacesBeforeValues + 1);
            addingMultipleCopiesOfSymbol(sketchPart, SYM_FENCE,
                        IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(iterator)
                                    .getMinuend()));
            amountSpacesBeforeValues = amountSpacesBeforeValues
                        + IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(iterator)
                                    .getMinuend())
                        - IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(iterator)
                                    .getMinuend()
                                    - divisionSteps.get(iterator)
                                    .getSubtrahend());
            sketchPart.append(SYM_NEW_LINE);
            if (iterator != (amountColumnsSubtraction - 1)) {
                if ((divisionSteps.get(iterator + 1)
                            .getMinuend()) == 0 ||
                            (divisionSteps.get(iterator)
                                        .getMinuend()
                                        - divisionSteps.get(iterator)
                                        .getSubtrahend()) == 0) {
                    amountSpacesBeforeValues = amountSpacesBeforeValues
                                + IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(iterator)
                                            .getMinuend());
                    if (IntegerCalculationUtilities.calculateAmountOfDigits(divisionSteps.get(iterator)
                                .getMinuend()) > 1) {
                        amountSpacesBeforeValues--;
                    }
                }
                addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER, amountSpacesBeforeValues);
                sketchPart.append(SYM_SUBTRACTION)
                .append(divisionSteps.get(iterator + 1)
                            .getMinuend());
            } else {
                addingMultipleCopiesOfSymbol(sketchPart, SYM_SPACE_DELIMITER, amountSpacesBeforeValues);
                sketchPart.append(SYM_SPACE_DELIMITER)
                .append(integerLongDivisionResult.getRemainder());
            }
            if (iterator != (amountColumnsSubtraction - 1)) {
                sketchPart.append(SYM_NEW_LINE);
            }
        }
        return sketchPart.toString();
    }
    
    private void addingMultipleCopiesOfSymbol(StringBuilder sketchPart,
                                              char symbol,
                                              int length) {
        for (int iterator = 0; iterator < length; iterator++) {
            sketchPart.append(symbol);
        }
    }
}
