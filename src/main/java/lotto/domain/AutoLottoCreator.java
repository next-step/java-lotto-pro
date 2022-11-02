package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoCreator implements LottoCreator {

    @Override
    public Lotteries createLotteries(int buyLottoCount) {
        List<Lotto> lotteries = new ArrayList();
        for (int i = 0; i < buyLottoCount; i++) {
            lotteries.add(createLotto());
        }
        return new Lotteries(lotteries);
    }

    private Lotto createLotto() {
        List<LottoNumber> lottoNumbers = LottoNumber.lottoNumberMinToMax();
        Collections.shuffle(lottoNumbers);
        return new Lotto(Lotto.getLottoDigitList(lottoNumbers));
    }

}
