package utils;

public class StringAddCalculator {

    private static String DELIMITERS = ",|:";

    public static int splitAndSum(String text) {
        if(isTextNullOrEmpty(text)){
            return 0;
        }

        String[] texts = split(text);
        return sum(texts);
    }

    private static boolean isTextNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text){
        return text.split(DELIMITERS);
    }

    private static int sum(String[] texts){
        int sum = 0;
        for (String text: texts){
            sum += Integer.parseInt(text);
        }

        return sum;
    }

}
