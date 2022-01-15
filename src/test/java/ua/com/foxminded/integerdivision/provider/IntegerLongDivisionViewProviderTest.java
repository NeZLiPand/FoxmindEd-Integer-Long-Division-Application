package ua.com.foxminded.integerdivision.provider;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionStep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

class IntegerLongDivisionViewProviderTest {
    IntegerLongDivisionViewProvider integerLongDivisionViewProvider = new IntegerLongDivisionViewProviderImpl();

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryEasyDifficultyIntegerDivisor3() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(120000, 120000));
        assertEquals("_12000034|120000\n"
                     + " 120000  |------\n"
                     + " ------  |100\n"
                     + "       34",
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                new IntegerLongDivisionResult(12000034, 120000, 34, steps)));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryEasyDifficultyIntegerDivisor2() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(12000034, 12000034));
        assertEquals("_12000034|12000034\n"
                     + " 12000034|--------\n"
                     + " --------|1\n"
                     + "        0",
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                new IntegerLongDivisionResult(12000034, 12000034, 0, steps)));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryEasyDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(100, 100));
        assertEquals("_100|20\n"
                     + " 100|--\n"
                     + " ---|5\n"
                     + "   0",
                    integerLongDivisionViewProvider
                                .integerLongDivisionProvideView(new IntegerLongDivisionResult(100, 20, 0, steps)));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputEasyDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(83, 61));
        steps.add(new IntegerLongDivisionStep(225, 183));
        steps.add(new IntegerLongDivisionStep(427, 427));
        assertEquals("_8357|61\n"
                     + " 61  |---\n"
                     + " --  |137\n"
                     + "_225\n"
                     + " 183\n"
                     + " ---\n"
                     + " _427\n"
                     + "  427\n"
                     + "  ---\n"
                     + "    0",
                    integerLongDivisionViewProvider
                                .integerLongDivisionProvideView(new IntegerLongDivisionResult(8357, 61, 0, steps)));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputMediumDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(33, 24));
        steps.add(new IntegerLongDivisionStep(96, 96));
        steps.add(new IntegerLongDivisionStep(84, 84));
        assertEquals("_33684|12\n"
                    + " 24   |----\n"
                    + " --   |2807\n"
                    + " _96\n"
                    + "  96\n"
                    + "  --\n"
                    + "   _84\n"
                    + "    84\n"
                    + "    --\n"
                    + "     0",
                    integerLongDivisionViewProvider
                                .integerLongDivisionProvideView(new IntegerLongDivisionResult(33684, 12, 0, steps)));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputNotVeryDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(987, 891));
        steps.add(new IntegerLongDivisionStep(966, 891));
        steps.add(new IntegerLongDivisionStep(755, 693));
        steps.add(new IntegerLongDivisionStep(624, 594));
        steps.add(new IntegerLongDivisionStep(303, 297));
        steps.add(new IntegerLongDivisionStep(621, 594));
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
                     + "        27",
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                new IntegerLongDivisionResult(987654321, 99, 27, steps)));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputDifficultEnoughDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(12, 12));
        steps.add(new IntegerLongDivisionStep(0, 0));
        steps.add(new IntegerLongDivisionStep(0, 0));
        steps.add(new IntegerLongDivisionStep(0, 0));
        steps.add(new IntegerLongDivisionStep(0, 0));
        steps.add(new IntegerLongDivisionStep(7, 6));
        steps.add(new IntegerLongDivisionStep(12, 12));
        assertEquals("_12000072|6\n"
                     + " 12      |-------\n"
                     + " --      |2000012\n"
                     + "  _0\n"
                     + "   0\n"
                     + "   -\n"
                     + "   _0\n"
                     + "    0\n"
                     + "    -\n"
                     + "    _0\n"
                     + "     0\n"
                     + "     -\n"
                     + "     _0\n"
                     + "      0\n"
                     + "      -\n"
                     + "      _7\n"
                     + "       6\n"
                     + "       -\n"
                     + "      _12\n"
                     + "       12\n"
                     + "       --\n"
                     + "        0",
                    integerLongDivisionViewProvider
                                .integerLongDivisionProvideView(new IntegerLongDivisionResult(12000072, 6, 0, steps)));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryVeryDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(123, 99));
        steps.add(new IntegerLongDivisionStep(244, 198));
        steps.add(new IntegerLongDivisionStep(465, 396));
        steps.add(new IntegerLongDivisionStep(696, 693));
        steps.add(new IntegerLongDivisionStep(378, 297));
        steps.add(new IntegerLongDivisionStep(819, 792));
        assertEquals("_123456789|99\n"
                     + "  99      |-------\n"
                     + " ---      |1247038\n"
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
                     + "        27",
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                new IntegerLongDivisionResult(123456789, 99, 27, steps)));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputIncredоiblyDifficultIntegerDivisor() {
        List<IntegerLongDivisionStep> steps = new LinkedList<>();
        steps.add(new IntegerLongDivisionStep(9, 8));
        steps.add(new IntegerLongDivisionStep(18, 18));
        steps.add(new IntegerLongDivisionStep(7, 6));
        steps.add(new IntegerLongDivisionStep(10, 10));
        steps.add(new IntegerLongDivisionStep(0, 0));
        steps.add(new IntegerLongDivisionStep(0, 0));
        steps.add(new IntegerLongDivisionStep(3, 2));
        steps.add(new IntegerLongDivisionStep(12, 12));
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
                    + "        1",
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                new IntegerLongDivisionResult(987000321, 2, 1, steps)));
    }
}
