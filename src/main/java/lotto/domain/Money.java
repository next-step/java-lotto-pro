package lotto.domain;

public class Money {
    private final int price;
    public Money(int price) {
        this.price = validateMoney(price);
    }

    private int validateMoney(int price) {
        validatePositiveMoney(price);
        validateMinLottoMoney(price);
        return price;
    }

    private void validatePositiveMoney(int price) {
        if(price < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 음수를 입력할 수 없습니다.");
        }
    }

    private void validateMinLottoMoney(int price) {
        if(price < 1000) {
            throw new IllegalArgumentException("[ERROR] Lotto 1장의 가격은 1000 입니다.");
        }
    }

    public int lottoCount() {
        return price / 1000;
    }

    public int getPrice() {
        return price;
    }
}
