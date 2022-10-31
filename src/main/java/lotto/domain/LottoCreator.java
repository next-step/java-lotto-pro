package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreator {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private static final List<Integer> baseLottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX).boxed().collect(Collectors.toList());

    public static Lottos buyLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }
        return new Lottos(lottos);
    }

    private static Lotto createLotto() {
        Collections.shuffle(baseLottoNumbers);
        return new Lotto(baseLottoNumbers.subList(0,LOTTO_NUMBERS_SIZE));
    }

}
