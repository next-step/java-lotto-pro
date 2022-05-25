package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoIssuer {
    private static final Money LOTTO_PRICE = Money.from(1000);

    private final LottoRandomFactory lottoRandomFactory;

    public AutoLottoIssuer(LottoRandomFactory lottoRandomFactory) {
        this.lottoRandomFactory = lottoRandomFactory;
    }

    public Lottos issueAutomatically(Money orderPrice) {
        List<Lotto> lottos = new ArrayList<>();

        for (int index = 0; index < orderPrice.divide(LOTTO_PRICE).intValue(); index++) {
            lottos.add(lottoRandomFactory.create());
        }

        return Lottos.from(lottos);
    }

    public Lottos issueManually(List<String[]> ManualLottoNumbers) {
        List<Lotto> manualLottos = new ArrayList<>();

        for (String[] manualLottoNumber : ManualLottoNumbers) {
            manualLottos.add(new Lotto(createLottoNumbers(manualLottoNumber)));
        }
        return Lottos.from(manualLottos);
    }
    
    private static LottoNumber[] createLottoNumbers(String[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String lottoNumber : numbers) {
            lottoNumbers.add(LottoNumber.from(lottoNumber));
        }
        return lottoNumbers.toArray(new LottoNumber[numbers.length]);
    }
}
