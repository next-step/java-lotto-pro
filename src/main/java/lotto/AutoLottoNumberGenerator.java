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
import java.util.stream.Collectors;

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
    public List<LottoNumber> generateSixNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
