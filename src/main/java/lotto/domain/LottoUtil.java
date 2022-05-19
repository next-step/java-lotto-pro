package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {

    private LottoUtil() {
        throw new UnsupportedOperationException();
    }

    public static List<LottoNumber> convertToLottoNumber(int[] intArray) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : intArray) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    public static int[] convertToIntArray(String[] lottoString) {
        int[] lottoNumbers = new int[lottoString.length];
        for (int i = 0; i < lottoString.length; i++) {
            lottoNumbers[i] = Integer.parseInt(lottoString[i]);
        }
        return lottoNumbers;
    }
}
