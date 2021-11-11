import java.math.BigInteger;
import java.util.List;

public class User {
    public static final int lottoPrice = 1000;
    private BigInteger money;
    private Lottos lottoList;
    LottoGame lottoGame = new LottoGame();

    public User() {
        this(BigInteger.ZERO);
    }

    public User(BigInteger money) {
        this.money = money;
        this.lottoList = new Lottos();
    }

    public BigInteger getMoney() {
        return money;
    }

    public void setMoney(BigInteger money) {
        this.money = money;
    }

    public Lottos getLottoList() {
        return lottoList;
    }

    public void buyLottos(List<String> manualLottoString) throws IllegalArgumentException {
        buyLottosManual(manualLottoString);
        while (hasMoney()) {
            buyLotto();
        }
    }

    public void buyLotto() {
        lottoList.add(new Lotto());
        expendMoney();
    }

    public void buyLotto(String lottoNumber) throws IllegalArgumentException {
        lottoList.add(new Lotto(lottoNumber));
        expendMoney();
    }

    public void buyLottosManual(List<String> manualLottoString) throws IllegalArgumentException {
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
        if (this.money.compareTo(BigInteger.valueOf(lottoPrice).multiply(BigInteger.valueOf(lottoCount))) < 0) {
            System.out.println("보유 금액이 부족합니다. 보유 : " + this.money);
            return false;
        }
        return true;
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

    public void startGame() {
        lottoGame.start(this);
    }
}
