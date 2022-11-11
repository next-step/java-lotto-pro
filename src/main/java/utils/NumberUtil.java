package utils;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {
    public static List<Integer> numbers(String[] text) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : text) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
