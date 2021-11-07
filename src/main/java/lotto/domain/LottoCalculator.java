package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;
    public static final int PROFIT_RATE = 1;

    private final Lottos lottos;
    private WinResults winResults;

    public LottoCalculator(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount.getQuantity(); i++) {
            lottos.add(LottoGenerator.generate());
        }
        this.lottos = new Lottos(lottos);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public WinResults getWinResults() {
        return winResults;
    }

    public void calculate(Lotto winNumber, LottoNumber bonusNumber) {
        this.winResults = lottos.getWinResults(winNumber, bonusNumber);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public float getProceedsRate() {
        return (float) winResults.getProceeds() / ((float) getLottosSize() * LOTTO_PRICE);
    }
}
