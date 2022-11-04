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
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberAutoGenerator implements LottoNumberGenerator {
    private static final List<Integer> lottoNumberKeys = new ArrayList<>();

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumberKeys.add(number);
        }
    }

    @Override
    public Set<LottoNumber> generateSixNumbers() {
        Collections.shuffle(lottoNumberKeys);
        return lottoNumberKeys.stream()
                .map(LottoNumber::from)
                .limit(6)
                .collect(Collectors.toSet());
    }
}
