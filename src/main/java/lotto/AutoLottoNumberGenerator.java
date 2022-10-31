/*
 * AutoLottoNumberGenerator.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.LOTTO_END_NUMBER;
import static lotto.Constant.LOTTO_START_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    List<Integer> lottoNumbers = new ArrayList<>();

    AutoLottoNumberGenerator() {
        initialize();
    }

    private void initialize() {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumbers.add(number);
        }
    }

    @Override
    public List<Integer> generateSixNumbers() {
        Collections.shuffle(lottoNumbers);
        List<Integer> sixNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(sixNumbers);
        return sixNumbers;
    }
}
