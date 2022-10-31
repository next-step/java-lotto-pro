package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static step3.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

public class LottoMachine {
    private static final Map<Integer, LottoNumber> lottoNumberMap = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toMap(LottoNumber::lottoNumber, e -> e));

    private LottoMachine() {

    }

    public static Lotto getLotto() {
        List<LottoNumber> origin = new ArrayList<>(lottoNumberMap.values());
        Collections.shuffle(origin);

        List<LottoNumber> destination = new ArrayList<>(origin.subList(0, 6));
        Collections.sort(destination);
        return new Lotto(destination);
    }
}
