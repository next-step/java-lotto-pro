package step3.domain.factory;

import step3.domain.lotto.LottoNumbers;
import step3.domain.lotto.LottoType;

public interface LottoFactory {

    LottoNumbers create();

    LottoType getLottoType();

}
