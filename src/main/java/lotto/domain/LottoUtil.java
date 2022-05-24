package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoUtil {

    public static final int LOTTO_SIZE = 6;

    private LottoUtil() {
        throw new UnsupportedOperationException();
    }

    public static List<LottoNumber> convertToLottoNumber(int[] intArray) {
        validateLottoSize(intArray.length);
        validateDuplication(intArray);
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

    public static void validateDuplication(int[] lottoNumberArray) {
        Set<Integer> lottoNumberSet = Arrays.stream(lottoNumberArray).boxed()
            .collect(Collectors.toSet());
        if (lottoNumberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("6자리 숫자를 중복 없이 입력하세요.");
        }
    }
}
