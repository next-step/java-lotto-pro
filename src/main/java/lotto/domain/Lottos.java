package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.domain.LottoResults.ADD_COUNT_AMOUNT;
import static lotto.domain.LottoResults.DEFALUT_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int maxLottoCount = money.maxLottoCount();
        for(int i = 0; i < maxLottoCount; i++) {
            lottos.add(Lotto.generateLotto(new RandomLottoNumberGenerator()));
        }
        this.lottos = lottos;
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public Money findTotalPrice() {
        return new Money(lottos.size() * LOTTO_PRICE);
    }

    public LottoResults createLottoResults(Lotto winningLotto) {
        Map<LottoPrize, Integer> lottoResults = new HashMap<>();
        for(Lotto lotto: lottos) {
            LottoPrize lottoPrize = lotto.findLottoPrize(winningLotto);
            lottoResults.put(lottoPrize, lottoResults.getOrDefault(lottoPrize, DEFALUT_COUNT) + ADD_COUNT_AMOUNT);
        }
        return LottoResults.createLottoResults(lottoResults);
    }

    public List<Lotto> unmodifiedLottos() {
        return Collections.unmodifiableList(this.lottos);
    }
}
