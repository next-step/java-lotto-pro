package study.step3.domain.lotto;

public interface LottoIssuanceStrategy {

    boolean isIssuableLottos(LottoIssuance lottoIssuance);

    Lottos issueLottos(LottoIssuance lottoIssuance);
}
