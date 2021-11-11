package lotto.service;

public class BoughtMoneyService {
    public static int getBoughtMoney(int inputBoughtMoney) {
        validateBoughtMoney(inputBoughtMoney);
        return inputBoughtMoney;
    }

    private static void validateBoughtMoney(int boughtMoney) {
        if (boughtMoney <= 0) {
            throw new IllegalArgumentException("구매급액은 0 이상의 값을 입력해주세요.");
        }
    }
}
