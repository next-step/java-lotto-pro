package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int size() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Integer, Lottos> matchLottos(WinningNumber winningNumber) {
        Map<Integer, Lottos> map = new HashMap<>();
        Lottos three = new Lottos();
        Lottos four = new Lottos();
        Lottos five = new Lottos();
        Lottos six = new Lottos();
        for (Lotto lotto : this.lottos) {
            if (matchCount(winningNumber, lotto) == 3) {
                three.add(lotto);
            } else if (matchCount(winningNumber, lotto) == 4) {
                four.add(lotto);
            } else if (matchCount(winningNumber, lotto) == 5) {
                five.add(lotto);
            } else if (matchCount(winningNumber, lotto) == 6) {
                six.add(lotto);
            }
        }
        map.put(3, three);
        map.put(4, four);
        map.put(5, five);
        map.put(6, six);
        return map;
    }

    private int matchCount(WinningNumber winningNumber, Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningNumber::contains)
                .count();
    }

    public int sum() {
        int sum = 0;
        for (Lotto lotto : this.lottos) {
            sum += lotto.sum();
        }
        return sum;
    }
}
