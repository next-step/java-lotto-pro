import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public int match(int matchCount) {
        return (int) lottoList.stream()
                .filter(lotto -> lotto.isMatch(matchCount))
                .count();
    }

    public BigInteger getProfit() {
        BigInteger reward = BigInteger.valueOf(0);
        for (LottoReward lottoReward : LottoReward.values()) {
            reward = reward.add(BigInteger.valueOf(match(lottoReward.getMatchCount()) * lottoReward.getReward()));
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
