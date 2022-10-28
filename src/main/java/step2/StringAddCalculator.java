package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {


    public static int splitAndSum(String reqStr) {
        int resultSum = 0;

        if(reqStr == null) {
            return resultSum;
        }

        if(reqStr.isEmpty()) {
            return resultSum;
        }

        String[] numbers;
        // 패턴 그룹은 소괄호
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(reqStr);
        if(m.find()) {
            String customDelimiter = m.group(1);

            // 특수문자 변경
            Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");

            if(pattern.matcher(reqStr).find()) {
                customDelimiter = "[" + customDelimiter + "]";
            }

            numbers = m.group(2).split(customDelimiter);

        } else {
            numbers = reqStr.split(",|:");
        }

        for(String i : numbers) {
            if(Integer.parseInt(i) < 0) {
                throw new RuntimeException("negati");
            }

            resultSum += Integer.parseInt(i);
        }


        return resultSum;
    }
}
