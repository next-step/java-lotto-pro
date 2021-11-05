package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;
    
    public Lottos(int quantity) {
        this.lottos = buyLotto(quantity);
    }
    
    public List<Lotto> buyLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
    
    public int getSize() {
        return this.lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
    
}
