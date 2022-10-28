package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int sum;

    public static int splitAndSum(String target) {
        initSum();

        if(isNullOrEmpty(target)) {
            return sum;
        }


        if(target.length() == 1) {
            return sum = Integer.parseInt(target);
        }


        String[] numbers;
        // 패턴 그룹은 소괄호
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(target);
        if(m.find()) {
            String customDelimiter = m.group(1);

            // 특수문자 변경
            Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");

            if(pattern.matcher(target).find()) {
                customDelimiter = "[" + customDelimiter + "]";
            }

            numbers = m.group(2).split(customDelimiter);

        } else {
            numbers = target.split(",|:");
        }

        for(String i : numbers) {
            if(Integer.parseInt(i) < 0) {
                throw new RuntimeException("negati");
            }

            sum += Integer.parseInt(i);
        }


        return sum;
    }

    private static void initSum() {
        sum = 0;
    }

    private static boolean isNullOrEmpty(String target) {
        return target == null || target.isEmpty();
    }
}
