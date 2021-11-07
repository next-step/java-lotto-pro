package calculator;

import calculator.domain.Result;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final String DEFAULT_DELIMITER = "[,:]";
    private final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public void start() {
        System.out.println("계산할 값을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        int result = splitAndSum(sc.next());
        System.out.println("결과 : " + result);
    }

    public int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }
        String[] values = getValues(value);
        Result result = new Result(values);
        return result.getResult();
    }

    private String[] getValues(String value) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(value);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            value = matcher.group(2);
        }
        return value.split(delimiter);
    }
}
