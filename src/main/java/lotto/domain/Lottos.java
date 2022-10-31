package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto>{
    List<Lotto> lottoList;
    public Lottos(List<Lotto> lottos) {
        this.lottoList = lottos;
    }

    public int size() {
        return lottoList.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoList.iterator();
    }
}
