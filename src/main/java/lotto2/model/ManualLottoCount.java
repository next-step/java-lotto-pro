package lotto2.model;

public class ManualLottoCount {
    private final int count;

    public ManualLottoCount(String input, MoneyToBuy moneyToBuy) {
        this.count = parseInt(input, moneyToBuy);
    }

    private int parseInt(String input, MoneyToBuy moneyToBuy) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (Exception e) {
            throw new NumberFormatException("수동으로 구매할 로또는 숫자를 입력해야 합니다.");
        }
        if (isNegative(count)) {
            throw new IllegalArgumentException("수동으로 구매할 로또는 반드시 0 이상의 정수여야 합니다.");
        }
        if (isMoreThanTotalCount(moneyToBuy, count)) {
            throw new IllegalArgumentException("수동으로 구매할 로또는 입력한 금액으로 구입 가능한 총 개수보다 많을 수 없습니다.");
        }
        return count;
    }

    private boolean isNegative(int count) {
        return count < 0;
    }

    private boolean isMoreThanTotalCount(MoneyToBuy moneyToBuy, int count) {
        return moneyToBuy.count() < count;
    }

    public int count() {
        return count;
    }
}
