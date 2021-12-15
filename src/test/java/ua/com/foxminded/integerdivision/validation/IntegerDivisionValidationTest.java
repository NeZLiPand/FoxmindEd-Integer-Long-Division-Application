package ua.com.foxminded.integerdivision.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


class IntegerDivisionValidationTest {
    private static final int ONE = 1;
    private static final int ZERO = 0;

    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerDivisionValidation.validateValues(ONE, ZERO);
        });
    }
    
    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainNegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerDivisionValidation.validateValues(ONE, -ONE);
        });
    }

    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainNegativeOneAndSecondNumberContainOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerDivisionValidation.validateValues(-ONE, ONE);
        });
    }
}
