package lotto.model.result;

import java.util.List;
import java.util.Map;
import lotto.model.money.Money;
import lotto.model.purchased.PurchasedInfo;
import lotto.model.purchased.PurchasedLotto;
import lotto.type.LottoWinningPriceType;

public class LottoResult {

    private Map<LottoWinningPriceType, List<PurchasedLotto>> lottoResultMap;
    private double winningRate;

    public LottoResult(Map<LottoWinningPriceType, List<PurchasedLotto>> lottoWinningPriceTypeListMap,
        Money purchasedMoney) {
        this.lottoResultMap = lottoWinningPriceTypeListMap;
        winningRate(purchasedMoney);
    }

    private void winningRate(Money purchasedMoney) {
        double gainPrice = lottoResultMap.entrySet().stream().mapToDouble(lottoWinningPriceTypeListEntry ->
            lottoWinningPriceTypeListEntry.getKey().getWinningPrice() * lottoWinningPriceTypeListEntry.getValue()
                .size()).sum();

        this.winningRate = gainPrice / purchasedMoney.getMoney();
    }

    public Map<LottoWinningPriceType, List<PurchasedLotto>> getLottoResultMap() {
        return lottoResultMap;
    }

    public double getWinningRate() {
        return winningRate;
    }

}
