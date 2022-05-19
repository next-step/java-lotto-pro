package study.lotto;

import java.util.List;
import study.lotto.util.LottoGenerator;

abstract class LottoCommonTest {
    private static final String NUMBER_DELIMITER = ",";

    protected Lotto newLotto(String text) {
        return new Lotto(getLottoNumbers(text));
    }

    protected List<LottoNumber> getLottoNumbers(String text) {
        return LottoGenerator.splitAndParseLottoNumber(text, NUMBER_DELIMITER);
    }
}
