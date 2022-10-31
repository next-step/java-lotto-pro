package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {
    public static List<Integer> stringToLottoNumbers(String lottoWinNumber) {
        List<Integer> winNumbers = new ArrayList<>();
        String[] strSplit = lottoWinNumber.split(",");
        for (String str : strSplit) {
            winNumbers.add(validateInt(str.trim()));
        }
        return winNumbers;
    }

    private static Integer validateInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 올바른 숫자가 아닙니다.");
        }
    }
}
