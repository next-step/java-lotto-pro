package lotto.auto;

import lotto.auto.common.LottoAutoUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.auto.common.Constants.DELIMITER;

public class LottoNumbers {
    private final int BEGIN_INDEX = 0;
    private final int LOTTO_NUMBER_LIST_SIZE = 6;

    private List<Integer> lottoNumbers;

    public LottoNumbers() {
        setUp();
        makeLottoNumbers();
    }

    public LottoNumbers(String inputStr) {
        setUp();
        stringToNumbersByToken(inputStr);
    }

    private void setUp() {
        lottoNumbers = new ArrayList<>();
    }

    private void stringToNumbersByToken(String inputStr) {
        String[] str = inputStr.split(DELIMITER);
        for (String number : str) {
            this.lottoNumbers.add(new LottoAutoUtils().stringToNumber(number));
        }
        Collections.sort(lottoNumbers);
    }

    private void makeLottoNumbers() {
        for (int num = 1; num <= 45; num++) {
            lottoNumbers.add(num);
        }
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(BEGIN_INDEX, BEGIN_INDEX + LOTTO_NUMBER_LIST_SIZE);
        Collections.sort(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
