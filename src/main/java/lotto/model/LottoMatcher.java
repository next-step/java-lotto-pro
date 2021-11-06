package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LottoMatcher {
    private final Payment payment;
    private final LottoNumbers winningNumbers;

    public LottoMatcher(int money, int... winningNumbers) {
        this.payment = new Payment(money);
        this.winningNumbers = new LottoNumbers(winningNumbers);
    }

    public MatchResult getMatchResult(Collection<LottoNumbers> lottoNumbersCollection) {
        List<MatchCount> matchCounts = new ArrayList<>();

        for (LottoNumbers lottoNumbers : lottoNumbersCollection) {
            MatchCount matchCount = lottoNumbers.getMatchCount(winningNumbers);
            matchCounts.add(matchCount);
        }

        return new MatchResult(payment, matchCounts);
    }
}
