package study.step3.io;

import java.util.List;
import study.step3.Lotto;
import study.step3.LottoResultMap;

public interface Printer {
    void print(String text);

    void printMyLottos(List<Lotto> lottos);

    void printResult(LottoResultMap lottoResultMap);
}
