package study.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import study.step3.enumtype.LottoWinningType;

public class LottoResultMap {
    private final EnumMap<LottoWinningType, List<Lotto>> resultMap;

    public LottoResultMap() {
        this.resultMap = new EnumMap<>(LottoWinningType.class);
    }

    public void addLotto(LottoWinningType lottoWinningType, Lotto lotto) {
        List<Lotto> lottos = resultMap.getOrDefault(lottoWinningType, new ArrayList<>());
        lottos.add(lotto);
        resultMap.put(lottoWinningType, lottos);
    }

    public int matchCount(LottoWinningType lottoWinningType) {
        return resultMap.getOrDefault(lottoWinningType, Collections.emptyList()).size();
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
