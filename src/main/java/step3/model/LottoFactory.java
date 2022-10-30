package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    public static List<Lotto> createLottos(LottoMoney lottoMoney) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < lottoMoney.getCountOfPurchasePrice(); i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        List<LottoNumber> lottoNumbers = LottoNumber.getLottoNumbers();
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> randomLottoNumbers = lottoNumbers
                .stream()
                .limit(Lotto.getNumberSize())
                .collect(Collectors.toList());
        return new Lotto(randomLottoNumbers);
    }
}
