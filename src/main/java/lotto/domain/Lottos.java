package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.WinningMoney.*;

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

    public Map<Integer, Lottos> matchLottos(WinningNumber winningNumber) {
        Map<Integer, Lottos> map = new HashMap<>();
        map.put(THREE_MATCH.getCount(), findLottosByMatchCount(THREE_MATCH.getCount(), winningNumber));
        map.put(FOUR_MATCH.getCount(), findLottosByMatchCount(FOUR_MATCH.getCount(), winningNumber));
        map.put(FIVE_MATCH.getCount(), findLottosByMatchCount(FIVE_MATCH.getCount(), winningNumber));
        map.put(SIX_MATCH.getCount(), findLottosByMatchCount(SIX_MATCH.getCount(), winningNumber));
        return map;
    }

    private Lottos findLottosByMatchCount(int matchCount, WinningNumber winningNumber) {
        Lottos lottos = new Lottos();
        for (Lotto lotto : this.lottos) {
            addLotto(matchCount, winningNumber, lottos, lotto);
        }
        return lottos;
    }

    private void addLotto(int matchCount, WinningNumber winningNumber, Lottos lottos, Lotto lotto) {
        if (isMatch(matchCount, winningNumber, lotto)) {
            lottos.add(lotto);
        }
    }

    private boolean isMatch(int matchCount, WinningNumber winningNumber, Lotto lotto) {
        int count = INIT_COUNT;
        for (Number number : lotto.getNumbers()) {
            count = countUp(winningNumber, count, number);
        }
        return count == matchCount;
    }

    private static int countUp(WinningNumber winningNumber, int count, Number number) {
        if (winningNumber.contains(number)) {
            count++;
        }
        return count;
    }
}
