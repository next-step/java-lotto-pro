package lotto;

import lotto.lotto.CommaSplittingLottoGenerator;
import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;

public class LottoAnalyzer {

    private static final int INIT_VALUE = 1;
    private final WinningLotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public LottoAnalyzer(WinningLotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = requireNonNull(winningLotto, "winningLotto");
        this.bonusLottoNumber = requireNonNull(bonusLottoNumber, "bonusLottoNumber");
    }

    public WinningResult analyze(List<Lotto> lottoes) {
        final Lotto winningLotto = generateLotto();
        final Map<LottoPrize, Integer> results = new EnumMap<>(LottoPrize.class);
        for (Lotto lotto : lottoes) {
            final LottoPrize lottoPrize = getLottoPrize(winningLotto, lotto);
            results.merge(lottoPrize, INIT_VALUE, Integer::sum);
        }
        return new WinningResult(results);
    }

    private LottoPrize getLottoPrize(Lotto winningLotto, Lotto lotto) {
        final int matchCount = winningLotto.countMatches(lotto);
        final boolean matchBonus = lotto.contains(bonusLottoNumber);
        return LottoPrize.valueOf(matchCount, matchBonus);
    }

    private Lotto generateLotto() {
        final LottoGenerator lottoGenerator = new CommaSplittingLottoGenerator(winningLotto.getLottoNumbers());
        return lottoGenerator.generate();
    }
}
