package step2;

import java.util.Arrays;
import step2.utils.StringArrayElementValidator;
import step2.utils.StringToStringArrayResolver;

public class StringAdderCalculator {

    private static String[] splitArray = null;

    public static int splitAndSum(String source) {
        init();
        splitArray = StringToStringArrayResolver.resolve(source);
        try {
            StringArrayElementValidator.validateSplitResult(splitArray);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        return sumNumbers();
    }

    private static int sumNumbers() {
        return Arrays.stream(splitArray)
            .mapToInt(value -> Integer.parseInt(value))
            .sum();
    }

    private static void init() {
        splitArray = null;
    }


}
