package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoPaper {

    private final List<LottoNumber> lottoNumbers;

    public LottoPaper(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public void matchLottoPaper(LottoPaper winningLottoPaper, LottoResult lottoResult) {
        lottoNumbers.forEach(lottoNumber -> winningLottoPaper.checkContainsLottoNumber(lottoNumber, lottoResult));
        lottoResult.addMatchCounts(lottoResult.getMatchCount());
        lottoResult.clearMatchCount();
    }

    public void checkContainsLottoNumber(LottoNumber lottoNumber,  LottoResult lottoResult) {
        if(lottoNumbers.contains(lottoNumber)){
            lottoResult.addMatchCount();
        }
    }
}
