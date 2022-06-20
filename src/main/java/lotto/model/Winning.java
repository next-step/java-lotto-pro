package lotto.model;

import java.util.Objects;

public class Winning {
    private static final String WINNING_NUMBERS_BONUS_NUMBER_CANNOT_BE_DUPLICATED = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    private final Lottery lottery;
    private final Number bonusNumber;

    public Winning(Lottery lottery, Number bonusNumber) {
        if (lottery.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_BONUS_NUMBER_CANNOT_BE_DUPLICATED);
        }
        this.lottery = lottery;
        this.bonusNumber = bonusNumber;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }

    public boolean containsNumber(Number number) {
        return lottery.contains(number);
    }

    public boolean equalsBonus(Number number) {
        return bonusNumber.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winning winning = (Winning) o;
        return Objects.equals(lottery, winning.lottery) && Objects.equals(bonusNumber, winning.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottery, bonusNumber);
    }

    @Override
    public String toString() {
        return "Winning{" +
                "lottery=" + lottery +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
