package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {

    private List<LottoNumber> lottoPaper = new ArrayList<>();

    public LottoPaper(List<LottoNumber> lottoPaper) {
        this.lottoPaper = lottoPaper;
    }
    public List<LottoNumber> getLottoNumber() {
        return lottoPaper;
    }
}
