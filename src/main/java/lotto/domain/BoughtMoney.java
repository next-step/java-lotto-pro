package lotto.domain;

public class BoughtMoney {
    private final int boughtMoney;

    public BoughtMoney(int inputBoughtMoney) {
        validateInputBoughtMoney(inputBoughtMoney);
        boughtMoney = inputBoughtMoney;
    }

    private void validateInputBoughtMoney(int inputBoughtMoney) {
        if (inputBoughtMoney <= 0) {
            throw new IllegalArgumentException("구매급액은 0 이상의 값을 입력해주세요.");
        }
    }

    public int getBoughtMoney() {
        return boughtMoney;
    }

    public int getLottoCount() {
        return boughtMoney / Lotto.LOTTO_PRICE;
    }
}
