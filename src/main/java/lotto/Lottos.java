package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int paperCount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < paperCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public int winningPrice(Lotto winningLotto) {
        int totalPrice = 0;
        Map<Integer, Rank> rankMap = calculateWinPriceMap(winningLotto);
        for (Integer key : rankMap.keySet()) {
            Rank rank = rankMap.get(key);
            totalPrice += rank.calculateTotalPrice();
        }
        return totalPrice;
    }

    public Map<Integer, Rank> calculateWinPriceMap(Lotto winningLotto) {
        Map<Integer, Rank> winMap = initWinPriceMap();

        for (Lotto lotto : lottos) {
            int checkMatchCount = lotto.checkMatchCount(winningLotto);
            addRankCount(winMap, checkMatchCount);
        }

        return winMap;
    }

    private void addRankCount(Map<Integer, Rank> winMap, int checkMatchCount) {
        if (winMap.containsKey(checkMatchCount)) {
            Rank rank = winMap.get(checkMatchCount);
            rank.addCount();
        }
    }

    private static Map<Integer, Rank> initWinPriceMap() {
        Map<Integer, Rank> winMap = new HashMap<>();
        winMap.put(3, new Rank(3, 5000, 0));
        winMap.put(4, new Rank(4, 50000, 0));
        winMap.put(5, new Rank(5, 1500000, 0));
        winMap.put(6, new Rank(6, 2000000000, 0));
        return winMap;
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public void printRanks(Map<Integer, Rank> winMap) {
        for (int i = 3; i < 7; i++) {
            Rank rank = winMap.get(i);
            rank.printRank();
        }
    }
}