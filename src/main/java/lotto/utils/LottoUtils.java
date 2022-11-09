package lotto.utils;

import lotto.constant.LottoMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {
    private static final String DELIMITER_COMMA = ",";
    public static List<Integer> stringToLottoNumbers(String lottoWinNumber) {
        List<Integer> winNumbers = new ArrayList<>();
        String[] strSplit = lottoWinNumber.split(DELIMITER_COMMA);
        for (String str : strSplit) {
            winNumbers.add(validateInt(str.trim()));
        }
        return winNumbers;
    }

    public static int StringToInt(String str) {
        return validateInt(str);
    }

    private static Integer validateInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoMessage.ERROR_INVALD_NUM);
        }
    }
}
