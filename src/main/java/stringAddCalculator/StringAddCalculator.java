package stringAddCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static stringAddCalculator.utils.Validation.*;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (isNotNullAndEmpty(input)){
            return 0;
        }
        if (isNumber(input)) {
            return Integer.parseInt(input);
        }
        if (!input.startsWith("//")) {
            return splitSumNormal(input);
        }

        return splicSumCustom(input);
    }
    
    public static int splitSumNormal(String input) {
        String[] numbers = input.split(",|:");
        return addArr(numbers);
    }

    public static int splicSumCustom(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return addArr(tokens);
        }
        throw new RuntimeException();
    }
    
    public static int addArr(String[] tokens) {
        int result = 0;
        for (String s : tokens) {
            isNumberAndSizeOne(s);
            result += Integer.parseInt(s);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        splitAndSum(br.readLine());
    }
}
