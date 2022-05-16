package lotto.lotto;

import java.util.List;

public class ManualLottoGenerator implements BatchLottoGenerator {

    private final List<String> rawLottoes;

    public ManualLottoGenerator(ManualLottoes manualLottoes) {
        this.rawLottoes = manualLottoes.lottoes();
    }

    @Override
    public Lotto generate() {
        return null;
    }

    @Override
    public boolean hasMore() {
        return false;
    }
}
