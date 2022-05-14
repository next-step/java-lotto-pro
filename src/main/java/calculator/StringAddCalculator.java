package calculator;

public class StringAddCalculator {
    private final static int CUSTOM_DELIMITER_INDEX = 0;
    private final static int CUSTOM_INPUT_INDEX = 1;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int[] splitNumbers = splitForNumber(input);
        return sum(splitNumbers);
    }

    static int sum(int[] integers) {
        int result = 0;
        for (Integer integer : integers) {
            result += integer;
        }
        return result;
    }

    static int[] splitForNumber(String input) {
        if (input.startsWith("//") && input.contains(System.lineSeparator())) {
            return splitCustomDelimiter(input);
        }
        return splitFormalDelimiter(input);
    }

    private static int[] splitFormalDelimiter(String input) {
        return splitWithDelimiter(input, ",|:");
    }

    private static int[] splitCustomDelimiter(String input) {
        String[] split = input.split("\n");
        String customDelimiter = split[CUSTOM_DELIMITER_INDEX].substring(2);
        return splitWithDelimiter(split[CUSTOM_INPUT_INDEX], customDelimiter);
    }

    private static int[] splitWithDelimiter(String input, String delimiter) {
        String[] split = input.split(delimiter);
        return mapStringArrayToIntegerArray(split);
    }

    private static int[] mapStringArrayToIntegerArray(String[] strings) {
        int[] integers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = mapStringToPositiveInteger(strings[i]);
        }
        return integers;
    }

    private static Integer mapStringToPositiveInteger(String string) {
        Integer integer = mapStringToInteger(string);
        if (integer < 0) {
            throw new RuntimeException("입력한 숫자가 음수입니다.");
        }
        return integer;
    }

    private static Integer mapStringToInteger(String string) {
        return Integer.valueOf(string);
    }
}
