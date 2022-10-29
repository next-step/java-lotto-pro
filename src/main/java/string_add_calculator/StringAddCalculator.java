package string_add_calculator;

import string_add_calculator.util.StringAddCalculatorUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final String splitter = ",|:";

    public int splitAndSum(String text) {
        if(text == null || text.isEmpty()) return 0;
        String[] numbers = splitText(text);
        if(numbers.length == 0) throw new RuntimeException();
        int result = 0;
        for(String number : numbers) {
            result += StringAddCalculatorUtil.toInt(number);;
        }
        return result;
    }

    private String[] splitText(String text) {
        String[] numbers = text.split(splitter);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter + "|" + splitter);
        }
        return numbers;
    }
}
