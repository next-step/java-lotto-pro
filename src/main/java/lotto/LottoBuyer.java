package lotto;

import java.util.List;

public class LottoBuyer {
    private final PayAmount payAmount;
    private final LottoList lottoList = new LottoList();
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
        lottoList.add(newLottoOne);
    }

    public void buyWithRandom(LottoStore lottoStore) {
        lottoStore.buyWith(RandomLottoNumberGenerateStrategy::new);
        List<Lotto> newLottoMany = lottoStore.payAll(this.payAmount);
        this.randomLottoCount += newLottoMany.size();
        lottoList.add(newLottoMany);
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }

    public int getRandomLottoCount() {
        return this.randomLottoCount;
    }

    @Override
    public String toString() {
        return lottoList.toString();
    }

    public void match(Lotto winLotto, BonusLottoNumber bonusLottoNumber) {
        lottoList.match(winLotto, bonusLottoNumber);
    }

    public Integer getLottoMatchTypeCount(LottoMatchType lottoMatchType) {
        return lottoList.getLottoMatchTypeCount(lottoMatchType);
    }

    public int getSumProfit() {
        return lottoList.getSumProfit();
    }
}
