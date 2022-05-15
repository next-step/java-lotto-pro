package lotto.model.factory;

import static lotto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MAX;
import static lotto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MIN;
import static lotto.constant.LottoSetting.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;

public class LottoAutoFactory implements ILottoFactory {

    private final List<LottoNumber> rangeLottoNumbers = new ArrayList<>();

    private LottoAutoFactory() {
        IntStream.rangeClosed(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX)
            .forEach(i -> rangeLottoNumbers.add(new LottoNumber(i)));
    }

    public static LottoAutoFactory create() {
        return new LottoAutoFactory();
    }

    public LottoNumbers generate() {
        Collections.shuffle(rangeLottoNumbers);
        return LottoNumbers.fromLottoNumberSet(rangeLottoNumbers.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toSet()));
    }

}
