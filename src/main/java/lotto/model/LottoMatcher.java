package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lotto.model.enums.Rank;

public class LottoMatcher {
    static final String DUPLICATE_BONUS_NUMBER_ERR_MSG = "보너스 번호는 당첨번호와 겹칠 수 없습니다.";

    private final Number bonusNumber;
    private final LottoNumbers winningNumbers;

    public LottoMatcher(int bonusNumber, int... winningNumbers) {
        this(Number.ofValue(bonusNumber), new LottoNumbers(winningNumbers));
    }

    public LottoMatcher(Number bonusNumber, LottoNumbers winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
        validate();
    }

    private void validate() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERR_MSG);
        }
    }

    public MatchResult match(Payment payment, Collection<LottoNumbers> lottoNumbersCollection) {
        List<Rank> ranks = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersCollection) {
            int countOfMatch = lottoNumbers.getCountOfMatch(winningNumbers);
            boolean matchBonus = lottoNumbers.contains(bonusNumber);
            ranks.add(Rank.valueOf(countOfMatch, matchBonus));
        }
        return new MatchResult(payment, ranks);
    }
}
