package ua.com.foxminded.integerdivision.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionMathProvider;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionViewProvider;
import ua.com.foxminded.integerdivision.validator.IntegerLongDivisionValidator;

@ExtendWith(MockitoExtension.class)
class IntegerLongDivisionCalculatorMockitoTest {

    @Mock
    private IntegerLongDivisionValidator integerLongDivisionValidator;
    @Mock
    private IntegerLongDivisionMathProvider integerLongDivisionMathProvider;
    @Mock
    private IntegerLongDivisionViewProvider integerLongDivisionViewProvider;
    @Mock
    private IntegerLongDivisionResult integerLongDivisionResult;

    @InjectMocks
    private IntegerLongDivisionCalculator integerLongDivisionCalculator;

    @Test
    void TestCalculateDivision_shouldReturnIllegalArgumentException_whenInputDividedIsLessThanZero() {
        doThrow(new IllegalArgumentException("divided is less than zero")).when(integerLongDivisionValidator)
                                                                          .validate(anyInt(), anyInt());
        assertThrows(IllegalArgumentException.class, () -> {
            integerLongDivisionCalculator.calculateDivision(-5, 2);
        });
        verify(integerLongDivisionValidator, times(1)).validate(-5, 2);
        verify(integerLongDivisionValidator, times(1)).validate(anyInt(), anyInt());
        verifyNoMoreInteractions(integerLongDivisionValidator);
    }

    @Test
    void TestCalculateDivision_shouldReturnSketchOfCalculateDivision_whenInputValidDividedAndDivisor() {
        doNothing().when(integerLongDivisionValidator)
                   .validate(anyInt(), anyInt());
        doReturn(integerLongDivisionResult).when(integerLongDivisionMathProvider)
                                           .provideMathIntegerLongDivision(anyInt(), anyInt());
        doReturn("_4|2\n"
                 + " 4|-\n"
                 + " -|2\n"
                 + " 0").when(integerLongDivisionViewProvider)
                        .integerLongDivisionProvideView(any());
        assertEquals("_4|2\n"
                     + " 4|-\n"
                     + " -|2\n"
                     + " 0",
                    integerLongDivisionCalculator.calculateDivision(4, 2));
    }
}
