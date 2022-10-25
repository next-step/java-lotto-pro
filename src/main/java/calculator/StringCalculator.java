package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static int isEmpty(String input) {
        return 0;
    }

    public static int isNull(String input) {
        return 0;
    }

    public static int plusOperationByComma(String input) {
        List<String> strings = Arrays.asList(input.split(","));
        int result = 0;

        for(String data : strings){
            result += Integer.valueOf(data);
        }
        return result;
    }
}
