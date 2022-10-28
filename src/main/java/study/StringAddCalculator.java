package study;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (validateText(text)) {
            return 0;
        }
        
        if(inNumberOnly(text)){
            return Integer.parseInt(text);
        }

        return 1;
    }

    private static boolean inNumberOnly(String text) {
        try {
            parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int parseInt(String number){
        int parseInt = Integer.parseInt(number);
        return parseInt;
    }

    private static boolean validateText(String text) {
        return isNull(text) || isEmpty(text);
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }
}
