package lotto.domain;

import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public long getAllPrize() {
        return lottoList.stream().map(Lotto::getPrize).mapToInt(Integer::intValue).sum();
    }

    public double getReturnRate() {
        return (double)getAllPrize() / lottoList.size() * Money.LOTTO_PRICE;
    }
}
