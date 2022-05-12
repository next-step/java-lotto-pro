package calculator;

public class StringAddCalculator {
    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Integer[] splitNumbers = splitForNumber(input);
        return sum(splitNumbers);
    }

    static int sum(Integer[] integers) {
        int result = 0;
        for (Integer integer : integers) {
            result += integer;
        }
        return result;
    }

    static Integer[] splitForNumber(String input) {
        if (input.startsWith("//") && input.contains("\n")) {
            return splitCustomDelimiter(input);
        }
        return splitFormalDelimiter(input);
    }

    private static Integer[] splitFormalDelimiter(String input) {
        return splitWithDelimiter(input, ",|:");
    }

    private static Integer[] splitCustomDelimiter(String input) {
        String[] split = input.split("\n");
        String customDelimiter = split[0].substring(2);
        return splitWithDelimiter(split[1], customDelimiter);
    }

    private static Integer[] splitWithDelimiter(String input, String delimiter) {
        String[] split = input.split(delimiter);
        return mapStringArrayToIntegerArray(split);
    }

    private static Integer[] mapStringArrayToIntegerArray(String[] strings) {
        Integer[] integers = new Integer[strings.length];
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
        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
