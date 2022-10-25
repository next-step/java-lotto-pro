package utils;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if(isTextNullOrEmpty(text)){
            return 0;
        }

        return 1;
    }

    private static boolean isTextNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

}
