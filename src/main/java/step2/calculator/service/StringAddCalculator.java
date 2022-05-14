package step2.calculator.service;

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

        numericValidation(input);
        positiveNumberValidation(input);
        return Integer.parseInt(input);
    }
}
