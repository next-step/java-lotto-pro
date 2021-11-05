package lotto.model;

import lotto.controller.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPapers {

    private final List<LottoPaper> lottoPapers;

    public LottoPapers(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public List<LottoPaper> getLottoPapers() {
        return Collections.unmodifiableList(lottoPapers);
    }
    public long lottoPaperSize() {
        return lottoPapers.size();
    }

    public static LottoPapers createLottoPapers(long lottoPaperCount) {
        List<LottoPaper> lottoPapers = new ArrayList<>();
        for (int i = 0; i < lottoPaperCount; i++) {
            lottoPapers.add(LottoNumberGenerator.getLottoNumbers());
        }
        return new LottoPapers(lottoPapers);
    }
}
