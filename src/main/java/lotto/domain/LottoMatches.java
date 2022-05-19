package lotto.domain;

import java.util.List;
import lotto.constants.Matched;

public class LottoMatches {
    private final List<Matched> lottoMatches;

    public LottoMatches(final List<Matched> lottoMatches) {
        this.lottoMatches = lottoMatches;
    }

    public List<Matched> getLottoMatches() {
        return this.lottoMatches;
    }

    public int matchedCount(final Matched matched) {
        return (int) lottoMatches.stream()
                .filter(
                        lottoMatch -> lottoMatch.equals(matched)
                ).count();
    }
}
