package ua.com.foxminded.integerdivision.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerdivision.validator.IntegerLongDivisionValidator;
import ua.com.foxminded.integerdivision.validator.IntegerLongDivisionValidatorImpl;

class IntegerDivisionValidationTest {
    IntegerLongDivisionValidator integerLongDivisionValidator = new IntegerLongDivisionValidatorImpl();

    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            integerLongDivisionValidator.validate(1, 0);
        });
    }

    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainNegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            integerLongDivisionValidator.validate(1, -1);
        });
    }

    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainNegativeOneAndSecondNumberContainOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            integerLongDivisionValidator.validate(-1, 1);
        });
    }

    @Test
    void testValidateValues_shouldNotThrowAnException_whenInputFirstNumberContainDecimalBaseAndSecondNumberContainOne() {
        assertDoesNotThrow(() -> {
            integerLongDivisionValidator.validate(10, 1);
        });
    }
}
