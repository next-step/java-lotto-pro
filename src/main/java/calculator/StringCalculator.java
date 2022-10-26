package calculator;

import calculator.utils.CalculatorValidator;
import calculator.utils.StringCalculateParser;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.utils.CalculatorValidator.*;
import static calculator.utils.StringCalculateParser.parseStringToArray;

public class StringCalculator {

    public static final int NULL_OR_EMPTY_RETURN_VALUE = 0;

    public static int addOperation(String input) {
        if (isNull(input) || isEmpty(input)) {
            return NULL_OR_EMPTY_RETURN_VALUE;
        }

        return add(parseStringToArray(input));
    }

    private static int add(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            validateOnlyNumber(number);
            result += Integer.parseInt(number);
        }

        return result;
    }
}
