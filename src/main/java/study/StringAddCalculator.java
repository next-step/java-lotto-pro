package study;

public class StringAddCalculator {

    private static final int NUM_0 = 0;
    private static String[] numbers;
    public static int splitAndSum(String text) {
        if(Validator.isNull(text) || Validator.isEmpty(text)){
            return NUM_0;
        }

        numbers= StringUtils.split(text);

        return Calculator.sumNumbers(numbers);
    }


}
