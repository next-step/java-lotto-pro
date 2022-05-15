package lotto;

public class Store {

    private final int lottoOneGamePrice;
    private int receiveMoney;

    public Store(int lottoPrice) {
        this.lottoOneGamePrice = lottoPrice;
    }

    public void receiveMoney(int money) {
        this.receiveMoney = checkMoney(money);
    }

    public Lottos giveLotto() {
        return new Lottos(this.receiveMoney / lottoOneGamePrice);
    }

    private int checkMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(String.format("최소 금액은 %d원 이상입니다.", this.lottoOneGamePrice));
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(String.format("금액은 %s원 단위로 입력해주세요.", this.lottoOneGamePrice));
        }
        return money;
    }
}
