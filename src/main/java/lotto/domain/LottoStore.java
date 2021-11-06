package lotto.domain;

//구매 금액만큼 로또를 발급하는 역할을 가진 클래스
public class LottoStore {

    private LottoStore() {
    }

    public static Lottos purchase(int purchaseAmount) {
        LottoIssuanceCount lottoIssuanceCount = LottoIssuanceCount.issuanceNumberCalculation(purchaseAmount);

        return new Lottos(lottoIssuanceCount.createLotto());
    }
}
