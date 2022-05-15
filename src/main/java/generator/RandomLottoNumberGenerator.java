package generator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final List<LottoNumber> LOTTO_NUMBERS = initLottoNumbers();

    private static List<LottoNumber> initLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < Lotto.LOTTO_SIZE_NUM; i++) {
            lottoNumbers.add(LOTTO_NUMBERS.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
