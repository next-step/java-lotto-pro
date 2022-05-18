package lotto;

import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinResult;
import lotto.domain.LottoWinResultGroup;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

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

    public static WinningNumbers winningNumbers(int... numbers) {
        return WinningNumbers.of(lottoNumbers(Arrays.copyOf(numbers, numbers.length - 1)),
                LottoNumber.valueOf(numbers[numbers.length - 1]));
    }
}
