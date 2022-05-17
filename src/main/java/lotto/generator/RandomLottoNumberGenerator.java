package lotto.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final List<LottoNumber> LOTTO_NUMBERS = initLottoNumbers();

    private static List<LottoNumber> initLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            lottoNumbers.add(LottoNumber.valueOf(i));
        }
        return lottoNumbers;
    }

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 0; i < Lotto.SIZE; i++) {
            lottoNumbers.add(LOTTO_NUMBERS.get(i));
        }
        return lottoNumbers;
    }
}
