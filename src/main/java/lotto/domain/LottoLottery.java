package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoLottery {
    private final List<LottoNumbers> lottoLottery;

    private LottoLottery(List<LottoNumbers> lottoLottery) {
        this.lottoLottery = lottoLottery;
    }

    public static LottoLottery of(LottoQuantity lottoQuantity, LottoNumberGenerator lottoNumberGenerator) {
        List<LottoNumbers> lottoLottery = new ArrayList<>();
        for (int i = 0; i < lottoQuantity.getQuantity(); i++) {
            lottoLottery.add(LottoNumbers.of(lottoNumberGenerator));
        }
        return new LottoLottery(lottoLottery);
    }

    public void print() {
        for (LottoNumbers lottoNumbers : this.lottoLottery) {
            System.out.println(lottoNumbers.print());
        }
    }
}