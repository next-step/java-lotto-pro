package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;

public class LottoAnalyzer {

    private static final int INIT_VALUE = 1;
    private final WinningLotto winningLotto;

    public LottoAnalyzer(WinningLotto winningLotto) {
        this.winningLotto = requireNonNull(winningLotto, "winningLotto");
    }

    public WinningResult analyze(List<Lotto> lottoes) {
        final Map<LottoPrize, Integer> results = new EnumMap<>(LottoPrize.class);
        for (Lotto lotto : lottoes) {
            final LottoPrize lottoPrize = this.winningLotto.guess(lotto);
            results.merge(lottoPrize, INIT_VALUE, Integer::sum);
        }
        return new WinningResult(results);
    }
}
