package study.lotto.domain.lottomachine.sorter;

import java.util.Collections;
import java.util.List;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;

public class LottoAscendingSorter implements LottoSorter {
    @Override
    public Lotto sort(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.get();
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
