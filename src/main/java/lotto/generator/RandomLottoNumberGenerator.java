package lotto.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final List<LottoNumber> lottoNumbers = initLottoNumbers();

    private static List<LottoNumber> initLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.valueOf(i));
        }
        return lottoNumbers;
    }

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> shuffledLottoNumbers = new ArrayList<>();
        for (int i = 0; i < Lotto.SIZE; i++) {
            shuffledLottoNumbers.add(RandomLottoNumberGenerator.lottoNumbers.get(i));
        }
        Collections.sort(shuffledLottoNumbers);
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 0; i < Lotto.SIZE; i++) {
            lottoNumbers.add(shuffledLottoNumbers.get(i));
        }
        return lottoNumbers;
    }
}
