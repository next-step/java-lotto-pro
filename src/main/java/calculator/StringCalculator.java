package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";

    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isNull(String input) {
        return input == null;
    }

    public static int plusOperation(String input) {
        if(isNull(input) || isEmpty(input)){
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(matcher.find()){
            delimiter += "|" + matcher.group(1);
            input = matcher.group(2);
        }

        int result = 0;
        List<String> strings = Arrays.asList(input.split(delimiter));

        for(String data : strings){
            validateNumber(data);
            result += Integer.parseInt(data);
        }
        return result;
    }

    public static void validateNumber(String input) {
        if(!Pattern.matches("^\\d*$", input)){
            throw new RuntimeException("숫자 이외의 문자가 포함되어 있습니다.");
        }
    }
}
