package study.lotto.domain.lottomachine;

import java.util.List;
import study.lotto.domain.LottoNumber;

public interface LottoGenerator {
    List<LottoNumber> generate();
}
