package step2;

import java.util.ArrayList;
import java.util.Arrays;
import step2.ArgumentResolver.CustomResolver;
import step2.ArgumentResolver.DefaultResolver;
import step2.ArgumentResolver.EmptyStringResolver;
import step2.ArgumentResolver.InputSingleNumberResolver;
import step2.ArgumentResolver.Resolver;
import step2.validator.NotNumberValidator;
import step2.validator.PositiveNumberValidator;
import step2.validator.Validator;

public class StringAdderCalculator {

    private static final ArrayList<Resolver> resolvers = new ArrayList<Resolver>();
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
        for (int i = 0; i < resolvers.size() && splitArray == null; i++) {
            executeResolver(source, resolvers.get(i));
        }
    }

    private static void executeResolver(String source, Resolver resolver) {
        if (resolver.canResolve(source)) {
            splitArray = resolver.resolve(source);
        }
    }

    private static int sumNumbers() {
        return Arrays.stream(splitArray)
            .mapToInt(value -> Integer.parseInt(value))
            .sum();
    }

    private static void init() {
        splitArray = null;

        resolvers.add(new EmptyStringResolver());
        resolvers.add(new InputSingleNumberResolver());
        resolvers.add(new DefaultResolver());
        resolvers.add(new CustomResolver());

        validators.add(new NotNumberValidator());
        validators.add(new PositiveNumberValidator());
    }


}
