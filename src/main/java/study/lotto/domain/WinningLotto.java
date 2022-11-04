package study.lotto.domain;

import study.lotto.domain.number.LottoGenerator;
import study.lotto.domain.number.LottoNumber;
import study.message.LottoExceptionCode;

import java.util.List;

public class WinningLotto {
    private static final int MATCH = 1;
    private static final int NOT_MATCH = 0;

    private final Lotto winningLotto;
    private LottoNumber bonusBall;

    public WinningLotto(String winningNumbers) {
        this.winningLotto = Store.buyLottoManually(winningNumbers);
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
        LottoNumber bonusBallConverted = LottoGenerator.toLottoNumber(bonusBall);

        if(winningLotto.contains(bonusBallConverted)) {
            throw new IllegalArgumentException(LottoExceptionCode.INVALID_BONUS_BALL.getMessage());
        }

        this.bonusBall = bonusBallConverted;
    }

    public boolean isMatchBonusBall(Lotto lotto) {
        return lotto.contains(bonusBall);
    }
}
