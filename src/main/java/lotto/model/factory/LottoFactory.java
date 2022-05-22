package lotto.model.factory;

import static lotto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MAX;
import static lotto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MIN;
import static lotto.constant.LottoSetting.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.Lotto;

public class LottoFactory implements ILottoFactory {

    private static final List<LottoNumber> rangeLottoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX)
            .forEach(i -> rangeLottoNumbers.add(new LottoNumber(i)));
    }

    public static LottoFactory create() {
        return new LottoFactory();
    }

    private Lotto generateAuto() {
        Collections.shuffle(rangeLottoNumbers);
        return Lotto.fromLottoNumber(rangeLottoNumbers.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toSet()));
    }

    @Override
    public List<Lotto> generateAuto(int lottoCount) {
        return IntStream.rangeClosed(1, lottoCount)
            .mapToObj(operand -> generateAuto())
            .collect(Collectors.toList());
    }

}
