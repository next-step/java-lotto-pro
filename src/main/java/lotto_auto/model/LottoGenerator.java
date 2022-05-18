package lotto_auto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto_auto.model.LottoNumber.MIN_NUMBER;
import static lotto_auto.model.LottoNumber.MAX_NUMBER;
import static lotto_auto.model.LottoNumbers.VALID_SIZE;

public class LottoGenerator {
    public static final List<LottoNumber> LOTTO_ALL_NUMBERS = IntStream
            .rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoGenerator() {}

    private static Lotto createLotto() {
        Collections.shuffle(LOTTO_ALL_NUMBERS);
        return new Lotto(new LottoNumbers(LOTTO_ALL_NUMBERS.subList(0, VALID_SIZE)));
    }

    public static Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i < count; i++) {
            lottos.add(createLotto());
        }

        return new Lottos(lottos);
    }
}
