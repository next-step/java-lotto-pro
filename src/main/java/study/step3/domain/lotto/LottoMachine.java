package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.domain.lottostatistics.LottoStatistics;

import java.util.List;

public class LottoMachine {

    private static final long ONE_LOTTO_PRICE = 1000L;
    private final long money;
    private final LottoIssuanceStrategy lottoIssuanceStrategy;

    public LottoMachine(final long money, final LottoIssuanceStrategy lottoIssuanceStrategy) {
        this.money = money;
        this.lottoIssuanceStrategy = lottoIssuanceStrategy;
    }

    public Lottos issue() {
        long lottoCount = this.money / ONE_LOTTO_PRICE;
        return lottoIssuanceStrategy.issue(lottoCount);
    }

    public LottoStatistics match(Lottos lottos, LottoNumbers winningNumbers) {
        List<Long> matchCounts = lottos.matchAll(winningNumbers);
        return new LottoStatistics(this.money, matchCounts);
    }
}
