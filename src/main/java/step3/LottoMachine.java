package step3;

public class LottoMachine {

    private final int lottoPrice;
    private int lottoCount;

    public LottoMachine(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public LottoMachine(int lottoPrice, int money) {
        this.lottoPrice = lottoPrice;

        receiveMoney(money);
    }

    public int receiveMoney(int money) {
        if (money < this.lottoPrice) {
            throw new RuntimeException(lottoPrice - money + "만큼 부족합니다.");
        }

        this.lottoCount = money / lottoPrice + lottoCount;

        return this.lottoCount;
    }
}
