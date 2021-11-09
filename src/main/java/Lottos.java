import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<Lotto>();
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void checkMatch(Lotto lotto) {
        for (Lotto myLotto : lottoList) {
            myLotto.match(lotto);
        }
    }

    public int getMatchLottoCount(LottoReward reward) {
        return (int) lottoList.stream()
                .filter(lotto -> lotto.isMatch(reward))
                .count();
    }

    public BigInteger getProfit() {
        BigInteger reward = BigInteger.valueOf(0);
        for (LottoReward lottoReward : LottoReward.values()) {
            reward = reward.add(BigInteger.valueOf(getMatchLottoCount(lottoReward) * lottoReward.getReward()));
        }
        return reward;
    }


    public void add(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public int size() {
        return this.lottoList.size();
    }

    public Lotto get(int index) {
        return this.lottoList.get(index);
    }
}
