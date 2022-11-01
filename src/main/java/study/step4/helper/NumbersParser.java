package study.step4.helper;

import java.util.ArrayList;
import java.util.List;

public class NumbersParser {
    private static final String SPLIT_DELIMITER = ",";
    private static final String SPACE_DELIMITER = " ";
    private static final String REPLACEMENT = "";

    public static List<Integer> stringToListInteger(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] stringArray = inputNumbers.replaceAll(SPACE_DELIMITER, REPLACEMENT).split(SPLIT_DELIMITER);
        for (String winLottoNumber : stringArray) {
            numbers.add(Integer.parseInt(winLottoNumber));
        }
        return numbers;
    }
}
