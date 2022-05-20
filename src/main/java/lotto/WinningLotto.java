package lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final Number bonus;

    public WinningLotto(Lotto lotto, Number bonus) {
        if (lotto.isContains(bonus)) {
            throw new IllegalArgumentException("보너스 숫자는 중복될 수 없습니다.");
        }
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Number getBonus() {
        return bonus;
    }

}
