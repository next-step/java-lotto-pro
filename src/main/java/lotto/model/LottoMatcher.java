package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lotto.model.enums.MatchCount;

public class LottoMatcher {
    private final LottoNumbers winningNumbers;

    public LottoMatcher(int... winningNumbers) {
        this(new LottoNumbers(winningNumbers));
    }

    public LottoMatcher(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public MatchResult getMatchResult(Payment payment, Collection<LottoNumbers> lottoNumbersCollection) {
        List<MatchCount> matchCounts = new ArrayList<>();

        for (LottoNumbers lottoNumbers : lottoNumbersCollection) {
            MatchCount matchCount = lottoNumbers.getMatchCount(winningNumbers);
            matchCounts.add(matchCount);
        }

        return new MatchResult(payment, matchCounts);
    }
}
