package step2.calculator.service;

import static step2.calculator.utils.DelimiterUtils.extractDelimiter;
import static step2.calculator.utils.DelimiterUtils.extractSplitTarget;
import static step2.calculator.utils.DelimiterUtils.hasAnyDelimiters;
import static step2.calculator.utils.DelimiterUtils.splitByDelimiterRegex;
import static step2.calculator.utils.StringUtils.isNullOrEmpty;
import static step2.calculator.validator.StringValidator.numericValidation;
import static step2.calculator.validator.StringValidator.positiveNumberValidation;

/**
 * @author : choi-ys
 * @date : 2022/05/13 5:30 오후
 */
public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        if (!hasAnyDelimiters(input)) {
            return stringToInt(input);
        }

        String delimiter = extractDelimiter(input);
        String splitTarget = extractSplitTarget(input);
        return sum(splitByDelimiterRegex(splitTarget, delimiter));
    }

    private static int stringToInt(String input) {
        numericValidation(input);
        positiveNumberValidation(input);
        return Integer.parseInt(input);
    }

    private static int sum(String[] values) {
        int total = 0;
        for (String value : values) {
            total += stringToInt(value);
        }
        return total;
    }
}
