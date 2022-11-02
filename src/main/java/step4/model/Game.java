package step4.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoBuyCount lottoBuyCount;
    private Money buyMoney;

    public Game(int count) {
        this.lottoBuyCount = new LottoBuyCount(count);
    }

    public Game(String money) {
        this.buyMoney = new Money(money);
        this.lottoBuyCount = new LottoBuyCount(this.buyMoney);
    }

    public LottoBuyCount getLottoBuyCount() {
        return lottoBuyCount;
    }

    public List<Lotto> startLottoGame() {
        List<Lotto> result = new ArrayList<>();
        LottoBuyCount index = new LottoBuyCount(0);
        while (!index.equals(this.lottoBuyCount)) {
            result.add(lottoGenerator.createLotto());
            index.plus();
        }
        return result;
    }

    public Money getBuyMoney() {
        return buyMoney;
    }
}
