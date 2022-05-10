import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static NumberValidator numberValidator;
    public static int splitAndSum(String text) {
        numberValidator = new NumberValidator(text);
        return numberValidator.getNumber();
    }


}
