package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lotto.model.dto.MatchResult;
import lotto.model.dto.Payment;
import lotto.model.dto.enums.MatchCount;

public class LottoMatcher {
    private final Payment payment;
    private final LottoNumbers winningNumbers;

    public LottoMatcher(int payment, int... winningNumbers) {
        this.payment = new Payment(payment);
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
