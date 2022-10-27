package calculator;

public class NumberValidator {

    private static String ERROR_MESSAGE_INVALID_NUMBER = "[ERROR] 양수가 아닌 문자 입력 값";
    private static String REGEX_DIGIT = "\\d+";

    public static boolean isEmpty(String input){
        return input == null || input.isEmpty();
    }

    public static void validateNumbers(String[] stringFormatNumbers){
        for(String str : stringFormatNumbers){
            validateNumber(str);
        }
    }

    public static void validateNumber(String stringFormatNumber){
        if(!stringFormatNumber.matches(REGEX_DIGIT)){
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NUMBER);
        }
    }

}
