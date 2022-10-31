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

    public Lottos(Money money, LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        int maxLottoCount = money.maxLottoCount();
        for(int i = 0; i < maxLottoCount; i++) {
            lottos.add(Lotto.generateLotto(lottoNumberGenerator));
        }
        this.lottos = lottos;
    }

    public Lottos(int maxLottoCount, LottoNumberGenerator lottoNumberGenerator, List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos); // TODO manualLottos null일 때 이슈 없는지 체크
        for(int i = 0; i < maxLottoCount; i++) {
            lottos.add(Lotto.generateLotto(lottoNumberGenerator));
        }
        this.lottos = lottos;
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Money findTotalPrice() {
        return Money.createMoney((long) lottos.size() * LOTTO_PRICE);
    }

    public LottoResults createLottoResults(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        Map<LottoPrize, Integer> lottoResults = new HashMap<>();
        for(Lotto lotto: lottos) {
            int matchCount = lotto.findLottoMatchCount(winningLotto);
            boolean isMatchBonusLottoNumber = lotto.isMatchLottoNumber(bonusLottoNumber);
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(matchCount, isMatchBonusLottoNumber);
            lottoResults.put(lottoPrize, lottoResults.getOrDefault(lottoPrize, DEFALUT_COUNT) + ADD_COUNT_AMOUNT);
        }
        return LottoResults.createLottoResults(lottoResults);
    }

    public List<Lotto> unmodifiedLottos() {
        return Collections.unmodifiableList(this.lottos);
    }
}
