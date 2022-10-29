package string_add_calculator;

import string_add_calculator.util.StringAddCalculatorUtil;

public class StringAddCalculator {

    public int splitAndSum(String text) {
        int result = 0;
        if(text == null || text.isEmpty()) return 0;
        String[] numbers = text.split(",|:");
        for(String number : numbers) {
            result += StringAddCalculatorUtil.toInt(number);;
        }
        return result;
    }
}
