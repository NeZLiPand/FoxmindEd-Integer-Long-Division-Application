package ua.com.foxminded.integerdivisor;

public class ViewIntegerDivision {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TEN = 10;
    private static final char NEW_LINE = '\n';
    private static final char SUBTRACTION = '_';
    private static final char SPACE_DELIMITER = ' ';
    private static final char PILLAR = '|';
    private static final char FENCE = '-';

    public static String viewLongIntegerDivision(IntegerDivisor integerDivision) {
        return LongIntegerDivision(integerDivision);
    }
    
    private static String LongIntegerDivision(IntegerDivisor integerDivision) {
        StringBuilder longIntegerDivision = new StringBuilder("");
        int dividend = integerDivision.getDividend();
        int divider = integerDivision.getDivider();
        int quotient = integerDivision.getQuotient();
        int countDigitsInQuotient = calculateAmountOfDigits(quotient);
        int[] digitsValueQuotient = arrayInitializationByDigitsOfNumber(countDigitsInQuotient, quotient);
        int differenceInAmountDigitsNumeratorAndDenominator = calculateAmountOfDigits(
                dividend / (int) Math.pow(TEN, countDigitsInQuotient - ONE))
                - calculateAmountOfDigits(digitsValueQuotient[ZERO] * divider);
        int amountSpacesDelimitersBeforePillars = calculateAmountOfDigits(dividend) - calculateAmountOfDigits(divider * digitsValueQuotient[ZERO])
                - differenceInAmountDigitsNumeratorAndDenominator;
        addingFirstLineOfLongDivision(longIntegerDivision, dividend, divider);
        addingSecondLineOfLongDivision(longIntegerDivision, divider, digitsValueQuotient, countDigitsInQuotient,
                amountSpacesDelimitersBeforePillars, differenceInAmountDigitsNumeratorAndDenominator);
        addingThirdLineOfLongDivision(longIntegerDivision, dividend, countDigitsInQuotient, quotient,
                amountSpacesDelimitersBeforePillars);
        addingTailOfLongDivision(longIntegerDivision, countDigitsInQuotient, digitsValueQuotient, dividend, divider);
        return longIntegerDivision.toString();
    }

    public static int calculateAmountOfDigits(int number) {
        int countDigitsInNumber = ONE;
        while (number >= TEN) {
            number /= TEN;
            countDigitsInNumber++;
        }
        return countDigitsInNumber;
    }
    
    public static int[] arrayInitializationByDigitsOfNumber(int sizeArray, int number) {
        arrayInitializationByDigitsOfNumberValidate(sizeArray, number);
        int[] arrayDigitsOfNumber = new int[sizeArray];
        for (int iteratorI = sizeArray; iteratorI > ZERO; iteratorI--) {
            arrayDigitsOfNumber[iteratorI - ONE] = number % TEN;
            number /= TEN;
        }
        return arrayDigitsOfNumber;
    }
    
    private static void arrayInitializationByDigitsOfNumberValidate(int sizeArray, int number) {
        if (sizeArray == ZERO || number == ZERO) {
            throw new IllegalArgumentException("number or sizeArray is null");
        }
        if (sizeArray < ZERO || number < ZERO) {
            throw new IllegalArgumentException("number or sizeArray less than null");
        }
    }
    
    public static int cutOutAnyDigitTheNumber(int number, int index) {
        cutOutAnyDigitTheNumberValidate(number, index);
        int digitFromNumber = number;
        if (digitFromNumber >= TEN) {
            if (index > ONE) {
                digitFromNumber /= (int) Math.pow(TEN, index - ONE);
            }
            digitFromNumber %= TEN;
        }
        return digitFromNumber;
    }
    
    private static void cutOutAnyDigitTheNumberValidate(int number, int index) {
        if (number == ZERO || index == ZERO) {
            throw new IllegalArgumentException("number or index is null");
        }
        if (number < ZERO || index < ZERO) {
            throw new IllegalArgumentException("number or index less than null");
        }
        if(number < TEN && index > ONE) {
            throw new IllegalArgumentException("number less than index");
        }
    }
    
    private static void addingFirstLineOfLongDivision(StringBuilder longIntegerDivision, int dividend, int divider) {
        longIntegerDivision.append(SUBTRACTION).append(dividend).append(PILLAR).append(divider).append(NEW_LINE)
                .append(SPACE_DELIMITER);
    }

    private static void addingSecondLineOfLongDivision(StringBuilder longIntegerDivision, int divider,
            int[] digitsValueQuotient, int countDigitsInQuotient, int amountSpacesDelimitersBeforePillars,
            int differenceInAmountDigitsNumeratorAndDenominator) {
        for (int iteratorSD = ZERO; iteratorSD < differenceInAmountDigitsNumeratorAndDenominator; iteratorSD++) {
            longIntegerDivision.append(SPACE_DELIMITER);
        }
        longIntegerDivision.append(digitsValueQuotient[ZERO] * divider);
        if (amountSpacesDelimitersBeforePillars > 0) {
            for (int iteratorK = ZERO; iteratorK < amountSpacesDelimitersBeforePillars; iteratorK++) {
                longIntegerDivision.append(SPACE_DELIMITER);
            }
        }
        longIntegerDivision.append(PILLAR);
        if (countDigitsInQuotient >= calculateAmountOfDigits(divider)) {
            for (int iteratorF = ZERO; iteratorF < countDigitsInQuotient; iteratorF++) {
                longIntegerDivision.append(FENCE);
            }
        } else {
            for (int iteratorF = ZERO; iteratorF < calculateAmountOfDigits(divider); iteratorF++) {
                longIntegerDivision.append(FENCE);
            }
        }
        longIntegerDivision.append(NEW_LINE).append(SPACE_DELIMITER);
    }

    private static void addingThirdLineOfLongDivision(StringBuilder longIntegerDivision, int dividend,
            int countDigitsInQuotient, int quotient, int amountSpacesDelimitersBeforePillars) {
        int amountFenceFirstDivision = calculateAmountOfDigits(
                dividend / (int) Math.pow(TEN, countDigitsInQuotient - ONE));
        for (int iteratorF = ONE; iteratorF <= amountFenceFirstDivision; iteratorF++) {
            longIntegerDivision.append(FENCE);
        }
        if (amountSpacesDelimitersBeforePillars > 0) {
            for (int iteratorS = ZERO; iteratorS < amountSpacesDelimitersBeforePillars; iteratorS++) {
                longIntegerDivision.append(SPACE_DELIMITER);
            }
        }
        longIntegerDivision.append(PILLAR).append(quotient).append(NEW_LINE);
    }

    private static void addingTailOfLongDivision(StringBuilder longIntegerDivision, int countDigitsInQuotient,
            int[] digitsValueQuotient, int dividend, int divider) {
        int numerator = dividend / (int) Math.pow(TEN, countDigitsInQuotient - ONE);
        int denominator = digitsValueQuotient[ZERO] * divider;
        int amountSpaces = calculateAmountOfDigits(numerator) - calculateAmountOfDigits(numerator - denominator) + ONE;
        int quotientMini = 0;
        int differenceInAmountDigitsNumeratorAndDenominator = 0;
        numerator -= digitsValueQuotient[ZERO] * divider;
        for (int iteratorSN = ZERO; iteratorSN < amountSpaces - ONE; iteratorSN++) {
            longIntegerDivision.append(SPACE_DELIMITER);
        }
        if (numerator == 0) {
            longIntegerDivision.append(SPACE_DELIMITER);
            amountSpaces++;
        }
        longIntegerDivision.append(SUBTRACTION);
        if (numerator != 0) {
            longIntegerDivision.append(numerator);
        }
        for (int iterator = ONE; iterator < countDigitsInQuotient; iterator++) {
            if (digitsValueQuotient[iterator] == 0 && numerator != 0) {
                numerator = numerator * TEN + cutOutAnyDigitTheNumber(dividend, countDigitsInQuotient - iterator);
                longIntegerDivision.append(cutOutAnyDigitTheNumber(dividend, countDigitsInQuotient - iterator));
            } else {
                if (calculateAmountOfDigits(numerator) <= calculateAmountOfDigits(
                        digitsValueQuotient[iterator] * divider)) {
                    numerator = numerator * TEN + cutOutAnyDigitTheNumber(dividend, countDigitsInQuotient - iterator);
                    longIntegerDivision.append(cutOutAnyDigitTheNumber(dividend, countDigitsInQuotient - iterator));
                }
                longIntegerDivision.append(NEW_LINE);
                denominator = digitsValueQuotient[iterator] * divider;
                differenceInAmountDigitsNumeratorAndDenominator = calculateAmountOfDigits(numerator)
                        - calculateAmountOfDigits(denominator);
                for (int iteratorSD = ZERO; iteratorSD < amountSpaces
                        + differenceInAmountDigitsNumeratorAndDenominator; iteratorSD++) {
                    longIntegerDivision.append(SPACE_DELIMITER);
                }
                longIntegerDivision.append(denominator).append(NEW_LINE);

                for (int iteratorSF = ZERO; iteratorSF < amountSpaces; iteratorSF++) {
                    longIntegerDivision.append(SPACE_DELIMITER);
                }
                for (int iteratorF = ZERO; iteratorF < calculateAmountOfDigits(numerator); iteratorF++) {
                    longIntegerDivision.append(FENCE);
                }
                longIntegerDivision.append(NEW_LINE);
                quotientMini = numerator - denominator;
                amountSpaces += calculateAmountOfDigits(numerator) - calculateAmountOfDigits(quotientMini);
                numerator -= denominator;
                if (numerator == 0) {
                    amountSpaces++;
                }
                for (int iteratorSN = ZERO; iteratorSN < amountSpaces - ONE; iteratorSN++) {
                    longIntegerDivision.append(SPACE_DELIMITER);
                }
                if (iterator != countDigitsInQuotient - ONE) {
                    longIntegerDivision.append(SUBTRACTION);
                } else {
                    longIntegerDivision.append(SPACE_DELIMITER);
                }
                if (numerator != 0) {
                    longIntegerDivision.append(numerator);
                } else {
                    if (iterator == countDigitsInQuotient - ONE) {
                        longIntegerDivision.deleteCharAt(longIntegerDivision.length() - ONE).append(numerator);
                    }
                }
            }
        }
    }
}
