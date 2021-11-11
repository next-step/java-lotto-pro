package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import lotto.model.enums.Rank;

public class LottoMatcher {
    static final String DUPLICATE_BONUS_NUMBER_ERR_MSG = "보너스 번호는 당첨번호와 겹칠 수 없습니다.";

    private final Number bonusNumber;
    private final LottoNumbers winningNumbers;

    public LottoMatcher(int bonusNumber, int... winningNumbers) {
        this(Number.of(bonusNumber), new LottoNumbers(winningNumbers));
    }

    public LottoMatcher(Number bonusNumber, LottoNumbers winningNumbers) {
        Objects.requireNonNull(bonusNumber);
        Objects.requireNonNull(winningNumbers);

        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;

        validate();
    }

    private void validate() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERR_MSG);
        }
    }

    public MatchResult match(Payment payment, Collection<LottoNumbers> lottoNumbers) {
        Objects.requireNonNull(payment);
        Objects.requireNonNull(lottoNumbers);

        List<Rank> ranks = new ArrayList<>();
        for (LottoNumbers numbers : lottoNumbers) {
            Rank rank = numbers.computeRank(bonusNumber, winningNumbers);
            ranks.add(rank);
        }
        return new MatchResult(payment, ranks);
    }
}
