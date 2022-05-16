package lotto;

import static java.util.Arrays.stream;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinResult;
import lotto.domain.LottoWinResultGroup;
import lotto.domain.Lottos;

public class LottoTestUtils {

    public static LottoNumbers lottoNumbers(int... numbers) {
        return LottoNumbers.pickNumbers(stream(numbers)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList()));
    }

    public static Lotto lotto(int... numbers) {
        return Lotto.generate(lottoNumbers(numbers));
    }

    public static Lottos lottos(Lotto... lottos) {
        return Lottos.of(lottos);
    }

    public static LottoWinResultGroup resultGroup(LottoWinResult... lottoWinResults) {
        return new LottoWinResultGroup(stream(lottoWinResults)
                .collect(Collectors.toList()));
    }
}
