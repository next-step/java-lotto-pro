package lotto.ui;

import java.util.List;
import lotto.dto.LottoGameResultDTO;
import lotto.number.LottoNumbers;

public interface ResultView {
    void printBoughtLottos(List<LottoNumbers> lottoNumbersList);

    void printGameResult(LottoGameResultDTO gameResult);
}
