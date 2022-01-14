package ua.com.foxminded.integerdivision.provider;

import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;

public interface IntegerLongDivisionMathProvider {
    IntegerLongDivisionResult provideMathIntegerLongDivision(int dividend,
                                                             int divider);
}
