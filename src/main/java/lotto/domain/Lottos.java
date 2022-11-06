package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.WinningMoney.NONE;

public class Lottos {
    private static final int INIT_COUNT = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int size() {
        return this.lottos.size();
    }

    public Map<Integer, Lottos> matchLottos(WinningLotto winningLotto) {
        Map<Integer, Lottos> map = new HashMap<>();
        for (WinningMoney winningMoney : WinningMoney.values()) {
            map.put(winningMoney.getCount(), findLottosByMatchCount(winningMoney.getCount(), winningLotto));
        }
        map.remove(NONE.getCount());
        return map;
    }

    private Lottos findLottosByMatchCount(int matchCount, WinningLotto winningLotto) {
        Lottos lottos = new Lottos();
        for (Lotto lotto : this.lottos) {
            addLotto(matchCount, winningLotto, lottos, lotto);
        }
        return lottos;
    }

    private void addLotto(int matchCount, WinningLotto winningLotto, Lottos lottos, Lotto lotto) {
        if (isMatch(matchCount, winningLotto, lotto)) {
            lottos.add(lotto);
        }
    }

    private boolean isMatch(int matchCount, WinningLotto winningLotto, Lotto lotto) {
        int count = INIT_COUNT;
        for (Number number : lotto.getNumbers()) {
            count = countUp(winningLotto, count, number);
        }
        return count == matchCount;
    }

    private static int countUp(WinningLotto winningLotto, int count, Number number) {
        if (winningLotto.contains(number)) {
            count++;
        }
        return count;
    }
}
