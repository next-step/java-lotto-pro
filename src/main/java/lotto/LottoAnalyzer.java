package lotto;

import lotto.lotto.Lotto;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;

public class LottoAnalyzer {

    private static final int INIT_VALUE = 1;
    private final Lotto lotto;

    public LottoAnalyzer(Lotto lotto) {
        this.lotto = requireNonNull(lotto, "lotto");
    }

    public WinningResult analyze(List<Lotto> lottoes) {
        final Map<LottoPrize, Integer> results = new EnumMap<>(LottoPrize.class);
        for (Lotto lotto : lottoes) {
            final int matchCount = this.lotto.countMatches(lotto);
            final LottoPrize lottoPrize = LottoPrize.valueOf(matchCount);
            results.merge(lottoPrize, INIT_VALUE, Integer::sum);
        }
        return new WinningResult(results);
    }
}
