package lotto.domain.lottonumber.factory;

import java.util.List;
import lotto.domain.lottonumber.LottoNumber;

public interface LottoNumberFactory {

    LottoNumber createLottoNumber();

    List<LottoNumber> createManualLottoNumbers(List<String> manualLottoNumbers);
}
