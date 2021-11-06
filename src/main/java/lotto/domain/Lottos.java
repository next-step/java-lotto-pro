package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lotto.utils.RandomGeneratorUtils;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public Lottos(int quantity) {
        this.lottos = buyLotto(quantity);
    }

    public static List<Lotto> buyLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(RandomGeneratorUtils.makeRandomNumbers()));
        }
        return lottos;
    }

    public int getSize() {
        return this.lottos.size();
    }

    public void countWinningRank(LottoNumbers winningLotto) {
        for (Lotto lotto : lottos) {
            lotto.resultLotto(winningLotto);
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

}
