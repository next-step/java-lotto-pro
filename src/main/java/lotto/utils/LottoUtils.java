package lotto.utils;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.*;

public class LottoUtils {

    private LottoUtils() {

    }
    // 랜덤한 숫자를 생성하도록 기능 추가
    private static final int MAX_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static LottoNumbers generateLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);

        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(new LottoNumber(lottoNumbers.get(i)));
        }


        return new LottoNumbers(numbers);
    }

}
