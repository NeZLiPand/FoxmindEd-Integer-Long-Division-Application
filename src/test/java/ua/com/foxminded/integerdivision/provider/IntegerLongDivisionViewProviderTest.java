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
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(120_000, 120_000));
        assertEquals("_12000034|120000\n"
                     + " 120000  |------\n"
                     + " ------  |100\n"
                     + "       34",
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(12_000_034)
                                                         .withDivisor(120_000)
                                                         .withRemainder(34)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryEasyDifficultyIntegerDivisor2() {
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(12_000_034, 12_000_034));
        assertEquals("_12000034|12000034\n"
                     + " 12000034|--------\n"
                     + " --------|1\n"
                     + "        0",
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(12_000_034)
                                                         .withDivisor(12_000_034)
                                                         .withRemainder(0)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryEasyDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(100, 100));
        assertEquals("_100|20\n"
                     + " 100|--\n"
                     + " ---|5\n"
                     + "   0",
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(100)
                                                         .withDivisor(20)
                                                         .withRemainder(0)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputEasyDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(83, 61));
        divisionSteps.add(new IntegerLongDivisionStep(225, 183));
        divisionSteps.add(new IntegerLongDivisionStep(427, 427));
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
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(8_357)
                                                         .withDivisor(61)
                                                         .withRemainder(0)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputMediumDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(33, 24));
        divisionSteps.add(new IntegerLongDivisionStep(96, 96));
        divisionSteps.add(new IntegerLongDivisionStep(84, 84));
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
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(33_684)
                                                         .withDivisor(12)
                                                         .withRemainder(0)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputNotVeryDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(987, 891));
        divisionSteps.add(new IntegerLongDivisionStep(966, 891));
        divisionSteps.add(new IntegerLongDivisionStep(755, 693));
        divisionSteps.add(new IntegerLongDivisionStep(624, 594));
        divisionSteps.add(new IntegerLongDivisionStep(303, 297));
        divisionSteps.add(new IntegerLongDivisionStep(621, 594));
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
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(987_654_321)
                                                         .withDivisor(99)
                                                         .withRemainder(27)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputDifficultEnoughDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(12, 12));
        divisionSteps.add(new IntegerLongDivisionStep(0, 0));
        divisionSteps.add(new IntegerLongDivisionStep(0, 0));
        divisionSteps.add(new IntegerLongDivisionStep(0, 0));
        divisionSteps.add(new IntegerLongDivisionStep(0, 0));
        divisionSteps.add(new IntegerLongDivisionStep(7, 6));
        divisionSteps.add(new IntegerLongDivisionStep(12, 12));
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
                    integerLongDivisionViewProvider.integerLongDivisionProvideView(
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(12_000_072)
                                                         .withDivisor(6)
                                                         .withRemainder(0)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputVeryVeryDifficultyIntegerDivisor() {
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(123, 99));
        divisionSteps.add(new IntegerLongDivisionStep(244, 198));
        divisionSteps.add(new IntegerLongDivisionStep(465, 396));
        divisionSteps.add(new IntegerLongDivisionStep(696, 693));
        divisionSteps.add(new IntegerLongDivisionStep(378, 297));
        divisionSteps.add(new IntegerLongDivisionStep(819, 792));
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
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(123_456_789)
                                                         .withDivisor(99)
                                                         .withRemainder(27)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }

    @Test
    void testconvertOnLongIntegerDivision_shouldReturnIntegerLongDivisionView_whenInputIncredоiblyDifficultIntegerDivisor() {
        List<IntegerLongDivisionStep> divisionSteps = new LinkedList<>();
        divisionSteps.add(new IntegerLongDivisionStep(9, 8));
        divisionSteps.add(new IntegerLongDivisionStep(18, 18));
        divisionSteps.add(new IntegerLongDivisionStep(7, 6));
        divisionSteps.add(new IntegerLongDivisionStep(10, 10));
        divisionSteps.add(new IntegerLongDivisionStep(0, 0));
        divisionSteps.add(new IntegerLongDivisionStep(0, 0));
        divisionSteps.add(new IntegerLongDivisionStep(3, 2));
        divisionSteps.add(new IntegerLongDivisionStep(12, 12));
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
                                IntegerLongDivisionResult.builder()
                                                         .withDivided(987_000_321)
                                                         .withDivisor(2)
                                                         .withRemainder(1)
                                                         .withDivisionSteps(divisionSteps)
                                                         .build()));
    }
}
