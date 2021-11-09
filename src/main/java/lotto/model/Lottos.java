package lotto.model;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottoGroup;

    public Lottos(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public int size() {
        return lottoGroup.size();
    }

    public List<Lotto> getLottoGroup() {
        return Collections.unmodifiableList(lottoGroup);
    }

}
