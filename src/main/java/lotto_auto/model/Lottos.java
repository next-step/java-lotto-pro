package lotto_auto.model;

import java.util.ArrayList;
import java.util.List;


public class Lottos{
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> list) {
        this.lottoList = list;
    }

    public Lottos(int count) {
        lottoList = new ArrayList<>();
        for (int i=0; i< count; i++) {
            lottoList.add(new Lotto(new LottoNumbers()));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

}
