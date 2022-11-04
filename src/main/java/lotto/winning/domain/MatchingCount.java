package lotto.winning.domain;

import common.vo.Count;
import lotto.lotto.domain.Lotto;

import java.util.List;
import java.util.Objects;

public class MatchingCount {

    public static final String LOTTO_EXCEPTION_MESSAGE = "로또가 없습니다.";
    public static final String WINNING_NUMBER_EXCEPTION_MESSAGE = "당첨 번호가 없습니다.";
    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;

    public MatchingCount(List<Lotto> lottos, WinningNumber winningNumber) {
        validate(lottos, winningNumber);
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    private static void validate(List<Lotto> lottos, WinningNumber winningNumber) {
        if (Objects.isNull(lottos) || lottos.isEmpty()) {
            throw new IllegalArgumentException(LOTTO_EXCEPTION_MESSAGE);
        }
        if (Objects.isNull(winningNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Count lottoCount(int matchingCount) {
        int lottoCount = 0;
        for (Lotto lotto : this.lottos) {
            lottoCount = lottoCountUp(matchingCount, lottoCount, lotto);
        }
        return new Count(lottoCount);
    }

    private int lottoCountUp(int matchingCount, int lottoCount, Lotto lotto) {
        if (isSame(matchingCount, lotto)) {
            lottoCount++;
        }
        return lottoCount;
    }

    private boolean isSame(int matchingCount, Lotto lotto) {
        return this.winningNumber.findMatchingCount(lotto) == matchingCount;
    }
}
