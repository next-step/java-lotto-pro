package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto>{
    List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList){
        this.lottos = lottoList;
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
