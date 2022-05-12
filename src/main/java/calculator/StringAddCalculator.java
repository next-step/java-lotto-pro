package calculator;

public class StringAddCalculator {
    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        return 1;
    }

    static Integer[] splitForNumber(String input) {
        String[] split = input.split(",|:");
        return mapStringArrayToIntegerArray(split);
    }

    static Integer[] mapStringArrayToIntegerArray(String[] strings) {
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
