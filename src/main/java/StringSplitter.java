import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMIT_REGEX = "//(.)\n(.*)";
    private static final int ZERO = 0;

    //유틸성 클래스로만 사용하기 위한 조치
    private StringSplitter(){}

    public static List<Integer> getNumbers(String expression) {
        Matcher customDelimitMatcher = Pattern.compile(CUSTOM_DELIMIT_REGEX).matcher(expression);
        String[] numbers = null;
        if(customDelimitMatcher.find()){
            String customDelimiter = customDelimitMatcher.group(1);
            numbers = customDelimitMatcher.group(2).split(customDelimiter);
            return convertNumbers(numbers);
        }
        numbers = expression.split(DEFAULT_DELIMITER);
        return convertNumbers(numbers);
    }

    private static List<Integer> convertNumbers(String[] numbers){
        List<Integer> numberList = new ArrayList<>();
        for (String numberString : numbers) {
            int number = Integer.parseInt(numberString);
            checkNagative(number);
            numberList.add(number);
        }
        return numberList;
    }

    private static void checkNagative(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException("양수만 계산 가능합니다.");
        }
    }
}
