package study.step3;

import java.util.ArrayList;
import java.util.List;

public class LottoParser {
    public static final String SPLIT_DELIMITER = ",";
    public static final String SPACE_DELIMITER = " ";
    public static final String REPLACEMENT = "";

    public static List<Integer> stringToListInteger(String lottoNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] winLottoNumbersArray = lottoNumbers.replaceAll(SPACE_DELIMITER, REPLACEMENT).split(SPLIT_DELIMITER);
        for (String winLottoNumber : winLottoNumbersArray) {
            numbers.add(Integer.parseInt(winLottoNumber));
        }
        return numbers;
    }
}
