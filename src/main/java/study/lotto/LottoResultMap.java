package study.lotto;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import study.lotto.enumtype.LottoRank;

public class LottoResultMap {
    private final EnumMap<LottoRank, List<Lotto>> resultMap;

    public LottoResultMap() {
        this.resultMap = new EnumMap<>(LottoRank.class);
    }

    public void addLotto(LottoRank lottoRank, Lotto lotto) {
        List<Lotto> lottos = resultMap.getOrDefault(lottoRank, new ArrayList<>());
        lottos.add(lotto);
        resultMap.put(lottoRank, lottos);
    }

    public int matchCount(LottoRank lottoRank) {
        return resultMap.getOrDefault(lottoRank, emptyList()).size();
    }

    public int allItemSize() {
        return resultMap.keySet().stream()
                .mapToInt(lottoWinningType -> resultMap.get(lottoWinningType).size())
                .sum();
    }

    public float calcLottoYield() {
        int totalWinnings = calcTotalWinnings();
        if (totalWinnings == 0) {
            return 0f;
        }

        int cost = LottoMoney.countAmount(allItemSize());
        return (float) totalWinnings / cost * 100f;
    }

    private int calcTotalWinnings() {
        return this.resultMap.keySet().stream()
                .mapToInt(
                        lottoWinningType -> matchCount(lottoWinningType) * lottoWinningType.getWinnings()
                ).sum();
    }
}
