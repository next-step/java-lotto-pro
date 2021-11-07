package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//구매 금액만큼 로또를 발급하는 역할을 가진 클래스
public class LottoStore {

    private LottoStore() {
    }

    public static Lottos purchase(int purchaseAmount) {
        LottoIssuanceCount issuance = LottoIssuanceCount.issuanceNumberCalculation(purchaseAmount);
        List<Lotto> lottos = createLottos(issuance);
        return new Lottos(lottos);
    }

    private static List<Lotto> createLottos(LottoIssuanceCount issuance) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < issuance.getIssuanceCount(); i++) {
            List<Integer> generatedLottoNumbers = LottoNumberGenerator.generator();

            List<LottoNumber> lottoNumbers = generatedLottoNumbers.stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());

            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }
}
