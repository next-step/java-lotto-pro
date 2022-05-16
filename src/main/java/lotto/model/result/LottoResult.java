package lotto.model.result;

import java.util.Map;
import java.util.Objects;
import lotto.model.money.Money;
import lotto.type.LottoRank;

public class LottoResult {

    private Map<LottoRank, Integer> lottoResultMap;

    public LottoResult(Map<LottoRank, Integer> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public double winningRate(Money purchasedMoney) {
        return totalPrice() / purchasedMoney.getMoney();
    }

    private double totalPrice() {
        return lottoResultMap.entrySet().stream()
            .mapToDouble(lottoResultEntry ->
                lottoResultEntry.getKey().getWinningPrice() * lottoResultEntry.getValue()
            ).sum();
    }

    public Map<LottoRank, Integer> getLottoResultMap() {
        return lottoResultMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResultMap, that.lottoResultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResultMap);
    }

}
