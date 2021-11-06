package lotto.model;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(Lotto[] lottoArray) {
        lottoList = Arrays.asList(lottoArray);
    }

    public int size() {
        return lottoList.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lottoList.size(); i++) {
            stringBuilder.append(lottoList.get(i).toString() + "\n");
        }
        return stringBuilder.toString();
    }

    public Map<Rank, Integer> matchResult(Lotto winLotto) {
        Map<Rank, Integer> result = createResultMap();
        for (int i = 0; i < size(); i++) {
            Rank rank = winLotto.matchNumber(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private Map<Rank, Integer> createResultMap() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        Rank[] ranks = Rank.values();
        for (int i = 0; i < ranks.length; i++) {
            result.put(ranks[i], 0);
        }
        return result;
    }

}
