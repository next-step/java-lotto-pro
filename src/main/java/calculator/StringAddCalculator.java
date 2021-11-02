package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if ("".equals(input) || input == null) {
            return 0;
        }
        String[] split = StringSplitter.split(input);
        List<Integer> numberList = new ArrayList<>();
        for (String numberString : split) {
            int number = convertNumber(numberString);
            numberList.add(number);

        }
        return numberList.stream().mapToInt(num -> num).sum();
    }

    private static int convertNumber(String numberString) {
        int number = Integer.parseInt(numberString);
        if (number < 0) {
            throw new RuntimeException("양수를 입력해야 합니다");
        }
        return number;
    }
}
