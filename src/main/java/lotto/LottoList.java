package lotto;

import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public long getAllPrize() {
        return lottoList.stream().map(Lotto::getPrize).mapToInt(Integer::intValue).sum();
    }
}
