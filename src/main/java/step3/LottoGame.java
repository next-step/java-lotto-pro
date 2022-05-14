package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int PRICE_LOTTO = 1000;

    public static int ableToBuyLottoCount(int money) {
        return money / PRICE_LOTTO;
    }

    public List<Lotto> buy(int ableToBuyLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ableToBuyLottoCount; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
        return lottos;
    }

    public Lotto createWinnerLotto(List<Integer> winnerNumbers) {
        return new Lotto(winnerNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList())
        );
    }
}
