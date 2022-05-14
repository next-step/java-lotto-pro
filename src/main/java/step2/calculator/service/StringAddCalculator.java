package step2.calculator.service;

import static step2.calculator.utils.DelimiterUtils.extractDelimiter;
import static step2.calculator.utils.DelimiterUtils.extractSplitTarget;
import static step2.calculator.utils.DelimiterUtils.hasCommaOrColonDelimiters;
import static step2.calculator.utils.DelimiterUtils.hasCustomDelimiter;
import static step2.calculator.utils.DelimiterUtils.splitByDelimiterRegex;
import static step2.calculator.validator.StringValidator.numericValidation;
import static step2.calculator.validator.StringValidator.positiveNumberValidation;

import step2.calculator.utils.StringUtils;

/**
 * @author : choi-ys
 * @date : 2022/05/13 5:30 오후
 */
public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (StringUtils.isNullOrEmpty(input)) {
            return 0;
        }

        if (hasCustomDelimiter(input)) {
            String delimiter = extractDelimiter(input);
            String splitTarget = extractSplitTarget(input);
            return sum(splitByDelimiterRegex(splitTarget, delimiter));
        }

        if (!hasCommaOrColonDelimiters(input)) {
            numericValidation(input);
            positiveNumberValidation(input);
            return Integer.parseInt(input);
        }

        if (hasCommaOrColonDelimiters(input)) {
            String delimiter = extractDelimiter(input);
            return sum(splitByDelimiterRegex(input, delimiter));
        }
        return 99;
    }

    private static int sum(String[] values) {
        int total = 0;
        for (String value : values) {
            positiveNumberValidation(value);
            total += Integer.parseInt(value);
        }
        return total;
    }
}
