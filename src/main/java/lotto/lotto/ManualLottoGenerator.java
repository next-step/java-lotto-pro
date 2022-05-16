package lotto.lotto;

import java.util.List;
import static java.util.Objects.requireNonNull;

public class ManualLottoGenerator implements BatchLottoGenerator {

    private final List<String> rawLottoes;
    private int tryCount;
    public ManualLottoGenerator(ManualLottoes manualLottoes) {
        requireNonNull(manualLottoes, "manualLottoes");
        this.rawLottoes = requireNonNull(manualLottoes.lottoes(), "rawLottoes");
    }

    @Override
    public Lotto generate() {
        if (!hasMore()) {
            throw new CanNotGenerateLottoException();
        }
        try {
            final LottoGenerator lottoGenerator = LottoGenerator.commaSplitting(rawLottoes.get(tryCount));
            return lottoGenerator.generate();
        } finally {
            tryCount++;
        }
    }

    @Override
    public boolean hasMore() {
        return rawLottoes.size() > tryCount;
    }
}
