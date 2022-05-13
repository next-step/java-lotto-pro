package step2;

import java.util.ArrayList;
import java.util.Arrays;
import step2.argumentresolver.CustomDelimiterStringArrayResolver;
import step2.argumentresolver.DefaultDelimiterStringArrayResolver;
import step2.argumentresolver.EmptyInputStringArrayResolver;
import step2.argumentresolver.SingleNumberStringArrayResolver;
import step2.argumentresolver.StringArrayResolver;
import step2.validator.NotNumberValidator;
import step2.validator.PositiveNumberValidator;
import step2.validator.Validator;

public class StringAdderCalculator {

    private static final ArrayList<StringArrayResolver> STRING_ARRAY_RESOLVERS = new ArrayList<StringArrayResolver>();
    private static final ArrayList<Validator> validators = new ArrayList<Validator>();
    private static String[] splitArray = null;

    public static int splitAndSum(String source) {
        init();
        getSplitArrayByInput(source);
        validateInput();
        return sumNumbers();
    }

    private static void validateInput() {
        boolean validateResult = true;
        for (int i = 0; i < validators.size() && validateResult; i++) {
            validateResult = validators.get(i).validate(splitArray);
        }
        if (!validateResult) {
            throw new RuntimeException();
        }
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

        validators.add(new NotNumberValidator());
        validators.add(new PositiveNumberValidator());
    }


}
