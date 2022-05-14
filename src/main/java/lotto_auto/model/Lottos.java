package lotto_auto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private List<Lotto> lottoList;

    public Lottos(List<Lotto> list) {
        this.lottoList = list;
    }

    public Lottos() {
        lottoList = new ArrayList<>();
    }

    public void appendLotto(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoList.iterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = "\n";

        for(Lotto lotto : lottoList) {
            result.append(lotto.toString()).append(newLine);
        }
        return result.toString();
    }
}
