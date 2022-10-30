package study.lotto.domain;

import study.splitter.Splitter;
import study.util.NumberUtil;

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

        throw new IllegalArgumentException(
                "[ERROR] The numbers entered are invalid as lotto numbers.");
    }

    private Set<LottoNumber> convertStringArrToSet(
            String[] winningNumbersSplited) {
        return Arrays.stream(winningNumbersSplited)
                .map((str) -> {
                    return LottoNumber.of(
                            NumberUtil.convertToPositiveIntNotContainsZero(str.trim())
                    );
                }).collect(Collectors.toSet());
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
        LottoNumber bonusBallConverted = LottoNumber.of(bonusBall);

        if(!winningLotto.contains(bonusBallConverted)) {
            this.bonusBall = bonusBallConverted;
            return;
        }

        throw new IllegalArgumentException(
                "[ERROR] Bonus ball number must not be contained in the winning numbers.");
    }

    public boolean isMatchBonusBall(Lotto lotto) {
        return lotto.contains(bonusBall);
    }
}
