package study.step3.domain.lotto;

public interface LottoIssuanceStrategy {

    Lottos issueLottos(PurchaseMoney purchaseMoney);
}
