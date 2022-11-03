package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    private final PayAmount payAmount;
    private final List<Lotto> lottoList = new ArrayList<>();
    private int manualLottoCount = 0;
    private int randomLottoCount = 0;

    public LottoBuyer(PayAmount payAmount) {
        this.payAmount = payAmount;
    }

    public void buyWithManual(LottoStore lottoStore, BuyManualCount buyManualCount) {
        while (buyManualCount.hasCount()) {
            buyWithManual(lottoStore, buyManualCount.give());
        }
    }

    public void buyWithManual(LottoStore lottoStore, List<Integer> numbers) {
        lottoStore.buyWith(() -> new ManualLottoNumberGenerateStrategy(numbers));
        List<Lotto> newLottoOne = lottoStore.pay(this.payAmount, new PayCount(1));
        this.manualLottoCount += newLottoOne.size();
        lottoList.addAll(newLottoOne);
    }

    public void buyWithRandom(LottoStore lottoStore) {
        lottoStore.buyWith(RandomLottoNumberGenerateStrategy::new);
        List<Lotto> newLottoMany = lottoStore.payAll(this.payAmount);
        this.randomLottoCount += newLottoMany.size();
        lottoList.addAll(newLottoMany);
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }

    public int getRandomLottoCount() {
        return this.randomLottoCount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            builder.append(lotto.toString())
                .append("\n");
        }
        return builder.toString();
    }

    public List<Lotto> reportLottoList() {
        return this.lottoList;
    }
}
