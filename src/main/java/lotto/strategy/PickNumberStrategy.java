package lotto.strategy;

import java.util.List;
import lotto.domain.LottoNumber;

public interface PickNumberStrategy {
    List<LottoNumber> pickLottoNumbers();
}
