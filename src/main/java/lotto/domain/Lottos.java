package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public int gameCount() {
        return lottoList.size();
    }

    public void addLotto(List<Integer> lottoNumbers) {
        Lotto lotto = new Lotto(lottoNumbers);
        lottoList.add(lotto);
    }

    public Lotto getLotto(int index) {
        return lottoList.get(index);
    }
}
