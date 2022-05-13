package step2;

import java.util.ArrayList;
import java.util.Arrays;
import step2.argumentresolver.CustomDelimiterStringArrayResolver;
import step2.argumentresolver.DefaultDelimiterStringArrayResolver;
import step2.argumentresolver.EmptyInputStringArrayResolver;
import step2.argumentresolver.SingleNumberStringArrayResolver;
import step2.argumentresolver.StringArrayResolver;
import step2.utils.StringArrayElementValidator;

public class StringAdderCalculator {

    private static final ArrayList<StringArrayResolver> STRING_ARRAY_RESOLVERS = new ArrayList<StringArrayResolver>();
    private static String[] splitArray = null;

    public static int splitAndSum(String source) {
        init();
        getSplitArrayByInput(source);
        try {
            StringArrayElementValidator.validateSplitResult(splitArray);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        return sumNumbers();
    }


    private static void getSplitArrayByInput(String source) {
        for (int i = 0; i < STRING_ARRAY_RESOLVERS.size() && splitArray == null; i++) {
            executeResolver(source, STRING_ARRAY_RESOLVERS.get(i));
        }
    }

    private static void executeResolver(String source, StringArrayResolver stringArrayResolver) {
        if (stringArrayResolver.canResolve(source)) {
            splitArray = stringArrayResolver.resolve(source);
        }
    }

    private static int sumNumbers() {
        return Arrays.stream(splitArray)
            .mapToInt(value -> Integer.parseInt(value))
            .sum();
    }

    private static void init() {
        splitArray = null;

        STRING_ARRAY_RESOLVERS.add(new EmptyInputStringArrayResolver());
        STRING_ARRAY_RESOLVERS.add(new SingleNumberStringArrayResolver());
        STRING_ARRAY_RESOLVERS.add(new DefaultDelimiterStringArrayResolver());
        STRING_ARRAY_RESOLVERS.add(new CustomDelimiterStringArrayResolver());
    }


}
