package ua.com.foxminded.integerdivision.services;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerdivision.providers.IntegerLongDivisionProvider;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerLongDivisionViewTest {

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryEasyDifficultyIntegerDivisor() {
        IntegerLongDivisionProvider integerLongDivision = IntegerLongDivisionMath.provideMathDivision(100, 20);
        assertEquals("_100|20\n" + " 100|--\n" + " ---|5\n" + "   0",
                IntegerLongDivisionView.convertOnLongIntegerDivision(integerLongDivision));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputEasyDifficultyIntegerDivisor() {
        IntegerLongDivisionProvider integerLongDivision = IntegerLongDivisionMath.provideMathDivision(8357, 61);
        assertEquals(

                "_8357|61\n" + " 61  |---\n" + " --  |137\n" + " _225\n" + "  183\n" + "  ---\n" + "  _427\n"
                        + "   427\n" + "   ---\n" + "     0",
                IntegerLongDivisionView.convertOnLongIntegerDivision(integerLongDivision));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputMediumDifficultyIntegerDivisor() {
        IntegerLongDivisionProvider integerLongDivision = IntegerLongDivisionMath.provideMathDivision(33684, 12);
        assertEquals(
                "_33684|12\n" + " 24   |----\n" + " --   |2807\n" + " _96\n" + "  96\n" + "  --\n" + "  _84\n"
                        + "   84\n" + "   --\n" + "    0",
                IntegerLongDivisionView.convertOnLongIntegerDivision(integerLongDivision));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputNotVeryDifficultyIntegerDivisor() {
        IntegerLongDivisionProvider integerLongDivision = IntegerLongDivisionMath.provideMathDivision(987_654_321, 99);
        assertEquals(
                "_987654321|99\n" + " 891      |-------\n" + " ---      |9976306\n" + "  _966\n" + "   891\n"
                        + "   ---\n" + "   _755\n" + "    693\n" + "    ---\n" + "    _624\n" + "     594\n"
                        + "     ---\n" + "     _303\n" + "      297\n" + "      ---\n" + "       _621\n"
                        + "        594\n" + "        ---\n" + "         27",
                IntegerLongDivisionView.convertOnLongIntegerDivision(integerLongDivision));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputDifficultEnoughDifficultyIntegerDivisor() {
        IntegerLongDivisionProvider integerLongDivision = IntegerLongDivisionMath.provideMathDivision(12000072, 6);
        assertEquals(
                "_12000072|6\n" + " 12      |-------\n" + " --      |2000012\n" + "  _0\n" + "   0\n" + "   -\n"
                        + "   _0\n" + "    0\n" + "    -\n" + "    _0\n" + "     0\n" + "     -\n" + "     _0\n"
                        + "      0\n" + "      -\n" + "      _7\n" + "       6\n" + "       -\n" + "      _12\n"
                        + "       12\n" + "       --\n" + "        0",
                IntegerLongDivisionView.convertOnLongIntegerDivision(integerLongDivision));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryVeryDifficultyIntegerDivisor() {
        IntegerLongDivisionProvider integerLongDivision = IntegerLongDivisionMath.provideMathDivision(123_456_789, 99);
        assertEquals("_123456789|99\n" + "  99      |-------\n" + " ---      |1247038\n" + " _244\n" + "  198\n"
                + "  ---\n" + "  _465\n" + "   396\n" + "   ---\n" + "   _696\n" + "    693\n" + "    ---\n"
                + "     _378\n" + "      297\n" + "      ---\n" + "      _819\n" + "       792\n" + "       ---\n"
                + "        27", IntegerLongDivisionView.convertOnLongIntegerDivision(integerLongDivision));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputIncredоiblyDifficultIntegerDivisor() {
        IntegerLongDivisionProvider integerLongDivision = IntegerLongDivisionMath.provideMathDivision(987_000_321, 2);
        assertEquals(
                "_987000321|2\n" + " 8        |---------\n" + " -        |493500160\n" + "_18\n" + " 18\n" + " --\n"
                        + " _7\n" + "  6\n" + "  -\n" + " _10\n" + "  10\n" + "  --\n" + "  _0\n" + "   0\n" + "   -\n"
                        + "   _0\n" + "    0\n" + "    -\n" + "    _3\n" + "     2\n" + "     -\n" + "    _12\n"
                        + "     12\n" + "     --\n" + "      1",
                IntegerLongDivisionView.convertOnLongIntegerDivision(integerLongDivision));
    }
}
