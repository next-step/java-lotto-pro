package lotto.domain;

import java.util.*;

public class Lottos{
    static List<Lotto> lottoList;
    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Map<RewardType, Integer> calculateWinResult(Lottos lottos, Lotto winLotto) {
        Map<RewardType, Integer> rewardMap = new HashMap<>();
        for (Lotto lotto : lottoList) {
            RewardType rewardType = RewardType.match(lotto, winLotto);
            rewardMap.put(rewardType, rewardMap.getOrDefault(rewardType, 0) + 1);
        }
        return rewardMap;
    }

    public int size() {
        return lottoList.size();
    }

    public static Lottos buyLottos(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(Lotto.createLotto());
        }
        return new Lottos(lottoList);
    }

    public List<Lotto> getLottosAsUnmodifiableList() {
        return Collections.unmodifiableList(lottoList);
    }
}
