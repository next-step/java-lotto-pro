package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//구매 금액만큼 로또를 발급하는 역할을 가진 클래스
public class LottoStore {

    private LottoStore() {
    }

    public static Lottos purchase(Money money, LottoManual lottoManual) {
        List<Lotto> lottos = createLottos(money.divide(), lottoManual.getManualLotto());
        return new Lottos(lottos);
    }

    private static List<Lotto> createLottos(int autoIssuanceCount, List<Lotto> manualLotto) {
        List<Lotto> lottos = new ArrayList<>(manualLotto);
        final int autoIssuance = autoIssuanceCount - manualLotto.size();
        if (autoIssuance > 0) {
            autoLottoIssuance(autoIssuance, lottos);
        }

        return lottos;
    }

    private static void autoLottoIssuance(final int autoIssuanceCount, final List<Lotto> lottos) {
        for (int i = 0; i < autoIssuanceCount; i++) {
            List<Integer> generatedLottoNumbers = LottoNumberGenerator.generator();

            List<LottoNumber> lottoNumbers = generatedLottoNumbers.stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());

            lottos.add(new Lotto(lottoNumbers));
        }
    }
}
