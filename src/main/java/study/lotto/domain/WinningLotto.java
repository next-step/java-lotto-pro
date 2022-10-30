package study.lotto.domain;

import study.splitter.Splitter;
import study.util.NumberUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int LOTTO_SIZE = 6;

    private final Lotto winningLotto;

    public WinningLotto(String winningNumbers) {
        this.winningLotto = new Lotto(inputWinningNumbers(winningNumbers));
    }

    private Set<LottoNumber> inputWinningNumbers(String winningNumbers) {
        String[] winningNumbersSplited = Splitter.split(winningNumbers);
        Set<LottoNumber> winningNumbersConverted = convertStringArrToSet(winningNumbersSplited);
        if(winningNumbersConverted.size() == LOTTO_SIZE) {
            return winningNumbersConverted;
        }
        throw new IllegalArgumentException("[ERROR] The numbers entered are invalid as lotto numbers.");
    }

    private Set<LottoNumber> convertStringArrToSet(String[] winningNumbersSplited) {
        return Arrays.stream(winningNumbersSplited)
                .map((str) -> {
                    return LottoNumber.of(NumberUtil.convertToPositiveIntNotContainsZero(str.trim()));
                }).collect(Collectors.toSet());
    }

    public int matchNumber(LottoNumber lottoNumber) {
       return winningLotto.contains(lottoNumber);
    }

    public WinStats drawLots(List<Lotto> lottos, WinStats stats) {
        lottos.forEach((lotto) -> {
            stats.accumulate(lotto.drawLots(this));
        });
        stats.calculate();
        return stats;
    }
}
