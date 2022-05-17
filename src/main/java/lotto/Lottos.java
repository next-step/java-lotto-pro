package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottos) {
        this.lottoList = lottos;
    }

    public Lottos(int paperCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < paperCount / 1000; i++) {
            lottoList.add(new Lotto());
        }
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottosSize() {
        return lottoList.size();
    }

}