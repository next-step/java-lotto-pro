package camp.nextstep.edu.until;

public class TypeCheckHelper {
    private static final String NUMBER_REGEX = "-?\\d+";

    public static boolean isPossibleStringToInteger(String value) {
        return value.matches(NUMBER_REGEX);
    }
}
