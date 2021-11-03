package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoMatch {

    private List<Number> matchNumbers;
    private List<LottoNumber> lottoNumbers;
    private HashMap<Rank, Integer> matchResult;

    public LottoMatch(List<Number> matchNumbers, Lotto lotto) {
        this.lottoNumbers = lotto.getLottoNumbers();
        this.matchResult = initializeMatchResult();
        this.matchNumbers = matchNumbers;
        matchLotto();
    }

    private void matchLotto() {
        initializeMatchResult();
        for (LottoNumber lottoNumber : lottoNumbers) {
            int matchCount = getMatchCount(matchNumbers, lottoNumber.getLottoNumbers());
            Rank rank = Rank.of(matchCount);
            matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
        }
    }

    private HashMap<Rank, Integer> initializeMatchResult() {
        HashMap<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private int getMatchCount(List<Number> matchNumbers, List<Number> lottoNumber) {
        int matchCount = 0;
        for (Number number : lottoNumber) {
            matchCount += Collections.frequency(matchNumbers, number);
        }
        return matchCount;
    }

    public HashMap<Rank, Integer> getMatchResult() {
        return matchResult;
    }
}
