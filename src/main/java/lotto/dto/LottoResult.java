package lotto.dto;

import java.util.List;

public class LottoResult {
    private final String earningRatio;
    private final List<LottoResultItem> items;

    public LottoResult(String earningRatio, List<LottoResultItem> items) {
        this.earningRatio = earningRatio;
        this.items = items;
    }

    public String getEarningRatio() {
        return earningRatio;
    }

    public List<LottoResultItem> getItems() {
        return items;
    }
}
