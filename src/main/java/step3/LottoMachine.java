package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final int lottoPrice;
    private int lottoCount;
    private List<List<Integer>> havingLottos;

    public LottoMachine(int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.havingLottos = new ArrayList<>();
    }

    public LottoMachine(int lottoPrice, int money) {
        this.lottoPrice = lottoPrice;
        this.havingLottos = new ArrayList<>();

        receiveMoney(money);
    }

    public int receiveMoney(int money) {
        if (money < this.lottoPrice) {
            throw new RuntimeException(lottoPrice - money + "만큼 부족합니다.");
        }

        this.lottoCount = money / lottoPrice + lottoCount;

        return this.lottoCount;
    }

    public List<Integer> addLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.havingLottos.add(lottoNumbers);

        return lottoNumbers;
    }
}
