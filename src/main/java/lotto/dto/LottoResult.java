package lotto.dto;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return earningRatio.equals(that.earningRatio) && items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earningRatio, items);
    }
}
