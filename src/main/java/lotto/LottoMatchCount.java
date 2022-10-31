package lotto;

public class LottoMatchCount {

    private static final int INIT_COUNT = 0;
    public int matchCount;

    public LottoMatchCount() {
        this(INIT_COUNT);
    }

    private LottoMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public void addIfContains(Lotto other, LottoNumber lottoNumber) {
        if (other.contains(lottoNumber)) {
            this.matchCount += 1;
        }
    }

    public LottoMatchType getLottoMatchType() {
        return LottoMatchType.valueOf(matchCount);
    }
}
