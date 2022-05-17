package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class UnsignedIntegers {

    public static final String ILLEGAL_ARG_NOT_INT_EXCEPTION = "숫자(정수 형태) 이외의 값입니다.";
    public static final String ILLEGAL_ARG_NEGATIVE_EXCEPTION = "음수입니다.";

    private final List<Integer> numbers;

    public UnsignedIntegers(String[] nums) {
        validateSummable(nums);
        this.numbers = parseUnsignedInts(nums);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSummable(String[] nums) {
        for (String num : nums) {
            validateInt(num);
            validateUnsignedInt(num);
        }
    }

    private void validateInt(String num) {
        if (num.isEmpty()) {
            return;
        }

        if (!isInt(num)) {
            throw new IllegalArgumentException(ILLEGAL_ARG_NOT_INT_EXCEPTION);
        }
    }

    private void validateUnsignedInt(String num) {
        if (num.isEmpty()) {
            return;
        }

        if (Integer.parseInt(num) < 0) {
            throw new IllegalArgumentException(ILLEGAL_ARG_NEGATIVE_EXCEPTION);
        }
    }

    private boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private List<Integer> parseUnsignedInts(String[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : nums) {
            numbers.add(parseUnsignedInt(num));
        }

        return numbers;
    }

    private int parseUnsignedInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(s);
    }
}
