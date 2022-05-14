package lotto.ui;

import java.util.List;
import lotto.number.LottoNumbers;

public interface ResultView {
    void printBoughtLottos(List<LottoNumbers> lottoNumbersList);
}
