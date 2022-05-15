package generator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.LottoNumber;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    public static final int LOTTO_SIZE_NUM = 6;
    private static final List<LottoNumber> LOTTO_NUMBERS_CACHE = initLottoNumbers();

    private static List<LottoNumber> initLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    private final List<LottoNumber> lottoNumbers;

    public RandomLottoNumberGenerator(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public RandomLottoNumberGenerator() {
        this(LOTTO_NUMBERS_CACHE);
    }

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(this.lottoNumbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE_NUM; i++) {
            lottoNumbers.add(this.lottoNumbers.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
