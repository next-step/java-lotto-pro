package step3.domain;

public class LottoMatcher {
    int lottoCount;
    int matchCount;
    boolean bonus;

    public LottoMatcher(int matchCount, boolean bonus) {
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public int lottoCount() {
        return lottoCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void plusLottoCountOne() {
        this.lottoCount++;
    }



    public boolean isEqualsToMatchCount(int value) {
        return value == matchCount;
    }

}
