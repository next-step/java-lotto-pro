package lotto.model.purchased;

import static lotto.constant.LottoSetting.LOTTO_UNIT_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import lotto.model.factory.ILottoFactory;
import lotto.model.money.Money;
import lotto.model.number.LottoNumbers;
import lotto.type.LottoGeneratorType;
import lotto.type.LottoWinningPriceType;

public class PurchasedInfo {

    private final ILottoFactory lottoFactory;
    private final int possiblePurchaseCount;
    private List<PurchasedLotto> purchasedLottos = new ArrayList<>();

    public PurchasedInfo(Money purchasedMoney, ILottoFactory lottoFactory) {
        this.possiblePurchaseCount = purchasedMoney.getMoney() / LOTTO_UNIT_PRICE;
        this.lottoFactory = lottoFactory;
        autoPurchaseLotto();
    }

    private void autoPurchaseLotto() {
        IntStream.range(0, possiblePurchaseCount)
            .forEach(i -> purchasedLottos.add(new PurchasedLotto(lottoFactory.generate(), LottoGeneratorType.AUTO)));
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
