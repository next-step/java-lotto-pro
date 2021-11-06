package lotto.domain;

import java.util.Objects;

public class Bonus {

    private final int bonus;

    public Bonus(String number) {
        this.bonus = Integer.parseInt(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bonus bonus1 = (Bonus) o;
        return bonus == bonus1.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus);
    }

    public int getBonus() {
        return bonus;
    }
}
