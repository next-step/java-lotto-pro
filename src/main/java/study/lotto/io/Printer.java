package study.lotto.io;

import java.util.List;
import study.lotto.Lotto;
import study.lotto.LottoResultMap;

public interface Printer {
    void print(String text);

    void printMyLottos(List<Lotto> lottos);

    void printResult(LottoResultMap lottoResultMap);
}
