import java.math.BigInteger;
import java.util.List;

public class User {
    public static final int lottoPrice = 1000;
    private BigInteger money;
    private Lottos lottoList;

    public User(BigInteger money) {
        this.money = money;
        this.lottoList = new Lottos();
    }

    public BigInteger getMoney() {
        return money;
    }

    public Lottos getLottoList() {
        return lottoList;
    }

    public void buyLottos(List<String> manualLottoString) {
        buyLottosManual(manualLottoString);
        while (hasMoney()) {
            buyLotto();
        }
    }

    public void buyLotto() {
        expendMoney();
        lottoList.add(new Lotto());
    }

    public void buyLotto(String lottoNumber) {
        expendMoney();
        lottoList.add(new Lotto(lottoNumber));
    }

    public void buyLottosManual(List<String> manualLottoString) {
        for (String lottoString : manualLottoString) {
            buyLotto(lottoString);
        }
    }

    private void expendMoney() {
        this.money = this.money.subtract(BigInteger.valueOf(lottoPrice));
    }

    public boolean hasMoney() {
        return this.money.compareTo(BigInteger.valueOf(lottoPrice)) >= 0;
    }

    public boolean hasMoney(int lottoCount) {
        return this.money.compareTo(BigInteger.valueOf(lottoPrice).multiply(BigInteger.valueOf(lottoCount))) >= 0;
    }

    public int howManyLotto() {
        return lottoList.size();
    }

    public void checkMatch(Lotto lotto) {
        lottoList.checkMatch(lotto);
    }

    public int getMatchLottoCount(LottoReward reward) {
        return lottoList.getMatchLottoCount(reward);
    }

    public double getProfitRate() {
        return Double.parseDouble(String.valueOf(lottoList.getProfit())) / Double.parseDouble(String.valueOf(lottoPrice * howManyLotto()));
    }
}
