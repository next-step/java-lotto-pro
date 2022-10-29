package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        for(int lottoNumber = MIN_LOTTO_NUMBER; lottoNumber <= MAX_LOTTO_NUMBER; lottoNumber++) {
            lottoNumbers.add(LottoNumber.from(lottoNumber));
        }
    }

    public RandomLottoNumberGenerator() {
    }

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> randomLottoNumbers = new ArrayList<>();
        for(int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            randomLottoNumbers.add(lottoNumbers.get(i));
        }
        Collections.sort(randomLottoNumbers);
        return randomLottoNumbers;
    }
}
