package lotto.auto.model;

import static lotto.auto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MAX;
import static lotto.auto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MIN;
import static lotto.auto.constant.LottoSetting.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoFactory {

    private static final List<LottoNumber> rangeLottoNumbers = new ArrayList<>();

    static {
        IntStream.range(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX)
            .forEach(i -> rangeLottoNumbers.add(new LottoNumber(i)));
    }

    private LottoAutoFactory() {
    }

    public static List<LottoNumber> randomLottoNumberByLottoSize() {
        Collections.shuffle(rangeLottoNumbers);
        return rangeLottoNumbers.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toList());
    }

}
