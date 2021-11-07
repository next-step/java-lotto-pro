package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoPrize.FIRST_PLACE;
import static lotto.domain.LottoPrize.FOURTH_PLACE;
import static lotto.domain.LottoPrize.SECOND_PLACE;
import static lotto.domain.LottoPrize.THIRD_PLACE;

public class LottoResult {

    private final Lotto winningLotto;
    private final List<Lotto> lottoList;
    private final Map<Integer, Integer> resultMap = new HashMap<>();

    public LottoResult(Lotto winningLotto, List<Lotto> lottoList) {
        this.winningLotto = winningLotto;
        this.lottoList = lottoList;
        setResultMap();
    }

    private void setResultMap() {
        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.match(lotto);
            resultMap.put(matchCount, resultMap.getOrDefault(matchCount, 0) + 1);
        }
    }

    protected int getResult(int key) {
        return resultMap.get(key) == null ? 0 : resultMap.get(key);
    }

    protected double getEarningsRate() {
        int purchaseAmount = Lotto.PRICE * lottoList.size();
        double winningAmount = 0;
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            winningAmount += (LottoPrize.getPrizeMoney(entry.getKey()) * entry.getValue());
        }
        double earningsRate = winningAmount / purchaseAmount;
        return Math.floor(earningsRate * 100) / 100.0; // 소수점 셋째 자리 버림
    }

    @Override
    public String toString() {
        return String.format("당첨 통계\n" +
                        "---------\n" +
                        "%d개 일치 (%d원)- %d개\n" +
                        "%d개 일치 (%d원)- %d개\n" +
                        "%d개 일치 (%d원)- %d개\n" +
                        "%d개 일치 (%d원)- %d개\n" +
                        "총 수익률은 %f입니다."
                , FOURTH_PLACE.getMatchCount(), FOURTH_PLACE.getPrizeMoney(), getResult(FOURTH_PLACE.getMatchCount())
                , THIRD_PLACE.getMatchCount(), THIRD_PLACE.getPrizeMoney(), getResult(THIRD_PLACE.getMatchCount())
                , SECOND_PLACE.getMatchCount(), SECOND_PLACE.getPrizeMoney(), getResult(SECOND_PLACE.getMatchCount())
                , FIRST_PLACE.getMatchCount(), FIRST_PLACE.getPrizeMoney(), getResult(FIRST_PLACE.getMatchCount())
                , getEarningsRate());
    }
}
