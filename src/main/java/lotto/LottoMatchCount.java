package lotto;

import static lotto.LottoMatchType.*;

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
        if (matchCount == 3) return THREE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 5) return FIVE;
        if (matchCount == 6) return SIX;
        return OTHER;
    }
}
