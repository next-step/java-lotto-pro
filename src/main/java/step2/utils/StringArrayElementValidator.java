package step2.utils;

public class StringArrayElementValidator {

    public static void validateSplitResult(String[] sources) {
        try {
            checkPositiveElement(sources);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 문자가 포함되어있습니다");
        }
    }

    private static void checkPositiveElement(String[] sources) {
        boolean validateResult = true;
        for (int i = 0; i < sources.length && validateResult; i++) {
            validateResult = Integer.parseInt(sources[i]) >= 0;
        }
        if (!validateResult) {
            throw new RuntimeException("음수가 포함되어 있습니다");
        }
    }
}
