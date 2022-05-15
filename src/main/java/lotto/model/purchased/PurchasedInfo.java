package lotto.model.purchased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import lotto.model.money.Money;
import lotto.model.number.LottoNumbers;
import lotto.type.LottoWinningPriceType;
import lotto.util.LottoUtil;

public class PurchasedInfo {

    private final int possiblePurchaseCount;

    private List<PurchasedLotto> purchasedLottos = new ArrayList<>();

    public PurchasedInfo(Money purchasedMoney) {
        this.possiblePurchaseCount = LottoUtil.calculatePossiblePurchaseLottoCount(purchasedMoney);
        autoPurchaseLotto();
    }

    private void autoPurchaseLotto() {
        IntStream.range(0, possiblePurchaseCount)
            .forEach(i -> purchasedLottos.add(PurchasedLotto.createAuto()));
    }

    public Map<LottoWinningPriceType, List<PurchasedLotto>> winningLotto(LottoNumbers winningLotto) {
        Map<LottoWinningPriceType, List<PurchasedLotto>> lottoResultMap = new HashMap<>();
        Arrays.stream(LottoWinningPriceType.values())
            .forEach(lottoWinningPriceType -> lottoResultMap.put(lottoWinningPriceType, new ArrayList<>()));

        this.purchasedLottos
            .forEach(purchasedLotto -> {
                Optional<LottoWinningPriceType> lottoWinningPriceType = purchasedLotto.checkWinning(winningLotto);
                lottoWinningPriceType.ifPresent(
                    winningPriceType -> lottoResultMap.get(winningPriceType).add(purchasedLotto));
            });

        return lottoResultMap;
    }

    public int getPossiblePurchaseCount() {
        return possiblePurchaseCount;
    }

    public List<PurchasedLotto> getPurchasedLottos() {
        return purchasedLottos;
    }

}
