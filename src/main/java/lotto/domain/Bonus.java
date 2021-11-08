package lotto.domain;

public class Bonus {
    private final int bonus;

    private Bonus(int bonus) {
        this.bonus = bonus;
    }

    public static Bonus from(int bonus) {
        return new Bonus(bonus);
    }

    public boolean isMatchBonus(int number) {
        return bonus == number;
    }

}
