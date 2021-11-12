package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPapers {

    private final List<LottoPaper> lottoPapers;

    public LottoPapers(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public List<LottoPaper> getLottoPapers() {
        return Collections.unmodifiableList(lottoPapers);
    }

    public long getLottoPapersSize() {
        return lottoPapers.size();
    }

    public static LottoPapers createLottoPapers(long lottoPaperCount) {
        List<LottoPaper> lottoPapers = new ArrayList<>();
        for (int i = 0; i < lottoPaperCount; i++) {
            lottoPapers.add(LottoNumberGenerator.createLottoNumbers());
        }
        return new LottoPapers(lottoPapers);
    }

    public LottoResult calculateLottoResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        getLottoPapers()
                .forEach(
                        lottoPaper -> lottoResult.addMatchCounts(
                                        lottoPaper.matchLottoPaper(winningLotto.getWinningLottoPaper()), lottoPaper.isContainsLottoNumber(winningLotto.getBonusLottoNumber())));
        return  lottoResult;
    }

    public LottoPapers addLottoPapers(LottoPapers addLottoPapers) {

        List<LottoPaper> mergedList = Stream.of(addLottoPapers.getLottoPapers(), lottoPapers)
                                            .flatMap(Collection::stream)
                                            .collect(Collectors.toList());

        return new LottoPapers(mergedList);
    }

}
