package study.lotto.domain;

import study.lotto.domain.number.CacheLottoNumbers;
import study.lotto.domain.number.LottoNumber;
import study.message.LottoExceptionCode;
import study.splitter.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MATCH = 1;
    private static final int NOT_MATCH = 0;

    private final Lotto winningLotto;
    private LottoNumber bonusBall;

    public WinningLotto(String winningNumbers) {
        this.winningLotto = new Lotto(inputWinningNumbers(winningNumbers));
    }

    private Set<LottoNumber> inputWinningNumbers(String winningNumbers) {
        String[] winningNumbersSplited = Splitter.split(winningNumbers);
        Set<LottoNumber> winningNumbersConverted = convertStringArrToSet(winningNumbersSplited);

        if(winningNumbersConverted.size() == LOTTO_SIZE) {
            return winningNumbersConverted;
        }

        throw new IllegalArgumentException(LottoExceptionCode.NOT_MATCH_LOTTO_SIZE.getMessage());
    }

    private Set<LottoNumber> convertStringArrToSet(String[] winningNumbersSplited) {
        return Arrays.stream(winningNumbersSplited)
                .map((str) -> CacheLottoNumbers.ofString(str.trim()))
                .collect(Collectors.toSet());
    }

    public int matchNumber(LottoNumber lottoNumber) {
       return winningLotto.contains(lottoNumber) ? MATCH : NOT_MATCH;
    }

    public WinStats drawLots(List<Lotto> lottos, WinStats stats) {
        lottos.forEach((lotto) -> {
            stats.accumulate(lotto.drawLots(this));
        });
        stats.calculate();

        return stats;
    }

    public void addBonusBall(int bonusBall) {
        LottoNumber bonusBallConverted = CacheLottoNumbers.of(bonusBall);

        if(winningLotto.contains(bonusBallConverted)) {
            throw new IllegalArgumentException(LottoExceptionCode.INVALID_BONUS_BALL.getMessage());
        }

        this.bonusBall = bonusBallConverted;
    }

    public boolean isMatchBonusBall(Lotto lotto) {
        return lotto.contains(bonusBall);
    }
}
