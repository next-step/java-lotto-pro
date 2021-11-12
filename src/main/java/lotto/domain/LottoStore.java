package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//구매 금액만큼 로또를 발급하는 역할을 가진 클래스
public class LottoStore {

    private LottoStore() {
    }

    public static Lottos purchase(Money money) {
        List<Lotto> lottos = createLottos(money.divide());
        return new Lottos(lottos);
    }

    private static List<Lotto> createLottos(int issuanceCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < issuanceCount; i++) {
            List<Integer> generatedLottoNumbers = LottoNumberGenerator.generator();

            List<LottoNumber> lottoNumbers = generatedLottoNumbers.stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());

            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }
}
