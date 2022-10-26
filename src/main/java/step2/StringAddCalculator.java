package step2;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;
    public static int splitAndSum(String text) {

        if(isEmptyOrNull(text))return DEFAULT_VALUE;

        return DEFAULT_VALUE;
    }

    private static boolean isEmptyOrNull(String text){
        return text == null || text.isEmpty();
    }



}
