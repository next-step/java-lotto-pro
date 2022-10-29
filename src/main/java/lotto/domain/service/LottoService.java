package lotto.domain.service;

import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.result.DefaultLottoResult;

public interface LottoService {

    void savePurchase(String purchase);

    void saveLottoNumbers();

    LottoNumbers findLottoNumbers();

    void saveLotto(String readWinningNumber);

    DefaultLottoResult result();

    String makeProfitMargin();
}
