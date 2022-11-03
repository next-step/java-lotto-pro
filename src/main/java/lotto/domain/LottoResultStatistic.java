package lotto.domain;

public final class LottoResultStatistic {

    private final LottoResult lottoResult;
    private final int count;

    public LottoResultStatistic(final LottoResult lottoResult, final int count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    public LottoNumberMatchCount getLottoNumberMatchCount() {
        return lottoResult.getLottoNumberMatchCount();
    }

    public int getCount() {
        return count;
    }

    public Money getPrizeMoney() {
        return lottoResult.getPrizeMoney();
    }

}
