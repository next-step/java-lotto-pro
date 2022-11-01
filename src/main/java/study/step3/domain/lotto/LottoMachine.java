package study.step3.domain.lotto;

public class LottoMachine {

    private final PurchaseMoney purchaseMoney;
    private final LottoIssuanceStrategy lottoIssuanceStrategy;

    public LottoMachine(final PurchaseMoney purchaseMoney, final LottoIssuanceStrategy lottoIssuanceStrategy) {
        this.purchaseMoney = purchaseMoney;
        this.lottoIssuanceStrategy = lottoIssuanceStrategy;
    }

    public Lottos issueLottos() {
        return lottoIssuanceStrategy.issueLottos(this.purchaseMoney);
    }
}
