package lotto.domain;

public class LottoCount {
    private final int count;

    private LottoCount(int count) {
        this.count = count;
    }

    public static LottoCount from(int count) {
        return new LottoCount(count);
    }

    public int getCount() {
        return this.count;
    }
}
