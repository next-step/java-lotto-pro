package lotto;

public class Game {
    public static final int PRICE = 1000;
    private final UserLotto userLotto;

    public Game(int purchaseMoney) {
        validate(purchaseMoney);
        int count = purchaseMoney / PRICE;
        this.userLotto = new UserLotto(count);
    }

    private void validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또 1장 가격은 1000원입니다. 1000원 이상의 금액을 입력해주세요.");
        }
    }

    public UserLotto getUserLotto() {
        return userLotto;
    }
}
