package ua.com.foxminded.integerdivisor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ViewIntegerDivisionTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int ONE_TO_NINE = 123_456_789;

    @Test
    void testCalculateAmountOfDigits_shouldReturnTheSameAmountOfDigits_whenInputNumberContainsOneDigit() {
        assertEquals(ONE, ViewIntegerDivision.calculateAmountOfDigits(ZERO));
    }

    @Test
    void testCalculateAmountOfDigits_shouldReturnTheSameAmountOfDigits_whenInputNumberContainsNineDigits() {
        assertEquals(NINE, ViewIntegerDivision.calculateAmountOfDigits(ONE_TO_NINE));
    }
    
    @Test
    void testArrayInitializationByDigitsOfNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.arrayInitializationByDigitsOfNumber(ONE, ZERO);
        });
    }
    
    @Test
    void testArrayInitializationByDigitsOfNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberContainZeroAndSecondNumberContainOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.arrayInitializationByDigitsOfNumber(ZERO, ONE);
        });
    }
    
    @Test
    void testArrayInitializationByDigitsOfNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainNegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.arrayInitializationByDigitsOfNumber(ONE, -ONE);
        });
    }
    
    @Test
    void testArrayInitializationByDigitsOfNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberContainNegativeOneAndSecondNumberContainOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.arrayInitializationByDigitsOfNumber(-ONE, ONE);
        });
    }

    @Test
    void testArrayInitializationByDigitsOfNumber_shouldReturnDigitsArrayOfSameNumber_whenInputNumberContainsOne() {
        int[] arrayDigitsOfNumber = new int[] { ONE };
        assertEquals(arrayDigitsOfNumber[ZERO], ViewIntegerDivision
                .arrayInitializationByDigitsOfNumber(ViewIntegerDivision.calculateAmountOfDigits(ONE), ONE)[ZERO]);
    }

    @Test
    void testArrayInitializationByDigitsOfNumber_shouldReturnDigitsArrayOfSameNumber_whenInputNumberContainsTenDigits() {
        int[] arrayDigitsOfNumber = new int[] { ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE };
        int[] arrayDigitsOfNumberOfMetod = ViewIntegerDivision.arrayInitializationByDigitsOfNumber(
                ViewIntegerDivision.calculateAmountOfDigits(ONE_TO_NINE), ONE_TO_NINE);
        for (int Iterator = ZERO; Iterator < arrayDigitsOfNumber.length; Iterator++) {
            assertEquals(arrayDigitsOfNumber[Iterator], arrayDigitsOfNumberOfMetod[Iterator]);
        }
    }

    @Test
    void testCutOutAnyDigitTheNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.cutOutAnyDigitTheNumber(ONE, ZERO);
        });
    }
    
    @Test
    void testCutOutAnyDigitTheNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberContainZeroAndSecondNumberContainOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.cutOutAnyDigitTheNumber(ZERO, ONE);
        });
    }

    @Test
    void testCutOutAnyDigitTheNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndIndexContainNegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.cutOutAnyDigitTheNumber(ONE, -ONE);
        });
    }
    
    @Test
    void testCutOutAnyDigitTheNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberContainNegativeOneAndIndexContainOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.cutOutAnyDigitTheNumber(-ONE, ONE);
        });
    }
    
    @Test
    void testCutOutAnyDigitTheNumberValidate_shouldReturnIllegalArgumentException_whenInputFirstNumberLessThanTenAndIndexGreaterOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            ViewIntegerDivision.cutOutAnyDigitTheNumber(NINE, TWO);
        });
    }
    
    @Test
    void testCutOutAnyDigitTheNumber_shouldReturnCutOutNinthDigitTheNumber_whenInputFirstNumberContainsNineAndIndexContainOne() {
        assertEquals(NINE, ViewIntegerDivision.cutOutAnyDigitTheNumber(NINE, ONE));
    }

    @Test
    void testCutOutAnyDigitTheNumber_shouldReturnCutOutNinthDigitTheNumber_whenInputFirstNumberContainsNineDigitsAndIndexContainNine() {
        assertEquals(ONE, ViewIntegerDivision.cutOutAnyDigitTheNumber(ONE_TO_NINE, NINE));
    }

    @Test
    void testCutOutAnyDigitTheNumber_shouldReturnCutOutFifthDigitTheNumber_whenInputFirstNumberContainsNineDigitsAndIndexContainFive() {
        assertEquals(FIVE, ViewIntegerDivision.cutOutAnyDigitTheNumber(ONE_TO_NINE, FIVE));
    }
    
    @Test
    void testViewLongIntegerDivision_shouldReturnLongIntegerDivision_whenInputVeryEasyDifficultyIntegerDivisor() {
        IntegerDivisor integerDivision = new IntegerDivisor (100, 20);
        assertEquals("_100|20\n"
                + " 100|--\n"
                + " ---|5\n"
                + "   _", ViewIntegerDivision.viewLongIntegerDivision(integerDivision));
    }
    
    @Test
    void testViewLongIntegerDivision_shouldReturnLongIntegerDivision_whenInputEasyDifficultyIntegerDivisor() {
        IntegerDivisor integerDivision = new IntegerDivisor (8357, 61);
        assertEquals("_8357|61\n"
                + " 61  |---\n"
                + " --  |137\n"
                + "_225\n"
                + " 183\n"
                + " ---\n"
                + " _427\n"
                + "  427\n"
                + "  ---\n"
                + "    0", ViewIntegerDivision.viewLongIntegerDivision(integerDivision));
    }
    
    @Test
    void testViewLongIntegerDivision_shouldReturnLongIntegerDivision_whenInputMediumDifficultyIntegerDivisor() {
        IntegerDivisor integerDivision = new IntegerDivisor (33684, 12);
        assertEquals("_33684|12\n"
                + " 24   |----\n"
                + " --   |2807\n"
                + " _96\n"
                + "  96\n"
                + "  --\n"
                + "   _8\n"
                + "    0\n"
                + "    -\n"
                + "   _84\n"
                + "    84\n"
                + "    --\n"
                + "     0", ViewIntegerDivision.viewLongIntegerDivision(integerDivision));
    }
    
    @Test
    void testViewLongIntegerDivision_shouldReturnLongIntegerDivision_whenInputNotVeryDifficultyIntegerDivisor() {
        IntegerDivisor integerDivision = new IntegerDivisor (987654321, 99);
        assertEquals("_987654321|99\n"
                + " 891      |-------\n"
                + " ---      |9976306\n"
                + " _966\n"
                + "  891\n"
                + "  ---\n"
                + "  _755\n"
                + "   693\n"
                + "   ---\n"
                + "   _624\n"
                + "    594\n"
                + "    ---\n"
                + "    _303\n"
                + "     297\n"
                + "     ---\n"
                + "      _621\n"
                + "       594\n"
                + "       ---\n"
                + "        27", ViewIntegerDivision.viewLongIntegerDivision(integerDivision));
    }
    
    @Test
    void testViewLongIntegerDivision_shouldReturnLongIntegerDivision_whenInputDifficultEnoughDifficultyIntegerDivisor() {
        IntegerDivisor integerDivision = new IntegerDivisor (1200072, 6);
        assertEquals("_1200072|6\n"
                + " 12     |------\n"
                + " --     |200012\n"
                + "  _0\n"
                + "   0\n"
                + "   -\n"
                + "   _0\n"
                + "    0\n"
                + "    -\n"
                + "    _0\n"
                + "     0\n"
                + "     -\n"
                + "     _7\n"
                + "      6\n"
                + "      -\n"
                + "     _12\n"
                + "      12\n"
                + "      --\n"
                + "       0", ViewIntegerDivision.viewLongIntegerDivision(integerDivision));
    }
    
    @Test
    void testViewLongIntegerDivision_shouldReturnLongIntegerDivision_whenInputVeryVeryDifficultyIntegerDivisor() {
        IntegerDivisor integerDivision = new IntegerDivisor (1234567890, 99);
        assertEquals("_1234567890|99\n"
                + "  99       |--------\n"
                + " ---       |12470382\n"
                + " _244\n"
                + "  198\n"
                + "  ---\n"
                + "  _465\n"
                + "   396\n"
                + "   ---\n"
                + "   _696\n"
                + "    693\n"
                + "    ---\n"
                + "     _378\n"
                + "      297\n"
                + "      ---\n"
                + "      _819\n"
                + "       792\n"
                + "       ---\n"
                + "       _270\n"
                + "        198\n"
                + "        ---\n"
                + "         72", ViewIntegerDivision.viewLongIntegerDivision(integerDivision));
    }
    
    @Test
    void testViewLongIntegerDivision_shouldReturnLongIntegerDivision_whenInputIncredоiblyDifficultIntegerDivisor() {
        IntegerDivisor integerDivision = new IntegerDivisor (987_000_321, 2);
        assertEquals("_987000321|2\n"
                + " 8        |---------\n"
                + " -        |493500160\n"
                + "_18\n"
                + " 18\n"
                + " --\n"
                + "  _7\n"
                + "   6\n"
                + "   -\n"
                + "  _10\n"
                + "   10\n"
                + "   --\n"
                + "    _0\n"
                + "     0\n"
                + "     -\n"
                + "     _0\n"
                + "      0\n"
                + "      -\n"
                + "      _3\n"
                + "       2\n"
                + "       -\n"
                + "      _12\n"
                + "       12\n"
                + "       --\n"
                + "        _1\n"
                + "         0\n"
                + "         -\n"
                + "         1", ViewIntegerDivision.viewLongIntegerDivision(integerDivision));
    }
}
