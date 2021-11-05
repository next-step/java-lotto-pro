package step3.domain;

import step3.dto.LottoRanksDto;
import step3.dto.WinnerLottoNumbersDto;

public interface LottoService {
    void buyLotto(Amount amount);

    LottoRanksDto lottoPurchaseDetails(Amount amount, WinnerLottoNumbersDto winLottoNumbers);
}
