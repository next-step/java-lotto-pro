package calculator;

public class StringAddCalculator {

    private static int DEFAULT_VALUE = 0;
    private static String ERROR_MESSAGE_INVALID_NUMBER = "[ERROR] 양수가 아닌 문자 입력 값";
    private static String REGEX_DIGIT = "\\d+";

    public static int splitAndSum(String input) {
        if(isEmpty(input)){
            return DEFAULT_VALUE;
        }

        String[] stringFormatNumbers = StringSplitter.split(input);
        validateNumbers(stringFormatNumbers);

        return sumStringFormatNumbers(stringFormatNumbers);
    }

    private static boolean isEmpty(String input){
        return input == null || input.isEmpty();
    }

    private static void validateNumbers(String[] stringFormatNumbers){
        for(String str : stringFormatNumbers){
            validateNumber(str);
        }
    }

    private static void validateNumber(String stringFormatNumber){
        if(!stringFormatNumber.matches(REGEX_DIGIT)){
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NUMBER);
        }
    }

    private static int sumStringFormatNumbers(String[] stringFormatNumbers){
        int sum = 0;
        for(String str : stringFormatNumbers){
            sum += Integer.parseInt(str);
        }
        return sum;
    }

}
