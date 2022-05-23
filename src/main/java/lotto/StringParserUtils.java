package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringParserUtils {

    private StringParserUtils() { }

    public static List<Integer> parseNumbers(String numbers) {
        String[] stringNumbers = numbers.split(",");
        if (stringNumbers.length != 6) {
            throw new IllegalArgumentException("Array size should be 6.");
        }

        List<Integer> result = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            result.add(Integer.parseInt(stringNumber.trim()));
        }

        Collections.sort(result);
        return result;
    }

}
