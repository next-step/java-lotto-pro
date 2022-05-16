package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos(int count) {
        List<Lotto> list = new ArrayList<>();
        for (int i=0; i<count; i++) {
            list.add(new Lotto());
        }
        this.lottoList = list;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void printLottoList() {
        for (Lotto n : this.lottoList) {
            n.printLottoNumber();
        }
    }
}
