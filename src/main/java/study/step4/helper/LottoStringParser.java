package study.step4.helper;

import study.step4.models.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoStringParser {
    private static final String SPLIT_DELIMITER = ",";
    private static final String SPACE_DELIMITER = " ";
    private static final String REPLACEMENT = "";

    public static List<LottoNumber> stringToLottoNumbers(String inputNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        String[] stringArray = inputNumbers.replaceAll(SPACE_DELIMITER, REPLACEMENT).split(SPLIT_DELIMITER);
        for (String winLottoNumber : stringArray) {
            numbers.add(new LottoNumber(Integer.parseInt(winLottoNumber)));
        }
        return numbers;
    }
}
