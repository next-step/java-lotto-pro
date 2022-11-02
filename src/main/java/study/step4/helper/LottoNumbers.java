package study.step4.helper;

import study.step4.models.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public static List<LottoNumber> shuffledLottoNumbers() {
        if (lottoNumbers.isEmpty()) {
            addLottoNumbers();
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static void addLottoNumbers() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }
}
