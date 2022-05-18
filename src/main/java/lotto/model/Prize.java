package lotto.model;

public class Prize {
    final int amount;

    private Prize(int prize) {
        this.amount = prize;
    }

    public static Prize of(int amount) {
        checkPrizeRange(amount);
        return new Prize(amount);
    }

    private static void checkPrizeRange(int prize) {
        if (prize < 0) {
            throw new IllegalArgumentException("[ERROR] 당첨금액은 음수일 수 없습니다!");
        }
    }

    public Prize add(Prize prize) {
        return Prize.of(this.amount + prize.amount);
    }

    public Prize multiply(int count) {
        return Prize.of(this.amount * count);
    }

    public int getAmount() {
        return amount;
    }
}
