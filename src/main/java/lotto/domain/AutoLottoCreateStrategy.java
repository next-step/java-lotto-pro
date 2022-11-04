package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

public class AutoLottoCreateStrategy implements LottoCreateStrategy {
    private static final Map<Integer, LottoNumber> lottoNumberMap = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toMap(LottoNumber::lottoNumber, e -> e));
    @Override
    public Lotto createLotto() {
        List<LottoNumber> origin = new ArrayList<>(lottoNumberMap.values());
        Collections.shuffle(origin);

        List<LottoNumber> destination = new ArrayList<>(origin.subList(0, 6));
        Collections.sort(destination);
        return new Lotto(destination);
    }
}
