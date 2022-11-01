package lotto.utils;

import lotto.constant.LottoMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {
    private static final String DELIMITER_COMMA = ",";
    private static final int LOTTO_NUMBERS_SIZE = 6;
    public static List<Integer> stringToLottoNumbers(String lottoWinNumber) {
        List<Integer> winNumbers = new ArrayList<>();
        String[] strSplit = lottoWinNumber.split(DELIMITER_COMMA);
        validateLottoSize(strSplit);
        for (String str : strSplit) {
            winNumbers.add(validateInt(str.trim()));
        }
        return winNumbers;
    }

    public static int stringToMoney(String money) {
        return validateInt(money);
    }

    private static void validateLottoSize(String[] strSplit) {
        if (strSplit.length != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_SIZE);
        }
    }

    private static Integer validateInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoMessage.ERROR_INVALD_NUM);
        }
    }
}
