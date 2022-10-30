package study;

public class Validator {
    public static boolean isNull(String text) {
        if(text == null){
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    public static boolean isNegativeNumber(int intValue) {
        return intValue<0;
    }
}
