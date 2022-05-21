package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    final List<Lotto> lottoSheets;

    public Lottos(List<Lotto> lottos) {
        this.lottoSheets = lottos;
    }

    public Lottos(int paperCount) {
        lottoSheets = new ArrayList<>();
        for (int i = 0; i < paperCount / 1000; i++) {
            List<Integer> lottoNumbers = RandomUtils.createRandomLottoNumber();
            lottoSheets.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoSheets;
    }

    public int getLottosSize() {
        return lottoSheets.size();
    }

}