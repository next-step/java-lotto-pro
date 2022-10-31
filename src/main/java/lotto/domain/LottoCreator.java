package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreator {

    private static final List<Integer> baseLottoNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public static Lottos buyLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }
        return new Lottos(lottos);
    }

    private static Lotto createLotto() {
        Collections.shuffle(baseLottoNumbers);
        return new Lotto(baseLottoNumbers.subList(0,6));
    }

}
