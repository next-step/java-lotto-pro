package step3.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step3.domain.Lotto;
import step3.domain.LottoNumber;

public class SimpleLottoShuffler implements LottoShuffleable {

    @Override
    public Lotto shuffle() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>(this.preparedLottoNumbers());

        Collections.shuffle(lottoNumbers);

        return new Lotto(lottoNumbers.subList(0, Lotto.LOTTO_LENGTH));
    }
}
