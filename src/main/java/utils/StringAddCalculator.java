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

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DELIMITERS);
    }

    private static int sum(String[] texts){
        int sum = 0;
        for (String text: texts){
            sum += parseInt(text);
        }

        return sum;
    }

}
