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

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    /**
     * 자동/수동 포함한 로또 생성기
     * @param maxLottoCount lottoNumberGenerator에 의해 생성할 로또 개수
     * @param lottoNumberGenerator
     * @param manualLottos 수동으로 기생성된 로또
     */
    public static Lottos mergeLottos(int maxLottoCount, LottoNumberGenerator lottoNumberGenerator, Lottos manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos.lottos);
        for(int i = 0; i < maxLottoCount; i++) {
            lottos.add(Lotto.generateLotto(lottoNumberGenerator));
        }
        return new Lottos(lottos);
    }

    public Money findTotalPrice() {
        return Money.createMoney((long) lottos.size() * LOTTO_PRICE);
    }

    public LottoResults createLottoResults(WinningLotto winningLotto) {
        Map<LottoPrize, Integer> lottoResults = new HashMap<>();
        for(Lotto lotto: lottos) {
            int matchCount = winningLotto.findLottoMatchCount(lotto);
            boolean isMatchBonusLottoNumber = winningLotto.isMatchBonusLottoNumber(lotto);
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(matchCount, isMatchBonusLottoNumber);
            lottoResults.put(lottoPrize, lottoResults.getOrDefault(lottoPrize, DEFALUT_COUNT) + ADD_COUNT_AMOUNT);
        }
        return LottoResults.createLottoResults(lottoResults);
    }

    public List<Lotto> unmodifiedLottos() {
        return Collections.unmodifiableList(this.lottos);
    }
}
