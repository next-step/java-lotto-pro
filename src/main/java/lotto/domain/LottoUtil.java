package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {

    private static final int LOTTO_SIZE = 6;

    private LottoUtil() {
        throw new UnsupportedOperationException();
    }

    public static List<LottoNumber> convertToLottoNumber(int[] intArray) {
        validateLottoSize(intArray.length);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : intArray) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    public static int[] convertLottoStringToIntArray(String[] lottoString) {
        validateLottoSize(lottoString.length);

        int[] lottoNumbers = new int[lottoString.length];
        for (int i = 0; i < lottoString.length; i++) {
            lottoNumbers[i] = Integer.parseInt(lottoString[i]);
        }
        return lottoNumbers;
    }

    private static void validateLottoSize(int lottoLength) {
        if (lottoLength != LOTTO_SIZE) {
            throw new IllegalArgumentException("6자리 숫자를 , 로 구분하여 입력하세요");
        }
    }
}
