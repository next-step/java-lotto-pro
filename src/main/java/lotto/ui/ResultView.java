package lotto.ui;

import java.util.List;
import lotto.dto.LottoGameResultDTO;
import lotto.number.LottoNumbers;

public interface ResultView {
    void printBoughtCount(int manualBuyCount, int autoBuyCount);

    void printBoughtLottos(List<LottoNumbers> lottoNumbersList);

    void printGameResult(LottoGameResultDTO gameResult);

}
