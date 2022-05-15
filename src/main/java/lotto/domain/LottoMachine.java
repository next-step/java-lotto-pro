package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_SIZE;
import static lotto.constants.LottoConstants.MAX;
import static lotto.constants.LottoConstants.MIN;
import static lotto.constants.LottoConstants.START_INDEX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(MIN, MAX).boxed()
        .collect(Collectors.toList());

    private LottoMachine() {
    }

    public static List<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        return Collections.unmodifiableList(LOTTO_NUMBERS.subList(START_INDEX, LOTTO_NUMBER_SIZE));
    }

    public static Lottos createLottos(int price) {
        int count = price / LottoShop.LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generate()));
        }

        return new Lottos(lottos);
    }
}
